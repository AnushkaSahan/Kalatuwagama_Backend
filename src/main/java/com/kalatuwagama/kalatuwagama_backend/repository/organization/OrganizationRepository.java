package com.kalatuwagama.kalatuwagama_backend.repository.organization;

import com.kalatuwagama.kalatuwagama_backend.entity.organization.Organization;
import com.kalatuwagama.kalatuwagama_backend.enums.OrganizationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, UUID>, JpaSpecificationExecutor<Organization> {
    Optional<Organization> findByName(String name);
    List<Organization> findByType(OrganizationType type);
    List<Organization> findByStatus(String status);
}