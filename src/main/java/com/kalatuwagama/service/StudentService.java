package com.kalatuwagama.service;

import com.kalatuwagama.dto.StudentDto;
import java.util.List;
import java.util.UUID;

public interface StudentService {
    StudentDto create(StudentDto dto);
    StudentDto update(UUID id, StudentDto dto);
    void delete(UUID id);
    StudentDto getById(UUID id);
    List<StudentDto> getAll();
}