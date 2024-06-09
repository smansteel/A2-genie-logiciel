package fr.genepisep.icompetences.services;

import fr.genepisep.icompetences.entities.dao.UserEntity;
import fr.genepisep.icompetences.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{
    @Autowired
    UserRepository userRepository;

    public UserEntity findUserByUsername(String username) {
        return userRepository.findByIsepId(username).orElseThrow();
    }

    public List<UserEntity> findAllUsersFromId(List<Long> ids) {
        return ids.stream().map(elem -> userRepository.findById(elem).orElseThrow()).toList();
    }
}
