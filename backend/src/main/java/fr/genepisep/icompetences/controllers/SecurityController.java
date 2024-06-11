package fr.genepisep.icompetences.controllers;

import fr.genepisep.icompetences.services.JwtService;
import fr.genepisep.icompetences.services.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SecurityController {

    @Autowired
    LoginService loginService;

    @Autowired
    JwtService jwtService;

//    @Autowired
//    CasAuthenticationProvider casAuthenticationProvider;

//    @PostMapping("login")
//    public ResponseEntity<String> login(@RequestBody LoginDto login) throws FailedLoginException {
//        return ResponseEntity.ok(loginService.loginUser(login.getUsername(), login.getPassword()));
//    }
//
//    @PostMapping("signup")
//    public ResponseEntity<String> signup(@RequestBody LoginDto login) throws FailedLoginException {
//        return ResponseEntity.ok(loginService.loginUser(login.getUsername(), login.getPassword()));
//    }

    @PostMapping("auth/refresh")
    public ResponseEntity<String> refresh(@RequestBody String refreshToken) {
        return ResponseEntity.ok("refresh");
    }



}
