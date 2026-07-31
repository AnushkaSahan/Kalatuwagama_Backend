package com.kalatuwagama.kalatuwagama_backend.dto.request.daham;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class TeacherRequest {
    @NotNull
    private UUID dahamPasalaId;

    private UUID userId; // optional

    @NotBlank
    private String name;

    private String phone;
    private String email;
    private String qualification;
    private String subjects;
    private LocalDate joinDate;
    private String status;
}
