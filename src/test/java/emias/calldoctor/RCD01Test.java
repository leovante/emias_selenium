package emias.calldoctor;

import emias.AbstractTest;
import emias.TestngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.calldoctor.Profiles_interfaces.Profile1;
import pages.calldoctor.Profiles_interfaces.Profile2;
import pages.calldoctor.Profiles_interfaces.Profile4;
import pages.calldoctor.Profiles_interfaces.User6;
import pages.utilities.SQLDemonstration;
import pages.utilities.StringGenerator;

public class RCD01Test extends AbstractTest implements Profile1, Profile2, Profile4 {
    private User6 user6 = new User6();
    String nameGen;

    @BeforeMethod(groups = {"CD", "test"})
    public void beforeTest() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterMethod(groups = {"CD", "test"})
    public void afterTest() {
        //SQLDemonstration.finalizePacientName(nameGen);
    }

    @Test(groups = "CD", description = "пустой вызов")
    @Issue("EMIAS-90")
    @TmsLink("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCallRegistrEmpy() throws InterruptedException {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile0();
        page.fullCardPage()
                .verifyCallProfile0()
                .closeCardBtn();
    }

    @Test(groups = "CD", description = "вызов с иточником Регистратура")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCallRegistr() throws Exception {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile1(nameGen);
        page.fullCardPage()
                .verifyCallProfile1(nameGen)
                .closeCardBtn();

        page.dashboardPage()
                .searchFilterFio(nameGen)
                .clearFilterDepart()
                .verifyNewCallProgressFrame(nameGen, adressPro1_3, telephonePro1);
    }

    @Test(groups = "CD", description = "вызов с источником СМП и привязкой МКАБ")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCallRegistrMkab() throws Exception {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile2(nameGen);
        this.nameGen = page.fullCardPage().verifyCallProfile2(nameGen);
        page.fullCardPage().closeCardBtn();

        page.dashboardPage().searchFilterFio(nameGen)
                .clearFilterDepart()
                .verifyNewCallProgressFrame(nameGen, adressPro2_2, telephonePro1);
    }

    @Test(groups = "CD", description = "вызов от СМП по api, ребенок по МКАБ без КЛАДР")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCallSMPApi() throws InterruptedException {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile3(nameGen);
        driver.get(curUrlCalldoctor);

        page.dashboardPage().openNewCallProgressFrame(nameGen);
        page.fullCardPage().verifyCallProfile3(nameGen);
    }

    @Test(groups = "CD", description = "вызов от СМП по api, ребенок по МКАБ без КЛАДР")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCallSMPApi2() throws InterruptedException {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile6(nameGen);
        driver.get(curUrlCalldoctor);

        page.dashboardPage().openNewCallProgressFrame(nameGen);
        page.fullCardPage().verifyCallProfile6(nameGen);
    }

    @Test(groups = "CD", description = "вызов ребенка с Портала")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCallPortal() throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get("https://uslugi.mosreg.ru/zdrav/");
        SQLDemonstration.finalizePacientNumberPol(nomerPolPro4);
        page.portalDashboard().createCallHelper(user6);
        driver.get(curUrlCalldoctor);

        page.dashboardPage().openNewCallProgressFrame(namePro4);
        page.fullCardPage().verifyCallProfile4(nameGen);
    }

    @Test(groups = "test", description = "создание вызова через портал по рандомному МКАБу")
//дата провайдер аннотацию добавить
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testRandomProfile() throws InterruptedException {
        driver.get("https://uslugi.mosreg.ru/zdrav/");
        SQLDemonstration.finalizePacientNumberPol(nomerPolPro4);
        page.portalDashboard().createRandomCall();
        driver.get(curUrlCalldoctor);

        page.dashboardPage().openNewCallProgressFrame(namePro4);
        page.fullCardPage().verifyCallProfile4(nameGen);
    }
}

/**Благодаря этому паттерну можно реализовать много интересных вещей, например,
 * вы можете реализовать пул браузеров. Многие жалуются – наши web-тесты тормозят,
 * потому что пока браузер поднимется, пока первая страница загрузится, пока скопируется профиль и так далее.
 Браузеры не обязательно создавать прямо в тесте, вместо этого можно использовать Background Pool,
 в котором настроено необходимое вам количество браузеров, и в этом пуле, когда браузер в него возвращается –
 вы его очищаете, делаете еще что-то, но это все происходит в бэкграунде, в параллельных с выполнением ваших тестов потоках.
 И только готовый к использованию браузер отдается вашему тесту, когда он запрашивает из браузерного пула новый браузер для себя.

 Наконец, классический пример более сложного использования этого паттерна – когда вы имеете пул инстансов базы данных.
 Вместо того, чтобы работать с реальной базой данных, вы поднимаете необходимый набор контейнеров базы данных в необходимом
 количестве на разных портах, это делается очень просто с Docker или каким-то другим доступным вам инструментом виртуализации,
 и после того, как вы поработали с базой данных, вы ее «потушили» и в пуле подняли новую. Благодаря этому вы можете постоянно иметь
 чистую базу данных для работы, нет необходимости делать teardown или очистку базы, собирание и загрузку данных, и так далее.

 https://habr.com/company/jugru/blog/338836/ посмотреть паттерн data provider и decorator

 @DataProvider
 public Object[][] dataProvider() {
 return new Object[][]{
 {1}, {2}, {3}
 };
 }

 @Attachment
 public byte[] attachScreenshot() {
 return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
 }


 */