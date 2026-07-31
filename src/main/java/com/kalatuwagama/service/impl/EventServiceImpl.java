package com.kalatuwagama.service.impl;

import com.kalatuwagama.dto.EventDto;
import com.kalatuwagama.entity.Event;
import com.kalatuwagama.exception.ResourceNotFoundException;
import com.kalatuwagama.mapper.EntityMapper;
import com.kalatuwagama.repository.EventRepository;
import com.kalatuwagama.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class EventServiceImpl implements EventService {

    private final EventRepository repository;
    private final EntityMapper mapper;

    @Override
    public EventDto create(EventDto dto) {
        Event entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public EventDto update(UUID id, EventDto dto) {
        Event entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + id));
        mapper.updateEntity(dto, entity);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Event not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public EventDto getById(UUID id) {
        Event entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + id));
        return mapper.toDto(entity);
    }

    @Override
    public List<EventDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}