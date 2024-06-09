package fr.genepisep.icompetences.entities.dto;

import fr.genepisep.icompetences.entities.dao.SubCompetency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompetencyDto {
    private Long id;
    String name;
    String description;
    List<SubCompetencyDto> subCompetencies;
}
