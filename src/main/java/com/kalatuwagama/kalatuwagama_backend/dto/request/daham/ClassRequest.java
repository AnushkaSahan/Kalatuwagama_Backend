package com.kalatuwagama.kalatuwagama_backend.dto.request.daham;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class ClassRequest {
    @NotNull
    private UUID dahamPasalaId;

    @NotBlank
    private String name;

    private String grade;
    private UUID teacherId;
    private String room;
    private String schedule;
    private Integer capacity;
}