package com.kalatuwagama.kalatuwagama_backend.dto.response.daham;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TeacherResponse {
    private UUID id;
    private UUID dahamPasalaId;
    private String dahamPasalaName;
    private UUID userId;
    private String username;
    private String name;
    private String phone;
    private String email;
    private String qualification;
    private String subjects;
    private LocalDate joinDate;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
