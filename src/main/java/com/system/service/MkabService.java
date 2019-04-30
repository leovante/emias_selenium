package com.system.service;

import com.system.model.HltMkabEntity;

import java.util.List;

public interface MkabService<T> {

    HltMkabEntity findById(int id);

    List findByIdList(int id);

    HltMkabEntity findByModel();

    List modelWithKladr();

    List<T> findAll();

    void save(T t);

    void update(T t);

    void delete(long id);
}
