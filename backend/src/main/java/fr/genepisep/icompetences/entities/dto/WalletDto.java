package fr.genepisep.icompetences.entities.dto;

import fr.genepisep.icompetences.entities.dao.Competency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletDto {
    private Long id;

    String name;

    String description;
    List<Long> authorizedEditorsID;

    List<CompetencyDto> competencies;
}
