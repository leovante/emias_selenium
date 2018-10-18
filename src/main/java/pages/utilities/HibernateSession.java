package pages.utilities;

import org.hibernate.Session;
import pages.sql.HltCallDoctorEntity;

import java.io.IOException;

public class HibernateSession {
    public static void run() throws IOException {
        Runtime.getRuntime().exec("src/main/resources/run_grid.bat");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        HltCallDoctorEntity hltCallDoctorEntity = new HltCallDoctorEntity();
        hltCallDoctorEntity.setBirthDate(new java.util.Date());

        session.save(hltCallDoctorEntity);
        session.getTransaction().commit();
        session.close();
    }
}