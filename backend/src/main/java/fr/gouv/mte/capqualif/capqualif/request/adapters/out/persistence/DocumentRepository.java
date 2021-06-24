package fr.gouv.mte.capqualif.capqualif.request.adapters.out.persistence;

import fr.gouv.mte.capqualif.capqualif.request.domain.marin.request.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
