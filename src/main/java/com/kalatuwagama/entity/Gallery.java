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

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String imageUrl;

    private String category;
}