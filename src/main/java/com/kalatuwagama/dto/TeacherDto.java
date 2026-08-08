package com.kalatuwagama.dto;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record TeacherDto(
        String id,
        @NotBlank String name,
        String position,
        String phone,
        String imageUrl,
        String imageFit,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
