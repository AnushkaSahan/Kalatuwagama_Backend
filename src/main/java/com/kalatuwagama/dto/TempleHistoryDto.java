package com.kalatuwagama.dto;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record TempleHistoryDto(
        String id,
        @NotBlank String title,
        String description,
        String imageUrl,
        String imageFit,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
