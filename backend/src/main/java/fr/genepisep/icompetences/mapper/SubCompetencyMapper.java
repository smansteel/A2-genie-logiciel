package fr.genepisep.icompetences.mapper;

import fr.genepisep.icompetences.entities.dao.SubCompetency;
import fr.genepisep.icompetences.entities.dto.SubCompetencyDto;

import java.util.List;

public class SubCompetencyMapper {
    public static SubCompetencyDto toDto(SubCompetency subCompetency) {
        return SubCompetencyDto.builder()
                .id(subCompetency.getId())
                .name(subCompetency.getName())
                .description(subCompetency.getDescription())
                .skill(subCompetency.getSkill())
                .build();
    }

    public static List<SubCompetencyDto> toDtoList(List<SubCompetency> subCompetencies) {
        return subCompetencies.stream().map(SubCompetencyMapper::toDto).toList();
    }
}
