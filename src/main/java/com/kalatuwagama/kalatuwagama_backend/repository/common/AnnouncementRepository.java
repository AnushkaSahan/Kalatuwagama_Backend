package com.kalatuwagama.kalatuwagama_backend.repository.common;

import com.kalatuwagama.kalatuwagama_backend.entity.common.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, UUID>, JpaSpecificationExecutor<Announcement> {
    List<Announcement> findByOrganizationId(UUID organizationId);
    List<Announcement> findByOrganizationIdAndIsPinnedTrue(UUID organizationId);
    List<Announcement> findByOrganizationIdAndExpiryDateAfter(UUID organizationId, LocalDateTime now);
}
