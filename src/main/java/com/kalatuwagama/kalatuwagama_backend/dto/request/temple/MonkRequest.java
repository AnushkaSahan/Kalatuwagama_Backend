package com.kalatuwagama.kalatuwagama_backend.dto.request.temple;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class MonkRequest {
    @NotNull
    private UUID templeId;

    @NotBlank
    private String name;

    private String title;
    private String biography;
    private String education;
    private String achievements;
    private String photoUrl;
    private boolean isChief;
    private String status;
    private LocalDate ordinationDate;
}
