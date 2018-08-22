package emias.calldoctor;

import emias.AbstractTest;
import emias.retry.RetryAnalyzer;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.testng.annotations.*;
import pages.Pages;
import pages.utilities.DriverManager;
import pages.utilities.SQLDemonstration;
import pages.utilities.StringGenerator;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

@Listeners(RetryAnalyzer.class)
public class RCD01Test extends AbstractTest {
    private String nameGen;

    @Parameters({"browser", "platform", "login", "pass"})
    @BeforeMethod()
    public void beforeMethod(@Optional String browser, @Optional String platform, @Optional String login, @Optional String pass) {
        System.out.println("Бефор метод " + Thread.currentThread().getId());
        System.out.println("Browser: " + browser);
        System.out.println("Platform: " + platform);
        driver = new DriverManager(browser).createDriver();
        page = new Pages();

        String site = "http://emias.mosreg.ru/demonstration/";
        System.out.println("Site: " + site);

        page.loginPage().login(site, login, pass);
        page.homePage().callDoctorBtn();
        switchTo().window(1);
        curUrlCalldoctor = driver.getCurrentUrl();

        StringGenerator nameGen = new StringGenerator();
        this.nameGen = String.valueOf(nameGen.generator());
    }

    @AfterMethod()
    public void afterMethod() {
        System.out.println("Афтер метод " + Thread.currentThread().getId());
        driver.manage().deleteAllCookies();
        close();
        SQLDemonstration.finalizePacientName(nameGen);
    }


    @Test(description = "пустой вызов", retryAnalyzer = RetryAnalyzer.class)
    @Issue("EMIAS-90")
    @TmsLink("EMIAS-90")
    public void testCallRegistrEmpy() throws IOException {
        System.out.println("тест RegistrEmpy " + Thread.currentThread().getId());
        open(curUrlCalldoctor);
        page.createCallPage().createNewCall("Profile0", nameGen, "n");
        page.fullCardPage()
                .verifyCallProfile0("Profile0")
                .closeCardBtn();
    }

/*    @Test(description = "вызов с иточником Регистратура без МКАБ", retryAnalyzer = RetryAnalyzer.class)
    @Issue("EMIAS-90")
    public void testCallRegistr() throws Exception {
        System.out.println("тест Registr " + Thread.currentThread().getId());
        open(curUrlCalldoctor);
        page.createCallPage()
                .createNewCall("Profile1", nameGen, "n");
        page.fullCardPage()
                .verifyCallNewCallGroup("Profile1", nameGen)
                .closeCardBtn();
        page.dashboardPage()
                .verifyNewCallGroup("Profile1", nameGen);
    }

    @Test(description = "вызов с источником СМП и привязкой МКАБ", retryAnalyzer = RetryAnalyzer.class)
    @Issue("EMIAS-90")
    public void testCallRegistrMkab() throws Exception {
        System.out.println("тест RegistrMkab " + Thread.currentThread().getId());
        open(curUrlCalldoctor);
        page.createCallPage().createNewCall("Profile2", nameGen, "y");
        page.fullCardPage()
                .verifyCallNewCallGroup("Profile2", nameGen)
                .closeCardBtn();
        page.dashboardPage()
                .verifyNewCallGroup("Profile2");
    }

    @Test(description = "вызов от СМП по api, ребенок по МКАБ без КЛАДР", retryAnalyzer = RetryAnalyzer.class)
    @Issue("EMIAS-90")
    public void testCallSmpChildMkab() throws IOException {
        System.out.println(Thread.currentThread().getId());
        open(curUrlCalldoctor);
        page.createCallPage().createCallProfile3(nameGen);
        page.dashboardPage().openNewCallProgressFrame("Profile3");
        page.fullCardPage().verifyCallNewCallGroup("Profile3", nameGen);
    }

    @Test(description = "вызов от СМП по api, Взрослый без МКАБ по КЛАДР", retryAnalyzer = RetryAnalyzer.class)
    @Issue("EMIAS-90")
    public void testCallSmpAdultKladr() throws IOException {
        System.out.println(Thread.currentThread().getId());
        open(curUrlCalldoctor);
        page.createCallPage().createCallProfile6(nameGen);
        page.dashboardPage().openNewCallProgressFrame("Profile6");
        page.fullCardPage().verifyCallNewCallGroup("Profile6", nameGen);
    }

    @Test(description = "вызов ребенка с Портала", retryAnalyzer = RetryAnalyzer.class)
    @Issue("EMIAS-90")
    public void testCallPortal() throws IOException {
        System.out.println("тест Portal " + Thread.currentThread().getId());
        SQLDemonstration.finalizePacientProfile("Profile4");
        open("https://uslugi.mosreg.ru/zdrav/");
        page.portalDashboard()
                .createCall("Profile4", nameGen);
        open(curUrlCalldoctor);
        page.dashboardPage()
                .clearFilterDepart()
                .openNewCallProgressFrame("Profile4");
        page.fullCardPage()
                .verifyCallNewCallGroup("Profile4", nameGen);
    }*/

    /*

        @DataProvider(name = "ProfileRegistr")
    public static Object[][] credentials() {
        return new Object[][]{
                {"Profile1", "n"},
                {"Profile2", "y"},
        };
    }

    @Test(groups = "", dataProvider = "ProfileRegistr", description = "тестирую создание вызова через датаПровайдер")//из минусов не создается уникальный дескрипшн к тесту
    public void testCallRegistr_DataProvider(String profileDProvider, String searchField) throws Exception {
        open(curUrlCalldoctor);
        page.createCallPage()
                .createNewCall(profileDProvider, nameGen, searchField);
        page.fullCardPage()
                .verifyCallNewCallGroup(profileDProvider, nameGen)
                .closeCardBtn();
        page.dashboardPage()
                .verifyNewCallGroup(profileDProvider, nameGen);
    }
*/

}

// TODO: 18.08.2018 create new call from CC for api
// TODO: 18.08.2018 сделать вызовы по апи от смп и проверить отображение подсветки что вызов неотложный и что он без возрастной категории
// TODO: 18.08.2018 создать вызов с адресом как в двух участках (один участок с номерами домов, другой только улица), указать номер дома как в участке с домами. Проверить что появляется окно с выбором участка. В выпадающем списке корректные участки
// TODO: 18.08.2018 создать вызов с адресом как в двух участках (один участок с номерами домов, другой только улица), указать уникальный номер дома. Проверить что появляется окно с выбором участка. В выпадающем списке корректные участки
// TODO: 18.08.2018 создать вызов с адресом как в двух участках (один участок с номерами домов, второй участок с такими же номерами домов), указать такой же номер дома. Проверить что появляется окно с выбором участка. В выпадающем списке корректные участки
// TODO: 18.08.2018 создать вызов с адресом как в двух участках (один участок с номерами домов, второй участок с такими же номерами домов), указать уникальный номер дома. Проверить что появляется окно с выбором участка. В выпадающем списке корректные участки
// TODO: 18.08.2018 сделать пару тестов для проверки кладра (выписать адреса с которыми было много проблем)
// TODO: 19.08.2018 на странице выбора врача в поле формализации адреса ввести другой адрес. Проверить что в хедере данный адрес изменился
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
 * @Attachment public byte[] attachScreenshot() {
 * return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
 * }
 */