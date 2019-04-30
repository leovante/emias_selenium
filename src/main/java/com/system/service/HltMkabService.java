package com.system.service;

import com.system.dao.HltMkabDao;
import com.system.model.HltMkabEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HltMkabService implements MkabService {

    @Autowired
    private HltMkabDao hltMkabDao;

    @Override
    public HltMkabEntity findById(int id) {
        return hltMkabDao.findById(id);
    }

    @Override
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
    }
}