package emias.callDoctor.before;

import emias.AbstractTestGrid;
import org.testng.annotations.Test;
import pages.sql.SQLDemonstration;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;
import java.text.ParseException;

public class BeforeSuiteCalldoctor extends AbstractTestGrid {

    @Test(description = "Создаю новое расписание на сегодня")
    @RetryCountIfFailed(2)
    public void cleanBeforeCallDoctorTests() throws IOException, ParseException {
//        SQLDemonstration.updateDB();//обновляю базу скриптами из папки
        SQLDemonstration.createShedule();
    }
}