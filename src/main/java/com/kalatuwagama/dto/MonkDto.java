package com.kalatuwagama.dto;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record MonkDto(
        String id,
        @NotBlank String name,
        String position,
        String biography,
        String imageUrl,
        String imageFit,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
