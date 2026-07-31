package com.kalatuwagama.kalatuwagama_backend.dto.request.daham;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class AttendanceRequest {
    @NotNull
    private UUID studentId;

    @NotNull
    private UUID classId;

    @NotNull
    private LocalDate date;

    @NotBlank
    private String status; // PRESENT, ABSENT, LATE
}
