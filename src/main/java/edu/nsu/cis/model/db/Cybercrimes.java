package edu.nsu.cis.model.db;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@Entity
@Table(name = "cybercrimes", schema = "dbo")
public class Cybercrimes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

}