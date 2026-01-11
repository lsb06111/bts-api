package com.example.bts_api.controller;

import com.example.bts_api.domain.User;
import com.example.bts_api.dto.EncodeRequestDTO;
import com.example.bts_api.dto.EncodedPWDTO;
import com.example.bts_api.dto.LoginRequestDTO;
import com.example.bts_api.dto.TokenResponseDTO;
import com.example.bts_api.repository.UserRepository;
import com.example.bts_api.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    public final AuthService authService;


    @PostMapping("/login")
    public TokenResponseDTO login(@RequestBody LoginRequestDTO req){
        return authService.login(req);
    }

    @PostMapping("/getEncodePW") // raw 비밀번호 인코드 값 확인용 테스트용!!
    public EncodedPWDTO getEncodePW(@RequestBody EncodeRequestDTO req) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        EncodedPWDTO dto = new EncodedPWDTO();
        dto.setEncodedPW(encoder.encode(req.raw().trim()));
        return dto;
    }


}
