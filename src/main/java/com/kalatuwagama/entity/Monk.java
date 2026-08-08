package com.kalatuwagama.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "monks")
public class Monk extends BaseEntity {

    @Column(nullable = false)
    private String name;

    private String position;

    @Column(columnDefinition = "TEXT")
    private String biography;

private String imageUrl;

    // Display fit for the image: "cover" (fill/crop) or "contain" (full image)
    private String imageFit = "cover";
}
