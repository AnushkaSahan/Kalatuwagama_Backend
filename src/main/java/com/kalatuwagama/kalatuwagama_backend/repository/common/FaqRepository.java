package com.kalatuwagama.kalatuwagama_backend.repository.common;

import com.kalatuwagama.kalatuwagama_backend.entity.common.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FaqRepository extends JpaRepository<Faq, UUID>, JpaSpecificationExecutor<Faq> {
    List<Faq> findByOrganizationId(UUID organizationId);
    List<Faq> findByOrganizationIdOrderByOrderIndexAsc(UUID organizationId);
}
