package com.kalatuwagama.kalatuwagama_backend.repository.organization;

import com.kalatuwagama.kalatuwagama_backend.entity.organization.Foundation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FoundationRepository extends JpaRepository<Foundation, UUID>, JpaSpecificationExecutor<Foundation> {
    Optional<Foundation> findByOrganizationId(UUID organizationId);
}
