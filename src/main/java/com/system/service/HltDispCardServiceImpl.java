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
    @Step("Close disp card")
    public void unClose(long cardNum) {
        HltDispCardEntity card = hltDispCardRepository.getByDispCardId(cardNum);
        card.setClosed(false);
        hltDispCardRepository.save(card);
    }
}