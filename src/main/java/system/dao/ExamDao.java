package system.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import system.model.HltDispExamEntity;
import utilities.HibernateSessionFactory;

import java.util.List;
import java.util.Optional;

public class ExamDao implements Dao<HltDispExamEntity> {

    @Override
    public Optional<HltDispExamEntity> findById(Long id) {
//        return HibernateSessionFactory.getSessionFactory().openSession().get(HltDispExamEntity.class, id);
        return null;
    }

    @Override
    public void save(HltDispExamEntity hltDispExamEntity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(hltDispExamEntity);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(HltDispExamEntity hltDispExamEntity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(hltDispExamEntity);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(HltDispExamEntity hltDispExamEntity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(hltDispExamEntity);
        tx1.commit();
        session.close();
    }


    public List<HltDispExamEntity> findAll() {
        List<HltDispExamEntity> hltDispExamEntity = (List<HltDispExamEntity>) HibernateSessionFactory
                .getSessionFactory()
                .openSession()
                .createQuery("From HltDispExamEntity")
                .list();
        return hltDispExamEntity;
    }
}
