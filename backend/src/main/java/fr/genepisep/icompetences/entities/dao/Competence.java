package fr.genepisep.icompetences.entities.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
/**
 * Objet type : Le Stagiaire en bon communiquant
 */
public class Competence implements Serializable {
    @Id
    private Long id;

    //List des Skills dans la compétence
    @OneToMany
    private List<Skill> skills;

    //Niveau de la Competence associée a une note concrète
    private Integer grade;
    private Integer gradeOutOf;

    //Niveau de la competence
    @ManyToOne
    private SkillLevel skillLevel;

}
