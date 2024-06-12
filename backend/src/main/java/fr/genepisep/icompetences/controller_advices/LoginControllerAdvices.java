package fr.genepisep.icompetences.controller_advices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.security.auth.login.FailedLoginException;

@ControllerAdvice
public class LoginControllerAdvices {
//    @ExceptionHandler({FailedLoginException.class,})
//    public ResponseEntity<String> handleFailedLogin() {
//        return ResponseEntity.status(403).body("Mauvais nom d'utilisateur ou mot de passe");
//    }
}
