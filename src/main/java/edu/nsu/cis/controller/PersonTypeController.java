package edu.nsu.cis.controller;

import edu.nsu.cis.model.db.Cybercrime;
import edu.nsu.cis.model.db.Person;
import edu.nsu.cis.model.db.Persontype;
import edu.nsu.cis.service.PersonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/save-persontype", method = RequestMethod.POST)
    public ModelAndView savePersonType(@ModelAttribute("persontype") Persontype persontype) {
        personTypeService.save(persontype);

        List<Persontype> personTypeList = personTypeService.retrieveAll();
        ModelAndView mav = new ModelAndView("personTypeList");
        mav.addObject("personTypeList", personTypeList);

        return mav;
    }

    @RequestMapping("/new-persontype")
    public String showNewProductPage(Model model) {
        Persontype persontype = new Persontype();
        model.addAttribute("persontype", persontype);

        return "new_personType";
    }

    @RequestMapping("/edit-persontype/{id}")
    public ModelAndView showEditPersonTypePage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_persontype");
        Persontype persontype = personTypeService.get(id);
        mav.addObject("persontype", persontype);
        return mav;
    }

    @RequestMapping("/delete-persontype/{id}")
    public ModelAndView deletePersonType(@PathVariable(name = "id") int id) {
        personTypeService.delete(id);

        List<Persontype> personTypeList = personTypeService.retrieveAll();
        ModelAndView mav = new ModelAndView("personTypeList");
        mav.addObject("personTypeList", personTypeList);

        return mav;
    }

}
