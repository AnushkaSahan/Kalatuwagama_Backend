package com.kalatuwagama.kalatuwagama_backend.entity.common;

import com.kalatuwagama.kalatuwagama_backend.entity.base.SoftDeletableEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "gallery_media")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLRestriction("deleted_at IS NULL")
public class GalleryMedia extends SoftDeletableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id", nullable = false)
    private GalleryAlbum album;

    @Column(length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "media_url", nullable = false, length = 500)
    private String mediaUrl;

    @Column(name = "media_type", nullable = false, length = 10)
    private String mediaType; // IMAGE, VIDEO

    @Column(name = "thumbnail_url", length = 500)
    private String thumbnailUrl;

    @Column(name = "order_index")
    private Integer orderIndex = 0;

    @Column(length = 20)
    private String status; // ACTIVE, HIDDEN
}