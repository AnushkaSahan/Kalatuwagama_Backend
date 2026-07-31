package com.kalatuwagama.service;

import com.kalatuwagama.dto.MonkDto;
import java.util.List;
import java.util.UUID;

public interface MonkService {
    MonkDto create(MonkDto dto);
    MonkDto update(UUID id, MonkDto dto);
    void delete(UUID id);
    MonkDto getById(UUID id);
    List<MonkDto> getAll();
}