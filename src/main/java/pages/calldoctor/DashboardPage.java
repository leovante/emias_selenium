package pages.calldoctor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractPage;
import pages.calldoctor.profiles_interfaces.Profile;
import pages.utilities.JSWaiter;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertFalse;

public class DashboardPage extends AbstractPage implements Profile {

    SelenideElement exitToMis = $(By.xpath("//mat-icon[contains(text(),'more_vert')]"));
    SelenideElement exitBtn = $(By.xpath("//*[contains(text(),'Выход')]"));
    SelenideElement logoType = $(By.xpath("//img[@src='assets/img/call-doctor-logo.svg']"));
    SelenideElement fioFilter = $(By.xpath("//*[@placeholder='ФИО']"));
    SelenideElement docFilter = $(By.xpath("//*[@placeholder='Врач']"));
    SelenideElement typeCall = $(By.xpath("//*[@placeholder='Вид вызова']"));
    SelenideElement newCallProgressFrame = $(By.id("newCallProgressFrame"));
    SelenideElement matexpansionpanel = $(By.xpath("//*[@id='newCallProgressFrame']/mat-expansion-panel/div"));
    SelenideElement smallMenu = $(By.xpath("//*[@id='newCallProgressFrame']/mat-expansion-panel/div/div/div/app-call-doctor-short-card/div/div/div[3]"));
    SelenideElement openCard = $(By.xpath("//a[@title='Открыть карту вызова']"));
    SelenideElement typeCallFilterNeotlozhniy = $(By.xpath("//span[contains(text(),'Неотложный')]"));
    SelenideElement activeCallProgressFrame = $(By.id("activeCallProgressFrame"));
    SelenideElement doneCallProgressFrame = $(By.id("doneCallProgressFrame"));
    SelenideElement cardSpace = $(By.id("cardSpace"));
    SelenideElement activeDocGroup = $(By.id("activeDocGroup"));

    public DashboardPage() {
    }

    @Step("вышел в мис")
    public DashboardPage exitToMis() {
        exitToMis.click();
        exitBtn.click();
        return this;
    }

    @Step("нажать на логотип")
    public DashboardPage clickLogoType() {
        logoType.click();
        return this;
    }

    @Step("поиск в фильтре ФИО")
    public DashboardPage searchFilterFio(String fioName) {
        fioFilter.click();
        fioFilter.setValue(fioName);
        return this;
    }

    @Step("поиск в фильтре врача")
    public DashboardPage searchFilterDoctor(String fioName) {
        docFilter.click();
        docFilter.setValue(fioName);
        docFilter.pressEnter();
        return this;
    }

    @Step("поиск в фильтре врача")
    public DashboardPage searchFilterTypeCallNeotlozhniy() {
        typeCall.click();
        typeCallFilterNeotlozhniy.click();
        return this;
    }

    @Step("очистить фильтр подразделение")
    public DashboardPage clearFilterDepart() {
        ElementsCollection closeList = $$(By.id("4198BD84-7A21-4E38-B36B-3ECB2E956408"));
        for (SelenideElement closeBtn : closeList) {
            closeBtn.click();
        }
        return this;
    }

    @Step("проверяю на дашборде запись в группе новые")
    public DashboardPage verifyNewCallProgressFrame(String nameGen, String profile) throws InterruptedException, IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);

        Thread.sleep(4000);
        newCallProgressFrame.$(By.id("order")).click();
        newCallProgressFrame.click();

        $(By.xpath("//[contains(.,'" + proData.get(adressDashboard) + "')]")).click();
        $(By.xpath("//[contains(.,'" + nameGen + "')]")).shouldBe(Condition.visible);
        $(By.xpath("//[contains(.,'" + proData.get(telephone) + "')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("проверяю на дашборде запись в группе новые")
    public DashboardPage verifyNewCallProgressFrame(String profile) throws InterruptedException, IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);

        Thread.sleep(4000);
        newCallProgressFrame.$(By.id("order")).click();
        newCallProgressFrame.click();
        $(By.xpath("//[contains(.,'" + proData.get(adressDashboard) + "')]")).click();
        $(By.xpath("//[contains(.,'" + proData.get(name) + "')]")).shouldBe(Condition.visible);
        $(By.xpath("//[contains(.,'" + proData.get(telephone) + "')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("проверяю на дашборде запись у врача в группе активные")
    public DashboardPage verifyActiveDocGroup(String doctorFam, String nameGen, String profile) throws InterruptedException, IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);

        Thread.sleep(4000);
        $(By.xpath("//*[contains(text(),'" + doctorFam + "')]")).click();
        activeCallProgressFrame.$(By.id("order")).click();
        activeCallProgressFrame.click();
        $(By.xpath("//[contains(.,'" + proData.get(adressDashboard) + "')]")).click();
        $(By.xpath("//[contains(.,'" + nameGen + "')]")).shouldBe(Condition.visible);
        $(By.xpath("//[contains(.,'" + proData.get(telephone) + "')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("проверка в группе обслуженные")
    public void verifyDoneDocGroup(String doctorFam, String nameGen, String profile) throws InterruptedException, IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);
        Thread.sleep(4000);

        $(By.xpath("//div[@id='doneCallAllCount'][contains(text(),'1')]"));
        $(By.xpath("//span[contains(text(),'" + doctorFam + "')]")).click();
        doneCallProgressFrame.click();
        $(By.xpath("//[contains(.,'" + proData.get(adressDashboard) + "')]")).click();
        $(By.xpath("//[contains(.,'" + nameGen + "')]")).shouldBe(Condition.visible);
        $(By.xpath("//[contains(.,'" + proData.get(telephone) + "')]")).shouldBe(Condition.visible);
    }

    @Step("Проверка что запись удалена с дашборда")
    public DashboardPage verifyRecordIsCancelFromDashboard() throws InterruptedException {
        Thread.sleep(4000);
        assertFalse(newCallProgressFrame.findElement(By.id("order")).isDisplayed());
        newCallProgressFrame.$(By.id("order")).shouldBe(Condition.not(Condition.visible));
        return this;
    }

    @Step("открываю карту вызова в группе 'Ожидают обработки' через дашбоард")
    public DashboardPage openNewCallProgressFrame(String profile) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);

        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        JSWaiter.waitJQueryAngular();

        newCallProgressFrame.click();
        newCallProgressFrame.$(By.id("order")).click();
        newCallProgressFrame.click();


        matexpansionpanel.hover();
        smallMenu.click();
        openCard.click();
        return this;
    }
}