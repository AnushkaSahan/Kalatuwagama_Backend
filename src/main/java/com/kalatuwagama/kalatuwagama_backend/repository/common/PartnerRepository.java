package com.kalatuwagama.kalatuwagama_backend.repository.common;

import com.kalatuwagama.kalatuwagama_backend.entity.common.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, UUID>, JpaSpecificationExecutor<Partner> {
    List<Partner> findByOrganizationId(UUID organizationId);
    List<Partner> findByOrganizationIdAndIsActiveTrueOrderByOrderIndexAsc(UUID organizationId);
}
