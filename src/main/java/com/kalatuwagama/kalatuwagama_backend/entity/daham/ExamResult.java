package com.kalatuwagama.kalatuwagama_backend.entity.daham;

import com.kalatuwagama.kalatuwagama_backend.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "exam_results")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamResult extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", nullable = false)
    private ClassEntity classEntity;

    @Column(name = "exam_name", nullable = false, length = 100)
    private String examName;

    @Column(precision = 5, scale = 2)
    private BigDecimal marks;

    @Column(length = 5)
    private String grade;

    @Column(name = "exam_date")
    private LocalDate examDate;
}