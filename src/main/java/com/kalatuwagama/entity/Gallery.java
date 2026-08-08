package com.kalatuwagama.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "gallery")
public class Gallery extends BaseEntity {

    // References Event.id — every gallery photo belongs to an event/album
    private String eventId;

    @Column(nullable = false)
    private String imageUrl;

// Optional per-photo caption
    private String title;

    private String category;

    // Display fit for the photo: "cover" (fill/crop) or "contain" (full image)
    private String imageFit = "cover";
}
