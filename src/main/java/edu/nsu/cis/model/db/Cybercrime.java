package edu.nsu.cis.model.db;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;


@Setter
@Getter
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

    @Override
    public String toString() {
        return String.valueOf(this.id);
    }
}