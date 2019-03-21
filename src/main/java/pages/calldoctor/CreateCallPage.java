package pages.calldoctor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import dataGenerator.ModuleData;
import io.qameta.allure.Step;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AbstractPage;
import system.model.HltMkabEntity;
import utilities.api_model.CallDoctorEntity;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CreateCallPage extends AbstractPage {
    CallDoctorEntity callDoctorEntity;
    HttpResponse httpResponse;
    ModuleData mData;
    HltMkabEntity mkab;

    SelenideElement cancelAdress = $(By.xpath("//*[@id='4198BD84-7A21-4E38-B36B-3ECB2E956408']"));
    SelenideElement list_first_container = $(By.xpath("//div[@class='autocomplete-list-container']/ul/li"));
    SelenideElement adress = $(By.xpath("//input[@placeholder='Адрес']"));

    SelenideElement dom = $(By.xpath("//input[@placeholder='Дом']"));
    SelenideElement vKat = $(By.xpath("//input[@placeholder='Возр. категория']"));
    SelenideElement korpus = $(By.xpath("//input[@placeholder='Корпус']"));
    SelenideElement stroenie = $(By.xpath("//input[@placeholder='Строение']"));
    SelenideElement kvartira = $(By.xpath("//input[@placeholder='Квартира']"));
    SelenideElement pd = $(By.xpath("//input[@placeholder='П-д']"));

    SelenideElement dfon = $(By.xpath("//input[@placeholder='Д-фон']"));
    SelenideElement etazh = $(By.xpath("//input[@placeholder='Этаж']"));
    SelenideElement seriyaPol = $(By.xpath("//input[@placeholder='Серия']"));
    SelenideElement nomerPol = $(By.xpath("//input[@placeholder='Номер полиса']"));
    SelenideElement fam = $(By.xpath("//input[@placeholder='Фамилия']"));
    SelenideElement name = $(By.xpath("//input[@placeholder='Имя']"));
    SelenideElement otchestvo = $(By.xpath("//input[@placeholder='Отчество']"));
    SelenideElement birthDateTemp = $(By.xpath("//input[@placeholder='Дата рождения']"));

    SelenideElement phone = $(By.id("phone"));
    SelenideElement famCall = $(By.id("callFamily"));
    SelenideElement nameCall = $(By.id("callName"));
    SelenideElement otCall = $(By.id("callPatronymic"));
    SelenideElement sourceSmp = $(By.id("source0"));
    SelenideElement sourceSmp2 = $(By.id("sourceSmp"));
    SelenideElement sourceReg = $(By.id("source1"));
    SelenideElement callerType = $(By.xpath("//input[@placeholder='Тип вызывающего']"));

    SelenideElement cancelBtn = $(By.id("cancelCall"));
    SelenideElement cancelField = $(By.xpath("//input[@placeholder='Причина отмены вызова']"));
    SelenideElement cancelCall = $(By.xpath("//a[@title='Отменить вызов']"));

    public CreateCallPage(ModuleData mData) {
        this.mData = mData;
        this.mkab = mData.getMkab();
    }

    protected static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    protected void statusBodyResponce(HttpResponse resp) throws IOException {
        if (resp.getStatusLine().getStatusCode() != 200) {
            LOGGER.info("Ошибка! Ответ сервера:\n" + EntityUtils.toString(resp.getEntity(), "UTF-8"));
        }
    }

    public CreateCallPage createCall() throws InterruptedException {
        if (mData.getApiStat() == true) {
            HttpClient httpClient = HttpClients.createDefault();
            if (mData.getSource() == "СМП") {//смп
                try {
                    callDoctorEntity = new CallDoctorEntity(mData);
                    httpResponse = httpClient.execute(callDoctorEntity.createRequest());
                    statusBodyResponce(httpResponse);
                    LOGGER.info("Карта вызова создана!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    LOGGER.info("Error, " + "Cannot Estabilish Connection");
                }
            }
            if (mData.getSource() == "КЦ") {
                try {
                    callDoctorEntity = new CallDoctorEntity(mData);
                    httpResponse = httpClient.execute(callDoctorEntity.createRequestToken());
                    statusBodyResponce(httpResponse);
                    LOGGER.info("Карта вызова создана!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    LOGGER.info("Error, " + "Cannot Estabilish Connection");
                }
            }
        }
        if (mData.getApiStat() == false) {
            if (mData.getMkabStat() == false) {
                addNewCall()
                        .sourceCall()
                        .address()
                        .birthDay()
                        .gender()
                        .complaint()
                        .polis()
                        .FIO()
                        .caller()
                        .telephone()
                        .saveBtn();
            }
            if (mData.getMkabStat() == true) {
                addNewCall()
                        .sourceCall()
                        .searchField()
                        .addressPlus()
                        .complaint()
                        .caller()
                        .telephone()
                        .saveBtn();
            }
        }
        return this;
    }

//    public CreateCallPage createCall_Mkab() throws IOException, InterruptedException, ParseException {
//        addNewCall()
//                .sourceCall()
//                .searchField()
//                .addressPlus()
//                .complaint()
//                .caller()
//                .telephone()
//                .saveBtn();
//        return this;
//    }

    //переделать под фабрику
//    @Step("Создаю вызов через api")
//    public void createCall_Api() {
//        HttpClient httpClient = HttpClients.createDefault();
//        if (pacient.getSource() == 2) {//смп
//            try {
//                callDoctorEntity = new CallDoctorEntity(findByModel);
//                httpResponse = httpClient.execute(callDoctorEntity.createRequest());
//                statusBodyResponce(httpResponse);
//                LOGGER.info("Карта вызова создана!");
//            } catch (Exception ex) {
//                ex.printStackTrace();
//                LOGGER.info("Error, " + "Cannot Estabilish Connection");
//            }
//        }
//        if (pacient.getSource() == 3) {
//            try {
//                callDoctorEntity = new CallDoctorEntity(findByModel);
//                httpResponse = httpClient.execute(callDoctorEntity.createRequestToken());
//                statusBodyResponce(httpResponse);
//                LOGGER.info("Карта вызова создана!");
//            } catch (Exception ex) {
//                ex.printStackTrace();
//                LOGGER.info("Error, " + "Cannot Estabilish Connection");
//            }
//        }
//    }

    @Step("редактирую вызов")
    public CreateCallPage editCallPage(ModuleData mData) throws IOException, ParseException, InterruptedException {
        this.mkab = mData.getMkab();
        sourceCall()
                .sourceCall()
                .address()
                .birthDay()
                .addressPlus()
                .addressPlus()
                .complaint()
                .polis()
                .FIO()
                .caller()
                .telephone();
//                .saveBtn();
        LOGGER.info("Вызов отредактирован! " + driver.getCurrentUrl());
        return this;
    }

    @Step("редактирую вызов с МКАБ + СМП")
    public CreateCallPage editCallPage_Mkab(ModuleData mkab) throws IOException, ParseException, InterruptedException {
        this.mkab = mkab.getMkab();
        sourceCall()
                .searchField()
                .addressPlus()
                .complaint()
                .caller()
                .telephone();
//                .saveBtn();
        LOGGER.info("Вызов отредактирован! " + driver.getCurrentUrl());
        return this;
    }

    @Step("очищаю все поля у карты")
    public CreateCallPage setDeafult() {
        $(By.id("source1")).click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();

        List<SelenideElement> selenideElements = $$(By.xpath("//button/span/mat-icon[contains(text(),'close')]"));
        List<SelenideElement> selenideElements2 = $$(By.xpath("//svg[@height='16px']"));

        for (SelenideElement element : selenideElements) {
            if (element.isDisplayed())
                element.click();
        }

        for (SelenideElement element : selenideElements2) {
            if (element.isDisplayed())
                element.click();
        }

        $(By.xpath("//input[@placeholder='Дом']")).clear();
        $(By.id("phone")).clear();
        $(By.xpath("//input[@placeholder='Корпус']")).clear();
        $(By.xpath("//input[@placeholder='Строение']")).clear();
        $(By.xpath("//input[@placeholder='Квартира']")).clear();
        $(By.xpath("//input[@placeholder='П-д']")).clear();
        $(By.xpath("//input[@placeholder='Д-фон']")).clear();
        $(By.xpath("//input[@placeholder='Этаж']")).clear();
        $(By.xpath("//input[@placeholder='Серия']")).clear();
        $(By.xpath("//input[@placeholder='Номер полиса']")).clear();
        $(By.xpath("//input[@placeholder='Фамилия']")).clear();
        $(By.xpath("//input[@placeholder='Имя']")).clear();
        $(By.xpath("//input[@placeholder='Отчество']")).clear();
        $(By.xpath("//input[@placeholder='Дата рождения']")).clear();
        LOGGER.info("Карта вызова очищена для редактирования!");
        return this;
    }

    @Step("добавить новый вызов")
    public CreateCallPage addNewCall() {
        $(By.id("addNewCall")).click();
        return this;
    }

    @Step("выбор источника вызова")
    private CreateCallPage sourceCall() {
        try {
            if (mData.getSource() == "СМП") {
                sourceSmp.click();
            } else if (mData.getSource() == "Регистратура") {
                sourceReg.click();
            }
        } catch (Exception e) {
            throw new InvalidArgumentException("Ошибка, не найден источник вызова!");
        }
        return this;
    }

    @Step("поиск МКАБ")
    public CreateCallPage searchField() {
        $(By.id("findPatientInput")).setValue(String.valueOf(mkab.getnPol()));
        $(By.xpath("//mat-option/span[contains(text(),'" + mkab.getFamily() + "')]")).click();
        return this;
    }

    @Step("ввод адреса")
    private CreateCallPage address() throws InterruptedException {
//        if (pacient.getAddress1() != null && pacient.getAddress1() != "") {
//            clearAddress();
//            list_first_container(pacient.getAddress1());
//        }
//        if (pacient.getAddress2() != null && pacient.getAddress2() != "")
//            list_first_container(pacient.getAddress2());
//        if (pacient.getAddress3() != null && pacient.getAddress3() != "") {
//            if (pacient.getAddress3adv() != null && pacient.getAddress3adv() != "") {
//                Thread.sleep(1000);
//                adress.sendKeys(pacient.getAddress3());
//                $(By.xpath("//mat-option/span[contains(text(),'" + pacient.getAddress3adv() + "')]")).click();
//            } else
//                list_first_container(pacient.getAddress3());
//        }
//        if (findByModel.getPhoneHome() != null && findByModel.getnPol() != "") {
//            $(By.xpath("//input[@placeholder='Дом']")).setValue(findByModel.getnPol());
//        }
//        addressPlus();
        return this;
    }

    @Step("выбрал адрес из выпадающего списка")
    void list_first_container(String address) throws InterruptedException {
        adress.hover();
        Thread.sleep(1000);
        WebDriver driver = getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement address1 = driver.findElement(By.xpath("//input[@placeholder='Адрес']"));
        address1.sendKeys(address);
        Thread.sleep(1000);
        korpus.hover();
        Thread.sleep(1000);
        adress.hover();
        $(By.xpath("//mat-option/span[contains(text(),'" + address + "')]"))
                .shouldBe(Condition.visible)
                .click();
    }

    @Step("очистить поле с адресом")
    void clearAddress() throws InterruptedException {
        $(By.xpath("//*[contains(text(),'КТО ПАЦИЕНТ')]")).shouldBe(Condition.visible);
        addressLoadWaiter();
        for (int k = 0; k < 10 && !adress.getValue().equals(""); k++) {
            cancelAdress.shouldBe(Condition.visible).click();
            LOGGER.info("очистил поле с адресом");
        }
    }

    @Step("жду загрузку адреса")
    void addressLoadWaiter() throws InterruptedException {
        if ($(By.xpath("//*[contains(text(),'Новый вызов')]")).isDisplayed()) {
            int i = 0;
            do {
                LOGGER.info("жду загрузку адреса");
                Thread.sleep(1000);
                i++;
            } while (!adress.getValue().equals("Московская обл.,") && i < 10);
            Assert.assertTrue(adress.getValue().equals("Московская обл.,"), "адрес не загрузился");
        }
    }

    @Step("уточняю адрес")
    private CreateCallPage addressPlus() {
//        korpus.setValue();
//        stroenie.setValue();
//        kvartira.setValue();
        pd.setValue(mData.getPd());
        dfon.setValue(mData.getDfon());
        etazh.setValue(mData.getEntrance());
        return this;
    }

    @Step("пол")
    private CreateCallPage gender() {
        if (mkab.getW() == 1) {
            $(By.id("sex1")).click();
        }
        if (mkab.getW() == 2) {
            $(By.id("sex2")).click();
        }
        return this;
    }

    @Step("жалоба")
    private CreateCallPage complaint() throws InterruptedException {
        SelenideElement complaint = $(By.xpath("//input[@aria-label='Введите текст жалобы'] | //input[@aria-label='Добавить жалобу']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='" + mData.getComplaint() + "';", complaint);
        complaint.sendKeys(Keys.SPACE);

        $(By.xpath("//span[contains(text(),'диатез')]")).click();
        $(By.xpath("//div[contains(text(),'" + mData.getComplaint() + "')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("полис")
    private CreateCallPage polis() {
        if (mkab.getsPol() != null && mkab.getsPol() != "") {
            $(By.xpath("//input[@placeholder='Серия']")).setValue(String.valueOf(mkab.getsPol()));
        }
        if (mkab.getnPol() != null && mkab.getnPol() != "") {
            $(By.xpath("//input[@placeholder='Номер полиса']")).setValue(String.valueOf(mkab.getnPol()));
        }
        return this;
    }

    @Step("фио")
    private CreateCallPage FIO() {
        if (mkab.getFamily() != null) {
            $(By.xpath("//input[@placeholder='Фамилия']")).setValue(mkab.getFamily());
        }
        if (mkab.getName() != null) {
            $(By.xpath("//input[@placeholder='Имя']")).setValue(mkab.getName());
        }
        if (mkab.getOt() != null) {
            $(By.xpath("//input[@placeholder='Отчество']")).setValue(mkab.getOt());
        }
        return this;
    }

    @Step("день рождения")
    private CreateCallPage birthDay() {
//        if (findByModel.getDateBd() != null)
//            $(By.xpath("//input[@placeholder='Дата рождения']")).setValue(findByModel.getDateBd("dd-MM-yyyy"));
        return this;
    }

    @Step("возрастная категория")
    public CreateCallPage vozrastKat() {
        $(By.xpath("//button[2]/span/mat-icon")).click();
        vKat.click();

        Date newData = new Date();
        Date bd = mkab.getDateBd();
        int years = (int) getDateDiff(bd, newData, TimeUnit.DAYS) / 365;
        if (years > 18) {
            $(By.xpath("//span[contains(.,'Взрослые')]")).click();
        }
        if (years < 18) {
            $(By.xpath("//span[contains(.,'Дети')]")).click();
        }
        return this;
    }

    @Step("фио вызывающего")
    private CreateCallPage caller() {
        if (mData.getSource() == "СМП") {
            $(By.id("sourceSmp")).setValue("Супер станция");
            $(By.id("callFamily")).setValue("ФамилияВызывающего");
            $(By.id("callName")).setValue("ИмяВызывающего");
            $(By.id("callPatronymic")).setValue("ОтчествоВызывающего");
            $(By.id("phone")).setValue(mData.getSMPPhone());
        } else {
            if (years() >= 18) {
                callerType.click();
                $(By.xpath("//span[contains(.,'Пациент')]")).click();
            } else {
                callerType.click();
                $(By.xpath("//span[contains(.,'Представитель')]")).click();
            }
        }
        return this;
    }

    @Step("телефон")
    private CreateCallPage telephone() {
        if (!mkab.getPhoneWork().equals("")) {
            $(By.id("phone")).setValue(mkab.getPhoneWork());
        }
        if (mkab.getPhoneWork().equals("")) {
            $(By.xpath("//label[@class='mat-checkbox-layout']")).click();
        }
        return this;
    }

    @Step("количество лет")
    public int years() {
        Date newData = new Date();
        Date bd = mkab.getDateBd();
        int years = (int) getDateDiff(bd, newData, TimeUnit.DAYS) / 365;
        return years;
    }

    @Step("кнопка сохранить")
    public CreateCallPage saveBtn() throws InterruptedException {
        SelenideElement fullCardPage = $(By.xpath("//*[contains(text(),'Карта вызова')]"));
        SelenideElement allert = $(By.xpath("//button[@aria-label='Close dialog']"));
        SelenideElement save = $(By.id("save"));
        String old = driver.getCurrentUrl();

        for (int i = 0; i < 10; i++) {
            if (!fullCardPage.isDisplayed()) {
                if (allert.isDisplayed())
                    allert.click();
                if (save.isDisplayed())
                    save.click();
            } else {
                break;
            }
            Thread.sleep(1000);
        }

        if (!old.equals(driver.getCurrentUrl()))
            LOGGER.info("Вызов создан! " + driver.getCurrentUrl());
        else LOGGER.info("Вызов НЕ создан!");
        return this;
    }

    @Step("кнопка редактировать")
    public CreateCallPage editCallBtn() {
        $(By.id("change")).click();
        return this;
    }

    @Step("проверяю на странице редактирования корректность данных")
    public CreateCallPage verifyCallProfile1() {
        Assert.assertEquals(phone.getAttribute("value"), parseTelephone(mData), "Номер телефона некорректный");
        Assert.assertEquals(nomerPol.getAttribute("value"), mkab.getnPol(), "Номер полиса некорректный");
        Assert.assertEquals(seriyaPol.getAttribute("value"), mkab.getsPol(), "Серия полса некорректная");
        Assert.assertEquals(fam.getAttribute("value"), mkab.getFamily(), "Фамилия некорректная");
        Assert.assertEquals(name.getAttribute("value"), mkab.getName(), "Имя некорректное");
        Assert.assertEquals(otchestvo.getAttribute("value"), mkab.getOt(), "Отчество некорректное");
//        Assert.assertEquals(birthDateTemp.getAttribute("value"), pacient.getBirthdate("dd.MM.yyyy"), "Дата рождения некорректная");
//        assertThat("Адрес некорректный", pacient.getAddress(), containsString(adress.getAttribute("value")));
//        Assert.assertEquals(dom.getAttribute("value"), pacient.getNumber(), "Номер дома некорректный");
//        Assert.assertEquals(korpus.getAttribute("value"), pacient.getBuilding(), "Номер корпуса некорректный");
//        Assert.assertEquals(stroenie.getAttribute("value"), pacient.getConstruction(), "Номер строения некорректный");
//        Assert.assertEquals(kvartira.getAttribute("value"), pacient.getAppartment(), "Номер квартиры некорректный");
//        Assert.assertEquals(getPd.getAttribute("value"), pacient.getEntrance(), "Номер подъезда некорректный");
//        Assert.assertEquals(getDfon.getAttribute("value"), pacient.getCodedomophone(), "Номер домофона некорректный");
//        Assert.assertEquals(etazh.getAttribute("value"), pacient.getFloor(), "Номер этажа некорректный");

        LOGGER.info("Проверка данных на странице редактирования выполнена!");
        return this;
    }

    @Step("нажимаю на выпадающий список участков")
    public CreateCallPage selectUchastokFromNeUdalosOpredelit() {
        SelenideElement se = $(By.xpath("//*[contains(text(),'Не удалось однозначно определить участок для адреса')]")).shouldBe(Condition.visible);
        $(By.xpath("//mat-label[contains(text(),'Участок')]/../../..//mat-select")).click();
        return this;
    }

    @Step("очищаю ФИО кто вызывает")
    public CreateCallPage deleteWhoCallFIO() {
        famCall.clear();
        nameCall.clear();
        otCall.clear();
        return this;
    }

    @Step("станция СМП")
    public CreateCallPage fillSourceSmp() {
        sourceSmp2.val("тест");
        return this;
    }

    @Step("валидация что вызов не отменился на странице редактирования")
    public CreateCallPage verifyCancellCallValidation() throws InterruptedException {
        $(By.xpath("//*[contains(text(),'Причина отмены вызова не указана, либо слишком коротка')]")).shouldBe(Condition.visible);
        Thread.sleep(2000);
        $(By.xpath("//*[contains(text(),'КТО ПАЦИЕНТ')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("отменить вызов")
    public CreateCallPage cancelOnFullCardBtn(String reason) {
        $(By.xpath("//*[contains(text(),'Редактирование вызова')]")).shouldBe(Condition.visible);
        cancelBtn.click();
        cancelField.setValue(reason);
        cancelCall.click();
        return this;
    }
}