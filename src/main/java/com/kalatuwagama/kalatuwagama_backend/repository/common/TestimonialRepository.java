package com.kalatuwagama.kalatuwagama_backend.repository.common;

import com.kalatuwagama.kalatuwagama_backend.entity.common.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TestimonialRepository extends JpaRepository<Testimonial, UUID>, JpaSpecificationExecutor<Testimonial> {
    List<Testimonial> findByOrganizationId(UUID organizationId);
    List<Testimonial> findByOrganizationIdAndIsApprovedTrue(UUID organizationId);
}
