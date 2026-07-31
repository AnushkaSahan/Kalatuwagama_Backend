package com.kalatuwagama.kalatuwagama_backend.dto.response.foundation;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class FoundationResponse {
    private UUID id;
    private UUID organizationId;
    private String organizationName;
    private String registrationNumber;
    private String contactPerson;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}