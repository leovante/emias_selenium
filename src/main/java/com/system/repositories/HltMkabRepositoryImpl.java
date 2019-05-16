package com.system.repositories;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class HltMkabRepositoryImpl implements CustomHltMkabRepository {

    @Autowired
    private EntityManager em;

    public int findOneResultById(int id) {
        return em.createQuery("select mk from HltMkabEntity mk").getFirstResult();
    }
}