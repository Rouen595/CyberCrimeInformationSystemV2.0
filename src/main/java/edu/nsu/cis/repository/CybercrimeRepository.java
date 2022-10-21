package edu.nsu.cis.repository;

import edu.nsu.cis.model.db.Cybercrime;
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
public interface CybercrimeRepository extends JpaRepository<Cybercrime, Integer> {

    @Transactional(readOnly = true)
    List<Cybercrime> findByCybercrimeType(String cybercrimeType);

}