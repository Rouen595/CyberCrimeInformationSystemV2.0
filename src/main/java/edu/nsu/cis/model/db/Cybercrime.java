package edu.nsu.cis.model.db;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cybercrime", schema = "dbo")
public class Cybercrime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CybercrimeID", nullable = false)
    private Integer id;

    @Size(max = 30)
    @NotNull
    @Column(name = "CybercrimeType", nullable = false, length = 30)
    private String cybercrimeType;

    @Size(max = 30)
    @NotNull
    @Column(name = "SeverityLevel", nullable = false, length = 30)
    private String severityLevel;

    @OneToMany(mappedBy = "cybercrimeID")
    private Set<Cybercrimes> cybercrimes = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCybercrimeType() {
        return cybercrimeType;
    }

    public void setCybercrimeType(String cybercrimeType) {
        this.cybercrimeType = cybercrimeType;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }

    public Set<Cybercrimes> getCybercrimes() {
        return cybercrimes;
    }

    public void setCybercrimes(Set<Cybercrimes> cybercrimes) {
        this.cybercrimes = cybercrimes;
    }

}