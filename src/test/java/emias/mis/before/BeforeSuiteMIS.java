package emias.mis.before;

import com.commons.retryCountListner.RetryCountIfFailed;
import emias.TestBase;

public class BeforeSuiteMIS extends TestBase {

    @org.testng.annotations.Test(groups = "mis", description = "Завершаю все вызовы", enabled = false)
    @RetryCountIfFailed(2)
    public void finalizeCalls() {
//        SQLDemonstration.updateDB();//обновляю базу скриптами из папки
    }

    @org.testng.annotations.Test(groups = "mis", description = "Cоздаю новое расписание у врачей на сегодня", enabled = false)
    @RetryCountIfFailed(2)
    public void cleanBeforeWork() {
        page.misHome().loginMis();
        page.homePageMis().vedenieRaspisaniyaBtn();
        page.homePageMis().createSomeRecords(15);
        page.homePageMis().logoHomeBtn();
    }
}