package com.kalatuwagama.kalatuwagama_backend.dto.request.foundation;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class FoundationRequest {
    @NotNull
    private UUID organizationId;

    private String registrationNumber;
    private String contactPerson;
}