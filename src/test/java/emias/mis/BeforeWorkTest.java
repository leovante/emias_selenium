package emias.mis;

import emias.BaseTest;
import emias.TestngRetryCount.RetryCountIfFailed;
import org.testng.annotations.Test;

public class BeforeWorkTest extends BaseTest {

    @Test(groups = "mis", description = "Завершаю все вызовы и создаю новое расписание у врачей на сегодня")
    @RetryCountIfFailed(2)
    public void cleanBeforeWork() throws ClassNotFoundException, InterruptedException {
        page.homePage().manageSheduleBtn();
        page.admissionSchedule().createShedule(15);
        page.homePage().logoHomeBtn();
    }
}