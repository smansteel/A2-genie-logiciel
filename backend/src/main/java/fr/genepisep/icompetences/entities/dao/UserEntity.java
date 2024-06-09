package fr.genepisep.icompetences.entities.dao;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "isep_user")
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String firstname;
    private String email;
    @Column(unique = true)
    private String isepId;
    private String passwordHash;
    private Date disableDate;

    @Enumerated(EnumType.ORDINAL)
    private Role role;

}
