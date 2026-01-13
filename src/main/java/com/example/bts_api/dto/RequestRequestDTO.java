package com.example.bts_api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class RequestRequestDTO {

    private Long id;
    private String title;
    private String content;
    private boolean isDraft;
    private boolean delYn;
    private Long devRepoId;
}
