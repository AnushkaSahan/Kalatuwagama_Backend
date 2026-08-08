package com.kalatuwagama.dto;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record StudentDto(
        String id,
        @NotBlank String fullName,
        String grade,
        @NotBlank String guardianName,
        @NotBlank String guardianPhone,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}