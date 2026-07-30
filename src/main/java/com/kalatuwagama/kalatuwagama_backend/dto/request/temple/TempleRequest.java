package com.kalatuwagama.kalatuwagama_backend.dto.request.temple;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class TempleRequest {
    @NotNull
    private UUID organizationId;

    private String history;
    private String mission;
    private String vision;
    private String objectives;
    private String openingHours;
    private String religiousServices;
    private String festivalInfo;
    private String status;
}
