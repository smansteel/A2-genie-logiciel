package fr.genepisep.icompetences.entities.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

/**
 * Objet type : jugement global, écouter et se faire écouter ...
 */
public enum Skill implements Serializable {
    INVALIDED,
    FAR,
    CLOSE,
    VERY_CLOSE,
    EXPECTED,
    BEYOND,
}
