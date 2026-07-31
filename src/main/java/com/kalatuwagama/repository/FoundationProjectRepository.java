package com.kalatuwagama.repository;

import com.kalatuwagama.entity.FoundationProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FoundationProjectRepository extends JpaRepository<FoundationProject, UUID> {
}