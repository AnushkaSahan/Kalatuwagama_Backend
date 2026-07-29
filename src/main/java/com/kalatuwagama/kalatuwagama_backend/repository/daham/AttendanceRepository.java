package com.kalatuwagama.kalatuwagama_backend.repository.daham;

import com.kalatuwagama.kalatuwagama_backend.entity.daham.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, UUID>, JpaSpecificationExecutor<Attendance> {
    List<Attendance> findByStudentId(UUID studentId);
    List<Attendance> findByClassEntityId(UUID classId);
    List<Attendance> findByClassEntityIdAndDate(UUID classId, LocalDate date);
}
