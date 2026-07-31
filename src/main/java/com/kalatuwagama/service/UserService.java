package com.kalatuwagama.service;

import com.kalatuwagama.dto.UserDto;
import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDto create(UserDto dto);
    UserDto update(UUID id, UserDto dto);
    void delete(UUID id);
    UserDto getById(UUID id);
    List<UserDto> getAll();
    UserDto getByEmail(String email);
}