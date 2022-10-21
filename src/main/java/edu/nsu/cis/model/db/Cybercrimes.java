package edu.nsu.cis.model.db;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cybercrimes", schema = "dbo")
public class Cybercrimes {
    @Id
    @Column(name = "CybercrimesID", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CybercrimeID", nullable = false)
    private Cybercrime cybercrimeID;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PersonID", nullable = false)
    private Person personID;

    @Size(max = 30)
    @Column(name = "Punishment", length = 30)
    private String punishment;

    @Size(max = 30)
    @NotNull
    @Column(name = "ArrestDate", nullable = false, length = 30)
    private String arrestDate;

    @Size(max = 30)
    @Column(name = "SentencingDate", length = 30)
    private String sentencingDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cybercrime getCybercrimeID() {
        return cybercrimeID;
    }

    public void setCybercrimeID(Cybercrime cybercrimeID) {
        this.cybercrimeID = cybercrimeID;
    }

    public Person getPersonID() {
        return personID;
    }

    public void setPersonID(Person personID) {
        this.personID = personID;
    }

    public String getPunishment() {
        return punishment;
    }

    public void setPunishment(String punishment) {
        this.punishment = punishment;
    }

    public String getArrestDate() {
        return arrestDate;
    }

    public void setArrestDate(String arrestDate) {
        this.arrestDate = arrestDate;
    }

    public String getSentencingDate() {
        return sentencingDate;
    }

    public void setSentencingDate(String sentencingDate) {
        this.sentencingDate = sentencingDate;
    }

}