package edu.nsu.cis.controller;

import edu.nsu.cis.model.db.Cybercrime;
import edu.nsu.cis.model.db.Cybercrimes;
import edu.nsu.cis.service.CybercrimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CybercrimesController {

    @Autowired
    private CybercrimesService cybercrimesService;
    @GetMapping("/search-all-crimes")
    public String searchAll(Model model) {
        List<Cybercrimes> cybercrimesList = cybercrimesService.retrieveAll();
        model.addAttribute("cybercrimesList", cybercrimesList);
        return "cybercrimesList";
    }

    @RequestMapping(value = "/save-cybercrimes", method = RequestMethod.POST)
    public String saveCybercrimes(@ModelAttribute("cybercrimes") Cybercrimes cybercrimes) {
        cybercrimesService.save(cybercrimes);
        return "/home";
    }

    @RequestMapping("/new-cybercrimes")
    public String showNewProductPage(Model model) {
        Cybercrimes cybercrimes = new Cybercrimes();
        model.addAttribute("cybercrimes", cybercrimes);

        return "new_cybercrimes";
    }

    @RequestMapping("/edit-cybercrimes/{id}")
    public ModelAndView showEditCybercrimePage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_cybercrimes");
        Cybercrimes cybercrimes = cybercrimesService.get(id);
        mav.addObject("cybercrimes", cybercrimes);
        return mav;
    }

    @RequestMapping("/delete-cybercrimes/{id}")
    public String deleteCybercrimes(@PathVariable(name = "id") int id) {
        cybercrimesService.delete(id);
        return "/home";
    }

    @RequestMapping("/view-cybercrimes/{id}")
    public ModelAndView showViewCybercrimePage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("view_cybercrimes");
        Cybercrimes cybercrimes = cybercrimesService.get(id);
        mav.addObject("cybercrimes", cybercrimes);
        return mav;
    }

}