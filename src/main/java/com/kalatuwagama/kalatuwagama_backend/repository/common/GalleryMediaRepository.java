package com.kalatuwagama.kalatuwagama_backend.repository.common;

import com.kalatuwagama.kalatuwagama_backend.entity.common.GalleryMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GalleryMediaRepository extends JpaRepository<GalleryMedia, UUID>, JpaSpecificationExecutor<GalleryMedia> {
    List<GalleryMedia> findByAlbumId(UUID albumId);
    List<GalleryMedia> findByAlbumIdOrderByOrderIndexAsc(UUID albumId);
}
