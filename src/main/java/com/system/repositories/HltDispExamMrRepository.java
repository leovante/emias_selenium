package com.system.repositories;

import com.system.model.HltDispExamMr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface HltDispExamMrRepository extends JpaRepository<HltDispExamMr, Long> {

    @Query(value = "select cd from HltDispExamMr cd where cd.rfExamGuid = :ExamGuid")
    HltDispExamMr findByRfExamGuid (@Param("ExamGuid") UUID ExamGuid);

    HltDispExamMr deleteByRfExamGuid (UUID ExamGuid);
}