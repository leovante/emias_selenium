package emias.callcenter.before;

import com.testRunner.TestNGBase;

public class BeforeSuiteCallCenter extends TestNGBase {

//    @Test(description = "Создаю новое расписание на сегодня")
//    @RetryCountIfFailed(2)
//    public void cancelCalls() throws InterruptedException, IOException, ParseException {
//        updateDB();
//        deleteShedule();
//        createShedule();

//        page.misHome().loginMis(site, loginMis, pass);
//        switchTo().window(0);
//        page.homePageMis().vedenieRaspisaniyaBtn();
//        createDoctorShedule();
//    }

//    @Step("Создаю расписание врача")
//    public void createDoctorShedule() throws InterruptedException {
//        ArrayList<String> doctors = new ArrayList<>();
//        doctors.add("Темников Дмитрий Олегович");
//        doctors.add("Моков Павел Александрович");
//        doctors.add("Серова Нина Кузьминична");
//        doctors.add("Немцова Татьяна Андреевна");
//        doctors.add("Юдина Татьяна Борисовна");//взрослая поликлиника
//        doctors.add("Зайцева Татьяна Михайловна");//детская поликлиника
//        for (String doctor_num : doctors) {
//            String doctor_fam = ManageShedule.getSecondName(doctor_num);
//            SQLDemonstration.finalizeCallLpuDoctor(doctor_fam);
//            SQLDemonstration.deleteShedule(doctor_fam);
//        }
//        for (String doctor_num : doctors) {
//            page.doctorMethods().selectDoctor(doctor_num);
//            page.beforeWork().createShedule();
//            page.manageShedule().verifyCreatedShedule(doctor_num);
//            page.doctorMethods().selectDoctor(doctor_num);
//        }
//    }
//
//    @Step("Обновляю БД для тестов на случай её изменения")
//    public void updateDB() throws IOException {
//        SQLDemonstration.scriptsToCalldoctor();
//    }
//
//    @Step("Создание расписания для врачей")
//    void createShedule() throws FileNotFoundException, ParseException {
//        SQLDemonstration.createSheduleCD(2078, 1220);
//        SQLDemonstration.createSheduleCD(1958, 1253);
//        SQLDemonstration.createSheduleCD(2075, 1244);
//        SQLDemonstration.createSheduleCD(1932, 1249);
//        SQLDemonstration.createSheduleCD(1941, 1278);
//        SQLDemonstration.createSheduleCD(2062, 1202);
//    }
//
//    @Step("Удаляю расписание")
//    void deleteShedule() throws FileNotFoundException, ParseException {
//        SQLDemonstration.deleteShedule(2078, 1220);
//        SQLDemonstration.deleteShedule(1958, 1253);
//        SQLDemonstration.deleteShedule(2075, 1244);
//        SQLDemonstration.deleteShedule(1932, 1249);
//        SQLDemonstration.deleteShedule(1941, 1278);
//        SQLDemonstration.deleteShedule(2062, 1202);
//    }
}