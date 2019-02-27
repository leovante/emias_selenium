package system.dao;

import org.springframework.stereotype.Repository;
import system.model.HltDispExamEntity;
import system.model.HltMkabEntity;
import utilities.HibernateSessionFactory;

import java.util.List;
import java.util.Optional;

@Repository
public class HltDispExamDao implements Dao {
//<!--правка hibernate-->

//    public HltDispExamEntity findById(int id) {
//        return HibernateSessionFactory.getSessionFactory().openSession().get(HltDispExamEntity.class, id);
//    }
//
//    @Override
//    public void save(HltDispExamEntity hltDispExamEntity) {
//        Session session = HibernateSessionFactory.getSessionFactory().openSession();
//        Transaction tx1 = session.beginTransaction();
//        session.save(hltDispExamEntity);
//        tx1.commit();
//        session.close();
//    }
//
//    @Override
//    public void update(HltDispExamEntity hltDispExamEntity) {
//        Session session = HibernateSessionFactory.getSessionFactory().openSession();
//        Transaction tx1 = session.beginTransaction();
//        session.update(hltDispExamEntity);
//        tx1.commit();
//        session.close();
//    }
//
//    @Override
//    public void delete(HltDispExamEntity hltDispExamEntity) {
//        Session session = HibernateSessionFactory.getSessionFactory().openSession();
//        Transaction tx1 = session.beginTransaction();
//        session.delete(hltDispExamEntity);
//        tx1.commit();
//        session.close();
//    }

    @Override
    public Optional<HltDispExamEntity> findById(Long id) {
        return Optional.empty();
    }

    public List<HltDispExamEntity> findAll() {
        List<HltDispExamEntity> hltDispExamEntity = (List<HltDispExamEntity>) HibernateSessionFactory
                .getSessionFactory()
                .openSession()
                .createQuery("From HltDispExamEntity")
                .list();
        return hltDispExamEntity;
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
