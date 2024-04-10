package fr.genepisep.icompetences.entities.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.io.Serializable;

/**
 * Objet type : loin, proche, au dela ...
 */
@Entity
public class SkillLevel implements Serializable {
    @Id
    private Long id;
    //Nom
    private String name;

    //valeur pour transformer en compétence notée
    private Integer value;

    //A quel referentiel le niveau se raporte
    @ManyToOne
    private ReferentielCompetenceEntity referentielCompetenceEntity;

}
