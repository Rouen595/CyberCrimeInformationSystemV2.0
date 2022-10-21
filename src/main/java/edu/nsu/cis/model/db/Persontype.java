package edu.nsu.cis.model.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "persontype", schema = "dbo")
public class Persontype {
    @Id
    @Column(name = "PersonTypeID", nullable = false)
    private Integer id;

    @Size(max = 30)
    @NotNull
    @Column(name = "PersonType", nullable = false, length = 30)
    private String personType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

}