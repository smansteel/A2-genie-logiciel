package fr.genepisep.icompetences.mapper;

import fr.genepisep.icompetences.entities.dto.ModuleDto;
import fr.genepisep.icompetences.entities.dao.Module;

import java.util.List;

public class ModuleMapper {
    public static ModuleDto toDto(Module module) {
        return ModuleDto.builder()
                .id(module.getId())
                .name(module.getName())
                .responsable(UserMapper.toDto(module.getResponsable()))
                .description(module.getDescription())
                .wallets(WalletMapper.toDtoList(module.getWallets()))
                .build();
    }

    public static List<ModuleDto> toDtoList(List<Module> modules) {
        return modules.stream().map(ModuleMapper::toDto).toList();
    }
}
