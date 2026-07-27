package com.kalatuwagama.kalatuwagama_backend.entity.common;

import com.kalatuwagama.kalatuwagama_backend.entity.base.BaseEntity;
import com.kalatuwagama.kalatuwagama_backend.entity.organization.Organization;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "donation_categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DonationCategory extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "is_active")
    private boolean isActive = true;
}