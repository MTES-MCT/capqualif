package fr.gouv.mte.capqualif.capAdmin.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitreRepository extends JpaRepository<TitreJpaEntity, Long> {
}
