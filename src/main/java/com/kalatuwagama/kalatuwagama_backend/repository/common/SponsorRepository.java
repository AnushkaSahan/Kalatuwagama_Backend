package com.kalatuwagama.kalatuwagama_backend.repository.common;

import com.kalatuwagama.kalatuwagama_backend.entity.common.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SponsorRepository extends JpaRepository<Sponsor, UUID>, JpaSpecificationExecutor<Sponsor> {
    List<Sponsor> findByOrganizationId(UUID organizationId);
    List<Sponsor> findByOrganizationIdAndIsActiveTrueOrderByOrderIndexAsc(UUID organizationId);
}