package emias.mis.before;

import emias.AbstractTestGrid;
import org.testng.annotations.Test;
import pages.sql.SQLDemonstration;
import utilities.testngRetryCount.RetryCountIfFailed;

public class BeforeSuiteMIS extends AbstractTestGrid {

    @Test(groups = "mis", description = "Завершаю все вызовы и создаю новое расписание у врачей на сегодня")
    @RetryCountIfFailed(2)
    public void cleanBeforeWork() throws InterruptedException {
        SQLDemonstration.finalizeAllCalls();
        page.loginPage().login(site, login, pass);
        page.homePageMis().manageSheduleBtn();
        page.homePageMis().createSomeRecords(15);
        page.homePageMis().logoHomeBtn();
    }
}