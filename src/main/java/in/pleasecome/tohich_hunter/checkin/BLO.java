/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin;

import in.pleasecome.tohich_hunter.checkin.DAO.AuthorityDAO;
import in.pleasecome.tohich_hunter.checkin.DAO.ConversationDAO;
import in.pleasecome.tohich_hunter.checkin.DAO.NoteDAO;
import in.pleasecome.tohich_hunter.checkin.DAO.TownDAO;
import in.pleasecome.tohich_hunter.checkin.DAO.UserDAO;
import in.pleasecome.tohich_hunter.checkin.entity.Authority;
import in.pleasecome.tohich_hunter.checkin.entity.Conversation;
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
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author toxa
 */
@Component
public class BLO
{

    private UserDAO userDAO;
    private ConversationDAO conversationDAO;
    private AuthorityDAO authorityDAO;
    private TownDAO townDAO;
    private NoteDAO noteDAO;
    private User user;
    private Conversation conversation;
    private Authority authority;
    private Town town;
    private Note note_;
    private ExecutorService executorService;

    public BLO()
    {
        executorService = Executors.newCachedThreadPool();
    }

    @Autowired
    public void setNoteDAO(NoteDAO noteDAO)
    {
        this.noteDAO = noteDAO;
    }

    @Autowired
    public void setNote(Note note)
    {
        this.note_ = note;
    }

    @Autowired
    public void setAuthorityDAO(AuthorityDAO authorityDAO)
    {
        this.authorityDAO = authorityDAO;
    }

    @Autowired
    public void setAuthority(Authority authority)
    {
        this.authority = authority;
    }

    @Autowired
    public void setConversationDAO(ConversationDAO conversationDAO)
    {
        this.conversationDAO = conversationDAO;
    }

    @Autowired
    public void setConversation(Conversation conversation)
    {
        this.conversation = conversation;
    }

    @Autowired
    public void setUserDAO(UserDAO userDAO)
    {
        this.userDAO = userDAO;
    }

    @Autowired
    public void setUser(User user)
    {
        this.user = user;
    }

    @Autowired
    public void setTownDAO(TownDAO townDAO)
    {
        this.townDAO = townDAO;
    }

    @Autowired
    public void setTown(Town town)
    {
        this.town = town;
    }

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

    public void addConversation(Long... particiants)
    {
        executorService.execute(new Runnable()
        {
            @Override
            public void run()
            {
                conversation.setParticiants(new HashSet<Long>());
                conversation.addParticiant(1L);
                conversation.addParticiant(2L);
                conversationDAO.add(conversation);
            }
        });
    }

    public void sendMessage(Long user_id, Long conversation_id, String text)
    {

    }

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
                                Logger.getAnonymousLogger().log(Level.SEVERE, "Failed to create dir", e);
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
                                Logger.getAnonymousLogger().log(Level.SEVERE, "Failed to save files", ioe);
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
            Logger.getAnonymousLogger().log(Level.SEVERE, "Failed to save files", e);
        }
    }

    public void addTown() throws ConcurrencyFailureException, IOException, HibernateException
    {
        TaskerDB task = new TaskerDB(town, townDAO);
        executorService = Executors.newCachedThreadPool();
        executorService.execute(task);
    }

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

    public List<Note> getNotes(final int numberOfNotes) throws InterruptedException, ExecutionException
    {
        Future<List<Note>> result = executorService.submit(new Callable<List<Note>>()
        {
            @Override
            public List<Note> call() throws Exception
            {
                return noteDAO.findLastNotes(numberOfNotes);
            }
        });
        return result.get();

    }

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

}
