package com.kalatuwagama.kalatuwagama_backend.repository.temple;

import com.kalatuwagama.kalatuwagama_backend.entity.temple.Monk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MonkRepository extends JpaRepository<Monk, UUID>, JpaSpecificationExecutor<Monk> {
    List<Monk> findByTempleId(UUID templeId);
    List<Monk> findByTempleIdAndIsChiefTrue(UUID templeId);
    List<Monk> findByTempleIdAndStatus(String status);
}
