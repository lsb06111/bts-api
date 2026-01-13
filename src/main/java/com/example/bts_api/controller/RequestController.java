package com.example.bts_api.controller;

import com.example.bts_api.dto.RequestRequestDTO;
import com.example.bts_api.dto.RequestResponseDTO;
import com.example.bts_api.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/request")
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;

    @PostMapping("/add")
    public RequestResponseDTO addRequest(RequestRequestDTO req){
        return requestService.saveRequest(req);
    }

    @PostMapping("/modify")
    public RequestResponseDTO modifyRequest(RequestRequestDTO req){
        return requestService.saveRequest(req);
    }
}
