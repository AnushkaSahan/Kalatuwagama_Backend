package com.kalatuwagama.kalatuwagama_backend.dto.request.daham;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class ExamResultRequest {
    @NotNull
    private UUID studentId;

    @NotNull
    private UUID classId;

    @NotBlank
    private String examName;

    private BigDecimal marks;
    private String grade;
    private LocalDate examDate;
}