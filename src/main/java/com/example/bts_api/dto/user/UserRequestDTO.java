package com.example.bts_api.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {

    private String username;
    private String password;
    private String githubId;
    private String name;
    private String phone;
    private String email;
    private String company;
    private Long jobno;
}
