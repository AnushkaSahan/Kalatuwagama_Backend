package com.kalatuwagama.service.impl;

import com.kalatuwagama.dto.StudentDto;
import com.kalatuwagama.entity.Student;
import com.kalatuwagama.exception.ResourceNotFoundException;
import com.kalatuwagama.mapper.EntityMapper;
import com.kalatuwagama.repository.StudentRepository;
import com.kalatuwagama.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    private final EntityMapper mapper;

    @Override
    public StudentDto create(StudentDto dto) {
        Student entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public StudentDto update(UUID id, StudentDto dto) {
        Student entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        mapper.updateEntity(dto, entity);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Student not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public StudentDto getById(UUID id) {
        Student entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        return mapper.toDto(entity);
    }

    @Override
    public List<StudentDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}