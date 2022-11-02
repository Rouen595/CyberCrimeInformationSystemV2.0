package edu.nsu.cis.repository;

import edu.nsu.cis.model.db.Cybercrimes;
import edu.nsu.cis.model.db.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Transactional(readOnly = true)
    List<Person> findByid(Integer id);

    @Transactional(readOnly = true)
    List<Person> findAll();

}