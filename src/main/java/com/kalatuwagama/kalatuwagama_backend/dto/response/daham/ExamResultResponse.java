package com.kalatuwagama.kalatuwagama_backend.dto.response.daham;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ExamResultResponse {
    private UUID id;
    private UUID studentId;
    private String studentName;
    private UUID classId;
    private String className;
    private String examName;
    private BigDecimal marks;
    private String grade;
    private LocalDate examDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
