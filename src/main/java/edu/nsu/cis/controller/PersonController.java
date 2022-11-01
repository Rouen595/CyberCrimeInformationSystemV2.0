package edu.nsu.cis.controller;

import edu.nsu.cis.model.db.Person;
import edu.nsu.cis.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;



@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/search-all-persons")
    public String searchAll(Model model) {
        List<Person> personList = personService.retrieveAll();
        model.addAttribute("personList", personList);
        return "personList";
    }
}
