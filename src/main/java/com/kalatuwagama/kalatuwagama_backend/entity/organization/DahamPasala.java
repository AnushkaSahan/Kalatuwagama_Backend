package com.kalatuwagama.kalatuwagama_backend.entity.organization;

import com.kalatuwagama.kalatuwagama_backend.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "daham_pasala")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DahamPasala extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false, unique = true)
    private Organization organization;

    @Column(name = "principal_name", length = 100)
    private String principalName;

    @Column(name = "established_year")
    private Integer establishedYear;

    @Column(name = "contact_email", length = 100)
    private String contactEmail;

    @Column(name = "contact_phone", length = 50)
    private String contactPhone;

    private String address;
}