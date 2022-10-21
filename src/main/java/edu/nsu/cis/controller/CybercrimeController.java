package edu.nsu.cis.controller;

import edu.nsu.cis.model.db.Cybercrime;
import edu.nsu.cis.service.CybercrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/cybercrime")
@Controller
public class CybercrimeController {

    @Autowired
    private CybercrimeService cybercrimeService;
    @GetMapping("/search-all")
    public String searchAll(Model model) {
        List<Cybercrime> cybercrimeList = cybercrimeService.retrieveAll();
        model.addAttribute("cybercrimeList", cybercrimeList);
        return "cybercrime/cybercrimeList";
    }

}