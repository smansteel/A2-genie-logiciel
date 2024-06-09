package fr.genepisep.icompetences.mapper;

import fr.genepisep.icompetences.entities.dao.Competency;
import fr.genepisep.icompetences.entities.dao.SubCompetency;
import fr.genepisep.icompetences.entities.dto.CompetencyDto;
import fr.genepisep.icompetences.entities.dto.SubCompetencyDto;

import java.util.List;

public class CompetencyMapper {
    public static CompetencyDto toDto(Competency competency) {
        return CompetencyDto.builder()
                .id(competency.getId())
                .name(competency.getName())
                .description(competency.getDescription())
                .subCompetencies(SubCompetencyMapper.toDtoList(competency.getSubCompetencies()))
                .build();
    }

    public static List<CompetencyDto> toDtoList(List<Competency> competencies) {
        return competencies.stream().map(CompetencyMapper::toDto).toList();
    }
}
