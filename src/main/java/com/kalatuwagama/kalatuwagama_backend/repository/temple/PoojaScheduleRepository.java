package com.kalatuwagama.kalatuwagama_backend.repository.temple;

import com.kalatuwagama.kalatuwagama_backend.entity.temple.PoojaSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PoojaScheduleRepository extends JpaRepository<PoojaSchedule, UUID>, JpaSpecificationExecutor<PoojaSchedule> {
    List<PoojaSchedule> findByTempleId(UUID templeId);
    List<PoojaSchedule> findByTempleIdAndIsActiveTrue(UUID templeId);
}
