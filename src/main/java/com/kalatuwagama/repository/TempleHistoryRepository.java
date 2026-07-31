package com.kalatuwagama.repository;

import com.kalatuwagama.entity.TempleHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TempleHistoryRepository extends JpaRepository<TempleHistory, UUID> {
}