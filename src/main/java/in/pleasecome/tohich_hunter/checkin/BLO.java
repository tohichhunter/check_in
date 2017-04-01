/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin;

import in.pleasecome.tohich_hunter.checkin.DAO.AuthorityDAO;
import in.pleasecome.tohich_hunter.checkin.DAO.ConversationDAO;
import in.pleasecome.tohich_hunter.checkin.DAO.MessageDAO;
import in.pleasecome.tohich_hunter.checkin.DAO.NoteDAO;
import in.pleasecome.tohich_hunter.checkin.DAO.TownDAO;
import in.pleasecome.tohich_hunter.checkin.DAO.UserDAO;
import in.pleasecome.tohich_hunter.checkin.entity.Authority;
import in.pleasecome.tohich_hunter.checkin.entity.Conversation;
import in.pleasecome.tohich_hunter.checkin.entity.Message;
import in.pleasecome.tohich_hunter.checkin.entity.Note;
import in.pleasecome.tohich_hunter.checkin.entity.Role;
import in.pleasecome.tohich_hunter.checkin.entity.Town;
import in.pleasecome.tohich_hunter.checkin.entity.User;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Anton Rumiantsev
 */
@Component
public class BLO
{

    private UserDAO userDAO;
    private ConversationDAO conversationDAO;
    private AuthorityDAO authorityDAO;
    private TownDAO townDAO;
    private NoteDAO noteDAO;
    private MessageDAO messageDAO;
    private Authority authority;
    private Town town;
    private ExecutorService executorService;
    
    private final Logger logger = Logger.getLogger(BLO.class);

    /**
     *<p>Constructor Business Logic Object</p>
     * initialises executorService with new cashed thread pool
     */
    public BLO()
    {
        executorService = Executors.newCachedThreadPool();
    }

    /**
     * Sets messageDAO to internal data access object
     * @param messageDAO
     */
    @Autowired
    public void setMessageDAO(MessageDAO messageDAO)
    {
        this.messageDAO = messageDAO;
    }
    
    /**
     * Sets noteDAO to internal data access object
     * @param noteDAO
     */
    @Autowired
    public void setNoteDAO(NoteDAO noteDAO)
    {
        this.noteDAO = noteDAO;
    }

    /**
     * Sets authorityDAO to internal data access object
     * @param authorityDAO
     */
    @Autowired
    public void setAuthorityDAO(AuthorityDAO authorityDAO)
    {
        this.authorityDAO = authorityDAO;
    }

    /**
     * Sets authority to internal object
     * @param authority
     */
    @Autowired
    public void setAuthority(Authority authority)
    {
        this.authority = authority;
    }

    /**
     * Sets conversationDAO to internal data access object
     * @param conversationDAO
     */
    @Autowired
    public void setConversationDAO(ConversationDAO conversationDAO)
    {
        this.conversationDAO = conversationDAO;
    }


    /**
     * Sets userDAO to internal data access object
     * @param userDAO
     */
    @Autowired
    public void setUserDAO(UserDAO userDAO)
    {
        this.userDAO = userDAO;
    }


    /**
     * Sets townDAO to internal data access object
     * @param townDAO
     */
    @Autowired
    public void setTownDAO(TownDAO townDAO)
    {
        this.townDAO = townDAO;
    }

    /**
     * Sets town to internal object
     * @param town
     */
    @Autowired
    public void setTown(Town town)
    {
        this.town = town;
    }

    /**
     * Saves user as a new user into database with role Role.USER
     * @param usr
     */
    public synchronized void saveUser(final User usr) throws HibernateException
    {
        if (usr != null)
        {
            executorService.execute(new Runnable()
            {
                @Override
                public void run()
                {
                    usr.setEnabled(true);
                    userDAO.add(usr);
                    authority.setRole(Role.ROLE_USER);
                    authority.setUsername(usr.getEmail());
                    authorityDAO.add(authority);
                }
            });
        }
    }

    /**
     * Updates information about certain user, using users id and saves into database
     * @param id
     * @param firstName
     * @param lastName
     * @param nt_id
     * @throws HibernateException 
     */
    public void editUser(final Long id, final String firstName, final String lastName, final Long nt_id) throws HibernateException
    {
        if (id != null)
        {
            executorService.execute(new Runnable()
            {
                @Override
                public void run()
                {
                    User editUser = userDAO.findByID(id);
                    editUser.setFirstName(firstName);
                    editUser.setLastName(lastName);
                    editUser.setNativeTown(nt_id);
                    userDAO.edit(editUser);
                }
            });
        }
    }
  
