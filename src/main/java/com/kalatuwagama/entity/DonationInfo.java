package com.kalatuwagama.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "donation_infos")
public class DonationInfo extends BaseEntity {

    @Column(nullable = false)
    private String bankName;

    @Column(nullable = false)
    private String accountName;

    @Column(nullable = false)
    private String accountNumber;

    private String branch;

    @Lob
    private String qrImage;
}