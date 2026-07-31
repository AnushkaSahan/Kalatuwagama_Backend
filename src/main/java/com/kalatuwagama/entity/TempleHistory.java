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
@Table(name = "temple_histories")
public class TempleHistory extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;

    private String imageUrl;
}