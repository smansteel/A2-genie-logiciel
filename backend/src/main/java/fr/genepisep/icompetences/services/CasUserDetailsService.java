package fr.genepisep.icompetences.services;

import fr.genepisep.icompetences.entities.dao.IsepUserDetails;
import fr.genepisep.icompetences.entities.dao.UserEntity;
import fr.genepisep.icompetences.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CasUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Get the user from the database.
        UserEntity casUser = getUserFromDatabase(username);

        // Create a UserDetails object.
        UserDetails userDetails = new IsepUserDetails(
                casUser);

        return userDetails;
    }

    private UserEntity getUserFromDatabase(String username) {
        return userRepository.findByIsepId(username).orElseThrow();
    }
}
