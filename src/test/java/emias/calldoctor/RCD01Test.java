package emias.calldoctor;

import emias.AbstractTest;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.utilities.SQLDemonstration;
import pages.utilities.StringGenerator;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class RCD01Test extends AbstractTest {
    private String nameGen;

    @BeforeMethod(groups = {"CD", "test"})
    public void beforeMethod() {
        StringGenerator nameGen = new StringGenerator();
        this.nameGen = String.valueOf(nameGen.generator());
    }

    @AfterMethod(groups = {"CD", "test"})
    public void afterMethod(ITestResult result) {
        SQLDemonstration.finalizePacientName(nameGen);
//        if (!result.isSuccess()) {
//            try {
//                WebDriver returned = new Augmenter().augment(driver);
//                if (returned != null) {
//                    File f = ((TakesScreenshot) returned).getScreenshotAs(OutputType.FILE);
//                    try {
//                        FileUtils.copyFile(f, new File("E:\\Test_results" + result.getName() + " " + /*getFileName()*/ ".jpg"));
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            } catch (ScreenshotException se) {
//                se.printStackTrace();
//            }
//        }
    }


    @DataProvider(name = "ProfileRegistr")
    public static Object[][] credentials() {
        return new Object[][]{
                {"Profile1"},
                {"Profile2"}
        };
    }

    @Test(groups = "CD", description = "пустой вызов")
    @Issue("EMIAS-90")
    @TmsLink("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCallRegistrEmpy() throws IOException {
        open(curUrlCalldoctor);
        page.createCallPage().createCallProfile0("Profile0");
        page.fullCardPage()
                .verifyCallProfile0("Profile0")
                .closeCardBtn();
    }

    @Test(groups = "CD", description = "вызов с иточником Регистратура без МКАБ")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCallRegistr() throws Exception {
        open(curUrlCalldoctor);
        open(curUrlCalldoctor);
        page.createCallPage().createCallProfile1("Profile1", nameGen);
        page.fullCardPage()
                .verifyCallNewCallGroup("Profile1", nameGen)
                .closeCardBtn();
        page.dashboardPage().verifyNewCallGroup("Profile1", nameGen);
    }

    @Test(groups = "test", dataProvider = "ProfileRegistr", description = "вызов с иточником Регистратура без МКАБ")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCallRegistr_DataProvider(String profile) throws Exception {
        open(curUrlCalldoctor);
        open(curUrlCalldoctor);
        page.createCallPage().createNewCall(profile, nameGen, "n");
        page.fullCardPage()
                .verifyCallNewCallGroup(profile, nameGen)
                .closeCardBtn();
        page.dashboardPage().verifyNewCallGroup(profile, nameGen);
    }

    @Test(groups = "CD", description = "вызов с источником СМП и привязкой МКАБ")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCallRegistrMkab() throws Exception {
        open(curUrlCalldoctor);
        page.createCallPage().createCallProfile2(nameGen);
        page.fullCardPage()
                .verifyCallNewCallGroup("Profile2", nameGen)
                .closeCardBtn();
        page.dashboardPage().verifyNewCallGroup("Profile2");
    }

    @Test(groups = "CD", description = "вызов от СМП по api, ребенок по МКАБ без КЛАДР")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCallSmpChildMkab() throws IOException {
        open(curUrlCalldoctor);
        page.createCallPage().createCallProfile3(nameGen);
        page.dashboardPage().openNewCallProgressFrame();
        page.fullCardPage().verifyCallNewCallGroup("Profile3", nameGen);
    }

    @Test(groups = "CD", description = "вызов от СМП по api, Взрослый без МКАБ по КЛАДР")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCallSmpAdultKladr() throws IOException {
        open(curUrlCalldoctor);
        page.createCallPage().createCallProfile6(nameGen);
        page.dashboardPage().openNewCallProgressFrame();
        page.fullCardPage().verifyCallNewCallGroup("Profile6", nameGen);
    }

    @Test(groups = "CD", description = "вызов ребенка с Портала")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCallPortal() throws IOException {
        open("https://uslugi.mosreg.ru/zdrav/");
        driver.manage().deleteAllCookies();
        open("https://uslugi.mosreg.ru/zdrav/");
        SQLDemonstration.finalizePacientNumberPol("Profile4");
        page.portalDashboard().createCall("Profile4", nameGen);
        open(curUrlCalldoctor);
        page.dashboardPage()
                .clearFilterDepart()
                .openNewCallProgressFrame();
        page.fullCardPage().verifyCallNewCallGroup("Profile4", nameGen);
    }
}

// TODO: 18.08.2018 create new call from CC for api
// TODO: 18.08.2018 пока напишу тут. Сделать пару тестов для проверки кладра

/*
 * Благодаря этому паттерну можно реализовать много интересных вещей, например,
 * вы можете реализовать пул браузеров. Многие жалуются – наши web-тесты тормозят,
 * потому что пока браузер поднимется, пока первая страница загрузится, пока скопируется профиль и так далее.
 * Браузеры не обязательно создавать прямо в тесте, вместо этого можно использовать Background Pool,
 * в котором настроено необходимое вам количество браузеров, и в этом пуле, когда браузер в него возвращается –
 * вы его очищаете, делаете еще что-то, но это все происходит в бэкграунде, в параллельных с выполнением ваших тестов потоках.
 * И только готовый к использованию браузер отдается вашему тесту, когда он запрашивает из браузерного пула новый браузер для себя.
 * <p>
 * Наконец, классический пример более сложного использования этого паттерна – когда вы имеете пул инстансов базы данных.
 * Вместо того, чтобы работать с реальной базой данных, вы поднимаете необходимый набор контейнеров базы данных в необходимом
 * количестве на разных портах, это делается очень просто с Docker или каким-то другим доступным вам инструментом виртуализации,
 * и после того, как вы поработали с базой данных, вы ее «потушили» и в пуле подняли новую. Благодаря этому вы можете постоянно иметь
 * чистую базу данных для работы, нет необходимости делать teardown или очистку базы, собирание и загрузку данных, и так далее.
 * <p>
 * https://habr.com/company/jugru/blog/338836/ посмотреть паттерн data provider и decorator
 *
 * @DataProvider public Object[][] dataProvider() {
 * return new Object[][]{
 * {1}, {2}, {3}
 * };
 * }
 * @Attachment public byte[] attachScreenshot() {
 * return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
 * }
 */