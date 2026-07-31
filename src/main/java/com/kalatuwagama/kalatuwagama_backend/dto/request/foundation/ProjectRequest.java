package com.kalatuwagama.kalatuwagama_backend.dto.request.foundation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class ProjectRequest {
    @NotNull
    private UUID foundationId;

    @NotBlank
    private String title;

    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal budget;
    private String status;
    private String location;
}
