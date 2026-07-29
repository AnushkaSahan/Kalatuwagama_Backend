package com.kalatuwagama.kalatuwagama_backend.repository.temple;

import com.kalatuwagama.kalatuwagama_backend.entity.temple.TempleEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface TempleEventRepository extends JpaRepository<TempleEvent, UUID>, JpaSpecificationExecutor<TempleEvent> {
    List<TempleEvent> findByTempleId(UUID templeId);
    List<TempleEvent> findByTempleIdAndStatus(String status);
    List<TempleEvent> findByTempleIdAndStartDateAfter(UUID templeId, LocalDateTime date);
}
