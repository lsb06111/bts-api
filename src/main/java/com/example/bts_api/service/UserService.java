package com.example.bts_api.service;

import com.example.bts_api.domain.Job;
import com.example.bts_api.domain.User;
import com.example.bts_api.dto.user.UserDetailResponseDTO;
import com.example.bts_api.dto.user.UserRequestDTO;
import com.example.bts_api.dto.user.UserResponseDTO;
import com.example.bts_api.repository.JobRepository;
import com.example.bts_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;
    public final JobRepository jobRepository;
    public final PasswordEncoder passwordEncoder;

    public UserResponseDTO addUser(UserRequestDTO req){
        Job job = jobRepository.findById(req.getJobno())
                .orElseThrow(() -> new IllegalArgumentException("직무가 없습니다."));

        String encodedPw = passwordEncoder.encode(req.getPassword());

        User newUser = User.builder()
                .username(req.getUsername())
                .password(encodedPw)
                .githubId(req.getGithubId())
                .name(req.getName())
                .phone(req.getPhone())
                .email(req.getEmail())
                .company(req.getCompany())
                .job(job)
                .build();

        userRepository.save(newUser);

        return new UserResponseDTO(req.getUsername());
    }

    public List<UserDetailResponseDTO> listAll(){
        List<User> userList = userRepository.findAll();

        return userList.stream()
                .map(user -> new UserDetailResponseDTO(
                        user.getUsername(),
                        user.getGithubId(),
                        user.getName(),
                        user.getPhone(),
                        user.getEmail(),
                        user.getCompany(),
                        user.getJob() == null ? null : user.getJob().getJobno()
                )).toList();
    }
}
