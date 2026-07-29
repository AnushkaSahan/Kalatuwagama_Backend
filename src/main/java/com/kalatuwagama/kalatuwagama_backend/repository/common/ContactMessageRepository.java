package com.kalatuwagama.kalatuwagama_backend.repository.common;

import com.kalatuwagama.kalatuwagama_backend.entity.common.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ContactMessageRepository extends JpaRepository<ContactMessage, UUID>, JpaSpecificationExecutor<ContactMessage> {
    List<ContactMessage> findByOrganizationId(UUID organizationId);
    List<ContactMessage> findByOrganizationIdAndStatus(String status);
}