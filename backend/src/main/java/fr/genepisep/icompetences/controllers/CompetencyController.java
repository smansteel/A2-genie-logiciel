package fr.genepisep.icompetences.controllers;

import fr.genepisep.icompetences.entities.dao.Competency;
import fr.genepisep.icompetences.entities.dto.CompetencyDto;
import fr.genepisep.icompetences.mapper.CompetencyMapper;
import fr.genepisep.icompetences.repository.CompetenciesRepository;
import fr.genepisep.icompetences.services.SubCompetencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("competency")
public class CompetencyController {
    @Autowired
    SubCompetencyService subCompetencyService;

    @Autowired
    CompetenciesRepository competenciesRepository;

    @GetMapping("{competency}")
    public CompetencyDto getCompetency(@PathVariable Competency competency) {
        return CompetencyMapper.toDto(competency);
    }

    @PatchMapping("{competencyId}")
    public CompetencyDto editCompetency(@PathVariable Long competencyId, @RequestBody CompetencyDto competencyDto) {
        Competency competency= competenciesRepository.findById(competencyId).orElseThrow();
        competency.setName(competencyDto.getName());
        competency.setDescription(competencyDto.getDescription());
        competency.setSubCompetencies(subCompetencyService.updateSubCompetencies(competencyDto.getSubCompetencies()));
        competenciesRepository.save(competency);
        return CompetencyMapper.toDto(competency);
    }
}
