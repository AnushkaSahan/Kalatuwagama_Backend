package com.kalatuwagama.repository;

import com.kalatuwagama.entity.DahamPasalaInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DahamPasalaInfoRepository extends JpaRepository<DahamPasalaInfo, UUID> {
}