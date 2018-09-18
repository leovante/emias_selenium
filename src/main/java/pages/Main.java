package pages;

import org.hibernate.Session;
import pages.sql.HltDoctorTimeTableEntity;
import pages.utilities.HibernateSessionFactory;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
//        Runtime.getRuntime().exec("src/main/resources/run_grid.bat");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
//        HltCallDoctorEntity hltCallDoctorEntity = new HltCallDoctorEntity();
        HltDoctorTimeTableEntity hltDoctorTimeTableEntity = new HltDoctorTimeTableEntity();

//        hltCallDoctorEntity.setxEdition(1);
//        hltCallDoctorEntity.setxStatus(1);
//        hltCallDoctorEntity.setRfLpuDoctorId(2062);
//        hltCallDoctorEntity.setRfMkabid(2723262);
//        hltCallDoctorEntity.setAddress("тест");
//        hltCallDoctorEntity.setComplaint("hibernate");
//        hltCallDoctorEntity.setDateCall(new Date());
//        hltCallDoctorEntity.setRfCallDoctorStatusId(1);
////        hltCallDoctorEntity.isFinalize();
//        hltCallDoctorEntity.setDateFinalize(new Date());
//        hltCallDoctorEntity.setRfTapid(0);
//        hltCallDoctorEntity.setCodeDomophon("45");
//        hltCallDoctorEntity.setPhone("987654321");
//        hltCallDoctorEntity.setRfFinalizeDocPrvdid(0);
//        hltCallDoctorEntity.setDescription("тест");
////        hltCallDoctorEntity.calldoctor("тест");
//        hltCallDoctorEntity.setEntrance(54);
//        hltCallDoctorEntity.setFloor(45);
//        hltCallDoctorEntity.setRfAddressId(0);
//        hltCallDoctorEntity.setRfDocPrvdid(0);
//        hltCallDoctorEntity.setRfFinalizeDocPrvdid(0);
//        hltCallDoctorEntity.setDateVisit(new Date());
//        hltCallDoctorEntity.setFlags(0);
//        hltCallDoctorEntity.setGuid("hibernate");
//        hltCallDoctorEntity.setRfLpuid(2314);
//        hltCallDoctorEntity.setSourceDvt(5);
//        hltCallDoctorEntity.setBirthDate(new Date());
//        hltCallDoctorEntity.setFamily("0");
//        hltCallDoctorEntity.setName("0");
//        hltCallDoctorEntity.setNumberPol("0");
//        hltCallDoctorEntity.setOt("0");
//        hltCallDoctorEntity.setRfKlSexId(2);
//        hltCallDoctorEntity.setSeriesPol("0");
//        hltCallDoctorEntity.setRfMkbid(0);
//        hltCallDoctorEntity.setDateStatus(new Date());
//        hltCallDoctorEntity.setCauseCancel("0");
//        hltCallDoctorEntity.setSourceSmp("0");
//        hltCallDoctorEntity.setCallFamily("0");
//        hltCallDoctorEntity.setCallName("0");
//        hltCallDoctorEntity.setCallPatronymic("0");
//        hltCallDoctorEntity.setRfCallPersonTypeId(0);
//        hltCallDoctorEntity.setAge(0);
//        hltCallDoctorEntity.setAgeTitle(0);
//        hltCallDoctorEntity.setDateActive(new Date());
//        hltCallDoctorEntity.setDateResolved(new Date());
//        hltCallDoctorEntity.isChild();
//        hltCallDoctorEntity.isNotification();
//        hltCallDoctorEntity.setRfUchastokId(0);
//        hltCallDoctorEntity.setRfKlAgeGroupId(3);
        hltDoctorTimeTableEntity.setRfLpuDoctorId(777);
        hltDoctorTimeTableEntity.setBeginTime(new Date());
        hltDoctorTimeTableEntity.setEndTime(new Date());
        hltDoctorTimeTableEntity.setDate(new Date());
        hltDoctorTimeTableEntity.setUguid("привет");

        session.save(hltDoctorTimeTableEntity);
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