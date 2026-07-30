package com.kalatuwagama.kalatuwagama_backend.dto.request.temple;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class PoojaScheduleRequest {
    @NotNull
    private UUID templeId;

    @NotBlank
    private String name;

    private String description;
    private String dayOfWeek;
    private LocalTime time;

    @NotBlank
    private String recurrenceType; // DAILY, WEEKLY, MONTHLY, YEARLY, POYA, SPECIAL

    private LocalDate specialDate;
    private Integer durationMinutes;
    private boolean isActive;
}