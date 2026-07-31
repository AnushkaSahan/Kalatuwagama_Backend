package com.kalatuwagama.kalatuwagama_backend.dto.response.daham;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AttendanceResponse {
    private UUID id;
    private UUID studentId;
    private String studentName;
    private UUID classId;
    private String className;
    private LocalDate date;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
