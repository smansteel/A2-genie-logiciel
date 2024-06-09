package fr.genepisep.icompetences.controllers;

import fr.genepisep.icompetences.entities.dto.LoginDto;
import fr.genepisep.icompetences.services.JwtService;
import fr.genepisep.icompetences.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.security.auth.login.FailedLoginException;

@Controller
@RequestMapping("auth")

public class SecurityController {

    @Autowired
    LoginService loginService;

    @Autowired
    JwtService jwtService;

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginDto login) throws FailedLoginException {
        return ResponseEntity.ok(loginService.loginUser(login.getUsername(), login.getPassword()));
    }

    @PostMapping("signup")
    public ResponseEntity<String> signup(@RequestBody LoginDto login) throws FailedLoginException {
        return ResponseEntity.ok(loginService.loginUser(login.getUsername(), login.getPassword()));
    }

    @PostMapping("refresh")
    public ResponseEntity<String> refresh(@RequestBody String refreshToken) {
        return ResponseEntity.ok("refresh");
    }


}
