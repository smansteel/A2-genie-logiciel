package fr.genepisep.icompetences.entities.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CreateUserDto {
    private Long id;
    private String name;
    private String firstname;
    private String email;
    private String isepId;
    private Date disableDate;
}
