package fr.genepisep.icompetences.controllers;

import fr.genepisep.icompetences.entities.dao.IsepUserDetails;
import fr.genepisep.icompetences.entities.dao.UserEntity;
import fr.genepisep.icompetences.repository.UserRepository;
import fr.genepisep.icompetences.services.JwtService;
import fr.genepisep.icompetences.services.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.Cas30ServiceTicketValidator;
import org.jasig.cas.client.validation.TicketValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("auth")
public class SecurityController {

    @Autowired
    LoginService loginService;

    @Autowired
    JwtService jwtService;

    @Autowired
    Cas30ServiceTicketValidator ticketValidator;

    @Autowired
    UserRepository userRepository;

    @PostMapping("refresh")
    public ResponseEntity<String> refresh(@RequestBody String refreshToken) {
        return ResponseEntity.ok("refresh");
    }

    @GetMapping("/cas")
    public ResponseEntity<String> test(@RequestParam String ticket, HttpServletRequest request) throws TicketValidationException {
        Assertion assertion = ticketValidator.validate(ticket, "https://api.icompetences.tardieu.info/auth/cas");
        UserEntity user = userRepository.findByIsepId(assertion.getPrincipal().toString()).orElseThrow();
        System.out.println(jwtService.generateToken(new IsepUserDetails(user)));
        return ResponseEntity.ok("Helooooo");
    }


    @GetMapping("/logout")
    public String logout(
            HttpServletRequest request,
            HttpServletResponse response,
            SecurityContextLogoutHandler logoutHandler) {
        Authentication auth = SecurityContextHolder
                .getContext().getAuthentication();
        logoutHandler.logout(request, response, auth );
        new CookieClearingLogoutHandler(
                AbstractRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY)
                .logout(request, response, auth);
        return "/logout";
    }

}
