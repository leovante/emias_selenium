package pages;

import org.hibernate.Session;
import utilities.HibernateSessionFactory;
import system.model.HltCallDoctorEntity;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().exec("src/main/resources/run_grid.bat");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        HltCallDoctorEntity hltCallDoctorEntity = new HltCallDoctorEntity();
        hltCallDoctorEntity.setBirthDate(new java.util.Date());
        session.save(hltCallDoctorEntity);
        session.getTransaction().commit();
        session.close();

//        TODO Auto-generated method stub
//        GridHubConfiguration configHub = new GridHubConfiguration();
//        configHub.host = "localhost";
//        configHub.port = 8060;
//
//        //GridNodeConfiguration configNode = new GridNodeConfiguration();
//        //configNode.host = configHub.host;
//        //configNode.port = 5300;
//
//        Hub hub = new Hub(configHub);
//        //configNode.getHubHost();
//        hub.start();
        //System.out.println(configNode.getRemoteHost());
        //hub.stop();


//        TestListenerAdapter tla = new TestListenerAdapter();
//        TestNG testng = new TestNG();
//        List<String> suites = Lists.newArrayList();
//        suites.add("src/test/resources/testngMIS.xml");
//        suites.add("src/test/resources/testngCD.xml");
//        suites.add("src/test/resources/testngTest.xml");
//        testng.setTestSuites(suites);
//        testng.run();
    }
}