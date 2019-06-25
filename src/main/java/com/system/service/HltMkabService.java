package com.system.service;

import com.system.model.HltMkabEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface HltMkabService<T> {

    Optional<HltMkabEntity> findById(long id);

    Optional<HltMkabEntity> findRandom();


//    List findByIdList(int id);

//    HltMkabEntity findByModel();

//    List modelWithKladr();

//    List<T> findAll();

//    void save(T t);

//    void update(T t);

//    void delete(long id);
}
