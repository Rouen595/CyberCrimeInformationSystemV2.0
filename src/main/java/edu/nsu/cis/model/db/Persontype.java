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
@Table(name = "persontype", schema = "dbo")
public class Persontype {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PersonTypeID", nullable = false)
    private Integer id;

    /*@Id
    @Column(name = "PersonTypeID", nullable = false)
    private Integer id;
    */

    @Size(max = 30)
    @NotNull
    @Column(name = "PersonType", nullable = false, length = 30)
    private String personType;

}