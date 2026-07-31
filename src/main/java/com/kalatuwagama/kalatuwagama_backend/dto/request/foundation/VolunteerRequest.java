package com.kalatuwagama.kalatuwagama_backend.dto.request.foundation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class VolunteerRequest {
    @NotNull
    private UUID foundationId;

    private UUID userId;

    @NotBlank
    private String name;

    private String email;
    private String phone;
    private String address;
    private String skills;
    private String availability;
    private String status;
}
