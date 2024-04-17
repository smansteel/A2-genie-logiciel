package fr.genepisep.icompetences.repository;

import fr.genepisep.icompetences.entities.dao.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByIsepId(String isepId);
}
