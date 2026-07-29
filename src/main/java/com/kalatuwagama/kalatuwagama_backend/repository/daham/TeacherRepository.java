package com.kalatuwagama.kalatuwagama_backend.repository.daham;

import com.kalatuwagama.kalatuwagama_backend.entity.daham.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, UUID>, JpaSpecificationExecutor<Teacher> {
    List<Teacher> findByDahamPasalaId(UUID dahamPasalaId);
    List<Teacher> findByDahamPasalaIdAndStatus(String status);
}
