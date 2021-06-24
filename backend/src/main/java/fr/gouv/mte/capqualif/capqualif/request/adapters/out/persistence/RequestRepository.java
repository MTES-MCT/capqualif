package fr.gouv.mte.capqualif.capqualif.request.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<RequestJpaEntity, Long> {

}
