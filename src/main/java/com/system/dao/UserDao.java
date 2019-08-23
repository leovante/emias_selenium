package com.system.dao;

import org.springframework.stereotype.Repository;
import com.system.model.User;
import com.utils.HibernateSessionFactory;

import java.util.Arrays;
import java.util.List;

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
    public void save(Object o) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Object o) {

    }


//    @Override
//    public Optional get(long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List getAll() {
//        return null;
//    }

//    @Override
//    public void save(Object o) {
//        Session session = HibernateSessionFactory.getSessionFactory().openSession();
//        Transaction tx1 = session.beginTransaction();
//        session.save(user);
//        tx1.commit();
//        session.close();
//    }
//
//    @Override
//    public void update(Object o, String[] params) {
//        Session session = HibernateSessionFactory.getSessionFactory().openSession();
//        Transaction tx1 = session.beginTransaction();
//        session.update(user);
//        tx1.commit();
//        session.close();
//    }
//
//    @Override
//    public void delete(Object o) {
//        Session session = HibernateSessionFactory.getSessionFactory().openSession();
//        Transaction tx1 = session.beginTransaction();
//        session.delete(user);
//        tx1.commit();
//        session.close();
//    }
//
//    public Auto findAutoById(int id) {
//        return HibernateSessionFactory.getSessionFactory().openSession().get(Auto.class, id);
//    }
//
//    public List<User> findAll() {
//        List<User> users = (List<User>) HibernateSessionFactory.getSessionFactory().openSession().createQuery("From User").list();
//        return users;
//    }

}
