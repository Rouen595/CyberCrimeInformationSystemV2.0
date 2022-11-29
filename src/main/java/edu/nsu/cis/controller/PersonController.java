package edu.nsu.cis.controller;

import edu.nsu.cis.model.db.Cybercrime;
import edu.nsu.cis.model.db.Person;
import edu.nsu.cis.model.db.Persontype;
import edu.nsu.cis.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/save-person", method = RequestMethod.POST)
    public ModelAndView savePerson(@ModelAttribute("Person") Person person) {
        personService.save(person);

        List<Person> personList = personService.retrieveAll();
        ModelAndView mav = new ModelAndView("personList");
        mav.addObject("personList", personList);

        return mav;
    }

    @RequestMapping("/new-person")
    public String showNewProductPage(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);

        return "new_person";
    }

    @RequestMapping("/edit-person/{id}")
    public ModelAndView showEditPersonPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_person");
        Person person = personService.get(id);
        mav.addObject("person", person);
        return mav;
    }


    @RequestMapping("/delete-person/{id}")
    public ModelAndView deletePerson(@PathVariable(name = "id") int id) {
        personService.delete(id);

        List<Person> personList = personService.retrieveAll();
        ModelAndView mav = new ModelAndView("personList");
        mav.addObject("personList", personList);

        return mav;
    }
}
