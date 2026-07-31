package com.kalatuwagama.kalatuwagama_backend.dto.response.temple;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TempleEventResponse {
    private UUID id;
    private UUID templeId;
    private String templeName;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
    private boolean featured;
    private String status;
    private boolean registrationRequired;
    private String imageUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
