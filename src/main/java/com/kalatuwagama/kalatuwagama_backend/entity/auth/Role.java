package com.kalatuwagama.kalatuwagama_backend.entity.auth;

import com.kalatuwagama.kalatuwagama_backend.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role extends BaseEntity {

    @Column(unique = true, nullable = false, length = 30)
    private String name;

    @Column(length = 255)
    private String description;
}
