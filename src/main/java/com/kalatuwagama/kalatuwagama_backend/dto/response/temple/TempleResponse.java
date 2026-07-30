package com.kalatuwagama.kalatuwagama_backend.dto.response.temple;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TempleResponse {
    private UUID id;
    private UUID organizationId;
    private String organizationName;
    private String history;
    private String mission;
    private String vision;
    private String objectives;
    private String openingHours;
    private String religiousServices;
    private String festivalInfo;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
