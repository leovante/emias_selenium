package emias.disp;

import com.codeborne.selenide.Condition;
import emias.AbstractTest;
import emias.testngRetryCount.RetryCountIfFailed;
import org.openqa.selenium.By;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RDisp01Test extends AbstractTest {

    @Test(groups = "disp", description = "заполнить карту Темников Дмитрий 24 года")
    @RetryCountIfFailed(0)
    public void testZapolnenieMeropriyatii() throws InterruptedException {
//        open("http://service.emias.mosreg.ru/test/disp/disp_ui/disp;doctorId=1208;doctorGuid=20d0da4b-b333-4878-9409-4525eae8e502;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=RqBrz85637XYrV2zFG8eZvYGvZiHSrF94TOHue0ltIZdapgZgXkv4sQcM0xD7g8soyDqwjLgeUQXu2Vd1n0XMEZyhoPIDVOEHbG%2FEmzG3oHGtBDPonMq%2FJFCnLoePrGqFQ0ah5DBFRv9zYEg%2BHYqwbvHeRVOHhz6Q9mQXyfsKTuC12xh6wLYRogVQi2KwEJq%2F5uAlC8vLHVZnBR7dujH2rB%2BEBN4tUwINqV1UE8CxcH82u54CO00eC84C8tkPBgbip4LJrEnHUz7TZj1n0HvU1mQHOSA5RbY5xgUnRJE5O0vFzpf/card/1837?ticket=RqBrz85637XYrV2zFG8eZvYGvZiHSrF94TOHue0ltIZdapgZgXkv4sQcM0xD7g8soyDqwjLgeUQXu2Vd1n0XMEZyhoPIDVOEHbG%2FEmzG3oHGtBDPonMq%2FJFCnLoePrGqFQ0ah5DBFRv9zYEg%2BHYqwbvHeRVOHhz6Q9mQXyfsKTuC12xh6wLYRogVQi2KwEJq%2F5uAlC8vLHVZnBR7dujH2rB%2BEBN4tUwINqV1UE8CxcH82u54CO00eC84C8tkPBgbip4LJrEnHUz7TZj1n0HvU1mQHOSA5RbY5xgUnRJE5O0vFzpf&mkabId=0&dvtId=376453&docPrvdId=1208&MisUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration&ReturnUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration%2FSchedule");
//        open("http://service.emias.mosreg.ru/test/disp/disp_ui/disp;doctorId=1239;doctorGuid=71f2edcf-8395-4c0d-b011-be9b4a437718;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=elTJjWwir6kkl0OOs5RW8tmwck32HM6hR61oGY5mQhY3SsXwsarZys9qbKeVICiVLjUCdzbEBikYObT%2fuEezuTS6rd6HvQ0gPJppMn3YBGvNqHI5rGdTxSRgg3kv0mzQQF9pzDfoeQqOdmrsYvqQQtFYWBYPoAJj6xOvkHbPiGa9Ws3%2f7al%2boT%2blwZzaa%2fQ4e3nUCjUZOegnwnBtNVOJncml7a9dEoOZOIhmvdz%2fTVJKFTYyYMnbNZ3okSEmlmnC4PRzdDnoCVQiHwV%2b8Bw9uPSFBNDYJKdVJ8Hpk7SIzXyqKMfX/card/2185?ticket=elTJjWwir6kkl0OOs5RW8tmwck32HM6hR61oGY5mQhY3SsXwsarZys9qbKeVICiVLjUCdzbEBikYObT%2fuEezuTS6rd6HvQ0gPJppMn3YBGvNqHI5rGdTxSRgg3kv0mzQQF9pzDfoeQqOdmrsYvqQQtFYWBYPoAJj6xOvkHbPiGa9Ws3%2f7al%2boT%2blwZzaa%2fQ4e3nUCjUZOegnwnBtNVOJncml7a9dEoOZOIhmvdz%2fTVJKFTYyYMnbNZ3okSEmlmnC4PRzdDnoCVQiHwV%2b8Bw9uPSFBNDYJKdVJ8Hpk7SIzXyqKMfX&mkabId=0&dvtId=379222&docPrvdId=1239&MisUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration&ReturnUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration%2fSchedule");
        open("http://service.emias.mosreg.ru/test/disp/disp_ui/disp;doctorId=1239;doctorGuid=71f2edcf-8395-4c0d-b011-be9b4a437718;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=tfFB2HFD5HRo1785XMbzklb3pAs3nkdxuETXQM%2FMKpZxWpDh%2FRwvQNEqM%2BOWu91pn9QRBqePUfNRpn%2FK8B56nr6L2P6men%2FQ1VNraknXAYieLcqf1Aa748xc4%2FAutpwKv%2BTcR8Hj1ExKMO1vNomhaiuXxW205LOPsW4Q2btgzFxQV7AFa6aJ9eq1JVPnOfJrJI%2BpPVdDt7s8SqJJPfrLyVb5hScVC5wKSHX%2BmCBbsw0Ltpszf0W3IKYnqgMs7X69V%2FBqHNBQL5YCKgaF6COb7XneEL9g91UsKUFCtB%2FNylItp0YT/card/2188?ticket=tfFB2HFD5HRo1785XMbzklb3pAs3nkdxuETXQM%2FMKpZxWpDh%2FRwvQNEqM%2BOWu91pn9QRBqePUfNRpn%2FK8B56nr6L2P6men%2FQ1VNraknXAYieLcqf1Aa748xc4%2FAutpwKv%2BTcR8Hj1ExKMO1vNomhaiuXxW205LOPsW4Q2btgzFxQV7AFa6aJ9eq1JVPnOfJrJI%2BpPVdDt7s8SqJJPfrLyVb5hScVC5wKSHX%2BmCBbsw0Ltpszf0W3IKYnqgMs7X69V%2FBqHNBQL5YCKgaF6COb7XneEL9g91UsKUFCtB%2FNylItp0YT&mkabId=0&dvtId=379258&docPrvdId=1239&MisUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration&ReturnUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration%2FSchedule");
        page.servicesPage().zapolnenieProfile1();
        $(By.xpath("//*[contains(text(),'(100%)')]")).shouldBe(Condition.visible);
    }

    @Ignore
    @Test(groups = "disp", description = "заполнить карту Генератор 36лет")
    @RetryCountIfFailed(0)
    public void testProcessCardGenerator() {
        open("http://service.emias.mosreg.ru/test/disp/disp_ui/disp;doctorId=1239;doctorGuid=71f2edcf-8395-4c0d-b011-be9b4a437718;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=Q884m10tjBUqdfAxilmamsok8lO3dBXjo1EYaN%2b9RMBO0Y%2fkw0Zp%2bQy%2fkuqjtnlUwNLQBM4LNod8vtefli6SLrGSXRpi1v%2bprbPNwU9iwFuSPuKFRAddo6Hnz7Z%2bcQh52EgRrscteRkqiosTw7BKDtdYjVuq5OLqBVwtcf2vjq9AedzOdSIXZL95wWuL6%2bY8N65rW75R68TZgobKxCry1FkL3Y%2bS9e7DJMfQbiTtGuhn0Wh6aDzNFPiCGwdhj3z2EpM7Lp30BZf%2f53Wie%2bqdmQrb6d6gNszGBtSywtR6Hep0z9Y6/card/2179?ticket=Q884m10tjBUqdfAxilmamsok8lO3dBXjo1EYaN%2b9RMBO0Y%2fkw0Zp%2bQy%2fkuqjtnlUwNLQBM4LNod8vtefli6SLrGSXRpi1v%2bprbPNwU9iwFuSPuKFRAddo6Hnz7Z%2bcQh52EgRrscteRkqiosTw7BKDtdYjVuq5OLqBVwtcf2vjq9AedzOdSIXZL95wWuL6%2bY8N65rW75R68TZgobKxCry1FkL3Y%2bS9e7DJMfQbiTtGuhn0Wh6aDzNFPiCGwdhj3z2EpM7Lp30BZf%2f53Wie%2bqdmQrb6d6gNszGBtSywtR6Hep0z9Y6&mkabId=0&dvtId=379130&docPrvdId=1239&MisUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration&ReturnUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration%2fSchedule");
//        page.servicesPage().fillProfile2();
        $(By.xpath("//*[contains(text(),'(100%)')]")).shouldBe(Condition.visible);
    }

    @Ignore
    @Test(groups = "disp", description = "заполнить карту Панченко Ксения 39 лет")
    @RetryCountIfFailed(0)
    public void testProcessCardPanchenko() {
        open("http://service.emias.mosreg.ru/test/disp/disp_ui/disp;doctorId=1239;doctorGuid=71f2edcf-8395-4c0d-b011-be9b4a437718;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=Q884m10tjBUqdfAxilmamsok8lO3dBXjo1EYaN%2b9RMBO0Y%2fkw0Zp%2bQy%2fkuqjtnlUwNLQBM4LNod8vtefli6SLrGSXRpi1v%2bprbPNwU9iwFuSPuKFRAddo6Hnz7Z%2bcQh52EgRrscteRkqiosTw7BKDtdYjVuq5OLqBVwtcf2vjq9AedzOdSIXZL95wWuL6%2bY8N65rW75R68TZgobKxCry1FkL3Y%2bS9e7DJMfQbiTtGuhn0Wh6aDzNFPiCGwdhj3z2EpM7Lp30BZf%2f53Wie%2bqdmQrb6d6gNszGBtSywtR6Hep0z9Y6/card/2180?ticket=Q884m10tjBUqdfAxilmamsok8lO3dBXjo1EYaN%2b9RMBO0Y%2fkw0Zp%2bQy%2fkuqjtnlUwNLQBM4LNod8vtefli6SLrGSXRpi1v%2bprbPNwU9iwFuSPuKFRAddo6Hnz7Z%2bcQh52EgRrscteRkqiosTw7BKDtdYjVuq5OLqBVwtcf2vjq9AedzOdSIXZL95wWuL6%2bY8N65rW75R68TZgobKxCry1FkL3Y%2bS9e7DJMfQbiTtGuhn0Wh6aDzNFPiCGwdhj3z2EpM7Lp30BZf%2f53Wie%2bqdmQrb6d6gNszGBtSywtR6Hep0z9Y6&mkabId=0&dvtId=379137&docPrvdId=1239&MisUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration&ReturnUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration%2fSchedule");
//        page.servicesPage().fillProfile3();
        $(By.xpath("//*[contains(text(),'(100%)')]")).shouldBe(Condition.visible);
    }

    @Ignore
    @Test(groups = "disp", description = "заполнить карту Терентьева 73 года")
    @RetryCountIfFailed(0)
    public void testProcessCardTerentieva() {
        open("http://service.emias.mosreg.ru/test/disp/disp_ui/disp;doctorId=1239;doctorGuid=71f2edcf-8395-4c0d-b011-be9b4a437718;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=Q884m10tjBUqdfAxilmamsok8lO3dBXjo1EYaN%2b9RMBO0Y%2fkw0Zp%2bQy%2fkuqjtnlUwNLQBM4LNod8vtefli6SLrGSXRpi1v%2bprbPNwU9iwFuSPuKFRAddo6Hnz7Z%2bcQh52EgRrscteRkqiosTw7BKDtdYjVuq5OLqBVwtcf2vjq9AedzOdSIXZL95wWuL6%2bY8N65rW75R68TZgobKxCry1FkL3Y%2bS9e7DJMfQbiTtGuhn0Wh6aDzNFPiCGwdhj3z2EpM7Lp30BZf%2f53Wie%2bqdmQrb6d6gNszGBtSywtR6Hep0z9Y6/card/2182?ticket=Q884m10tjBUqdfAxilmamsok8lO3dBXjo1EYaN%2b9RMBO0Y%2fkw0Zp%2bQy%2fkuqjtnlUwNLQBM4LNod8vtefli6SLrGSXRpi1v%2bprbPNwU9iwFuSPuKFRAddo6Hnz7Z%2bcQh52EgRrscteRkqiosTw7BKDtdYjVuq5OLqBVwtcf2vjq9AedzOdSIXZL95wWuL6%2bY8N65rW75R68TZgobKxCry1FkL3Y%2bS9e7DJMfQbiTtGuhn0Wh6aDzNFPiCGwdhj3z2EpM7Lp30BZf%2f53Wie%2bqdmQrb6d6gNszGBtSywtR6Hep0z9Y6&mkabId=0&dvtId=379146&docPrvdId=1239&MisUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration&ReturnUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration%2fSchedule");
//        page.servicesPage().fillProfile4();
        $(By.xpath("//*[contains(text(),'(100%)')]")).shouldBe(Condition.visible);
    }
    // TODO: 04.09.2018 для второго этапа добавить карту женщины 30 лет что бы в мероприятиях был врач окушер фельдшер. Т.к. там есть заключение
}