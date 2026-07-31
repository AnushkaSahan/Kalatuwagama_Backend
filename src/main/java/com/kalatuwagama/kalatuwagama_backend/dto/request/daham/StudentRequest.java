package com.kalatuwagama.kalatuwagama_backend.dto.request.daham;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class StudentRequest {
    @NotNull
    private UUID dahamPasalaId;

    @NotBlank
    private String name;

    private LocalDate dateOfBirth;
    private String parentName;
    private String parentPhone;
    private String parentEmail;
    private String address;
    private LocalDate enrollmentDate;
    private String grade;
    private String status;
}
