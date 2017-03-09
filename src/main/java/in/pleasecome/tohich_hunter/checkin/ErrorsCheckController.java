/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author toxa
 */
@Controller
public class ErrorsCheckController
{
    @RequestMapping("/400")
    public ModelAndView e400()
    {
        return new org.springframework.web.servlet.ModelAndView("error/400");
    }
    
    @RequestMapping("/403")
    public ModelAndView e403()
    {
        return new org.springframework.web.servlet.ModelAndView("error/403");
    }
    
    @RequestMapping("/404")
    public ModelAndView e404()
    {
        return new org.springframework.web.servlet.ModelAndView("error/404");
    }
    
    @RequestMapping("/500")
    public ModelAndView e500()
    {
        return new org.springframework.web.servlet.ModelAndView("error/500");
    }
}
