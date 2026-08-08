package com.kalatuwagama.dto;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

public record FoundationProjectDto(
        String id,
        @NotBlank String title,
        String description,
        LocalDate startDate,
        LocalDate endDate,
        String imageUrl,
        String imageFit
) {}
