package com.system.service;

import com.system.model.HltDispCardEntity;
import com.system.repositories.HltDispCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HltDispCardServiceImpl {

    @Autowired
    private HltDispCardRepository hltDispCardRepository;

    public void unClose(long cardNum) {
        HltDispCardEntity card = hltDispCardRepository.getByDispCardId(cardNum);
        card.setClosed(false);
        hltDispCardRepository.save(card);
    }
}