package fr.gouv.mte.capqualif.capqualif.request.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<DocumentJpaEntity, Long> {
}
