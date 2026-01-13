package com.example.bts_api.repository;

import com.example.bts_api.domain.DevRepo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevRepoRepository extends JpaRepository<DevRepo, Long> {
}
