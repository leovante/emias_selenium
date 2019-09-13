package com.system.service;

import com.system.model.HltDispExamEntity;
import com.system.repositories.HltDispCardRepository;
import com.system.repositories.HltDispExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.stream.Stream;

@Service
public class HltDispExamServiceImpl {

    @Autowired
    private HltDispCardRepository hltDispCardRepository;

    @Autowired
    private HltDispExamRepository hltDispExamRepository;

    @Transactional(readOnly = true)
    public void resetCardExams(Long num) {
        UUID uuid = hltDispCardRepository.findById(num).get().getGuid();
        try (Stream<HltDispExamEntity> exam = hltDispExamRepository.findByRfCardGuid(uuid)) {
            exam.forEach(e -> e.setOtkaz(false));
        }
    }
}