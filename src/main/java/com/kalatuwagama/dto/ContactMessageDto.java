package com.kalatuwagama.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record ContactMessageDto(
        String id,
        @NotBlank String fullName,
        @Email @NotBlank String email,
        @NotBlank String subject,
        String message,
        LocalDateTime createdAt
) {}