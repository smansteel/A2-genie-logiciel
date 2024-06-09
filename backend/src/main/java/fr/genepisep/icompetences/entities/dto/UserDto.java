package fr.genepisep.icompetences.entities.dto;

import fr.genepisep.icompetences.entities.dao.Role;
import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String firstname;
    private String email;
    private String username;
    private Date disableDate;
    private Role role;
}
