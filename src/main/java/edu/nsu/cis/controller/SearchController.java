package edu.nsu.cis.controller;

import edu.nsu.cis.model.CyberSearchDTO;
import edu.nsu.cis.model.db.Cybercrime;
import edu.nsu.cis.model.db.Cybercrimes;
import edu.nsu.cis.model.db.Person;
import edu.nsu.cis.model.db.Persontype;
import edu.nsu.cis.service.CybercrimeService;
import edu.nsu.cis.service.CybercrimesService;
import edu.nsu.cis.service.PersonService;
import edu.nsu.cis.service.PersonTypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private CybercrimeService cybercrimeService;

    @Autowired
    private CybercrimesService cybercrimesService;

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonTypeService personTypeService;

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
        List<Cybercrimes> cybercrimesList = cybercrimesService.retrieveAll();
        List<String> cybercrimeBySeverityLevelList = cybercrimeService.retrieveDistinctBySeverityLevel();
        List<Person> personList = personService.retrieveAll();
        List<Persontype> persontypeList = personTypeService.retrieveAll();

        model.addAttribute("cyberSearch", new CyberSearchDTO());
        model.addAttribute("cybercrimeList", cybercrimeList);
        model.addAttribute("cybercrimesList", cybercrimesList);
        model.addAttribute("cybercrimeBySeverityLevelList", cybercrimeBySeverityLevelList);
        model.addAttribute("personList", personList);
        model.addAttribute("persontypeList", persontypeList);

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
    public String viewCybercrimeResults(CyberSearchDTO cyberSearch, Model model) throws Exception {
        model.addAttribute("cyberSearch", cyberSearch);

        List<Cybercrimes> cybercrimesList = cybercrimesService.searchCybercrimes(
                StringUtils.isNotBlank(cyberSearch.getCybercrimeType()) ? Integer.parseInt(cyberSearch.getCybercrimeType()) : 0,
                cyberSearch.getSeverityLevel(), cyberSearch.getPunishment(), cyberSearch.getArrestDate(),
                cyberSearch.getSentencingDate(), cyberSearch.getFirstName(), cyberSearch.getLastName(), cyberSearch.getStreetAddress(), cyberSearch.getCity(), cyberSearch.getState(),
                cyberSearch.getZipcode());

        // if you look at the console when it performs the query, only the part with the cybercrime id is given a value to search for, the rest all have "?"

        for (int i = 0; i < cybercrimesList.size(); i++) {
            System.out.println(cybercrimesList.get(i));
        }

        return "searchResults";
    }

}