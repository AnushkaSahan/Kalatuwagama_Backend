package com.kalatuwagama.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "events")
public class Event extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;

    private String location;

    @Column(nullable = false)
    private LocalDateTime eventDate;

    private String imageUrl;
}