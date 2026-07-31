package com.kalatuwagama.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "students")
public class Student extends BaseEntity {

    @Column(nullable = false)
    private String fullName;

    private String grade;

    @Column(nullable = false)
    private String guardianName;

    @Column(nullable = false)
    private String guardianPhone;
}