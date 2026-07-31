package com.kalatuwagama.service.impl;

import com.kalatuwagama.dto.AuthRequest;
import com.kalatuwagama.dto.AuthResponse;
import com.kalatuwagama.dto.UserDto;
import com.kalatuwagama.entity.User;
import com.kalatuwagama.exception.BadRequestException;
import com.kalatuwagama.mapper.EntityMapper;
import com.kalatuwagama.repository.UserRepository;
import com.kalatuwagama.security.JwtTokenUtil;
import com.kalatuwagama.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final EntityMapper mapper;

    @Override
    public UserDto register(UserDto userDto) {
        if (userRepository.existsByEmail(userDto.email())) {
            throw new BadRequestException("Email already in use");
        }
        User user = new User();
        user.setFirstName(userDto.firstName());
        user.setLastName(userDto.lastName());
        user.setEmail(userDto.email());
        user.setPassword(passwordEncoder.encode(userDto.password()));
        user.setRole(userDto.role() != null ? userDto.role() : "VIEWER");
        user = userRepository.save(user);
        return mapper.toUserDto(user);   // <-- fixed method name
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtTokenUtil.generateToken(userDetails);
        String role = userDetails.getAuthorities().stream()
                .findFirst().map(auth -> auth.getAuthority().replace("ROLE_", ""))
                .orElse("VIEWER");
        return new AuthResponse(token, userDetails.getUsername(), role);
    }
}