package edu.nsu.cis.service;


import edu.nsu.cis.model.db.Cybercrime;
import edu.nsu.cis.model.db.Person;
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

    public void save(Persontype persontype) {
        personTypeRepository.save(persontype);
    }

    public Persontype get(Integer id) {
        return personTypeRepository.findById(id).get();
    }

    public void delete(int id) {
        personTypeRepository.deleteById(id);
    }
}
