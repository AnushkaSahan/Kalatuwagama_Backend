package com.kalatuwagama.kalatuwagama_backend.dto.request.common;

import com.kalatuwagama.kalatuwagama_backend.enums.OrganizationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrganizationRequest {
    @NotBlank
    private String name;

    private String description;
    private String logoUrl;
    private String address;
    private String phone;

    @Email
    private String email;

    private String website;

    @NotNull
    private OrganizationType type;

    private String status;
    private LocalDate establishedDate;
}
