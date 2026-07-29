package com.kalatuwagama.kalatuwagama_backend.repository.organization;

import com.kalatuwagama.kalatuwagama_backend.entity.organization.DahamPasala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DahamPasalaRepository extends JpaRepository<DahamPasala, UUID>, JpaSpecificationExecutor<DahamPasala> {
    Optional<DahamPasala> findByOrganizationId(UUID organizationId);
}
