package com.kalatuwagama.dto;

public record AuthResponse(
        String token,
        String email,
        String role
) {}
