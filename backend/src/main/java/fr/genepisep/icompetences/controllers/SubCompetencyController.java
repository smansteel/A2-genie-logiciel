package fr.genepisep.icompetences.controllers;

import fr.genepisep.icompetences.entities.dao.SubCompetency;
import fr.genepisep.icompetences.entities.dto.SubCompetencyDto;
import fr.genepisep.icompetences.mapper.SubCompetencyMapper;
import fr.genepisep.icompetences.repository.SubCompetenciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("subcompetency")
public class SubCompetencyController {
    @Autowired
    SubCompetenciesRepository subCompetenciesRepository;

    @GetMapping("{subcompetency}")
    public SubCompetencyDto getCompetency(@PathVariable SubCompetency subcompetency) {
        return SubCompetencyMapper.toDto(subcompetency);
    }

    @PatchMapping("{subcompetencyId}")
    public SubCompetencyDto editCompetency(@PathVariable Long subcompetencyId, @RequestBody SubCompetencyDto subCompetencyDto) {
        SubCompetency subCompetency = subCompetenciesRepository.findById(subcompetencyId).orElseThrow();
        subCompetency.setName(subCompetencyDto.getName());
        subCompetency.setDescription(subCompetencyDto.getDescription());
        subCompetency.setSkill(subCompetencyDto.getSkill());
        subCompetenciesRepository.save(subCompetency);
        return SubCompetencyMapper.toDto(subCompetency);
    }
}
