/**
 * тут мы проверяем корректное заполнение полей врачей.
 */

package emias.disp.regress;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import org.openqa.selenium.By;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RDisp02Test extends AbstractTestGrid {

    @Ignore
    @Test(groups = "disp", description = "заполнить карту Темников Дмитрий 24г")
    @RetryCountIfFailed(0)
    public void testZapolnenieMeropriyatii() throws InterruptedException {
//        open("http://service.emias.mosreg.ru/test/disp/disp_ui/disp;doctorId=1208;doctorGuid=20d0da4b-b333-4878-9409-4525eae8e502;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=RqBrz85637XYrV2zFG8eZvYGvZiHSrF94TOHue0ltIZdapgZgXkv4sQcM0xD7g8soyDqwjLgeUQXu2Vd1n0XMEZyhoPIDVOEHbG%2FEmzG3oHGtBDPonMq%2FJFCnLoePrGqFQ0ah5DBFRv9zYEg%2BHYqwbvHeRVOHhz6Q9mQXyfsKTuC12xh6wLYRogVQi2KwEJq%2F5uAlC8vLHVZnBR7dujH2rB%2BEBN4tUwINqV1UE8CxcH82u54CO00eC84C8tkPBgbip4LJrEnHUz7TZj1n0HvU1mQHOSA5RbY5xgUnRJE5O0vFzpf/card/1837?ticket=RqBrz85637XYrV2zFG8eZvYGvZiHSrF94TOHue0ltIZdapgZgXkv4sQcM0xD7g8soyDqwjLgeUQXu2Vd1n0XMEZyhoPIDVOEHbG%2FEmzG3oHGtBDPonMq%2FJFCnLoePrGqFQ0ah5DBFRv9zYEg%2BHYqwbvHeRVOHhz6Q9mQXyfsKTuC12xh6wLYRogVQi2KwEJq%2F5uAlC8vLHVZnBR7dujH2rB%2BEBN4tUwINqV1UE8CxcH82u54CO00eC84C8tkPBgbip4LJrEnHUz7TZj1n0HvU1mQHOSA5RbY5xgUnRJE5O0vFzpf&mkabId=0&dvtId=376453&docPrvdId=1208&MisUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration&ReturnUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration%2FSchedule");
        open("http://service.emias.mosreg.ru/test/disp/disp_ui/disp;doctorId=1239;doctorGuid=71f2edcf-8395-4c0d-b011-be9b4a437718;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=elTJjWwir6kkl0OOs5RW8tmwck32HM6hR61oGY5mQhY3SsXwsarZys9qbKeVICiVLjUCdzbEBikYObT%2fuEezuTS6rd6HvQ0gPJppMn3YBGvNqHI5rGdTxSRgg3kv0mzQQF9pzDfoeQqOdmrsYvqQQtFYWBYPoAJj6xOvkHbPiGa9Ws3%2f7al%2boT%2blwZzaa%2fQ4e3nUCjUZOegnwnBtNVOJncml7a9dEoOZOIhmvdz%2fTVJKFTYyYMnbNZ3okSEmlmnC4PRzdDnoCVQiHwV%2b8Bw9uPSFBNDYJKdVJ8Hpk7SIzXyqKMfX/card/2185?ticket=elTJjWwir6kkl0OOs5RW8tmwck32HM6hR61oGY5mQhY3SsXwsarZys9qbKeVICiVLjUCdzbEBikYObT%2fuEezuTS6rd6HvQ0gPJppMn3YBGvNqHI5rGdTxSRgg3kv0mzQQF9pzDfoeQqOdmrsYvqQQtFYWBYPoAJj6xOvkHbPiGa9Ws3%2f7al%2boT%2blwZzaa%2fQ4e3nUCjUZOegnwnBtNVOJncml7a9dEoOZOIhmvdz%2fTVJKFTYyYMnbNZ3okSEmlmnC4PRzdDnoCVQiHwV%2b8Bw9uPSFBNDYJKdVJ8Hpk7SIzXyqKMfX&mkabId=0&dvtId=379222&docPrvdId=1239&MisUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration&ReturnUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration%2fSchedule");
        page.exampPage().fillTemnikov();
        $(By.xpath("//*[contains(text(),'(100%)')]")).shouldBe(Condition.visible);
    }

}