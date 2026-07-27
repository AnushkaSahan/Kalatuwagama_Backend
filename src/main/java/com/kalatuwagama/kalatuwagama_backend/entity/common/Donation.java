package com.kalatuwagama.kalatuwagama_backend.entity.common;

import com.kalatuwagama.kalatuwagama_backend.entity.base.SoftDeletableEntity;
import com.kalatuwagama.kalatuwagama_backend.entity.organization.Organization;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "donations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLRestriction("deleted_at IS NULL")
public class Donation extends SoftDeletableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private DonationCategory category;

    @Column(name = "donor_name", length = 100)
    private String donorName;

    @Column(name = "donor_email", length = 100)
    private String donorEmail;

    @Column(name = "donor_phone", length = 20)
    private String donorPhone;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(name = "donation_date")
    private LocalDate donationDate;

    @Column(name = "transaction_id", length = 100, unique = true)
    private String transactionId;

    @Column(name = "payment_method", length = 20)
    private String paymentMethod; // BANK_TRANSFER, CREDIT_CARD, QR, CASH, OTHER

    @Column(length = 20)
    private String status; // PENDING, COMPLETED, FAILED, REFUNDED

    @Column
    private boolean anonymous = false;

    @Column(columnDefinition = "TEXT")
    private String message;

    @Column(name = "receipt_url", length = 500)
    private String receiptUrl;
}