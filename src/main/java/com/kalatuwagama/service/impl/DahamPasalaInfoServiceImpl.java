package com.kalatuwagama.service.impl;

import com.kalatuwagama.dto.DahamPasalaInfoDto;
import com.kalatuwagama.entity.DahamPasalaInfo;
import com.kalatuwagama.exception.ResourceNotFoundException;
import com.kalatuwagama.mapper.EntityMapper;
import com.kalatuwagama.repository.DahamPasalaInfoRepository;
import com.kalatuwagama.service.DahamPasalaInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class DahamPasalaInfoServiceImpl implements DahamPasalaInfoService {

    private final DahamPasalaInfoRepository repository;
    private final EntityMapper mapper;

    @Override
    public DahamPasalaInfoDto create(DahamPasalaInfoDto dto) {
        DahamPasalaInfo entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public DahamPasalaInfoDto update(UUID id, DahamPasalaInfoDto dto) {
        DahamPasalaInfo entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DahamPasalaInfo not found with id: " + id));
        mapper.updateEntity(dto, entity);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("DahamPasalaInfo not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public DahamPasalaInfoDto getById(UUID id) {
        DahamPasalaInfo entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DahamPasalaInfo not found with id: " + id));
        return mapper.toDto(entity);
    }

    @Override
    public List<DahamPasalaInfoDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}