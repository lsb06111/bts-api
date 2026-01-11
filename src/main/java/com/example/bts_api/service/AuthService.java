package com.example.bts_api.service;

import com.example.bts_api.dto.LoginRequestDTO;
import com.example.bts_api.dto.TokenResponseDTO;
import com.example.bts_api.util.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    public TokenResponseDTO login(LoginRequestDTO req){
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));

        String token = jwtProvider.createAccessToken(auth.getName());
        return new TokenResponseDTO(token);
    }
}
