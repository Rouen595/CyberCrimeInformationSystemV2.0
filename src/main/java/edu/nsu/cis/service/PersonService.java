package edu.nsu.cis.service;


import edu.nsu.cis.model.db.Person;
import edu.nsu.cis.model.db.Persontype;
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

    public void save(Person person) {
        personRepository.save(person);
    }

    public Person get(Integer id) {
        return personRepository.findById(id).get();
    }

    public void delete(int id) {
        personRepository.deleteById(id);
    }
}
