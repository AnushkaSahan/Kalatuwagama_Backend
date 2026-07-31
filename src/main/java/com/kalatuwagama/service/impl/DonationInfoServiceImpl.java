package com.kalatuwagama.service.impl;

import com.kalatuwagama.dto.DonationInfoDto;
import com.kalatuwagama.entity.DonationInfo;
import com.kalatuwagama.exception.ResourceNotFoundException;
import com.kalatuwagama.mapper.EntityMapper;
import com.kalatuwagama.repository.DonationInfoRepository;
import com.kalatuwagama.service.DonationInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class DonationInfoServiceImpl implements DonationInfoService {

    private final DonationInfoRepository repository;
    private final EntityMapper mapper;

    @Override
    public DonationInfoDto create(DonationInfoDto dto) {
        DonationInfo entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public DonationInfoDto update(UUID id, DonationInfoDto dto) {
        DonationInfo entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DonationInfo not found with id: " + id));
        mapper.updateEntity(dto, entity);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("DonationInfo not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public DonationInfoDto getById(UUID id) {
        DonationInfo entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DonationInfo not found with id: " + id));
        return mapper.toDto(entity);
    }

    @Override
    public List<DonationInfoDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}