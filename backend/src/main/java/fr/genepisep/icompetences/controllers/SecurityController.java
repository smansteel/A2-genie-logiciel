package fr.genepisep.icompetences.controllers;

import fr.genepisep.icompetences.dto.LoginDto;
import fr.genepisep.icompetences.entities.dao.UserEntity;
import fr.genepisep.icompetences.services.JwtService;
import fr.genepisep.icompetences.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.security.auth.login.FailedLoginException;

@Configuration
@RequestMapping("login")
public class SecurityController {

    @Autowired
    LoginService loginService;

    @Autowired
    JwtService jwtService;

    @GetMapping()
    public ResponseEntity<String> login(@RequestBody LoginDto login) throws FailedLoginException {
        UserEntity user = loginService.loginUser(login.getIsepId(), login.getPassword());
        return ResponseEntity.ok(jwtService.createToken(user.getIsepId()));
    }
}
