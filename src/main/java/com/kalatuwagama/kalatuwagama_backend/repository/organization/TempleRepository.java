package com.kalatuwagama.kalatuwagama_backend.repository.organization;

import com.kalatuwagama.kalatuwagama_backend.entity.organization.Temple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TempleRepository extends JpaRepository<Temple, UUID>, JpaSpecificationExecutor<Temple> {
    Optional<Temple> findByOrganizationId(UUID organizationId);
}
