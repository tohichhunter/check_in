/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin;

import in.pleasecome.tohich_hunter.checkin.entity.Note;
import in.pleasecome.tohich_hunter.checkin.entity.Town;
import in.pleasecome.tohich_hunter.checkin.entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author toxa
 */
@Controller
public class MainController
{

    private BLO blo;

    @RequestMapping("/index")
    public ModelAndView indexPage()
    {
        return new ModelAndView("index");
    }

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
            Logger.getAnonymousLogger().log(Level.SEVERE, "Failed to load notes", e);
        }

        return new ModelAndView("mypage", "command", new Note()).addObject("notes", result);
    }

    @RequestMapping("/edit")
    public ModelAndView editPage()
    {
        return new ModelAndView("edit");
    }

    @RequestMapping("/admin")
    public ModelAndView adminPage()
    {
        try
        {
            blo.addTown();
        } catch (Exception e)
        {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Something went wrong", e);
        }

        return new ModelAndView("admin");
    }

    @RequestMapping("/conversation")
    public ModelAndView conversationPage()
    {
        return new ModelAndView("conversation");
    }

    @RequestMapping("/conversations")
    public ModelAndView conversationsListPage()
    {
        return new ModelAndView("conversations_list");
    }

    @RequestMapping("/locations")
    public ModelAndView locationsPage()
    {
        return new ModelAndView("locations");
    }

    @RequestMapping(value = "/register")
    public ModelAndView registerPage()
    {
        return new ModelAndView("register", "command", new User());
    }

    @RequestMapping(value = "/login")
    public ModelAndView loginPage()
    {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("command") User usr)
    {
        try
        {
            blo.saveUser(usr);
            return new ModelAndView("login");
        } catch (Exception e)
        {
            Logger.getAnonymousLogger().log(Level.SEVERE, "User register failure", e);
            return new ModelAndView("register").addObject("msg", "User with the same email already exists");
        }
    }

    @RequestMapping(value = "/addNote", method = RequestMethod.POST)
    public String addNote(@ModelAttribute Note note, HttpServletRequest request)
    {
        System.err.println(note);
        try
        {
            blo.addNote(note, request.getRealPath("/resources/usersphotos/"));
        } catch (Exception e)
        {
            Logger.getAnonymousLogger().log(Level.SEVERE, "failed to add this note", e);
        } finally
        {
            return "redirect:mypage";
        }
    }

    @RequestMapping(value = "/getTowns")
    public @ResponseBody
    List<Town> getTowns()
    {
        try
        {
            return blo.getTowns();
        } catch (Exception ex)
        {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<Town>(0);
    }

    @Autowired
    public void setBlo(BLO blo)
    {
        this.blo = blo;
    }

}
