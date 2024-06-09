package fr.genepisep.icompetences.repository;

import fr.genepisep.icompetences.entities.dao.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
}
