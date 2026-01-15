package com.example.bts_api.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDetailResponseDTO {

    private String username;
    private String githubId;
    private String name;
    private String phone;
    private String email;
    private String company;
    private Long jobno;
}
