package edu.nsu.cis.controller;

import edu.nsu.cis.model.CyberSearchDTO;
import edu.nsu.cis.model.db.Cybercrime;
import edu.nsu.cis.service.CybercrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private CybercrimeService cybercrimeService;

    /*
    @GetMapping("/search")
    public String searchCybercrime(Model model) {
        model.addAttribute("cyberSearch", new CyberSearch());
        return "/search";
    }
    */

    @GetMapping("/search")
    public String searchAll(Model model) {
        List<Cybercrime> cybercrimeList = cybercrimeService.retrieveAll();
        List<String> cybercrimeBySeverityLevelList = cybercrimeService.retrieveDistinctBySeverityLevel();

        model.addAttribute("cyberSearch", new CyberSearchDTO());
        model.addAttribute("cybercrimeList", cybercrimeList);
        model.addAttribute("cybercrimeBySeverityLevelList", cybercrimeBySeverityLevelList);
        return "/search";
    }

    /*
    @PostMapping("/search")
    public String viewCybercrimeResults(CyberSearch cyberSearch, Model model) {
        model.addAttribute("cyberSearch", cyberSearch);

        //List<Cybercrime> cybercrimeList = cybercrimeService.retrieveCybercrimeList("Phishing");

        return "searchResults";
    }
    */

    @PostMapping("/search")
    public String viewCybercrimeResults(CyberSearchDTO cyberSearch, Model model) {
        model.addAttribute("cyberSearch", cyberSearch);

        //List<Cybercrime> cybercrimeList = cybercrimeService.retrieveCybercrimeList("Phishing");

        return "searchResults";
    }

}