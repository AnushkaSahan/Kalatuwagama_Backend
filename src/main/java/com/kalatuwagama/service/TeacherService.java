package com.kalatuwagama.service;

import com.kalatuwagama.dto.TeacherDto;
import java.util.List;
import java.util.UUID;

public interface TeacherService {
    TeacherDto create(TeacherDto dto);
    TeacherDto update(UUID id, TeacherDto dto);
    void delete(UUID id);
    TeacherDto getById(UUID id);
    List<TeacherDto> getAll();
}