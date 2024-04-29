package fr.genepisep.icompetences.services;

import fr.genepisep.icompetences.entities.dao.IsepUserDetails;
import fr.genepisep.icompetences.entities.dao.UserEntity;
import fr.genepisep.icompetences.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.security.auth.login.FailedLoginException;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtService jwtService;

    public String loginUser(String isepId, String password) throws FailedLoginException {
        UserEntity user = userRepository.findByIsepId(isepId).orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));
        if (BCrypt.checkpw(password, user.getPasswordHash())) {
            return jwtService.generateToken(new IsepUserDetails(user));
        }
        throw new FailedLoginException();
    }

}
