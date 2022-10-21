package edu.nsu.cis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {

    @RequestMapping("/")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @RequestMapping("/logout")
    public ModelAndView handleLogout() {
        ModelAndView mav = new ModelAndView("logout");
        return mav;
    }

}
