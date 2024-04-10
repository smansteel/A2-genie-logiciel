package fr.genepisep.icompetences.entities.dao;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


/**
 * Objet type : Referentiel d'évaluation pour le stage de I2
 */
@Entity
@Data
public class ReferentielCompetenceEntity implements Serializable {
    @Id
    private Long id;

    //Liste des Compétences dans le référentiel
    @OneToMany
    private List<Competence> competences;
}
