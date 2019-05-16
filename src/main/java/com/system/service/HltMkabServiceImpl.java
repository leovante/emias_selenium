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

/*    @Override
    public List findByIdList(int id) {
        return hltMkabDao.findByIdList(id);
    }

    @Override
    public HltMkabEntity findByModel() {
        return hltMkabDao.findByModel();
    }

    @Override
    public List modelWithKladr() {
        return hltMkabDao.modelWithKladr();
    }

    @Override
    public List findAll() {
        return hltMkabDao.findAll();
    }

    @Override
    public void save(Object o) {
    }

    @Override
    public void update(Object o) {
    }

    @Override
    public void delete(long id) {
    }*/
}