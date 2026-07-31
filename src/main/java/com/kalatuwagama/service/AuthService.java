package com.kalatuwagama.service;

import com.kalatuwagama.dto.AuthRequest;
import com.kalatuwagama.dto.AuthResponse;
import com.kalatuwagama.dto.UserDto;

public interface AuthService {
    UserDto register(UserDto userDto);
    AuthResponse login(AuthRequest request);
}