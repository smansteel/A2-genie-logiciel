package fr.genepisep.icompetences.repository;

import fr.genepisep.icompetences.entities.dao.Competency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenciesRepository extends JpaRepository<Competency, Long> {
}
