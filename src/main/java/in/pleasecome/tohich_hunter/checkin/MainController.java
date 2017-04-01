/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin;

import in.pleasecome.tohich_hunter.checkin.entity.Conversation;
import in.pleasecome.tohich_hunter.checkin.entity.Message;
import in.pleasecome.tohich_hunter.checkin.entity.Note;
import in.pleasecome.tohich_hunter.checkin.entity.Town;
import in.pleasecome.tohich_hunter.checkin.entity.User;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *<p>MainController</p>
 * Class, designed to control HTTP requests and invoke appropriate business logic methods.
 * @author Anton Rumiantsev
 */
@Controller
public class MainController
{

    /**
     * Log4j logger class, prints log messages to chosen path.
     */
    private final Logger logger = Logger.getLogger(MainController.class);
    /**
     * {@link in.pleasecome.tohich_hunter.checkin.BLO Business logic object}, on which invokes business methods.
     */
    private BLO blo;

    /**
     * Handles "index" request, return index.jsp page.
     * @return {@link org.springframework.web.servlet.ModelAndView ModelAndView} with specified view info
     */
    @RequestMapping("/index")
    public ModelAndView indexPage()
    {
        return new ModelAndView("index");
    }

    /**
     * Handles "userlist" request, returns userlist.jsp page with loaded registered users list.
     * @return {@link org.springframework.web.servlet.ModelAndView ModelAndView} with specified view info
     */
    @RequestMapping(value = "/userlist")
    public ModelAndView userlistPage()
    {
        List<User> result = null;
        try
        {
            result = blo.getUserList();
        } catch (Exception e)
        {
            logger.error(e.getMessage());
        }
        return new ModelAndView("userlist", "users", result);
    }

