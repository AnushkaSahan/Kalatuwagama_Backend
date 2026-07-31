package com.kalatuwagama.service.impl;

import com.kalatuwagama.dto.AnnouncementDto;
import com.kalatuwagama.entity.Announcement;
import com.kalatuwagama.exception.ResourceNotFoundException;
import com.kalatuwagama.mapper.EntityMapper;
import com.kalatuwagama.repository.AnnouncementRepository;
import com.kalatuwagama.service.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementRepository repository;
    private final EntityMapper mapper;

    @Override
    public AnnouncementDto create(AnnouncementDto dto) {
        Announcement entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public AnnouncementDto update(UUID id, AnnouncementDto dto) {
        Announcement entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Announcement not found with id: " + id));
        mapper.updateEntity(dto, entity);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Announcement not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public AnnouncementDto getById(UUID id) {
        Announcement entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Announcement not found with id: " + id));
        return mapper.toDto(entity);
    }

    @Override
    public List<AnnouncementDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}