package com.kalatuwagama.kalatuwagama_backend.entity.common;

import com.kalatuwagama.kalatuwagama_backend.entity.base.SoftDeletableEntity;
import com.kalatuwagama.kalatuwagama_backend.entity.organization.Organization;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gallery_albums")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLRestriction("deleted_at IS NULL")
public class GalleryAlbum extends SoftDeletableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "cover_image", length = 500)
    private String coverImage;

    @Column(nullable = false, length = 10)
    private String type; // IMAGE, VIDEO

    @Column(length = 20)
    private String status; // ACTIVE, HIDDEN

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GalleryMedia> mediaItems = new ArrayList<>();
}
