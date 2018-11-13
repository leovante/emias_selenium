/**
 * заходим в журнал и проверяем карту из журнала
 */

package emias.disp.regress;

import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.switchTo;

public class ZhurnalTest extends AbstractTestGrid {

    @Ignore
    @Test(groups = "disp", description = "заполнить карту Темников Дмитрий 24г", enabled = false)
    @RetryCountIfFailed(0)
    public void testZapolnenieMeropriyatii() {
        enterSite.loginMis();
        page.homePageMis().dispCardBtn();
        switchTo().window(1);

    }
}