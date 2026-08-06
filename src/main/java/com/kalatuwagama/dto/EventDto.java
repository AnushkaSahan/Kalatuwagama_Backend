package com.kalatuwagama.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record EventDto(
        String id,
        @NotBlank String title,
        String description,
        String location,
        @NotNull LocalDateTime eventDate,
        String imageUrl,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}