package com.kalatuwagama.kalatuwagama_backend.entity.foundation;

import com.kalatuwagama.kalatuwagama_backend.entity.base.SoftDeletableEntity;
import com.kalatuwagama.kalatuwagama_backend.entity.organization.Foundation;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "campaigns")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLRestriction("deleted_at IS NULL")
public class Campaign extends SoftDeletableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foundation_id", nullable = false)
    private Foundation foundation;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "goal_amount", precision = 15, scale = 2)
    private BigDecimal goalAmount;

    @Column(name = "raised_amount", precision = 15, scale = 2)
    private BigDecimal raisedAmount;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(length = 20)
    private String status; // ACTIVE, COMPLETED, CANCELLED
}
