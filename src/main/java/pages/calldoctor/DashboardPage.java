package pages.calldoctor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import pages.AbstractPage;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertFalse;

public class DashboardPage extends AbstractPage {
    private SelenideElement exitToMis = $(By.xpath("//mat-icon[contains(text(),'more_vert')]"));
    private SelenideElement exitBtn = $(By.xpath("//*[contains(text(),'Выход')]"));
    private SelenideElement fioFilter = $(By.xpath("//*[@placeholder='ФИО']"));
    private SelenideElement docFilter = $(By.xpath("//*[@placeholder='Врач']"));
    private SelenideElement typeCall = $(By.xpath("//*[@placeholder='Вид вызова']"));
    private SelenideElement newCallProgressFrame = $(By.id("newCallProgressFrame"));
    private SelenideElement matExpansionPanel = $(By.xpath("//*[@id='newCallProgressFrame']/mat-expansion-panel/div"));
    private SelenideElement smallMenu = $(By.xpath("//*[@id='newCallProgressFrame']/mat-expansion-panel/div/div/div/app-call-doctor-short-card/div/div/div[3]"));
    private SelenideElement openCard = $(By.xpath("//a[@title='Открыть карту вызова']"));
    private SelenideElement typeCallFilterNeotlozhniy = $(By.xpath("//span[contains(text(),'Неотложный')]"));
    private SelenideElement activeCallProgressFrame = $(By.id("activeCallProgressFrame"));
    private SelenideElement doneCallProgressFrame = $(By.id("doneCallProgressFrame"));

    public DashboardPage() {
    }

    @Step("вышел в мис")
    public void exitToMis() {
        exitToMis.click();
        exitBtn.click();
    }

    @Step("поиск в фильтре ФИО")
    public DashboardPage searchFilterFio(String nameGen) {
        fioFilter.click();
        fioFilter.setValue(nameGen);
        return this;
    }

    @Step("поиск в фильтре ФИО")
    public DashboardPage searchFilterFio_Fam(String profile) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map<String, String> proData = new ObjectMapper().readValue(reader, Map.class);
        fioFilter.click();
        fioFilter.setValue(proData.get("fam"));
        return this;
    }

    @Step("поиск в фильтре врача")
    public DashboardPage searchFilterDoctor(String profile) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map<String, String> proData = new ObjectMapper().readValue(reader, Map.class);
        docFilter.click();
        docFilter.setValue(proData.get("doctorFam"));
        $(By.xpath("//ul/li/div[contains(text(),'" + proData.get("doctorFam") + "')]")).click();
//        docFilter.pressEnter();
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
    public void verifyNewCallGroup(String profile, String nameGen) throws InterruptedException, IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);
        Thread.sleep(4000);
        newCallProgressFrame.$(By.id("order")).click();
        newCallProgressFrame.click();
        if (proData.get("source").equals("СМП")) {
            $(By.xpath("//*[contains(text(),'" + proData.get("adressDashboard") + "')]")).click();
            $(By.xpath("//*[contains(text(),'" + proData.get("fam") + "')]")).shouldBe(Condition.visible);
            $(By.xpath("//*[contains(text(),'" + proData.get("telephone") + "')]")).shouldBe(Condition.visible);
        }
        if (!proData.get("source").equals("СМП")) {
            $(By.xpath("//*[contains(text(),'" + proData.get("adressDashboard") + "')]")).click();
            $(By.xpath("//*[contains(text(),'" + nameGen + "')]")).shouldBe(Condition.visible);
            $(By.xpath("//*[contains(text(),'" + proData.get("telephone") + "')]")).shouldBe(Condition.visible);
        }
        System.out.println("Краткая карта вызова проверена!");
    }

    @Step("проверяю на дашборде запись в группе новые")
    public void verifyNewCallGroup(String profile) throws InterruptedException, IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);
        Thread.sleep(4000);
        newCallProgressFrame.$(By.id("order")).click();
        newCallProgressFrame.click();
        $(By.xpath("//*[contains(text(),'" + proData.get("adressDashboard") + "')]")).click();
        $(By.xpath("//*[contains(text(),'" + proData.get("name") + "')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("telephone") + "')]")).shouldBe(Condition.visible);
        System.out.println("Краткая карта вызова проверена!");
    }

    @Step("проверяю на дашборде запись у врача в группе активные")
    public void verifyActiveDocGroup(String nameGen, String profile, String profile2) throws InterruptedException, IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);
        File reader2 = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile2 + ".json");
        Map proData2 = new ObjectMapper().readValue(reader2, Map.class);
        Thread.sleep(4000);
        $(By.xpath("//*[contains(text(),'" + proData.get("doctorFam") + "')]")).click();
        activeCallProgressFrame.$(By.id("order")).click();
        activeCallProgressFrame.click();
        $(By.xpath("//*[contains(text(),'" + proData2.get("adressDashboard") + "')]")).click();
        $(By.xpath("//*[contains(text(),'" + nameGen + "')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData2.get("telephone") + "')]")).shouldBe(Condition.visible);
        System.out.println("Краткая карта вызова проверена!");
    }

    @Step("проверяю на дашборде запись у врача в группе активные")
    public void verifyActiveDocGroup(String nameGen, String profile) throws InterruptedException, IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);
        Thread.sleep(4000);
        $(By.xpath("//span[contains(text(),'" + proData.get("doctorFam") + "')]")).click();
        activeCallProgressFrame.$(By.id("order")).click();
        activeCallProgressFrame.click();
        $(By.xpath("//*[contains(text(),'" + proData.get("adressDashboard") + "')]")).click();
        $(By.xpath("//*[contains(text(),'" + nameGen + "')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("telephone") + "')]")).shouldBe(Condition.visible);
        System.out.println("Краткая карта вызова проверена!");
    }

    @Step("проверка в группе обслуженные")
    public void verifyDoneDocGroup(String nameGen, String profile) throws InterruptedException, IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);
        Thread.sleep(4000);
        $(By.xpath("//div[@id='doneCallAllCount'][contains(text(),'1')]"));
        $(By.xpath("//span[contains(text(),'" + proData.get("doctorFam") + "')]")).click();
        doneCallProgressFrame.click();
        $(By.xpath("//*[contains(text(),'" + proData.get("adressDashboard") + "')]")).click();
        $(By.xpath("//*[contains(text(),'" + nameGen + "')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("telephone") + "')]")).shouldBe(Condition.visible);
        System.out.println("Краткая карта вызова проверена!");
    }

    @Step("Проверка что запись удалена с дашборда")
    public void verifyRecordIsCancelFromDashboard() throws InterruptedException {
        Thread.sleep(4000);
        assertFalse(newCallProgressFrame.findElement(By.id("order")).isDisplayed());
        newCallProgressFrame.$(By.id("order")).shouldBe(Condition.not(Condition.visible));
    }

    @Step("открываю карту вызова в группе 'Ожидают обработки' через дашбоард")
    public void openNewCallProgressFrame(String profile) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map<String, String> proData = new ObjectMapper().readValue(reader, Map.class);


        newCallProgressFrame.$(By.id("order")).click();
        newCallProgressFrame.click();
        // TODO: 23.07.2018 повысить стабильность hover, сейчас часто релодит и фокус сбивается
        Actions actions = new Actions(driver);
        actions.moveToElement($(By.xpath("//*[contains(.,'" + proData.get("adressDashboard") + "')]/mat-expansion-panel/div"))).perform();
//        actions.moveToElement(matExpansionPanel).perform();
        actions.moveToElement(smallMenu).perform();
        openCard.click();
    }
}