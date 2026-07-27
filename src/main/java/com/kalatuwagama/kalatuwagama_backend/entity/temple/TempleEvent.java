package com.kalatuwagama.kalatuwagama_backend.entity.temple;

import com.kalatuwagama.kalatuwagama_backend.entity.base.SoftDeletableEntity;
import com.kalatuwagama.kalatuwagama_backend.entity.organization.Temple;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;

@Entity
@Table(name = "temple_events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLRestriction("deleted_at IS NULL")
public class TempleEvent extends SoftDeletableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "temple_id", nullable = false)
    private Temple temple;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(length = 200)
    private String location;

    @Column(name = "is_featured")
    private boolean isFeatured = false;

    @Column(length = 20)
    private String status; // UPCOMING, ONGOING, COMPLETED, CANCELLED

    @Column(name = "registration_required")
    private boolean registrationRequired = false;

    @Column(name = "image_url", length = 500)
    private String imageUrl;
}
