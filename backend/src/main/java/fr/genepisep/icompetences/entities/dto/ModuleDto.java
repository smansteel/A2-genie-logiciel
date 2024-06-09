package fr.genepisep.icompetences.entities.dto;

import fr.genepisep.icompetences.entities.dao.UserEntity;
import fr.genepisep.icompetences.entities.dao.Wallet;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModuleDto {
    Long id;
    String name;
    String description;
    UserDto responsable;
    List<WalletDto> wallets;
}
