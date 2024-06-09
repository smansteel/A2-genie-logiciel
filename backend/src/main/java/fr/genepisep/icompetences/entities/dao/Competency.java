package fr.genepisep.icompetences.entities.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Competency implements Serializable {
    @Id
    private Long id;
    String name;
    String description;
    @OneToMany
    List<SubCompetency> subCompetencies;

}
