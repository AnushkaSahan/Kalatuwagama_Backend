package com.kalatuwagama.kalatuwagama_backend.repository.foundation;

import com.kalatuwagama.kalatuwagama_backend.entity.foundation.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, UUID>, JpaSpecificationExecutor<Campaign> {
    List<Campaign> findByFoundationId(UUID foundationId);
    List<Campaign> findByFoundationIdAndStatus(String status);
}
