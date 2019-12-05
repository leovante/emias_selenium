package com.system.service;

import com.system.model.HltDispCardEntity;
import com.system.repositories.HltDispCardRepository;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HltDispCardServiceImpl {
    @Autowired
    private HltDispCardRepository hltDispCardRepository;

    @Transactional
    public void open(long ID) {
        HltDispCardEntity card = hltDispCardRepository.getByDispCardId(ID);
        card.setClosed(false);
        card.setOtkaz(false);
        hltDispCardRepository.save(card);
    }
}