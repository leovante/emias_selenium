package dataGenerator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import utilities.HibernateSessionFactory;

import java.util.List;

public class MkabProfiler {
    /*select ss,
           gender,
           date_bd,
           s_pol,
           n_pol,
           ADRES,
           AdresFact,
           rf_UchastokID,
           contactMPhone, *
    from hlt_MKAB
    where ss != ''
      and gender != ''
      and date_bd > dateadd(year, -18, getdate())
      and s_pol != ''
      and n_pol != ''
      and adres != AdresFact
      and AdresFact != ''
      and rf_UchastokID != ''
      and DATE_BD != ''
      and contactMPhone != ''
    */

    String gender;
    String date_bd;
    String s_pol;
    String n_pol;
    String adres;
    String adresFact;
    String uchastok;
    String contactMPhone;

    public MkabProfiler(ProfileData data) {
        this.gender = gender;
        this.date_bd = date_bd;
        this.s_pol = s_pol;
        this.n_pol = n_pol;
        this.adres = adres;
        this.adresFact = adresFact;
        this.uchastok = uchastok;
        this.contactMPhone = contactMPhone;
    }

    public List getMkabData() {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query q1 = session.createQuery(
                "select " +
                        "kl.addressString " +
                        "from KlaAddressEntity kl " +
                        "where kl.flags = 1 " +
                        "group by " +
                        "kl.addressString");
//        Query q2 = session.createQuery(
//                "select mk.ss, " +
//                        "mk.gender, " +
//                        "mk.date_bd, " +
//                        "mk.s_pol, " +
//                        "mk.n_pol, " +
//                        "mk.ADRES, " +
//                        "mk.AdresFact, " +
//                        "mk.rf_UchastokID, " +
//                        "mk.contactMPhone, " +
//                        "from HltMkabEntity mk " +
//                        "where mk.ss != '' " +
//                        "and mk.gender != '' " +
//                        "and mk.date_bd > dateadd(year, -18, getdate()) " +
//                        "and mk.s_pol != '' " +
//                        "and mk.n_pol != '' " +
//                        "and mk.adres != AdresFact " +
//                        "and mk.AdresFact != '' " +
//                        "and mk.rf_UchastokID != '' " +
//                        "and mk.DATE_BD != '' " +
//                        "and mk.contactMPhone != ''");
        return q1.list();
    }
}