package fr.genepisep.icompetences.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY;

@Controller
public class AuthController {

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/login")
    public String login() {
        logger.info("/login called");
        return "redirect:/secured";
    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, SecurityContextLogoutHandler logoutHandler) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CookieClearingLogoutHandler cookieClearingLogoutHandler = new CookieClearingLogoutHandler(SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY);
        cookieClearingLogoutHandler.logout(request, response, auth);
        logoutHandler.logout(request, response, auth);
        return "<html>\n" +
                "<head>\n" +
                "    <title>Cas Secured App - Logout</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>You have logged out of Cas Secured Spring Boot App Successfully</h1>\n" +
                "<br>\n" +
                "<a href=\"/logout/cas\">Log out of all other Services</a>\n" +
                "</body>\n" +
                "</html>";
    }
}
