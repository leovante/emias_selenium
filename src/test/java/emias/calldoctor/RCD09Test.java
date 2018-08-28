package emias.calldoctor;

import emias.AbstractTest;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Attachment;
import io.qameta.allure.Issue;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.utilities.SQLDemonstration;
import pages.utilities.StringGenerator;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;

public class RCD09Test extends AbstractTest {
    String nameGen;

    @BeforeMethod(groups = {"CD", "test"})
    public void beforeMethod() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterMethod(groups = {"CD", "test"})
    public void afterMethod(ITestResult result) {
        SQLDemonstration.finalizeAllTestCalls();
        //        if (!result.isSuccess()) {
//            try {
//                WebDriver returned = new Augmenter().augment(driver);
//                if (returned != null) {
//                    File f = ((TakesScreenshot) returned).getScreenshotAs(OutputType.FILE);
//                    try {
//                        FileUtils.copyFile(f, new File("D:\\Test_results\\" + result.getName() + " " + /*getFileName()*/ ".jpg"));
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            } catch (ScreenshotException se) {
//                se.printStackTrace();
//            }
//        }
    }

    @Test(groups = "CD", description = "фильтр поиск по ФИО")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testFilterFIO() throws InterruptedException, IOException {
        open(curUrlCalldoctor);
        page.createCallPage().createNewCall("Profile1", nameGen, "n");
        page.fullCardPage().closeCardBtn();
        page.dashboardPage()
                .searchFilterFio(nameGen)
                .verifyNewCallGroup("Profile1", nameGen);
    }

    //    @Listeners({CustomTestListener.class}) //https://automated-testing.info/t/pomogite-podklyuchit-allure-k-proektu-java-testng-maven/7122/15
    @Attachment(value = "Console error", type = "text/plain")
    @Test(groups = "CD", description = "фильтр поиск по врачу")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(0)
    public void testFilterDoctor() throws InterruptedException, IOException {
        open(curUrlCalldoctor);
        page.createCallPage().createNewCall("Profile1", nameGen, "n");
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor("Profile1");
        page.fullCardPage().closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .searchFilterDoctor("Profile1")
                .verifyActiveDocGroup(nameGen, "Profile1");
    }

    @Test(groups = "CD", description = "фильтр поиск по виду вызова")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testTypeCall() throws InterruptedException, IOException {
        page.createCallPage().createCallProfile3(nameGen);
        open(curUrlCalldoctor);
        page.dashboardPage().openNewCallProgressFrame();
        page.fullCardPage().closeCardBtn();
        page.dashboardPage()
                .searchFilterFio(nameGen)
                .searchFilterTypeCallNeotlozhniy()
                .verifyNewCallGroup("Profile3", nameGen);
    }

    @Test(groups = "CD", description = "проверка кнопки выход")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testExitToMis() {
        open(curUrlCalldoctor);
        page.dashboardPage().exitToMis();
        assertTrue($(By.xpath("//span[contains(text(),'Расписание приёма')]")).isDisplayed());
    }

    // TODO: 13.08.2018 сделать тест отображение вызовов в различных подразделениях и группах
}