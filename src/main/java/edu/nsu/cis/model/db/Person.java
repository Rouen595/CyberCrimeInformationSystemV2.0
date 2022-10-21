package edu.nsu.cis.model.db;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "persons", schema = "dbo")
public class Person {
    @Id
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persontype getPersonTypeID() {
        return personTypeID;
    }

    public void setPersonTypeID(Persontype personTypeID) {
        this.personTypeID = personTypeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}