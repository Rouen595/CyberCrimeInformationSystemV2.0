package edu.nsu.cis.controller;

import edu.nsu.cis.model.db.Persontype;
import edu.nsu.cis.service.PersonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;



@Controller
public class PersonTypeController {

    @Autowired
    private PersonTypeService personTypeService;

    @GetMapping("/search-all-person-types")
    public String searchAll(Model model) {
        List<Persontype> personTypeList = personTypeService.retrieveAll();
        model.addAttribute("personTypeList", personTypeList);
        return "personTypeList";
    }
}
