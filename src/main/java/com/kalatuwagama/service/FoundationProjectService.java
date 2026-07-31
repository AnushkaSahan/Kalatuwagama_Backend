package com.kalatuwagama.service;

import com.kalatuwagama.dto.FoundationProjectDto;
import java.util.List;
import java.util.UUID;

public interface FoundationProjectService {
    FoundationProjectDto create(FoundationProjectDto dto);
    FoundationProjectDto update(UUID id, FoundationProjectDto dto);
    void delete(UUID id);
    FoundationProjectDto getById(UUID id);
    List<FoundationProjectDto> getAll();
}