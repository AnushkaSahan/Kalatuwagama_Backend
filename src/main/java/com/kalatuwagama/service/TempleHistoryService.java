package com.kalatuwagama.service;

import com.kalatuwagama.dto.TempleHistoryDto;

import java.util.List;
import java.util.UUID;

public interface TempleHistoryService {
    TempleHistoryDto create(TempleHistoryDto dto);
    TempleHistoryDto update(UUID id, TempleHistoryDto dto);
    void delete(UUID id);
    TempleHistoryDto getById(UUID id);
    List<TempleHistoryDto> getAll();
}