    /**
     * Handles requests, appropriate to "mypage*" mask. Returns mypage.jsp page with user notes loaded.
     * @param request from client side
     * @return {@link org.springframework.web.servlet.ModelAndView ModelAndView} with specified view info
     */
    @RequestMapping(value = "/mypage*", method = RequestMethod.GET)
    public ModelAndView myPage(HttpServletRequest request)
    {
        int skip = 0;
        if (request.getParameter("skip") != null)
        {
            skip = Integer.valueOf(request.getParameter("skip"));
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Note> result = null;
        try
        {
            result = blo.getNotes(username, skip);
        } catch (Exception e)
        {
            logger.error(e.getMessage());
        }

        return new ModelAndView("mypage", "command", new Note()).addObject("notes", result);
    }

    /**
     * Handles "edit" request, returns edit.jsp page.
     * @return {@link org.springframework.web.servlet.ModelAndView ModelAndView} with specified view info
     */
    @RequestMapping("/edit")
    public ModelAndView editPage()
    {
        return new ModelAndView("edit");
    }

    /**
     * Handles "admin" request, returns admin.jsp page.
     * @return {@link org.springframework.web.servlet.ModelAndView ModelAndView} with specified view info
     */
    @RequestMapping("/admin")
    public ModelAndView adminPage()
    {
        try
        {
            // blo.addTown();
        } catch (Exception e)
        {
            logger.error(e.getMessage());
        }

        return new ModelAndView("admin");
    }

    /**
     * Handles request, appropriate to "addMessage*" mask, 
     * creates and modifies {@link in.pleasecome.tohich_hunter.checkin.entity.Message Message}
     * and delegates message saving to BLO.
     * Returns string message to requester.
     * @param text of message
     * @param cvrs - name of conversation
     * @return string with info about process state
     */
    @RequestMapping(value = "/addMessage*", method = RequestMethod.POST)
    public @ResponseBody
    String addMessage(@RequestParam("txt") String text, @RequestParam("conversation") String cvrs)
    {
        if (text == null || cvrs == null)
        {
            return "BAD";
        } else
        if (text.trim().equals(""))
        {
            return "EMPTY";
        } 
        Message msg = new Message();
        msg.setConversationName(cvrs);
        msg.setText(text);
        msg.setAddtime(new Timestamp(System.currentTimeMillis()));
        msg.setSender(SecurityContextHolder.getContext().getAuthentication().getName());
        try
        {
            blo.sendMessage(msg);
            return "OK";
        } catch (Exception e)
        {
            logger.error(e.getMessage());
            return "BAD";
        }
    }

    /**
     * Handles requests, appropriate to "conversation_*" mask. 
     * Tries to get {@link in.pleasecome.tohich_hunter.checkin.entity.Conversation Conversation}.
     * Returns conversation.jsp page.
     * @param request from client side
     * @return {@link org.springframework.web.servlet.ModelAndView ModelAndView} with specified view info
     */
    @RequestMapping("/conversation_*")
    public ModelAndView conversationPage(HttpServletRequest request)
    {
        try
        {
            String particiant = request.getParameter("part");
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            Conversation conversation = blo.getConversation(particiant, username);
            return new ModelAndView("conversation", "command", conversation);

        } catch (Exception e)
        {
            logger.error(e.getMessage());
        }
        return new ModelAndView("conversation");
    }

    /**
     * Handles "conversation" request, returns conversations_list.jsp page.
     * @return {@link org.springframework.web.servlet.ModelAndView ModelAndView} with specified view info
     */
    @RequestMapping("/conversations")
    public ModelAndView conversationsListPage()
    {
        return new ModelAndView("conversations_list");
    }

    /**
     * Handles "locations" request, returns locations.jsp page.
     * @return {@link org.springframework.web.servlet.ModelAndView ModelAndView} with specified view info
     */
    @RequestMapping("/locations")
    public ModelAndView locationsPage()
    {
        return new ModelAndView("locations");
    }

    /**
     * Handles "register" request, returns register.jsp page.
     * @return {@link org.springframework.web.servlet.ModelAndView ModelAndView} with specified view info
     */
    @RequestMapping(value = "/register")
    public ModelAndView registerPage()
    {
        return new ModelAndView("register", "command", new User());
    }

    /**
     * Handles "login" request, returns login.jsp page.
     * @return {@link org.springframework.web.servlet.ModelAndView ModelAndView} with specified view info
     */
    @RequestMapping(value = "/login")
    public ModelAndView loginPage()
    {
        return new ModelAndView("login");
    }

    /**
     * Handles "add_user" request, delegates saving process to business logic object.
     * Returns either login.jsp page, in a case of successful transaction, or register.jsp page otherwise.
     * @param usr - {@link in.pleasecome.tohich_hunter.checkin.entity.User User} object with defined properties
     * @return {@link org.springframework.web.servlet.ModelAndView ModelAndView} with specified view info
     */
    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("command") User usr)
    {
        try
        {
            blo.saveUser(usr);
            return new ModelAndView("login");
        } catch (Exception e)
        {
            logger.error(e.getMessage());
            return new ModelAndView("register").addObject("msg", "User with the same email already exists");
        }
    }

    /**
     * Handles "addNote" request, gets absolute path of resources folder
     * and pass it with Note object to appropriate business logic objects method.
     * Returns command string, to redirect back to users page.
     * @param note - {@link in.pleasecome.tohich_hunter.checkin.entity.Note Note} with defined properties
     * @param request - client side request
     * @return string with redirect command
     */
    @RequestMapping(value = "/addNote", method = RequestMethod.POST)
    public String addNote(@ModelAttribute Note note, HttpServletRequest request)
    {
        System.err.println(note);
        try
        {
            blo.addNote(note, request.getRealPath("/resources/usersphotos/"));
        } catch (Exception e)
        {
            logger.error(e.getMessage());
        } finally
        {
            return "redirect:mypage";
        }
    }

    /**
     * Handles "getTowns" request, tries to get list of all towns via business logic object.
     * Returns converted to JSON list of towns.
     * @return list of towns, if any found, or empty list otherwise
     */
    @RequestMapping(value = "/getTowns")
    public @ResponseBody
    List<Town> getTowns()
    {
        try
        {
            return blo.getTowns();
        } catch (Exception ex)
        {
            logger.error(ex.getMessage());
        }
        return new ArrayList<Town>(0);
    }

    /**
     * Setter for business logic object, with Springs @autowired  annotation
     * @param blo - certain object of BLO type
     */
    @Autowired
    public void setBlo(BLO blo)
    {
        this.blo = blo;
    }

}
