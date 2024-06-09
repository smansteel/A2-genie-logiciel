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
public class Wallet {
    @Id
    @GeneratedValue
    private Long id;

    String name;

    String description;
    @OneToMany
    List<UserEntity> authorizedEditors;

    @OneToMany
    List<Competency> competencies;
}
