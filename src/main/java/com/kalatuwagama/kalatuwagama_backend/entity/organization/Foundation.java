package com.kalatuwagama.kalatuwagama_backend.entity.organization;

import com.kalatuwagama.kalatuwagama_backend.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "foundations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Foundation extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false, unique = true)
    private Organization organization;

    @Column(name = "registration_number", length = 50)
    private String registrationNumber;

    @Column(name = "contact_person", length = 100)
    private String contactPerson;
}