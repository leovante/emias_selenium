package com.system.repositories;

import com.system.model.HltMkabEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class HltMkabRepositoryImpl {

    @Autowired
    private HltMkabRepository mkabRepository;

    public Optional<HltMkabEntity> findById(int id) {
        return mkabRepository.findById(id);
    }
}