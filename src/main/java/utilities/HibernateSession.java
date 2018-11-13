package utilities;

import org.hibernate.Session;
import system.model.HltCallDoctorEntity;

import java.io.IOException;

public class HibernateSession {

    public static void run() throws IOException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        HltCallDoctorEntity hltCallDoctorEntity = new HltCallDoctorEntity();
        hltCallDoctorEntity.setBirthDate(new java.util.Date());

        session.save(hltCallDoctorEntity);
        session.getTransaction().commit();
        session.close();
    }
}