package fr.genepisep.icompetences.entities.dto;

import fr.genepisep.icompetences.entities.dao.Skill;
import fr.genepisep.icompetences.entities.dao.SubCompetency;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubCompetencyDto {
    Long id;
    String name;
    String description;
    Skill skill;
}
