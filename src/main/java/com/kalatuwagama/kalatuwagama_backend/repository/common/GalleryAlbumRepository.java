package com.kalatuwagama.kalatuwagama_backend.repository.common;

import com.kalatuwagama.kalatuwagama_backend.entity.common.GalleryAlbum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GalleryAlbumRepository extends JpaRepository<GalleryAlbum, UUID>, JpaSpecificationExecutor<GalleryAlbum> {
    List<GalleryAlbum> findByOrganizationId(UUID organizationId);
    List<GalleryAlbum> findByOrganizationIdAndStatus(String status);
    List<GalleryAlbum> findByOrganizationIdAndType(String type);
}
