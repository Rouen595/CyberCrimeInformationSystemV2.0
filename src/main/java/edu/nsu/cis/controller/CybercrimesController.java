package edu.nsu.cis.controller;

import edu.nsu.cis.model.db.Cybercrime;
import edu.nsu.cis.model.db.Cybercrimes;
import edu.nsu.cis.service.CybercrimeService;
import edu.nsu.cis.service.CybercrimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}