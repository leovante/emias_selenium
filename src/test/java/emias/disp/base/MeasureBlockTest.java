package emias.disp.base;

import com.codeborne.selenide.Condition;
import com.utils.sql.DBScripts;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MeasureBlockTest extends TestBase {

    @Test(groups = "disp", description = "проверка поиска медзаписи при полном вводе", enabled = false)
    @RetryCountIfFailed(2)
    public void testFillExamp() throws InterruptedException {
        open("http://192.168.7.24/test/disp;doctorId=2135;doctorGuid=24688d3b-5db6-4ce7-823e-50c6ba025a8d;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=uEeTxWVNRnIes5LMY35ENUe%2B6iH3vNo%2BPondtot%2F4XDcjfMWwbeec61uE4%2F6POsmo%2FlQ%2B9EbnKvngutrYmvnH72o2%2FMskn569R0WVdpcp7%2BWeIrhia4iKuuhZw2S09WVP267OijSmoSxZuL74%2B5lnfcmI7ZOHyzghdoY6ioDxhLwznyFHrCBpX%2FHpTwWlttMAYEgbJKaM5BL1FgPjFZUzTmmIlDGyM1J8nZi9TnoHSVBcbzRva2zveK%2FHFxAxzZyEh5hbkSR9CSzl%2Bm%2Bx%2BM46PJsSwRyAhkTJ%2FDZCV%2F6vF%2BscFmLnGCWXI0wrfMrWGaFp2w5rQ%3D%3D/card/2214?ticket=uEeTxWVNRnIes5LMY35ENUe%2B6iH3vNo%2BPondtot%2F4XDcjfMWwbeec61uE4%2F6POsmo%2FlQ%2B9EbnKvngutrYmvnH72o2%2FMskn569R0WVdpcp7%2BWeIrhia4iKuuhZw2S09WVP267OijSmoSxZuL74%2B5lnfcmI7ZOHyzghdoY6ioDxhLwznyFHrCBpX%2FHpTwWlttMAYEgbJKaM5BL1FgPjFZUzTmmIlDGyM1J8nZi9TnoHSVBcbzRva2zveK%2FHFxAxzZyEh5hbkSR9CSzl%2Bm%2Bx%2BM46PJsSwRyAhkTJ%2FDZCV%2F6vF%2BscFmLnGCWXI0wrfMrWGaFp2w5rQ%3D%3D&mkabId=0&dvtId=1473713&DocPrvdId=2135&MisUrl=http:%2F%2F192.168.7.54%2Ftest&ReturnUrl=http:%2F%2F192.168.7.54%2Ftest%2FSchedule");
        page.exampPage().switchAllServicesTap();
        // TODO: 7/17/2019 доделать добавление и поиск новой медзаписи в диспе

    }

    @Test(groups = "disp", description = "отображение результата обращения в зависимости от типа отделения", enabled = false)
    @RetryCountIfFailed(2)
    public void testResultQuestionFromTypeDepartment() throws InterruptedException {
        // TODO: 7/17/2019 сделать проверку в блоке закрытия тап. Проверять содержимое результата обращения в зависимости от типа отделения оператора
        /*если тип отделения - поликлиника, то вид оплыта ОМС. Результаты начинаются с 301
        если тип отделения не поликлиника, то вид оплаты лбой кроме ОМС. Результаты начинаюстя с 101
         */
    }
}