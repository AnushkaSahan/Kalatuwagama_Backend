package com.kalatuwagama.dto;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record DahamPasalaInfoDto(
        String id,
        @NotBlank String introImage,
        String imageFit,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}