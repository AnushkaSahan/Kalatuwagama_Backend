package com.kalatuwagama.kalatuwagama_backend.repository.daham;

import com.kalatuwagama.kalatuwagama_backend.entity.daham.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID>, JpaSpecificationExecutor<Student> {
    List<Student> findByDahamPasalaId(UUID dahamPasalaId);
    List<Student> findByDahamPasalaIdAndStatus(String status);
    List<Student> findByDahamPasalaIdAndGrade(String grade);
}