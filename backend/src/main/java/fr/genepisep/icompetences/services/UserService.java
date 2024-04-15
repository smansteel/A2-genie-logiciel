package fr.genepisep.icompetences.services;

import fr.genepisep.icompetences.entities.dao.UserEntity;
import fr.genepisep.icompetences.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends EntityService<UserEntity, UserRepository> {
    public UserService(UserRepository entityRepository) {
        super(entityRepository);
    }
}
