package com.kalatuwagama.security;

public class SecurityConstants {
    public static final String SECRET_KEY = "${jwt.secret}";
    public static final long EXPIRATION_TIME = 86400000; // 24h
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/auth/register";
    public static final String LOGIN_URL = "/api/auth/login";
}