package emias.calldoctor.before;

import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.sql.SQLDemonstration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class BeforeSuiteCalldoctor extends AbstractTestGrid {

    @Test(description = "Создаю новое расписание на сегодня")
    @RetryCountIfFailed(2)
    public void cleanBeforeCallDoctorTests() throws IOException, ParseException {
        updateDB();
        deleteShedule();
        createShedule();
    }

    @Step("Обновляю БД для тестов на случай её изменения")
    public void updateDB() throws IOException {
        SQLDemonstration.scriptsToCalldoctor();
    }

    @Step("Создание расписания для врачей")
    void createShedule() throws FileNotFoundException, ParseException {
        SQLDemonstration.createSheduleCD(2078, 1220);
        SQLDemonstration.createSheduleCD(1958, 1253);
        SQLDemonstration.createSheduleCD(2075, 1244);
        SQLDemonstration.createSheduleCD(1932, 1249);
        SQLDemonstration.createSheduleCD(1941, 1278);
        SQLDemonstration.createSheduleCD(2062, 1202);
    }

    @Step("Удаляю расписание")
    void deleteShedule() throws FileNotFoundException, ParseException {
        SQLDemonstration.deleteShedule(2078, 1220);
        SQLDemonstration.deleteShedule(1958, 1253);
        SQLDemonstration.deleteShedule(2075, 1244);
        SQLDemonstration.deleteShedule(1932, 1249);
        SQLDemonstration.deleteShedule(1941, 1278);
        SQLDemonstration.deleteShedule(2062, 1202);
    }
}