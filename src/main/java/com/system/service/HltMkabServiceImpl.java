package com.system.service;

import com.system.model.HltMkabEntity;
import com.system.repositories.HltMkabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
        String query = "select mk from HltMkabEntity mk where mkabid > 0 order by RAND(1)";
        Query q = em.createQuery(query, HltMkabEntity.class);
        q.setMaxResults(1);
        HltMkabEntity mk = (HltMkabEntity) q.getSingleResult();
        return Optional.ofNullable(mk);
    }
}