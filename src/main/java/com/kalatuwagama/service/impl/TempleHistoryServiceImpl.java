package com.kalatuwagama.service.impl;

import com.kalatuwagama.dto.TempleHistoryDto;
import com.kalatuwagama.entity.TempleHistory;
import com.kalatuwagama.exception.ResourceNotFoundException;
import com.kalatuwagama.mapper.EntityMapper;
import com.kalatuwagama.repository.TempleHistoryRepository;
import com.kalatuwagama.service.TempleHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TempleHistoryServiceImpl implements TempleHistoryService {

    private final TempleHistoryRepository repository;
    private final EntityMapper mapper;

    @Override
    public TempleHistoryDto create(TempleHistoryDto dto) {
        TempleHistory entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public TempleHistoryDto update(UUID id, TempleHistoryDto dto) {
        TempleHistory entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TempleHistory not found with id: " + id));
        mapper.updateEntity(dto, entity);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("TempleHistory not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public TempleHistoryDto getById(UUID id) {
        TempleHistory entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TempleHistory not found with id: " + id));
        return mapper.toDto(entity);
    }

    @Override
    public List<TempleHistoryDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}