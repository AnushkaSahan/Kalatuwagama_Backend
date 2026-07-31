package com.kalatuwagama.dto;

import jakarta.validation.constraints.NotBlank;

public record TempleHistoryDto(
        String id,
        @NotBlank String title,
        String description,
        String imageUrl
) {}