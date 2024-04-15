package fr.genepisep.icompetences.repository;

import fr.genepisep.icompetences.entities.dao.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
