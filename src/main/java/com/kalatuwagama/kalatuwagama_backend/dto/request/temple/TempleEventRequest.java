package com.kalatuwagama.kalatuwagama_backend.dto.request.temple;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TempleEventRequest {
    @NotNull
    private UUID templeId;

    @NotBlank
    private String title;

    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
    private boolean isFeatured;
    private String status;
    private boolean registrationRequired;
    private String imageUrl;
}
