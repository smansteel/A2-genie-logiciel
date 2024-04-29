package fr.genepisep.icompetences.security;

import fr.genepisep.icompetences.entities.dao.IsepUserDetails;
import fr.genepisep.icompetences.entities.dao.UserEntity;
import fr.genepisep.icompetences.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class IsepSecurityService {

    @Autowired
    UserService userService;

    public String getCurrentUsername() {
        return ((IsepUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    }

    public UserEntity getCurrentUser() {
        return userService.findUserByUsername(getCurrentUsername());
    }
}
