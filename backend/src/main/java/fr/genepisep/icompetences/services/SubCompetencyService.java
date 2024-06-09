package fr.genepisep.icompetences.services;

import fr.genepisep.icompetences.entities.dao.Competency;
import fr.genepisep.icompetences.entities.dao.SubCompetency;
import fr.genepisep.icompetences.entities.dto.CompetencyDto;
import fr.genepisep.icompetences.entities.dto.SubCompetencyDto;
import fr.genepisep.icompetences.repository.CompetenciesRepository;
import fr.genepisep.icompetences.repository.SubCompetenciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubCompetencyService {

    @Autowired
    private SubCompetenciesRepository subCompetenciesRepository;

    public List<SubCompetency> updateSubCompetencies(List<SubCompetencyDto> subCompetencyDtos){
        List<SubCompetency> subCompetencies = new ArrayList<>();
        for (SubCompetencyDto subCompetencyDto : subCompetencyDtos ){
            SubCompetency subCompetency = subCompetenciesRepository.findById(subCompetencyDto.getId()).orElseThrow();
            subCompetency.setName(subCompetencyDto.getName());
            subCompetency.setDescription(subCompetencyDto.getDescription());
            subCompetency.setSkill(subCompetencyDto.getSkill());
            subCompetencies.add(subCompetency);
        }
        return subCompetenciesRepository.saveAll(subCompetencies);
    }
}
