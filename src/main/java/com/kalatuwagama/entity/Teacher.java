package com.kalatuwagama.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "teachers")
public class Teacher extends BaseEntity {

    @Column(nullable = false)
    private String name;

    private String position;

    private String phone;

    private String imageUrl;
}