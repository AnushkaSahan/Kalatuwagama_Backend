package com.kalatuwagama.service;

import com.kalatuwagama.dto.GalleryDto;
import java.util.List;
import java.util.UUID;

public interface GalleryService {
    GalleryDto create(GalleryDto dto);
    GalleryDto update(UUID id, GalleryDto dto);
    void delete(UUID id);
    GalleryDto getById(UUID id);
    List<GalleryDto> getAll();
}