package edu.nsu.cis.repository;

import edu.nsu.cis.model.db.Cybercrime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface CybercrimeRepository extends JpaRepository<Cybercrime, Integer> {

    @Transactional(readOnly = true)
    List<Cybercrime> findByCybercrimeType(String cybercrimeType);

    @Transactional(readOnly = true)
    List<Cybercrime> findAll();

    @Transactional(readOnly = true)
    @Query("select distinct severityLevel from Cybercrime order by severityLevel desc")
    List<String> findDistinctBySeverityLevel();

}