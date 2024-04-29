package fr.genepisep.icompetences.services;

import fr.genepisep.icompetences.entities.dao.UserEntity;
import fr.genepisep.icompetences.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends EntityService<UserEntity, UserRepository> {

    //Pas fan de ça, je préfère les autowire
    public UserService(UserRepository entityRepository) {
        super(entityRepository);
    }

    public UserEntity findUserByUsername(String username) {
        return entityRepository.findByIsepId(username).orElseThrow();
    }
}
