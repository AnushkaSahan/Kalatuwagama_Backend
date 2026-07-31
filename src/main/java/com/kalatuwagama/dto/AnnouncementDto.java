package com.kalatuwagama.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record AnnouncementDto(
        String id,
        @NotBlank String title,
        String description,
        @NotNull LocalDateTime publishDate
) {}