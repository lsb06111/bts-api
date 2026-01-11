package com.example.bts_api.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @Column(length = 30, nullable = false, unique = true)
    private String username;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(length = 39, unique = true) // github id는 39까지 가능
    private String githubId;

    @Column(length = 20)
    private String name;

    @Column(length = 20, unique = true)
    private String phone;

    @Column(unique = true)
    private String email;

    @Column(length = 100)
    private String company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobno")
    private Job job;



}
