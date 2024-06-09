package fr.genepisep.icompetences.entities.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Module {
    @Id
    @GeneratedValue
    Long id;
    String name;
    String description;
    @OneToOne
    UserEntity responsable;
    @OneToMany
    List<Wallet> wallets;
}
