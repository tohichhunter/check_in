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
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.stereotype.Component;

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
    private Note note;
    private ExecutorService executorService;

    @Autowired
    public void setNoteDAO(NoteDAO noteDAO)
    {
        this.noteDAO = noteDAO;
    }

    @Autowired
    public void setNote(Note note)
    {
        this.note = note;
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

    public synchronized void saveUser(User usr) throws HibernateException
    {
        if (usr != null)
        {
            usr.setEnabled(true);
            userDAO.add(usr);
            authority.setRole(Role.ROLE_USER);
            authority.setUsername(usr.getEmail());
            authorityDAO.add(authority);
        }
    }

    public void editUser(Long id, String firstName, String lastName, Long nt_id) throws HibernateException
    {
        if (id != null)
        {
            User editUser = userDAO.findByID(id);
            editUser.setFirstName(firstName);
            editUser.setLastName(lastName);
            editUser.setNativeTown(nt_id);
            userDAO.edit(editUser);
        }
    }

    public void addConversation(Long... particiants)
    {

        conversation.setParticiants(new HashSet<Long>());
        conversation.addParticiant(1L);
        conversation.addParticiant(2L);
        conversationDAO.add(conversation);
    }

    public void sendMessage(Long user_id, Long conversation_id, String text)
    {

    }

    public void addNote(Note note)
    {
        if (note != null)
        {
            noteDAO.add(note);
        }
        throw new NullPointerException();
    }

    public void addTown() throws ConcurrencyFailureException, IOException, HibernateException
    {
        TaskerDB task = new TaskerDB(town, townDAO);
        executorService = Executors.newCachedThreadPool();
        executorService.execute(task);
        executorService.shutdown();
    }

    public List<Town> getTowns()
    {
        List<Town> townsList = null;
        executorService = Executors.newCachedThreadPool();
        Future<List<Town>> result = executorService.submit(new Callable<List<Town>>()
        {
            @Override
            public List<Town> call() throws Exception
            {
                return townDAO.findAll();
            }
        });
        try
        {
            townsList = result.get();
        } catch (Exception e)
        {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Failed to get list of towns", e);
        }
        return townsList;
    }
}
