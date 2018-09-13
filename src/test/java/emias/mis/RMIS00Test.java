package emias.mis;

import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.mis.ManageShedule;
import pages.utilities.SQLDemonstration;

public class RMIS00Test extends AbstractTestGrid {

    @Test(groups = "mis", description = "Завершаю все вызовы и создаю новое расписание у врачей на сегодня")
    @RetryCountIfFailed(2)
    public void cleanBeforeWork() throws InterruptedException {
        //driver.get(curUrlCalldoctor);
        SQLDemonstration.finalizeAllCalls();
        page.homePage().manageSheduleBtn();
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
            page.manageShedule().verifyCreatedShedule(doctor_num_fam);
            page.doctorMethods().selectDoctor(doctor_num);

            n++;
        }
    }
}