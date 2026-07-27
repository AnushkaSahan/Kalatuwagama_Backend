package com.kalatuwagama.kalatuwagama_backend.entity.temple;

import com.kalatuwagama.kalatuwagama_backend.entity.base.SoftDeletableEntity;
import com.kalatuwagama.kalatuwagama_backend.entity.organization.Temple;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;

@Entity
@Table(name = "monks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLRestriction("deleted_at IS NULL")
public class Monk extends SoftDeletableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "temple_id", nullable = false)
    private Temple temple;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 50)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String biography;

    @Column(columnDefinition = "TEXT")
    private String education;

    @Column(columnDefinition = "TEXT")
    private String achievements;

    @Column(name = "photo_url", length = 500)
    private String photoUrl;

    @Column(name = "is_chief")
    private boolean isChief = false;

    @Column(length = 20)
    private String status; // ACTIVE, INACTIVE, DECEASED

    @Column(name = "ordination_date")
    private LocalDate ordinationDate;
}
