package com.kalatuwagama.kalatuwagama_backend.dto.response.foundation;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ProjectResponse {
    private UUID id;
    private UUID foundationId;
    private String foundationName;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal budget;
    private String status;
    private String location;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
