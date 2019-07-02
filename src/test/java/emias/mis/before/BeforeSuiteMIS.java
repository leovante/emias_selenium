package emias.mis.before;

import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;

import java.io.IOException;

public class BeforeSuiteMIS extends TestBase {

    @org.testng.annotations.Test(groups = "mis", description = "Завершаю все вызовы", enabled = false)
    @RetryCountIfFailed(2)
    public void finalizeCalls() throws IOException {
//        SQLDemonstration.updateDB();//обновляю базу скриптами из папки
    }

    @org.testng.annotations.Test(groups = "mis", description = "Cоздаю новое расписание у врачей на сегодня", enabled = false)
    @RetryCountIfFailed(2)
    public void cleanBeforeWork() throws InterruptedException {
        page.misHomePage().loginMis();
        page.homePageMis().vedenieRaspisaniyaBtn();
        page.homePageMis().createSomeRecords(15);
        page.homePageMis().logoHomeBtn();
    }
}