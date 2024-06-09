package fr.genepisep.icompetences.entities.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class SubCompetency {
    @Id
    @GeneratedValue
    Long id;
    String name;
    String description;
    @Enumerated(value = EnumType.ORDINAL)
    Skill skill;
}
