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
    public void findByModel() {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query q1 = session.createQuery(
                "select " +
                        "kl.w, " +
                        "kl.dateBd, " +
                        "kl.sPol, " +
                        "kl.nPol, " +
                        "kl.adres, " +
                        "kl.adresFact, " +
                        "kl.rfUchastokId, " +
                        "kl.contactMPhone " +
                        "from HltMkabEntity kl " +
                        "where kl.ss != '' " +
                        "and kl.gender != '' " +
                        "and kl.date_bd > dateadd(year, -18, getdate()) " +//что тут?
                        "and kl.s_pol != '' " +
                        "and kl.n_pol != '' " +
                        "and kl.adres != AdresFact " +
                        "and kl.AdresFact != '' " +
                        "and kl.rf_UchastokID != '' " +
                        "and kl.DATE_BD != '' " +
                        "and kl.contactMPhone != ''"
        );
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