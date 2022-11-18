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

//    @Query("select u from User u where u.emailAddress = ?1")
//    User findByEmailAddress(String emailAddress);
    @Transactional(readOnly = true)
    @Query("Select c1,p,c2 from Cybercrimes c1 join Person p on c1.personID.id = p.id join Cybercrime c2 on c1.cybercrimeID.id = c2.id where c1.cybercrimeID.id = ?1 and p.state = ?2")
    List<Cybercrimes> searchByParameters(Integer cybercrimeId, String state);


//    Select c1.CybercrimesID, c1.CybercrimeID, c1.ArrestDate, c1.SentencingDate, c1.Punishment, c1.PersonID,
//    p.FirstName, p.LastName, p.StreetAddress, p.City, p.State, p.ZipCode, p.Age
//    From cybercrimes c1 with (NOLOCK)
//    Join cybercrime c2 with (NOLOCK)
//    On c1.CybercrimeID = c2.CybercrimeID
//    Join persons p with (NOLOCK)
//    On c1.PersonID = p.PersonID
//    Where c1.CybercrimeID = 3004

}