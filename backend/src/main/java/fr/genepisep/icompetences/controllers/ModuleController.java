package fr.genepisep.icompetences.controllers;

import fr.genepisep.icompetences.entities.dao.Wallet;
import fr.genepisep.icompetences.entities.dto.ModuleDto;
import fr.genepisep.icompetences.entities.dto.WalletDto;
import fr.genepisep.icompetences.mapper.ModuleMapper;
import fr.genepisep.icompetences.mapper.WalletMapper;
import fr.genepisep.icompetences.repository.ModuleRepository;
import fr.genepisep.icompetences.repository.UserRepository;
import fr.genepisep.icompetences.services.UserService;
import fr.genepisep.icompetences.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import fr.genepisep.icompetences.entities.dao.Module;


@Controller
@RequestMapping("module")
public class ModuleController {
    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private WalletService walletService;

    @GetMapping("{module}")
    public ModuleDto getModule(@PathVariable Module module){
        return ModuleMapper.toDto(module);
    }

    @PatchMapping("{moduleId}")
    public ModuleDto wallet(@PathVariable Long moduleId, @RequestBody ModuleDto moduleDto) {
        Module module= moduleRepository.findById(moduleId).orElseThrow();
        module.setName(moduleDto.getName());
        module.setDescription(moduleDto.getDescription());
        module.setWallets(walletService.updateWallets(moduleDto.getWallets()));
        module.setResponsable(userRepository.findById(moduleDto.getResponsable().getId()).orElseThrow());
        moduleRepository.save(module);
        return ModuleMapper.toDto(module);
    }

}
