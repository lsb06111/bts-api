package com.example.bts_api.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "job")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Job {

    @Id
    private Long jobno;

    @Column(length = 30)
    private String jname;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;
}
