package fr.genepisep.icompetences.entities.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class UserEntity implements Serializable {
    @Id
    private Long id;

    private String name;
    private String firstname;
    private String email;
    private String isepId;
}
