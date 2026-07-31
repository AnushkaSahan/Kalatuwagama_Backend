package com.kalatuwagama.dto;

import jakarta.validation.constraints.NotBlank;

public record GalleryDto(
        String id,
        @NotBlank String title,
        @NotBlank String imageUrl,
        String category
) {}