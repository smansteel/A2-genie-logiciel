package fr.genepisep.icompetences.services;

import fr.genepisep.icompetences.entities.dao.IsepUserDetails;
import fr.genepisep.icompetences.entities.dao.UserEntity;
import fr.genepisep.icompetences.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class IsepUserDetailsManager implements UserDetailsManager {
    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(UserDetails user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setIsepId(user.getUsername());
        userEntity.setPasswordHash(user.getPassword());
        userRepository.save(userEntity);
    }

    @Override
    public void updateUser(UserDetails user) {
        UserEntity userEntity = userRepository.findByIsepId(user.getUsername()).orElseThrow();
        userEntity.setPasswordHash(user.getPassword());
        userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(String username) {
        userRepository.delete(userRepository.findByIsepId(username).orElseThrow());
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
    }

    @Override
    public boolean userExists(String username) {
        return userRepository.findByIsepId(username).isPresent();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new IsepUserDetails(userRepository.findByIsepId(username).orElseThrow(() -> new UsernameNotFoundException(username)));
    }
}
