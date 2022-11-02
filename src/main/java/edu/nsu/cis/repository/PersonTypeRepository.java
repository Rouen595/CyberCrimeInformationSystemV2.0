package edu.nsu.cis.repository;

import edu.nsu.cis.model.db.Persontype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PersonTypeRepository extends JpaRepository<Persontype, Integer> {

    @Transactional(readOnly = true)
    List<Persontype> findByid(Integer id);

    @Transactional(readOnly = true)
    List<Persontype> findAll();

}