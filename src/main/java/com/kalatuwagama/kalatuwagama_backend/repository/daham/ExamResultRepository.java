package com.kalatuwagama.kalatuwagama_backend.repository.daham;

import com.kalatuwagama.kalatuwagama_backend.entity.daham.ExamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExamResultRepository extends JpaRepository<ExamResult, UUID>, JpaSpecificationExecutor<ExamResult> {
    List<ExamResult> findByStudentId(UUID studentId);
    List<ExamResult> findByClassEntityId(UUID classId);
    List<ExamResult> findByStudentIdAndExamName(UUID studentId, String examName);
}