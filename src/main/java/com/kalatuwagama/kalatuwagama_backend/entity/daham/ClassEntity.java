package com.kalatuwagama.kalatuwagama_backend.entity.daham;

import com.kalatuwagama.kalatuwagama_backend.entity.base.SoftDeletableEntity;
import com.kalatuwagama.kalatuwagama_backend.entity.organization.DahamPasala;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "classes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLRestriction("deleted_at IS NULL")
public class ClassEntity extends SoftDeletableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "daham_pasala_id", nullable = false)
    private DahamPasala dahamPasala;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 10)
    private String grade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @Column(length = 50)
    private String room;

    @Column(columnDefinition = "TEXT")
    private String schedule;

    private Integer capacity;
}
