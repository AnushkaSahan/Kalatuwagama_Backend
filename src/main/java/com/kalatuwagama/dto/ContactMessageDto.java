package com.kalatuwagama.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ContactMessageDto(
        String id,
        @NotBlank String fullName,
        @Email @NotBlank String email,
        @NotBlank String subject,
        String message
) {}