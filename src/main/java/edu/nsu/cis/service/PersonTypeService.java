package edu.nsu.cis.service;


import edu.nsu.cis.model.db.Persontype;
import edu.nsu.cis.repository.PersonRepository;
import edu.nsu.cis.repository.PersonTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonTypeService {

    @Autowired
    private PersonTypeRepository personTypeRepository;

    public List<Persontype> retrievePersonTypeList(Integer id) {
        return personTypeRepository.findByid(id);
    }
    public List<Persontype> retrieveAll() {
        return personTypeRepository.findAll();
    }
}
