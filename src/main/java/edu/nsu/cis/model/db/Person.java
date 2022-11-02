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
@Table(name = "persons", schema = "dbo")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PersonID", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PersonTypeID", nullable = false)
    private Persontype personTypeID;

    @Size(max = 12)
    @NotNull
    @Column(name = "FirstName", nullable = false, length = 12)
    private String firstName;

    @Size(max = 20)
    @NotNull
    @Column(name = "LastName", nullable = false, length = 20)
    private String lastName;

    @NotNull
    @Column(name = "Age", nullable = false)
    private Integer age;

    @Size(max = 30)
    @NotNull
    @Column(name = "StreetAddress", nullable = false, length = 30)
    private String streetAddress;

    @Size(max = 30)
    @NotNull
    @Column(name = "City", nullable = false, length = 30)
    private String city;

    @Size(max = 2)
    @NotNull
    @Column(name = "State", nullable = false, length = 2)
    private String state;

    @Size(max = 15)
    @NotNull
    @Column(name = "ZipCode", nullable = false, length = 15)
    private String zipCode;

}