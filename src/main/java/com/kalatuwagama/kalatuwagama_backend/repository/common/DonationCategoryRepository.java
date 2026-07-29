package com.kalatuwagama.kalatuwagama_backend.repository.common;

import com.kalatuwagama.kalatuwagama_backend.entity.common.DonationCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DonationCategoryRepository extends JpaRepository<DonationCategory, UUID>, JpaSpecificationExecutor<DonationCategory> {
    List<DonationCategory> findByOrganizationId(UUID organizationId);
    List<DonationCategory> findByOrganizationIdAndIsActiveTrue(UUID organizationId);
}
