package com.kalatuwagama.dto;

import jakarta.validation.constraints.NotBlank;

public record TeacherDto(
        String id,
        @NotBlank String name,
        String position,
        String phone,
        String imageUrl
) {}