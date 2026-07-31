package com.kalatuwagama.service;

import com.kalatuwagama.dto.EventDto;
import java.util.List;
import java.util.UUID;

public interface EventService {
    EventDto create(EventDto dto);
    EventDto update(UUID id, EventDto dto);
    void delete(UUID id);
    EventDto getById(UUID id);
    List<EventDto> getAll();
}