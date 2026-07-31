package com.kalatuwagama.service;

import com.kalatuwagama.dto.AnnouncementDto;
import java.util.List;
import java.util.UUID;

public interface AnnouncementService {
    AnnouncementDto create(AnnouncementDto dto);
    AnnouncementDto update(UUID id, AnnouncementDto dto);
    void delete(UUID id);
    AnnouncementDto getById(UUID id);
    List<AnnouncementDto> getAll();
}