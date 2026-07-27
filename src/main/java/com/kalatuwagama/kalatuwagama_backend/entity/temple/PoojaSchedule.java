package com.kalatuwagama.kalatuwagama_backend.entity.temple;

import com.kalatuwagama.kalatuwagama_backend.entity.base.BaseEntity;
import com.kalatuwagama.kalatuwagama_backend.entity.organization.Temple;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "pooja_schedules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PoojaSchedule extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "temple_id", nullable = false)
    private Temple temple;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "day_of_week", length = 10)
    private String dayOfWeek;

    @Column(nullable = false)
    private LocalTime time;

    @Column(name = "recurrence_type", nullable = false, length = 20)
    private String recurrenceType;

    @Column(name = "special_date")
    private LocalDate specialDate;

    @Column(name = "duration_minutes")
    private Integer durationMinutes;

    @Column(name = "is_active")
    private boolean isActive = true;
}
