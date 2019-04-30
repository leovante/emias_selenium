package com.system.dao;

import com.system.model.HltMkabEntity;
import com.system.model.User;
import com.utils.HibernateSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//<!--правка hibernate-->
@Repository
public class UserDao implements Dao {

    private List<User> users = Arrays.asList(
            new User("admin", "admin"),
            new User("user1", "user1"));

    public List<User> getAllUsers() {
        return users;
    }

    public User findById(int id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(User.class, id);
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public void save(HltMkabEntity hltMkabEntity) {

    }

    @Override
    public void update(HltMkabEntity hltMkabEntity) {

    }

    @Override
    public void delete(HltMkabEntity hltMkabEntity) {

    }
}