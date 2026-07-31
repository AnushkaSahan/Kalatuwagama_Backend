package com.kalatuwagama.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "foundation_projects")
public class FoundationProject extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private String imageUrl;
}