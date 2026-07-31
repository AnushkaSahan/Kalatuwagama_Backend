package com.kalatuwagama.service.impl;

import com.kalatuwagama.dto.TeacherDto;
import com.kalatuwagama.entity.Teacher;
import com.kalatuwagama.exception.ResourceNotFoundException;
import com.kalatuwagama.mapper.EntityMapper;
import com.kalatuwagama.repository.TeacherRepository;
import com.kalatuwagama.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository repository;
    private final EntityMapper mapper;

    @Override
    public TeacherDto create(TeacherDto dto) {
        Teacher entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public TeacherDto update(UUID id, TeacherDto dto) {
        Teacher entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id: " + id));
        mapper.updateEntity(dto, entity);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Teacher not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public TeacherDto getById(UUID id) {
        Teacher entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id: " + id));
        return mapper.toDto(entity);
    }

    @Override
    public List<TeacherDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}