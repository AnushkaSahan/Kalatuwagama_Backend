package com.kalatuwagama.dto;

import jakarta.validation.constraints.NotBlank;

public record MonkDto(
        String id,
        @NotBlank String name,
        String position,
        String biography,
        String imageUrl
) {}