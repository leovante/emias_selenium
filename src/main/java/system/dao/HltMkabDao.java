package system.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import system.model.HltMkabEntity;
import utilities.HibernateSessionFactory;

import java.util.List;

@Repository
public class HltMkabDao implements MkabDao {

    @Override
    public HltMkabEntity findById(int id) {
        return HibernateSessionFactory
                .getSessionFactory()
                .openSession()
                .get(HltMkabEntity.class, id);
    }

    @Override
    public HltMkabEntity findByModel() {
//        MkabBuilder findByModel = MkabBuilder.newBuilder()
//                .setW()
//                .setIsAdult()//0-ребенок; 1-взрослый; пусто-без возрастной
//                .contactMPhone()
//                .

        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        /*----*/
        session.createQuery(
                "from HltMkabEntity me " +
                        "where me.ss != '' " +
                        "and me.w != 0 " +
//                        "and me.datebd > dateadd(year, -18, getdate()) " +//что тут?
                        "and me.sPol != '' " +
                        "and me.nPol != '' " +
//                        "and me.adres != AdresFact " +
                        "and me.adresFact != '' " +
                        "and me.rfUchastokId != 0 " +
                        "and me.dateBd != '' " +
                        "and me.contactMPhone != ''"
        );
        return null;
    }

    @Override
    public List findByIdList(int id) {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query q1 = session.createQuery(
                "select " +
                        "kl.addressString " +
                        "from KlaAddressEntity kl " +
                        "where kl.flags = 1 " +
                        "group by " +
                        "kl.addressString");
        return q1.list();
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