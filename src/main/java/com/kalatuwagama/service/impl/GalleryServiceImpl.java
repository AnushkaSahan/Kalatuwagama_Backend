package com.kalatuwagama.service.impl;

import com.kalatuwagama.dto.GalleryDto;
import com.kalatuwagama.entity.Gallery;
import com.kalatuwagama.exception.ResourceNotFoundException;
import com.kalatuwagama.mapper.EntityMapper;
import com.kalatuwagama.repository.GalleryRepository;
import com.kalatuwagama.service.GalleryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class GalleryServiceImpl implements GalleryService {

    private final GalleryRepository repository;
    private final EntityMapper mapper;

    @Override
    public GalleryDto create(GalleryDto dto) {
        Gallery entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public GalleryDto update(UUID id, GalleryDto dto) {
        Gallery entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gallery not found with id: " + id));
        mapper.updateEntity(dto, entity);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Gallery not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public GalleryDto getById(UUID id) {
        Gallery entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gallery not found with id: " + id));
        return mapper.toDto(entity);
    }

    @Override
    public List<GalleryDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}