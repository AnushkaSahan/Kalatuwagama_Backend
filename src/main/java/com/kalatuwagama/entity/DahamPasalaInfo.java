package com.kalatuwagama.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

// Singleton-style content (same pattern as DonationInfo/TempleHistory):
// only one row is expected to exist, edited from the admin dashboard and
// read by the public website's Daham Pasala page.
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "daham_pasala_infos")
public class DahamPasalaInfo extends BaseEntity {

    @Column(nullable = false, columnDefinition = "TEXT")
    private String introImage;

    // Display fit for the intro image: "cover" (fill/crop) or "contain" (full image)
    private String imageFit = "cover";
}