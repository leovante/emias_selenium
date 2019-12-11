package com.system.service;

import com.system.model.HltDispExamEntity;
import com.system.repositories.HltDispCardRepository;
import com.system.repositories.HltDispExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service("HltDispExamServiceImpl")
public class HltDispExamServiceImpl {

    @Autowired
    private HltDispCardRepository hltDispCardRepository;

    @Autowired
    private HltDispExamRepository hltDispExamRepository;

    @Transactional
    public void resetCardExams(long ID) {
        UUID uuid = hltDispCardRepository.findById(ID).get().getGuid();
        List<HltDispExamEntity> exams = hltDispExamRepository.findByRfCardGuid(uuid);
        for (HltDispExamEntity exam : exams) {
            exam.setSigned(false);
        }
    }
}