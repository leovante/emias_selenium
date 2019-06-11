package com.system.service;

import com.system.model.HltMkabEntity;
import com.system.repositories.HltMkabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HltMkabServiceImpl implements HltMkabService {

    @Autowired
    private HltMkabRepository hltMkabRepository;

    @Override
    public Optional<HltMkabEntity> findById(int id) {
        return hltMkabRepository.findById(id);
    }

    @Override
    public HltMkabEntity findRandom() {
        double d = Math.random();
        double f = hltMkabRepository.countAllByName();
        return findById((int) (d * f)).get();
    }
}