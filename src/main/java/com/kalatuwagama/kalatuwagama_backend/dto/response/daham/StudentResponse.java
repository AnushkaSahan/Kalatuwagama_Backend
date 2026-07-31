package com.kalatuwagama.kalatuwagama_backend.dto.response.daham;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class StudentResponse {
    private UUID id;
    private UUID dahamPasalaId;
    private String dahamPasalaName;
    private String name;
    private LocalDate dateOfBirth;
    private String parentName;
    private String parentPhone;
    private String parentEmail;
    private String address;
    private LocalDate enrollmentDate;
    private String grade;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
