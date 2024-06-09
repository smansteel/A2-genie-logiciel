package fr.genepisep.icompetences.services;

import fr.genepisep.icompetences.entities.dao.Competency;
import fr.genepisep.icompetences.entities.dao.SubCompetency;
import fr.genepisep.icompetences.entities.dto.CompetencyDto;
import fr.genepisep.icompetences.repository.CompetenciesRepository;
import fr.genepisep.icompetences.repository.SubCompetenciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompetencyService {

    @Autowired
    private CompetenciesRepository competenciesRepository;

    @Autowired
    private SubCompetencyService subCompetencyService;

    public List<Competency> updateCompetencies(List<CompetencyDto> competences){
        List<Competency> competencies = new ArrayList<>();

        for (CompetencyDto competencyDto : competences ){
            Competency competency = competenciesRepository.findById(competencyDto.getId()).orElseThrow();
            competency.setName(competencyDto.getName());
            competency.setDescription(competencyDto.getDescription());
            competency.setSubCompetencies(subCompetencyService.updateSubCompetencies(competencyDto.getSubCompetencies()));
            competencies.add(competency);
        }
        return competenciesRepository.saveAll(competencies);
    }
}
