package fr.genepisep.icompetences.mapper;

import fr.genepisep.icompetences.entities.dao.Competency;
import fr.genepisep.icompetences.entities.dao.UserEntity;
import fr.genepisep.icompetences.entities.dao.Wallet;
import fr.genepisep.icompetences.entities.dto.CompetencyDto;
import fr.genepisep.icompetences.entities.dto.WalletDto;

import java.util.List;

public class WalletMapper {
    public static WalletDto toDto(Wallet wallet) {
        return WalletDto.builder()
                .id(wallet.getId())
                .name(wallet.getName())
                .authorizedEditorsID(wallet.getAuthorizedEditors().stream().map(UserEntity::getId).toList())
                .competencies(CompetencyMapper.toDtoList(wallet.getCompetencies()))
                .description(wallet.getDescription())
                .build();
    }

    public static List<WalletDto> toDtoList(List<Wallet> wallets) {
        return wallets.stream().map(WalletMapper::toDto).toList();
    }
}
