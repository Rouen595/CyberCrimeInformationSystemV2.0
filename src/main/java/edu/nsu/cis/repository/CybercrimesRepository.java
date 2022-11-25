package edu.nsu.cis.repository;


import edu.nsu.cis.model.db.Cybercrimes;
import edu.nsu.cis.model.CyberResultDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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
    @Query("Select c1,p,c2 from Cybercrimes c1 join Person p on c1.personID.id = p.id join Cybercrime c2 on c1.cybercrimeID.id = c2.id " +
            "where c1.cybercrimeID.id = ?1 and c1.cybercrimeID.severityLevel = ?2 and c1.punishment = ?3 and c1.arrestDate = ?4 and c1.sentencingDate = ?5 " +
            "and p.firstName = ?6 and p.lastName = ?7 and p.streetAddress = ?8 and p.city = ?9 and p.state = ?10 and p.zipCode = ?11")
    List<Cybercrimes> searchByParameters(Integer cybercrimeId, String severity, String punishment, String arrest,
                                         String sentence, String firstName, String lastName, String address, String city, String state, String zip);

    // for right now we are only searching cybercrimes ergo *only select the cybercrimes*
    /*
    @Transactional(readOnly = true)
    @Query(value = "Select new edu.nsu.cis.model.CyberResultDTO(c1.cybercrimeID.id, p.firstName, p.lastName, p.state, p.city, c2.severityLevel, c1.punishment, c1.arrestDate, c1.sentencingDate) " +
            "from Cybercrimes c1 join Person p on c1.personID.id = p.id join Cybercrime c2 on c1.cybercrimeID.id = c2.id join Persontype pt on p.id = pt.id " +
            "where ((c1.cybercrimeID.id IS NULL) OR (c1.cybercrimeID IS NOT NULL AND  c1.cybercrimeID.id = ?1)) " +
            "and ((c1.cybercrimeID.severityLevel IS NULL) OR (c1.cybercrimeID.severityLevel IS NOT NULL AND c1.cybercrimeID.severityLevel = ?2)) " +
            "and ((c1.punishment IS NULL) OR (c1.punishment IS NOT NULL AND c1.punishment = ?3))  " +
            "and ((c1.arrestDate IS NULL) OR (c1.arrestDate IS NOT NULL AND c1.arrestDate = ?4))  " +
            "and ((c1.sentencingDate IS NULL) OR (c1.sentencingDate IS NOT NULL AND c1.sentencingDate = ?5)) " +
            "and ((p.firstName IS NULL) OR (p.firstName IS NOT NULL AND p.firstName = ?6)) " +
            "and ((p.lastName IS NULL) OR (p.lastName IS NOT NULL AND p.lastName = ?7)) " +
            "and ((p.streetAddress IS NULL) OR (p.streetAddress IS NOT NULL AND p.streetAddress = ?8))" +
            "and ((p.city IS NULL) OR (p.city IS NOT NULL AND p.city = ?9)) " +
            "and ((p.state IS NULL) OR (p.state IS NOT NULL AND p.state = ?10)) " +
            "and ((p.streetAddress IS NULL) OR (p.streetAddress IS NOT NULL AND p.zipCode = ?11))")
    CyberResultDTO searchByParams(Integer cybercrimeId, String severity, String punishment, String arrest,
                                         String sentence, String firstName, String lastName, String address, String city, String state, String zip);
    */

    //new try
    /*
    @Transactional(readOnly = true)
    @Query(value = "Select c1.cybercrimeID.id, p.firstName, p.lastName, p.state, p.city, c2.severityLevel, c1.punishment, c1.arrestDate, c1.sentencingDate " +
            "from Cybercrimes c1 join Person p on c1.personID.id = p.id join Cybercrime c2 on c1.cybercrimeID.id = c2.id join Persontype pt on p.id = pt.id " +
            "where ((c1.cybercrimeID.id IS NULL) OR (c1.cybercrimeID IS NOT NULL AND  c1.cybercrimeID.id = ?1)) " +
            "and ((c1.cybercrimeID.severityLevel IS NULL) OR (c1.cybercrimeID.severityLevel IS NOT NULL AND c1.cybercrimeID.severityLevel = ?2)) " +
            "and ((c1.punishment IS NULL) OR (c1.punishment IS NOT NULL AND c1.punishment = ?3))  " +
            "and ((c1.arrestDate IS NULL) OR (c1.arrestDate IS NOT NULL AND c1.arrestDate = ?4))  " +
            "and ((c1.sentencingDate IS NULL) OR (c1.sentencingDate IS NOT NULL AND c1.sentencingDate = ?5)) " +
            "and ((p.firstName IS NULL) OR (p.firstName IS NOT NULL AND p.firstName = ?6)) " +
            "and ((p.lastName IS NULL) OR (p.lastName IS NOT NULL AND p.lastName = ?7)) " +
            "and ((p.streetAddress IS NULL) OR (p.streetAddress IS NOT NULL AND p.streetAddress = ?8))" +
            "and ((p.city IS NULL) OR (p.city IS NOT NULL AND p.city = ?9)) " +
            "and ((p.state IS NULL) OR (p.state IS NOT NULL AND p.state = ?10)) " +
            "and ((p.streetAddress IS NULL) OR (p.streetAddress IS NOT NULL AND p.zipCode = ?11))")
    List<String> searchByParams(Integer cybercrimeId, String severity, String punishment, String arrest,
                                             String sentence, String firstName, String lastName, String address, String city, String state, String zip);
    */
  /*
    @Transactional(readOnly = true)
    @Query(value = "Select c1 " +
            "from Cybercrimes c1 join Person p on c1.personID.id = p.id join Cybercrime c2 on c1.cybercrimeID.id = c2.id " +
            "where c1.cybercrimeID.id = ?1 " +
            "AND (?2 like '' or  c1.cybercrimeID.severityLevel = ?2) " +
            "AND (?3 like '' or c1.punishment = ?3) " +
            "AND (?4 like '' or c1.arrestDate = ?4) " +
            "AND (?5 like '' or c1.sentencingDate = ?5) " +
            "AND (?6 like '' or p.firstName = ?6) " +
            "AND (?7 like '' or p.lastName =?7)")
    List<Cybercrimes> searchByParams(Integer cybercrimeId, String severity, String punishment, String arrest, String sentence, String firstName, String lastName);
*/
    @Transactional(readOnly = true)
    @Query(value = "SELECT c1 " +
            "from Cybercrimes c1 join Person p on c1.personID.id = p.id join Cybercrime c2 on c1.cybercrimeID.id = c2.id " +
            "where c1.cybercrimeID.id = ?1 " +
            "AND (?2 like '' or  c1.cybercrimeID.severityLevel = ?2) " +
            "AND (?3 like '' or c1.punishment = ?3) " +
            "AND (?4 like '' or c1.arrestDate = ?4) " +
            "AND (?5 like '' or c1.sentencingDate = ?5) " +
            "AND (?6 like '' or p.firstName = ?6) " +
            "AND (?7 like '' or p.lastName =?7)" +
            "AND (?8 like '' or p.streetAddress = ?8) " +
            "AND (?9 like '' or p.city = ?9) " +
            "AND (?10 like '' or p.state = ?10) " +
            "AND (?11 like '' or p.zipCode = ?11) ")
    List<Cybercrimes> searchByParams(Integer cybercrimeId, String severity, String punishment, String arrest,
                                     String sentence, String firstName, String lastName, String address, String city, String state, String zip);

    //(?2 is null or c1.cybercrimeID.severityLevel = ?2)

//    Select c1.CybercrimesID, c1.CybercrimeID, c1.ArrestDate, c1.SentencingDate, c1.Punishment, c1.PersonID,
//    p.FirstName, p.LastName, p.StreetAddress, p.City, p.State, p.ZipCode, p.Age
//    From cybercrimes c1 with (NOLOCK)
//    Join cybercrime c2 with (NOLOCK)
//    On c1.CybercrimeID = c2.CybercrimeID
//    Join persons p with (NOLOCK)
//    On c1.PersonID = p.PersonID
//    Where c1.CybercrimeID = 3004

    /*
    @Query("SELECT * FROM person p WHERE ((:firstName IS NULL) OR (:firstName IS NOT NULL AND p.firstName = :firstName))
    AND ((:lastName IS NULL) OR (:lastName IS NOT NULL AND p.lastName = :lastName)) AND ((:gender IS NULL) OR (:gender IS NOT NULL AND p.gender = :gender))
    AND ((:dateOfBirth IS NULL) OR (:dateOfBirth IS NOT NULL AND p.dateOfBirth = :dateOfBirth )) ")
        Page<Person> findBy(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("gender") String gender, @Param("dateOfBirth")
        String dateOfBirth, Pageable page);*/


}