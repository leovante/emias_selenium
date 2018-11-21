package emias.mis.before;

import emias.AbstractTestGrid;
import org.testng.annotations.Test;
import pages.sql.SQLDemonstration;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;

public class BeforeSuiteMIS extends AbstractTestGrid {

    @Test(groups = "mis", description = "Завершаю все вызовы")
    @RetryCountIfFailed(2)
    public void finalizeCalls() throws IOException {
        SQLDemonstration.updateDB();//обновляю базу скриптами из папки
    }

    @Test(groups = "mis", description = "Cоздаю новое расписание у врачей на сегодня")
    @RetryCountIfFailed(2)
    public void cleanBeforeWork() throws InterruptedException {
        page.loginPage().login(site, login, pass);
        page.homePageMis().manageSheduleBtn();
        page.homePageMis().createSomeRecords(15);
        page.homePageMis().logoHomeBtn();
    }
}