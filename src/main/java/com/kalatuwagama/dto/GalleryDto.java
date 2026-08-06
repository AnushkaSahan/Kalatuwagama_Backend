package com.kalatuwagama.dto;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record GalleryDto(
        String id,
        @NotBlank String title,
        @NotBlank String imageUrl,
        String category,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}