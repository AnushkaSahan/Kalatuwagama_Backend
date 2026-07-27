package com.kalatuwagama.kalatuwagama_backend.entity.daham;

import com.kalatuwagama.kalatuwagama_backend.entity.base.SoftDeletableEntity;
import com.kalatuwagama.kalatuwagama_backend.entity.organization.DahamPasala;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLRestriction("deleted_at IS NULL")
public class Student extends SoftDeletableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "daham_pasala_id", nullable = false)
    private DahamPasala dahamPasala;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "parent_name", length = 100)
    private String parentName;

    @Column(name = "parent_phone", length = 20)
    private String parentPhone;

    @Column(name = "parent_email", length = 100)
    private String parentEmail;

    @Column(columnDefinition = "TEXT")
    private String address;

    @Column(name = "enrollment_date")
    private LocalDate enrollmentDate;

    @Column(length = 10)
    private String grade;

    @Column(length = 20)
    private String status; // ACTIVE, GRADUATED, DROPPED
}