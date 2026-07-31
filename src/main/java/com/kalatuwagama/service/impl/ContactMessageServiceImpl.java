package com.kalatuwagama.service.impl;

import com.kalatuwagama.dto.ContactMessageDto;
import com.kalatuwagama.entity.ContactMessage;
import com.kalatuwagama.exception.ResourceNotFoundException;
import com.kalatuwagama.mapper.EntityMapper;
import com.kalatuwagama.repository.ContactMessageRepository;
import com.kalatuwagama.service.ContactMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ContactMessageServiceImpl implements ContactMessageService {

    private final ContactMessageRepository repository;
    private final EntityMapper mapper;

    @Override
    public ContactMessageDto create(ContactMessageDto dto) {
        ContactMessage entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public ContactMessageDto update(UUID id, ContactMessageDto dto) {
        ContactMessage entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ContactMessage not found with id: " + id));
        // We may not want to update contact messages, but we implement it anyway.
        // MapStruct will ignore nulls, so partial updates are possible.
        mapper.updateEntity(dto, entity);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("ContactMessage not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public ContactMessageDto getById(UUID id) {
        ContactMessage entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ContactMessage not found with id: " + id));
        return mapper.toDto(entity);
    }

    @Override
    public List<ContactMessageDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}