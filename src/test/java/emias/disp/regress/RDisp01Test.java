package emias.disp.regress;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RDisp01Test extends AbstractTestGrid {

    @Test(groups = "disp", description = "заполнить карту Темников Дмитрий 24 года")
    @RetryCountIfFailed(0)
    public void testZapolnenieMeropriyatii() throws InterruptedException {
        open("http://service.emias.mosreg.ru/test/disp;doctorId=1211;doctorGuid=ce23d190-d946-4829-85c5-591bcfa1b15d;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=Y98aI66DVzBQZRb7WJyjXW9g6WPVJIz5HW8pfCyEX0LKUUzLbe5kBBtOSRHzQeqGmKnpzUTT5XC%2FDBGOFf4g3H2gRHnZTyXMbGU%2FbazTh%2Brh9xcpm4vdgUahCcCvSZIGMj8Md2IAHCClldJ4hvWlCa0A%2FW8GFCKouWkFI70y575zGc%2Bi%2Bm%2BLWI4NzAF0RWsQ7QBcptkAS%2Fy%2B8L83DaiVCUPJGyfBpJbta1n2Onlk2D3PGVxi69cGDD%2F6x3xmOtu%2B%2B8Fh0SbFbuQde%2Fwe%2BJlqYPIgB%2F0yqFBPBEJ1DvdrqQoWq8aB/card/2921?ticket=Y98aI66DVzBQZRb7WJyjXW9g6WPVJIz5HW8pfCyEX0LKUUzLbe5kBBtOSRHzQeqGmKnpzUTT5XC%2FDBGOFf4g3H2gRHnZTyXMbGU%2FbazTh%2Brh9xcpm4vdgUahCcCvSZIGMj8Md2IAHCClldJ4hvWlCa0A%2FW8GFCKouWkFI70y575zGc%2Bi%2Bm%2BLWI4NzAF0RWsQ7QBcptkAS%2Fy%2B8L83DaiVCUPJGyfBpJbta1n2Onlk2D3PGVxi69cGDD%2F6x3xmOtu%2B%2B8Fh0SbFbuQde%2Fwe%2BJlqYPIgB%2F0yqFBPBEJ1DvdrqQoWq8aB&mkabId=0&dvtId=384050&docPrvdId=1211&MisUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration&ReturnUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration%2FSchedule");
        page.servicesPage().zapolnenieProfile1();
        $(By.xpath("//*[contains(text(),'(100%)')]")).shouldBe(Condition.visible);
    }

//    @Test(groups = "disp", description = "заполнить карту Генератор 36 лет")
//    @RetryCountIfFailed(0)
//    public void testProcessCardGenerator() {
//        open("http://service.emias.mosreg.ru/test/disp/disp_ui/disp;doctorId=1239;doctorGuid=71f2edcf-8395-4c0d-b011-be9b4a437718;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=Q884m10tjBUqdfAxilmamsok8lO3dBXjo1EYaN%2b9RMBO0Y%2fkw0Zp%2bQy%2fkuqjtnlUwNLQBM4LNod8vtefli6SLrGSXRpi1v%2bprbPNwU9iwFuSPuKFRAddo6Hnz7Z%2bcQh52EgRrscteRkqiosTw7BKDtdYjVuq5OLqBVwtcf2vjq9AedzOdSIXZL95wWuL6%2bY8N65rW75R68TZgobKxCry1FkL3Y%2bS9e7DJMfQbiTtGuhn0Wh6aDzNFPiCGwdhj3z2EpM7Lp30BZf%2f53Wie%2bqdmQrb6d6gNszGBtSywtR6Hep0z9Y6/card/2179?ticket=Q884m10tjBUqdfAxilmamsok8lO3dBXjo1EYaN%2b9RMBO0Y%2fkw0Zp%2bQy%2fkuqjtnlUwNLQBM4LNod8vtefli6SLrGSXRpi1v%2bprbPNwU9iwFuSPuKFRAddo6Hnz7Z%2bcQh52EgRrscteRkqiosTw7BKDtdYjVuq5OLqBVwtcf2vjq9AedzOdSIXZL95wWuL6%2bY8N65rW75R68TZgobKxCry1FkL3Y%2bS9e7DJMfQbiTtGuhn0Wh6aDzNFPiCGwdhj3z2EpM7Lp30BZf%2f53Wie%2bqdmQrb6d6gNszGBtSywtR6Hep0z9Y6&mkabId=0&dvtId=379130&docPrvdId=1239&MisUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration&ReturnUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration%2fSchedule");
////        page.servicesPage().fillProfile2();
//        $(By.xpath("//*[contains(text(),'(100%)')]")).shouldBe(Condition.visible);
//    }
//
//    @Test(groups = "disp", description = "заполнить карту Панченко Ксения 39 лет")
//    @RetryCountIfFailed(0)
//    public void testProcessCardPanchenko() {
//        open("http://service.emias.mosreg.ru/test/disp/disp_ui/disp;doctorId=1239;doctorGuid=71f2edcf-8395-4c0d-b011-be9b4a437718;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=Q884m10tjBUqdfAxilmamsok8lO3dBXjo1EYaN%2b9RMBO0Y%2fkw0Zp%2bQy%2fkuqjtnlUwNLQBM4LNod8vtefli6SLrGSXRpi1v%2bprbPNwU9iwFuSPuKFRAddo6Hnz7Z%2bcQh52EgRrscteRkqiosTw7BKDtdYjVuq5OLqBVwtcf2vjq9AedzOdSIXZL95wWuL6%2bY8N65rW75R68TZgobKxCry1FkL3Y%2bS9e7DJMfQbiTtGuhn0Wh6aDzNFPiCGwdhj3z2EpM7Lp30BZf%2f53Wie%2bqdmQrb6d6gNszGBtSywtR6Hep0z9Y6/card/2180?ticket=Q884m10tjBUqdfAxilmamsok8lO3dBXjo1EYaN%2b9RMBO0Y%2fkw0Zp%2bQy%2fkuqjtnlUwNLQBM4LNod8vtefli6SLrGSXRpi1v%2bprbPNwU9iwFuSPuKFRAddo6Hnz7Z%2bcQh52EgRrscteRkqiosTw7BKDtdYjVuq5OLqBVwtcf2vjq9AedzOdSIXZL95wWuL6%2bY8N65rW75R68TZgobKxCry1FkL3Y%2bS9e7DJMfQbiTtGuhn0Wh6aDzNFPiCGwdhj3z2EpM7Lp30BZf%2f53Wie%2bqdmQrb6d6gNszGBtSywtR6Hep0z9Y6&mkabId=0&dvtId=379137&docPrvdId=1239&MisUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration&ReturnUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration%2fSchedule");
////        page.servicesPage().fillProfile3();
//        $(By.xpath("//*[contains(text(),'(100%)')]")).shouldBe(Condition.visible);
//    }
//
//    @Test(groups = "disp", description = "заполнить карту Терентьева 73 года")
//    @RetryCountIfFailed(0)
//    public void testProcessCardTerentieva() {
//        open("http://service.emias.mosreg.ru/test/disp/disp_ui/disp;doctorId=1239;doctorGuid=71f2edcf-8395-4c0d-b011-be9b4a437718;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=Q884m10tjBUqdfAxilmamsok8lO3dBXjo1EYaN%2b9RMBO0Y%2fkw0Zp%2bQy%2fkuqjtnlUwNLQBM4LNod8vtefli6SLrGSXRpi1v%2bprbPNwU9iwFuSPuKFRAddo6Hnz7Z%2bcQh52EgRrscteRkqiosTw7BKDtdYjVuq5OLqBVwtcf2vjq9AedzOdSIXZL95wWuL6%2bY8N65rW75R68TZgobKxCry1FkL3Y%2bS9e7DJMfQbiTtGuhn0Wh6aDzNFPiCGwdhj3z2EpM7Lp30BZf%2f53Wie%2bqdmQrb6d6gNszGBtSywtR6Hep0z9Y6/card/2182?ticket=Q884m10tjBUqdfAxilmamsok8lO3dBXjo1EYaN%2b9RMBO0Y%2fkw0Zp%2bQy%2fkuqjtnlUwNLQBM4LNod8vtefli6SLrGSXRpi1v%2bprbPNwU9iwFuSPuKFRAddo6Hnz7Z%2bcQh52EgRrscteRkqiosTw7BKDtdYjVuq5OLqBVwtcf2vjq9AedzOdSIXZL95wWuL6%2bY8N65rW75R68TZgobKxCry1FkL3Y%2bS9e7DJMfQbiTtGuhn0Wh6aDzNFPiCGwdhj3z2EpM7Lp30BZf%2f53Wie%2bqdmQrb6d6gNszGBtSywtR6Hep0z9Y6&mkabId=0&dvtId=379146&docPrvdId=1239&MisUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration&ReturnUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration%2fSchedule");
////        page.servicesPage().fillProfile4();
//        $(By.xpath("//*[contains(text(),'(100%)')]")).shouldBe(Condition.visible);
//    }
    // TODO: 04.09.2018 для второго этапа добавить карту женщины 30 лет что бы в мероприятиях был врач окушер фельдшер. Т.к. там есть заключение
}