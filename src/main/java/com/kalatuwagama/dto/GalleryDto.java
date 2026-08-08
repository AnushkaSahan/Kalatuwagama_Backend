package com.kalatuwagama.dto;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record GalleryDto(
        String id,
        @NotBlank String eventId,
        @NotBlank String imageUrl,
        String title,
        String category,
        String imageFit,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
