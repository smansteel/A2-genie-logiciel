package fr.genepisep.icompetences.controllers;

import fr.genepisep.icompetences.entities.dto.LoginDto;
import fr.genepisep.icompetences.services.JwtService;
import fr.genepisep.icompetences.services.LoginService;
import org.apereo.cas.client.validation.Cas30ServiceTicketValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.FailedLoginException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;

@Controller
@RequestMapping("auth")

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

    @PostMapping("refresh")
    public ResponseEntity<String> refresh(@RequestBody String refreshToken) {
        return ResponseEntity.ok("refresh");
    }

    @GetMapping("login/cas")
    public ResponseEntity<String> returnCas(@RequestParam String cas) throws Exception {
        System.out.println(cas);
        return ResponseEntity.ok("test");
    }


}
