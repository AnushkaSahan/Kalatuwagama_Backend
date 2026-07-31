package com.kalatuwagama.service.impl;

import com.kalatuwagama.dto.MonkDto;
import com.kalatuwagama.entity.Monk;
import com.kalatuwagama.exception.ResourceNotFoundException;
import com.kalatuwagama.mapper.EntityMapper;
import com.kalatuwagama.repository.MonkRepository;
import com.kalatuwagama.service.MonkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MonkServiceImpl implements MonkService {

    private final MonkRepository repository;
    private final EntityMapper mapper;

    @Override
    public MonkDto create(MonkDto dto) {
        Monk entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public MonkDto update(UUID id, MonkDto dto) {
        Monk entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Monk not found with id: " + id));
        mapper.updateEntity(dto, entity);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Monk not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public MonkDto getById(UUID id) {
        Monk entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Monk not found with id: " + id));
        return mapper.toDto(entity);
    }

    @Override
    public List<MonkDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}