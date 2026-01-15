package com.example.bts_api.controller;

import com.example.bts_api.dto.user.UserDetailResponseDTO;
import com.example.bts_api.dto.user.UserRequestDTO;
import com.example.bts_api.dto.user.UserResponseDTO;
import com.example.bts_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;

    @PostMapping("/add")
    public UserResponseDTO addUser(@RequestBody UserRequestDTO req){
        return userService.addUser(req);
    }

    @GetMapping("/listAll")
    public List<UserDetailResponseDTO> getAllUser(){
        return userService.listAll();
    }
}
