package com.kalatuwagama.kalatuwagama_backend.dto.response.common;

import com.kalatuwagama.kalatuwagama_backend.enums.OrganizationType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class OrganizationResponse {
    private UUID id;
    private String name;
    private String description;
    private String logoUrl;
    private String address;
    private String phone;
    private String email;
    private String website;
    private OrganizationType type;
    private String status;
    private LocalDate establishedDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
