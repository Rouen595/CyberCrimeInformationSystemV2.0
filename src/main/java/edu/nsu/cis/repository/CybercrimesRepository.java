package edu.nsu.cis.repository;


import edu.nsu.cis.model.db.Cybercrimes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface CybercrimesRepository extends JpaRepository<Cybercrimes, Integer> {

    @Transactional(readOnly = true)
    List<Cybercrimes> findByid(Integer id);

    @Transactional(readOnly = true)
    List<Cybercrimes> findAll();

    @Transactional(readOnly = true)
    @Query(value = "SELECT c1 " +
            "from Cybercrimes c1 join Person p on c1.personID.id = p.id join Cybercrime c2 on c1.cybercrimeID.id = c2.id " +
            "where c1.cybercrimeID.id = ?1 " +
            "AND (?2 like '' or c1.punishment = ?2) " +
            "AND (?3 like '' or c1.arrestDate = ?3) " +
            "AND (?4 like '' or c1.sentencingDate = ?4) " +
            "AND (?5 like '' or p.firstName = ?5) " +
            "AND (?6 like '' or p.lastName =?6)" +
            "AND (?7 like '' or p.streetAddress = ?7) " +
            "AND (?8 like '' or p.city = ?8) " +
            "AND (?9 like '' or p.state = ?9) " +
            "AND (?10 like '' or p.zipCode = ?10) ")
    List<Cybercrimes> searchByParams(Integer cybercrimeId, String punishment, String arrest,
                                     String sentence, String firstName, String lastName, String address, String city, String state, String zip);

}