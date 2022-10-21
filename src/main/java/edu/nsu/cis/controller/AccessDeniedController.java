package edu.nsu.cis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccessDeniedController {

    @RequestMapping ("/access-denied")
    public ModelAndView handleAccessDenied() {
        return new ModelAndView("accessDenied");
    }
}