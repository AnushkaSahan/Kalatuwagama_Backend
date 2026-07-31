package com.kalatuwagama.service.impl;

import com.kalatuwagama.dto.FoundationProjectDto;
import com.kalatuwagama.entity.FoundationProject;
import com.kalatuwagama.exception.ResourceNotFoundException;
import com.kalatuwagama.mapper.EntityMapper;
import com.kalatuwagama.repository.FoundationProjectRepository;
import com.kalatuwagama.service.FoundationProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class FoundationProjectServiceImpl implements FoundationProjectService {

    private final FoundationProjectRepository repository;
    private final EntityMapper mapper;

    @Override
    public FoundationProjectDto create(FoundationProjectDto dto) {
        FoundationProject entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public FoundationProjectDto update(UUID id, FoundationProjectDto dto) {
        FoundationProject entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FoundationProject not found with id: " + id));
        mapper.updateEntity(dto, entity);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("FoundationProject not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public FoundationProjectDto getById(UUID id) {
        FoundationProject entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FoundationProject not found with id: " + id));
        return mapper.toDto(entity);
    }

    @Override
    public List<FoundationProjectDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}