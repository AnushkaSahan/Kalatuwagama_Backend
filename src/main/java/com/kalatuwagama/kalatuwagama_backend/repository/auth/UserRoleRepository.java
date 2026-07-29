package com.kalatuwagama.kalatuwagama_backend.repository.auth;

import com.kalatuwagama.kalatuwagama_backend.entity.auth.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UUID>, JpaSpecificationExecutor<UserRole> {
    List<UserRole> findByUserId(UUID userId);
    List<UserRole> findByUserIdAndOrganizationId(UUID userId, UUID organizationId);
    void deleteByUserIdAndOrganizationId(UUID userId, UUID organizationId);
}
