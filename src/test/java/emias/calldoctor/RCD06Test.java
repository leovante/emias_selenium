package emias.calldoctor;

import com.codeborne.selenide.Condition;
import emias.AbstractTest;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Issue;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.utilities.SQLDemonstration;
import pages.utilities.StringGenerator;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RCD06Test extends AbstractTest {
    String nameGen;

    @BeforeMethod(groups = {"CD", "test"})
    public void beforeMethod() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterMethod(groups = {"CD", "test"})
    public void afterMethod() {
        SQLDemonstration.finalizePacientName(nameGen);
    }

    @Test(groups = "CD", description = "передача вызова из Юр лица в подразделение")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testTransferCallLpu_Depart() throws IOException {
        open(curUrlCalldoctor);
        page.createCallPage()
                .createNewCall("ProfileTransferLpu-Dep", nameGen, "n");
        $(By.xpath("//*[contains(.,'Стенд ЕМИАС МО')]")).shouldBe(Condition.visible);
        page.fullCardPage().transferToDepartBtn();
        page.setLpuPage().transfer("ProfileTransferLpu-Dep");
        $(By.xpath("//*[contains(.,'Детское подразделение')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "передача вызова из подразделения в подразделение")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testTransferCallDepart_Depart() {
//        open(curUrlCalldoctor);
//        page.createCallPage()
//                .createNewCall("ProfileTransferLpu-Dep", nameGen, "n");
//        $(By.xpath("//*[contains(.,'Стенд ЕМИАС МО')]")).shouldBe(Condition.visible);
//        page.fullCardPage().transferToDepartBtn();
//        page.setLpuPage().transfer("ProfileTransferLpu-Dep");
//        $(By.xpath("//*[contains(.,'Детское подразделение')]")).shouldBe(Condition.visible);
    }

    // TODO: 13.08.2018 передать вызов из подразделения в др.подразделение
    // TODO: 13.08.2018 передать вызов из подразделения в юр. Лицо
    // TODO: 13.08.2018 передать вызов из первого ЛПУ в др. ЛПУ
}