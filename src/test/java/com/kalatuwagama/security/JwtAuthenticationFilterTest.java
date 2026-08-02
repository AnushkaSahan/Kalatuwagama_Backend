package com.kalatuwagama.security;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JwtAuthenticationFilterTest {

    @Mock
    private JwtTokenUtil jwtTokenUtil;

    @Mock
    private CustomUserDetailsService userDetailsService;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private FilterChain chain;

    @InjectMocks
    private JwtAuthenticationFilter filter;

    @Test
    void shouldIgnoreExpiredTokenAndContinueChain() throws Exception {
        SecurityContextHolder.clearContext();
        when(request.getHeader("Authorization")).thenReturn("Bearer expired-token");
        when(jwtTokenUtil.extractUsername("expired-token"))
                .thenThrow(new ExpiredJwtException(null, null, "Token expired"));

        assertDoesNotThrow(() -> filter.doFilterInternal(request, response, chain));
        verify(chain).doFilter(request, response);
    }
}
