package emias.mis;

import emias.AbstractTest;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.mis.ManageShedule;
import pages.utilities.SQLDemonstration;

public class BeforeWorkTest extends AbstractTest {

    @Test(groups = "mis", description = "Завершаю все вызовы и создаю новое расписание у врачей на сегодня")
    @RetryCountIfFailed(0)
    public void cleanBeforeWork() throws InterruptedException {
        //driver.get(curUrlCalldoctor);

        page.homePage().manageSheduleBtn();
        SQLDemonstration.finalizeAllCalls();
        createSomeRecords(15);
        page.homePage().logoHomeBtn();
    }

    @Step("Сделать запись")
    public void createSomeRecords(int i) throws InterruptedException {
        int n = 1;
        while (n <= i) {
            System.out.println("Обрабатываю врача №: " + n);
            String doctor_num = page.doctorMethods().getUnicalDoctor3(n);
            String doctor_num_fam = ManageShedule.getSecondName(doctor_num);
            SQLDemonstration.deleteShedule(doctor_num_fam);

            page.doctorMethods().selectDoctor(doctor_num);
            page.beforeWork().createShedule();
            page.manageShedule().verifyCreatedShedule();
            page.doctorMethods().selectDoctor(doctor_num);

            n++;
        }
    }
}