package com.kalatuwagama.kalatuwagama_backend.repository.foundation;

import com.kalatuwagama.kalatuwagama_backend.entity.foundation.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<Project, UUID>, JpaSpecificationExecutor<Project> {
    List<Project> findByFoundationId(UUID foundationId);
    List<Project> findByFoundationIdAndStatus(String status);
}