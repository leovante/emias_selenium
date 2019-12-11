package com.system.service;

import com.system.model.HltDispCardEntity;
import com.system.model.HltDispExamEntity;
import com.system.model.HltDispExamMr;
import com.system.repositories.HltDispCardRepository;
import com.system.repositories.HltDispExamMrRepository;
import com.system.repositories.HltDispExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service("HltDispExamMrServiceImpl")
public class HltDispExamMrServiceImpl {
    @Autowired
    private HltDispCardRepository hltDispCardRepository;

    @Autowired
    private HltDispExamRepository hltDispExamRepository;

    @Autowired
    private HltDispExamMrRepository hltDispExamMrRepository;

    @Transactional
    public void delete(long ID) {
        List<HltDispExamMr> examsMr = new ArrayList<HltDispExamMr>();

        HltDispCardEntity card = hltDispCardRepository.findById(ID).get();
        UUID cardGuid = card.getGuid();

        List<HltDispExamEntity> exams = hltDispExamRepository.findByRfCardGuid(cardGuid);
        for (HltDispExamEntity exam : exams) {
            UUID examGuid = exam.getGuid();
            HltDispExamMr hltDispExamMr = hltDispExamMrRepository.findByRfExamGuid(examGuid);
            examsMr.add(hltDispExamMr);
        }
        for (HltDispExamMr examMrr : examsMr) {
            try {
                hltDispExamMrRepository.deleteByRfExamGuid(examMrr.getGuid());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}