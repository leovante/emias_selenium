package system.dao;

import org.springframework.stereotype.Repository;
import system.model.HltMkabEntity;
import utilities.HibernateSessionFactory;

import java.util.List;

@Repository
public class HltMkabDao implements MkabDao {

    @Override
    public HltMkabEntity findById(int id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(HltMkabEntity.class, id);
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
    public void delete(long id) {

    }
}