package fr.genepisep.icompetences.controllers;

import fr.genepisep.icompetences.dto.UserDto;
import fr.genepisep.icompetences.mapper.UserMapper;
import fr.genepisep.icompetences.security.IsepSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    IsepSecurityService isepSecurityService;

    @GetMapping("me")
    @ResponseBody
    public ResponseEntity<UserDto> getUser() {
        return ResponseEntity.ok(UserMapper.toDto(isepSecurityService.getCurrentUser()));
    }

}
