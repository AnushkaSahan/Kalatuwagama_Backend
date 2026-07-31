package com.kalatuwagama.repository;

import com.kalatuwagama.entity.Monk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MonkRepository extends JpaRepository<Monk, UUID> {
}