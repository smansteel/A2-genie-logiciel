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
    @Column
    private Long id;

    @Column
    private String name;
    @Column
    private String firstname;
    @Column
    private String email;
    @Column(unique = true)
    private String isepId;
    @Column
    private String passwordHash;

    @Column
    private Date disableDate;

}
