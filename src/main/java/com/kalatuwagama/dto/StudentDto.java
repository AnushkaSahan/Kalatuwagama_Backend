package com.kalatuwagama.dto;

import jakarta.validation.constraints.NotBlank;

public record StudentDto(
        String id,
        @NotBlank String fullName,
        String grade,
        @NotBlank String guardianName,
        @NotBlank String guardianPhone
) {}