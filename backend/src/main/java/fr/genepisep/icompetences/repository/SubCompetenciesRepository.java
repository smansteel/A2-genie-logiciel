package fr.genepisep.icompetences.repository;

import fr.genepisep.icompetences.entities.dao.SubCompetency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCompetenciesRepository extends JpaRepository<SubCompetency, Long> {
}
