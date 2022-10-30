package edu.nsu.cis.repository;


import edu.nsu.cis.model.db.Cybercrimes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
https://www.baeldung.com/the-persistence-layer-with-spring-and-jpa
https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa
https://www.baeldung.com/spring-data-annotations

 */

@Repository
public interface CybercrimesRepository extends JpaRepository<Cybercrimes, Integer> {

    @Transactional(readOnly = true)
    List<Cybercrimes> findByid(Integer id);

    @Transactional(readOnly = true)
    List<Cybercrimes> findAll();

}