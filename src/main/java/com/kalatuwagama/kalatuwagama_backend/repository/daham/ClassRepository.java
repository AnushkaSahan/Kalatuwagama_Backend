package com.kalatuwagama.kalatuwagama_backend.repository.daham;

import com.kalatuwagama.kalatuwagama_backend.entity.daham.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, UUID>, JpaSpecificationExecutor<ClassEntity> {
    List<ClassEntity> findByDahamPasalaId(UUID dahamPasalaId);
    List<ClassEntity> findByTeacherId(UUID teacherId);
}