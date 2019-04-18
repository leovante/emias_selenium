package system.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import system.model.HltMkabEntity;
import utils.HibernateSessionFactory;

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
        HltMkabEntity hltMkabEntity = HibernateSessionFactory.getSessionFactory()
                .openSession()
                .createQuery(
                        "from HltMkabEntity me " +
//                                "inner join KlaAddressEntity klaa on me.rfAddressRegId = klaa.addressId " +
                                "where me.ss != '' " +
                                "and me.w != 0 " +
//                        "and me.datebd > dateadd(year, -18, getdate()) " +//что тут?
                                "and me.sPol != '' " +
                                "and me.nPol != '' " +
//                        "and me.adres != AdresFact " +
                                "and me.adresFact != '' " +
                                "and me.rfUchastokId != 0 " +
                                "and me.dateBd != '' " +
                                "and me.contactMPhone != ''", HltMkabEntity.class
                )
                .setMaxResults(1)
                .getSingleResult();
        return hltMkabEntity;
    }

    @Override
    public List modelWithKladr() {
        List hltMkabEntity = HibernateSessionFactory.getSessionFactory()
                .openSession()
                .createQuery(
                        "from HltMkabEntity me, KlaAddressEntity kl " +
//                                "inner join KlaAddressEntity kl on me.rfAddressRegId = kl.addressId " +
                                "where me.rfAddressRegId = kl.addressId " +
                                "and me.ss != '' " +
                                "and me.w != 0 " +
                                "and me.sPol != '' " +
                                "and me.nPol != '' " +
                                "and me.adresFact != '' " +
                                "and me.rfAddressRegId != null " +
                                "and me.rfUchastokId != 0 " +
                                "and me.dateBd != '' " +
                                "and me.contactMPhone != '' order by newid()"
                )
                .setMaxResults(1)
                .list();
        return hltMkabEntity;
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