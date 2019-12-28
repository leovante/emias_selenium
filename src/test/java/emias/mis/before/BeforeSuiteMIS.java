package emias.mis.before;

import com.commons.retryCountListner.RetryCountIfFailed;
import com.testRunner.TestNGBase;
import org.testng.annotations.Test;

public class BeforeSuiteMIS extends TestNGBase {

    @Test(groups = "mis", description = "Завершаю все вызовы", enabled = false)
    @RetryCountIfFailed(2)
    public void finalizeCalls() {
//        SQLDemonstration.updateDB();//обновляю базу скриптами из папки
    }

    @Test(groups = "mis", description = "Cоздаю новое расписание у врачей на сегодня", enabled = false)
    @RetryCountIfFailed(2)
    public void cleanBeforeWork() {
        IPage.misHome().loginMis();
        IPage.homePageMis().vedenieRaspisaniyaBtn();
        IPage.homePageMis().createSomeRecords(15);
        IPage.homePageMis().logoHomeBtn();
    }
}