package emias.calldoctor.regress;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.utilities.StringGenerator;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;

public class ChangeDepartmentTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "передача вызова из Юр лица в подразделение")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testTransferCallLpu_Depart() throws IOException, InterruptedException {
        enterSite.enterCalldoctor();
        page.createCallPage()
                .createCall("ProfileTransferLpu-Dep", nameGen, "n");
        page.fullCardPage()
                .verifyDepart("ProfileTransferLpu-Dep", "firstDepart")
                .transferToDepartBtn();
        page.setLpuPage().transfer("ProfileTransferLpu-Dep", "detskayaPol");
        page.fullCardPage().verifyDepart("ProfileTransferLpu-Dep", "detskayaPol");
    }

    @Test(groups = "CD", description = "передача вызова из подразделения в подразделение")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testTransferCallDepart_Depart() throws IOException, InterruptedException {
        enterSite.enterCalldoctor();
        page.createCallPage()
                .createCall("ProfileTransferDep-Dep", nameGen, "n");
        page.fullCardPage()
                .verifyDepart("ProfileTransferDep-Dep", "firstDepart")
                .transferToDepartBtn();
        page.setLpuPage().transfer("ProfileTransferDep-Dep", "detskayaPol");
        page.fullCardPage()
                .verifyDepart("ProfileTransferDep-Dep", "detskayaPol")
                .transferToDepartBtn();
        page.setLpuPage().transfer("ProfileTransferDep-Dep", "vzroslayaPol");
        page.fullCardPage().verifyDepart("ProfileTransferDep-Dep", "vzroslayaPol");
    }

    @Test(groups = "CD", description = "передача вызова из подр в ЛПУ")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testTransferCallDepart_Lpu() throws IOException, InterruptedException {
        enterSite.enterCalldoctor();
        page.createCallPage()
                .createCall("ProfileTransferDep-Lpu", nameGen, "n");
        page.fullCardPage()
                .verifyDepart("ProfileTransferDep-Lpu", "firstDepart")
                .transferToDepartBtn();
        page.setLpuPage().transfer("ProfileTransferDep-Lpu", "detskayaPol");
        page.fullCardPage()
                .verifyDepart("ProfileTransferDep-Lpu", "detskayaPol")
                .transferToDepartBtn();
        page.setLpuPage().transfer("ProfileTransferDep-Lpu", "firstDepart");
        page.fullCardPage().verifyDepart("ProfileTransferDep-Lpu", "firstDepart");
    }

    @Test(groups = "CD", description = "передача вызова из ЛПУ в ЛПУ")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testTransferCallLpu_Lpu() {
//        open(curUrlCalldoctor);
//        page.createCallPage()
//                .createCall("ProfileTransferDep-Dep", nameGen, "n");
//        page.fullCardPage()
//                .verifyDepart("firstDepart")
//                .transferToDepartBtn();
//        page.setLpuPage().transfer("ProfileTransferLpu-Dep", "detskayaPol");
//        page.fullCardPage()
//                .verifyDepart("detskayaPol")
//                .transferToDepartBtn();
//        page.setLpuPage().transfer("ProfileTransferDep-Dep", "firstDepart");
//        page.fullCardPage().verifyDepart("firstDepart");
    }

    @Test(groups = "CD", description = "проверить что на странице передачи в другое лпу у взрослого вызова не отображается детская поликлиника и наоборот")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testshowMeYourAdultPoliklinika() throws Exception {
        String nameGen = new StringGenerator().generator();
        enterSite.enterCalldoctor();
        page.createCallPage()
                .createCall("Profile1", nameGen, "n");
        page.fullCardPage().transferToDepartBtn();
        $(By.xpath("//*[contains(text(),'Детская поликлиника')]")).shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверить что на странице передачи в другое лпу у детского вызова не отображается взрослая поликлиника и наоборот")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testshowMeYourKidPoliklinika() throws Exception {
        String nameGen = new StringGenerator().generator();
        enterSite.enterCalldoctor();
        page.createCallPage()
                .createCall("Profile2", nameGen, "y");
        page.fullCardPage().transferToDepartBtn();
        $(By.xpath("//*[contains(text(),'Взрослая поликлиника')]")).shouldNotBe(Condition.visible);
    }

    // TODO: 13.08.2018 передать вызов из первого ЛПУ в др. ЛПУ
}