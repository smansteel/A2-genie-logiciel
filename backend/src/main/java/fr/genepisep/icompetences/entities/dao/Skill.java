package fr.genepisep.icompetences.entities.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

/**
 * Objet type : jugement global, écouter et se faire écouter ...
 */
@Entity
public class Skill implements Serializable {
    @Id
    private Long id;
    //nom du skill
    private String name;

    //Niveau du skill associé a une note concrète
    private Integer grade;
    private Integer gradeOutOf;

    //Niveau du skill
    @ManyToOne
    private SkillLevel skillLevel;
}
