package com.system.repositories;

import com.system.model.HltDispExamMr;
import com.system.model.HltDispExamSm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HltDispExamSmRepository extends JpaRepository<HltDispExamSm, Long> {
}