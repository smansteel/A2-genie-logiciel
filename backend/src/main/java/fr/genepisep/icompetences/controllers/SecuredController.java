package fr.genepisep.icompetences.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecuredController {

    private Logger logger = LoggerFactory.getLogger(SecuredController.class);

    @GetMapping("/secured")
    public String securedIndex() {

        logger.info("/secured called");

        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();

        String rtext =  "<html>\n" +
                "<head>\n" +
                "    <title>Cas Secured App - Secured</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Welcome to Cas Secured Spring Boot App</h1>\n" +
                "<h2>This is a Secured Page</h2>\n" +
                "<h3>Welcome home <span style=\"color:cadetblue;\">username</span></h3>\n" +
                "<br>\n" +
                "<a href=\"/logout\">Logout</a>\n" +
                "</body>\n" +
                "</html>";
        if(auth.getPrincipal() instanceof UserDetails)
            rtext = rtext.replace("username", ((UserDetails) auth.getPrincipal()).getUsername());
        return rtext;
    }
}