    /**
     * Saves new message into database
     * @param message 
     */
    public void sendMessage(final Message message)
    {
        executorService.execute(new Runnable()
        {
            @Override
            public void run()
            {
                if (message == null)
                {
                    throw new IllegalArgumentException();
                }
                messageDAO.add(message);
            }
        });
    }

    /**
     * Saves new note into database and attached photos into file system. 
     * Database stores file paths as strings.
     * @param note
     * @param path 
     */
    public void addNote(final Note note, final String path)
    {
        final String user = SecurityContextHolder.getContext().getAuthentication().getName();
        try
        {

            executorService.execute(new Runnable()
            {
                @Override
                public void run()
                {
                    Set<String> photos = new HashSet<>();
                    if (note.getFiles() != null)
                    {
                        Path dir = Paths.get(path + user);
                        if (!Files.exists(dir))
                        {
                            try
                            {
                                Files.createDirectory(dir);
                            } catch (Exception e)
                            {
                                logger.error(e.getMessage());
                            }
                        }

                        for (MultipartFile file : note.getFiles())
                        {
                            try
                            {
                                String photoPath = path + user + "/" + System.currentTimeMillis() + "_" + file.getOriginalFilename();
                                File saved = new File(photoPath);
                                file.transferTo(saved);
                                photos.add(photoPath.replace(path, "resources/usersphotos/"));
                            } catch (IOException ioe)
                            {
                                logger.error(ioe.getMessage());
                            }
                        }
                    }

                    note.setPhotos(photos);
                    note.setUser(user);
                    noteDAO.add(note);
                }
            });
        } catch (Exception e)
        {
            logger.error(e.getMessage());
        }
    }

    /**
     * Special method, used to fill database with towns information. Not allowed to use more than one time.
     * @deprecated 
     * @throws ConcurrencyFailureException
     * @throws IOException
     * @throws HibernateException 
     */
    private synchronized void addTown() throws ConcurrencyFailureException, IOException, HibernateException
    {
        TaskerDB task = new TaskerDB(town, townDAO);
        executorService = Executors.newCachedThreadPool();
        executorService.execute(task);
    }

    /**
     * Returns list of all towns in database
     * @return List of Town
     * @throws InterruptedException
     * @throws ExecutionException 
     */
    public List<Town> getTowns() throws InterruptedException, ExecutionException
    {
        Future<List<Town>> result = executorService.submit(new Callable<List<Town>>()
        {
            @Override
            public List<Town> call() throws Exception
            {
                return townDAO.findAll();
            }
        });
        return result.get();

    }

    /**
     * Returns list of all users in database
     * @return List of User
     * @throws InterruptedException
     * @throws ExecutionException 
     */
    public List<User> getUserList() throws InterruptedException, ExecutionException
    {
        Future<List<User>> result = executorService.submit(new Callable<List<User>>()
        {
            @Override
            public List<User> call() throws Exception
            {
                return userDAO.findAll();
            }
        });
        return result.get();

    }

    /**
     * Returns no more than 10 notes of certain user. 
     * Skip parameter used to make offset from the beginning.
     * @param username
     * @param skip
     * @return
     * @throws InterruptedException
     * @throws ExecutionException 
     */
    public List<Note> getNotes(final String username, final int skip) throws InterruptedException, ExecutionException
    {
        Future<List<Note>> result = executorService.submit(new Callable<List<Note>>()
        {
            @Override
            public List<Note> call() throws Exception
            {
                return noteDAO.findByUsername(username, skip);
            }
        });
        return result.get();
    }

    /**
     * Makes search of conversation with certain set of participants. Creates new if not found.
     * Returns appropriative conversation.
     * @param participant
     * @param username
     * @return
     * @throws InterruptedException
     * @throws ExecutionException 
     */
    public Conversation getConversation(final String participant, final String username) throws InterruptedException, ExecutionException
    {
        if (participant != null && username != null)
        {

            Future<Conversation> result = executorService.submit(new Callable<Conversation>()
            {
                @Override
                public Conversation call() throws Exception
                {
                    return conversationDAO.findByParticiants(participant, username);
                }
            });
            Conversation res = result.get();
            if (res != null)
            {
                return res;
            } else
            {
                final Conversation newC = new Conversation();
                newC.setConversationName(username + "_" + participant);
                newC.setParticiants(new HashSet<String>());
                newC.setMessages(new LinkedList<Message>());
                newC.addParticiant(username);
                newC.addParticiant(participant);
                executorService.submit(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        conversationDAO.add(newC);
                    }
                });
                return newC;
            }
        }
        throw new IllegalArgumentException();
    }

}
