package com.kalatuwagama.kalatuwagama_backend.dto.response.temple;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MonkResponse {
    private UUID id;
    private UUID templeId;
    private String templeName;
    private String name;
    private String title;
    private String biography;
    private String education;
    private String achievements;
    private String photoUrl;
    private boolean isChief;
    private String status;
    private LocalDate ordinationDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
