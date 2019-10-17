package com.system.repositories;

import com.system.model.HltDispExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface HltDispExamRepository extends JpaRepository<HltDispExamEntity, Long> {
    List<HltDispExamEntity> findByRfCardGuid(UUID rfCardGuid);
}