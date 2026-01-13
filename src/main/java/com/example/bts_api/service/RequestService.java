package com.example.bts_api.service;

import com.example.bts_api.domain.DevRepo;
import com.example.bts_api.domain.Request;
import com.example.bts_api.domain.User;
import com.example.bts_api.dto.RequestRequestDTO;
import com.example.bts_api.dto.RequestResponseDTO;
import com.example.bts_api.repository.DevRepoRepository;
import com.example.bts_api.repository.RequestRepository;
import com.example.bts_api.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RequestService {

    private final RequestRepository requestRepository;
    private final UserRepository userRepository;
    private final DevRepoRepository devRepoRepository;

    @Transactional
    public RequestResponseDTO saveRequest(RequestRequestDTO req){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        User user = userRepository.findById(username)
                .orElseThrow(() -> new IllegalArgumentException("로그인 유저 없음: " + username));

        DevRepo devRepo = devRepoRepository.findById(req.getDevRepoId())
                .orElseThrow(() -> new IllegalArgumentException("개발 레포 없음: " + req.getDevRepoId()));

        Request request;

        if(req.getId() == null){ // 신규
            request = Request.builder()
                    .title(req.getTitle())
                    .content(req.getContent())
                    .isDraft(req.isDraft())
                    .delYn(req.isDelYn())
                    .user(user)
                    .devRepo(devRepo)
                    .build();
        }else{ // 수정
            request = requestRepository.findById(req.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Request 없음: " + req.getId()));

            if(!request.getUser().getUsername().equals(username))
                throw new SecurityException("작성자만 수정 요청할 수 있습니다.");

            request.setTitle(req.getTitle());
            request.setContent(req.getContent());
            request.setDraft(req.isDraft());
            request.setDelYn(req.isDelYn());
            request.setDevRepo(devRepo);
        }

        Request saved = requestRepository.save(request);
        return new RequestResponseDTO(saved.getId());
    }


}
