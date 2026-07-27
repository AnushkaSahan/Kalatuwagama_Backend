package com.kalatuwagama.kalatuwagama_backend.entity.organization;

import com.kalatuwagama.kalatuwagama_backend.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "temples")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Temple extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false, unique = true)
    private Organization organization;

    @Column(columnDefinition = "TEXT")
    private String history;

    @Column(columnDefinition = "TEXT")
    private String mission;

    @Column(columnDefinition = "TEXT")
    private String vision;

    @Column(columnDefinition = "TEXT")
    private String objectives;

    @Column(name = "opening_hours", length = 100)
    private String openingHours;

    @Column(name = "religious_services", columnDefinition = "TEXT")
    private String religiousServices;

    @Column(name = "festival_info", columnDefinition = "TEXT")
    private String festivalInfo;

    @Column(length = 20)
    private String status; // ACTIVE, INACTIVE
}
