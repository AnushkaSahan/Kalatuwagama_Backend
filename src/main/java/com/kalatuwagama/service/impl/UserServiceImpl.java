package com.kalatuwagama.service.impl;

import com.kalatuwagama.dto.UserDto;
import com.kalatuwagama.entity.User;
import com.kalatuwagama.exception.BadRequestException;
import com.kalatuwagama.exception.ResourceNotFoundException;
import com.kalatuwagama.mapper.EntityMapper;
import com.kalatuwagama.repository.UserRepository;
import com.kalatuwagama.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EntityMapper mapper; // We need to add user mapping in mapper

    @Override
    public UserDto create(UserDto dto) {
        if (userRepository.existsByEmail(dto.email())) {
            throw new BadRequestException("Email already in use");
        }
        User user = new User();
        user.setFirstName(dto.firstName());
        user.setLastName(dto.lastName());
        user.setEmail(dto.email());
        user.setPassword(passwordEncoder.encode(dto.password())); // password is in DTO? We'll assume it's present, but UserDto may not contain password. We'll add a password field in UserDto for admin creation.
        user.setRole(dto.role());
        user = userRepository.save(user);
        return mapper.toUserDto(user);
    }

    @Override
    public UserDto update(UUID id, UserDto dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        // Update fields (ignore password for now, or allow)
        if (dto.firstName() != null) user.setFirstName(dto.firstName());
        if (dto.lastName() != null) user.setLastName(dto.lastName());
        if (dto.email() != null && !dto.email().equals(user.getEmail())) {
            if (userRepository.existsByEmail(dto.email())) {
                throw new BadRequestException("Email already in use");
            }
            user.setEmail(dto.email());
        }
        if (dto.role() != null) user.setRole(dto.role());
        // Password update not handled here; use separate endpoint
        user = userRepository.save(user);
        return mapper.toUserDto(user);
    }

    @Override
    public void delete(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public UserDto getById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return mapper.toUserDto(user);
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream()
                .map(mapper::toUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
        return mapper.toUserDto(user);
    }
}