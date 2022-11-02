package edu.nsu.cis.controller;

import edu.nsu.cis.model.db.Cybercrime;
import edu.nsu.cis.service.CybercrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CybercrimeController {

    @Autowired
    private CybercrimeService cybercrimeService;
    @GetMapping("/search-all")
    public String searchAll(Model model) {
        List<Cybercrime> cybercrimeList = cybercrimeService.retrieveAll();
        model.addAttribute("cybercrimeList", cybercrimeList);
        return "cybercrimeList";
    }


    @RequestMapping(value = "/save-cybercrime", method = RequestMethod.POST)
    public String saveCybercrime(@ModelAttribute("cybercrime") Cybercrime cybercrime) {
        cybercrimeService.save(cybercrime);
        return "/home";
    }

    @RequestMapping("/new-cybercrime")
    public String showNewProductPage(Model model) {
        Cybercrime cybercrime = new Cybercrime();
        model.addAttribute("cybercrime", cybercrime);

        return "new_cybercrime";
    }

    @RequestMapping("/edit-cybercrime/{id}")
    public ModelAndView showEditCybercrimePage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_cybercrime");
        Cybercrime cybercrime = cybercrimeService.get(id);
        mav.addObject("cybercrime", cybercrime);
        return mav;
    }

    @RequestMapping("/delete-cybercrime/{id}")
    public String deleteCybercrime(@PathVariable(name = "id") int id) {
        cybercrimeService.delete(id);
        return "/home";
    }

}