package com.kalatuwagama.kalatuwagama_backend.repository.foundation;

import com.kalatuwagama.kalatuwagama_backend.entity.foundation.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, UUID>, JpaSpecificationExecutor<Volunteer> {
    List<Volunteer> findByFoundationId(UUID foundationId);
    List<Volunteer> findByFoundationIdAndStatus(String status);
}