package com.system.service;

import com.system.model.HltMkabEntity;
import com.system.repositories.HltMkabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Service
public class HltMkabServiceImpl implements HltMkabService {

    @Autowired
    private HltMkabRepository hltMkabRepository;

    @PersistenceContext
    public EntityManager em;

    @Override
    public Optional<HltMkabEntity> findById(long id) {
        return hltMkabRepository.findById(id);
    }

    @Override
    public Optional<HltMkabEntity> findRandom() {
        long me = hltMkabRepository.count();
        int idx = (int) (Math.random() * me);

        String query = "select mk from HltMkabEntity mk where mkabid > 0 order by RAND(1)";
        return em.createQuery(query, HltMkabEntity.class)
                .setMaxResults(idx)
                .getResultList()
                .stream()
                .findFirst();
        // TODO: 6/17/2019 бесконечно генерит
    }
}