package com.example.bts_api.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dev_repo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DevRepo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String projectName;

    @Column(length = 50, nullable = false)
    private String ownerUsername;

    @Column(length = 500, nullable = false)
    private String repoName;

    @Column(nullable = false)
    private String repoToken;

    @Column(length = 9)
    @Builder.Default
    private String currentStage = "진행중";

}
