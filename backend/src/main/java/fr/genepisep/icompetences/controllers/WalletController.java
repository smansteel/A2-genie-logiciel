package fr.genepisep.icompetences.controllers;

import fr.genepisep.icompetences.entities.dao.Wallet;
import fr.genepisep.icompetences.entities.dto.WalletDto;
import fr.genepisep.icompetences.mapper.WalletMapper;
import fr.genepisep.icompetences.repository.CompetenciesRepository;
import fr.genepisep.icompetences.repository.WalletRepository;
import fr.genepisep.icompetences.services.CompetencyService;
import fr.genepisep.icompetences.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("wallet")
public class WalletController {
    @Autowired
    WalletRepository walletRepository;
    @Autowired
    CompetencyService competencyService;
    @Autowired
    private UserService userService;

    @GetMapping("{wallet}")
    public WalletDto wallet(@PathVariable Wallet wallet) {
        return WalletMapper.toDto(wallet);
    }

    @PatchMapping("{walletId}")
    public WalletDto wallet(@PathVariable Long walletId, @RequestBody WalletDto walletDto) {
        Wallet wallet= walletRepository.findById(walletId).orElseThrow();
        wallet.setName(walletDto.getName());
        wallet.setDescription(walletDto.getDescription());
        wallet.setCompetencies(competencyService.updateCompetencies(walletDto.getCompetencies()));
        wallet.setAuthorizedEditors(userService.findAllUsersFromId(walletDto.getAuthorizedEditorsID()));
        walletRepository.save(wallet);
        return WalletMapper.toDto(wallet);
    }



}
