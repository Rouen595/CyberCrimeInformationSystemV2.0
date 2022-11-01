package edu.nsu.cis.service;


import edu.nsu.cis.model.db.Person;
import edu.nsu.cis.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> retrievePersonList(Integer id) {
        return personRepository.findByid(id);
    }
    public List<Person> retrieveAll() {
        return personRepository.findAll();
    }
}
