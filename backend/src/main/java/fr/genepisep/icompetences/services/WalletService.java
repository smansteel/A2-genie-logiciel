package fr.genepisep.icompetences.services;

import fr.genepisep.icompetences.entities.dao.Competency;
import fr.genepisep.icompetences.entities.dao.Module;
import fr.genepisep.icompetences.entities.dao.Wallet;
import fr.genepisep.icompetences.entities.dto.CompetencyDto;
import fr.genepisep.icompetences.entities.dto.WalletDto;
import fr.genepisep.icompetences.repository.UserRepository;
import fr.genepisep.icompetences.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WalletService {
    @Autowired
    WalletRepository walletRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CompetencyService competencyService;

    public List<Wallet> updateWallets(List<WalletDto> walletsDto){
        List<Wallet> wallets = new ArrayList<>();
        for (WalletDto walletDto : walletsDto ){
            Wallet wallet = walletRepository.findById(walletDto.getId()).orElseThrow();
            wallet.setName(walletDto.getName());
            wallet.setDescription(walletDto.getDescription());
            wallet.setAuthorizedEditors(walletDto.getAuthorizedEditorsID().stream().map(elem -> userRepository.findById(elem).orElseThrow()).toList());
            wallet.setCompetencies(competencyService.updateCompetencies(walletDto.getCompetencies()));
            wallets.add(wallet);
        }
        return walletRepository.saveAll(wallets);
    }
}
