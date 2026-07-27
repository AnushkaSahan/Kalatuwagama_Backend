package com.kalatuwagama.kalatuwagama_backend.entity.foundation;

import com.kalatuwagama.kalatuwagama_backend.entity.auth.User;
import com.kalatuwagama.kalatuwagama_backend.entity.base.SoftDeletableEntity;
import com.kalatuwagama.kalatuwagama_backend.entity.organization.Foundation;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "volunteers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLRestriction("deleted_at IS NULL")
public class Volunteer extends SoftDeletableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foundation_id", nullable = false)
    private Foundation foundation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 100)
    private String email;

    @Column(length = 20)
    private String phone;

    @Column(columnDefinition = "TEXT")
    private String address;

    @Column(columnDefinition = "TEXT")
    private String skills;

    @Column(length = 50)
    private String availability;

    @Column(length = 20)
    private String status; // ACTIVE, INACTIVE
}