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
@Table(name = "monks")
public class Monk extends BaseEntity {

    @Column(nullable = false)
    private String name;

    private String position;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String biography;

    private String imageUrl;
}