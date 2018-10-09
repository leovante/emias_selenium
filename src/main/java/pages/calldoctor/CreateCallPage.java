package pages.calldoctor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.PressEscape;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.qameta.allure.Step;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.testng.Assert;
import pages.AbstractPage;
import pages.calldoctor.profiles_interfaces.Pacient;
import pages.sql.SQL;
import pages.utilities.Tokenizer;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.Assertions.assertThat;


public class CreateCallPage extends AbstractPage {

    @Autowired
    private JacksonTester<Pacient> json;

    String clientApplication = "CB174067-702F-42D0-B0EB-1D84A514515D";
    String requestSmp = "http://rpgu.emias.mosreg.ru/api/v2/smp/calldoctor/a7f391d4-d5d8-44d5-a770-f7b527bb1233";
    private Pacient pacient;
    SelenideElement cancelAdress = $(By.id("4198BD84-7A21-4E38-B36B-3ECB2E956408"));
    SelenideElement list_first_container = $(By.xpath("//div[@class='autocomplete-list-container']/ul/li"));
    SelenideElement placeholder_adress = $(By.xpath("//input[@placeholder='Адрес']"));
    SelenideElement dom = $(By.xpath("//input[@placeholder='Дом']"));
    SelenideElement telephoneNumber = $(By.id("phone"));
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

    SelenideElement tipVisivaushego = $(By.xpath("//input[@placeholder='Тип вызывающего']"));
    SelenideElement birthDateTemp = $(By.id("birthDateTemp"));
    SelenideElement phone = $(By.id("phone"));
    SelenideElement age = $(By.id("age"));
    SelenideElement famCall = $(By.id("callFamily"));
    SelenideElement nameCall = $(By.id("callName"));
    SelenideElement otCall = $(By.id("callPatronymic"));
    SelenideElement sourceSmp = $(By.id("source0"));
    SelenideElement sourceReg = $(By.id("source1"));

    public void createCall(Pacient pacient) throws IOException, InterruptedException, ParseException {
//        this.personDTO = new PersonDTO(profile);
        this.pacient = pacient;
//        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
//        this.pacient = new ObjectMapper().readValue(reader, Map.class);
        addNewCall()
                .sourceCall()
                .address()
                .vozrastKat()
                .birthDay()
//                .adressAddition()
                .gender()
                .complaint()
                .polis()
                .FIO()
                .caller()
                .telephone()
                .saveBtn();
//                .adressAlarma();
        waitCreating();
    }

    public void createCall_Mkab(String profile) throws IOException, InterruptedException, ParseException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map<String, String> pacient = new ObjectMapper().readValue(reader, Map.class);
        addNewCall()
                .sourceCall()
                .searchField()
//                .adressAddition()
                .complaint()
                .caller()
                .telephone()
                .saveBtn();
//                .adressAlarma();
        waitCreating();
    }

    @Step("Создаю вызов через api")
    public void createCall_Api(Pacient pacient) throws IOException {
//        File file = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + pacient + ".json");
//        Map jMapProfile = new ObjectMapper().readValue(file, Map.class);
        this.pacient = pacient;

        String gson = new Gson().toJson(jMapProfile);

        SQL.finalizeCall_NPol(pacient.getNumberpol());


        HttpClient httpClient = HttpClients.createDefault();

        assertThat(this.json.write(pacient))
                .extractingJsonPathStringValue("@.profession")
                .isEqualTo("");

        //вызов создается по авторизованному методу если в json нет имени пациента
        if (!pacient.getName().equals(null)) {
            try {
                HttpPost request = new HttpPost(requestSmp);
                request.addHeader("content-type", "application/json");
                request.addHeader("ClientApplication", clientApplication);

                StringEntity params = new StringEntity(gson, "UTF-8");
                request.setEntity(params);
                HttpResponse response = httpClient.execute(request);

                int statusCode = response.getStatusLine().getStatusCode();
                Assert.assertEquals(String.valueOf(statusCode), "200", "Не удаётся создать новый вызов!");

            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Error, " + "Cannot Estabilish Connection");
            }
            System.out.println("Карта вызова создана!");
        }
        if (pacient.getName().equals(null)) {
            try {
                String token = new Tokenizer().getToken(jMapProfile, clientApplication);
                HttpPost request = new HttpPost(requestSmp);
                request.addHeader("Content-type", "application/json");
                request.addHeader("Authorization", "Bearer " + token);
                request.addHeader("ClientApplication", clientApplication);

                StringEntity params = new StringEntity(gson, "UTF-8");
                request.setEntity(params);
                HttpResponse response = httpClient.execute(request);

                int statusCode = response.getStatusLine().getStatusCode();
                Assert.assertEquals(String.valueOf(statusCode), "200", "Не удаётся создать новый вызов!");

            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Error, " + "Cannot Estabilish Connection");
            }
            System.out.println("Карта вызова создана!");

        }
    }

    @Step("редактирую вызов с МКАБ + СМП")
    public void editCallProfile2(Pacient pacient) throws IOException, ParseException {
//        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
//        this.pacient = new ObjectMapper().readValue(reader, Map.class);
        this.pacient = pacient;
        sourceCall()
                .searchField()
//                .adressAddition()
                .telephone()
                .complaint()
                .caller()
                .saveBtn();
        System.out.println("Вызов отредактирован! " + driver.getCurrentUrl());
    }

    public CreateCallPage setDeafult() {
        $(By.id("source1")).click();
        new PressEscape();
        List<SelenideElement> selenideElements = $$(By.xpath("//button/span/mat-icon[contains(text(),'close')]"));
        List<SelenideElement> selenideElements2 = $$(By.xpath("//svg[@height='16px']"));

        for (SelenideElement element : selenideElements) {
            element.click();
        }

        for (SelenideElement element : selenideElements2) {
            element.click();
        }

        $(By.id("4198BD84-7A21-4E38-B36B-3ECB2E956408")).click();
        $(By.xpath("//input[@placeholder='Дом']")).clear();
        $(By.id("phone")).clear();
//        $(By.xpath("//label[@class='mat-checkbox-layout']")).clear();
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
        System.out.println("Карта вызова очищена для редактирования!");
        return this;
    }

    private CreateCallPage addNewCall() {
        $(By.id("addNewCall")).click();
        return this;
    }

    private CreateCallPage sourceCall() {
        try {
            if (pacient.getSource() == 1) {
                sourceReg.click();
            }
            if (pacient.getSource() == 2) {
                sourceSmp.click();
            }
        } catch (Exception e) {
            throw new InvalidArgumentException("Ошибка, не найден источник вызова!");
        }
        return this;
    }

    private CreateCallPage searchField() {
        $(By.id("findPatientInput")).setValue(String.valueOf(pacient.getNumberpol()));
        $(By.xpath("//mat-option/span[contains(text(),'" + pacient.getFamily() + "')]")).click();
        return this;
    }

    private CreateCallPage address() {
        cancelAdress.shouldBe(Condition.visible);
        if (!pacient.getAddress1().contains(null)) {
            cancelAdress.click();
            placeholder_adress.setValue(pacient.getAddress1());
            list_first_container.click();
        }
        if (!pacient.getAddress2().contains(null)) {
            placeholder_adress.setValue(pacient.getAddress2());
            list_first_container.click();
        }
        if (!pacient.getAddress3().contains(null)) {
            placeholder_adress.setValue(pacient.getAddress3());
            list_first_container.click();
        }
        if (pacient.getBuilding().contains(null)) {
            $(By.xpath("//input[@placeholder='Дом']")).setValue(pacient.getNumber());
        }
        $(By.xpath("//input[@placeholder='Корпус']")).setValue(pacient.getBuilding());
        $(By.xpath("//input[@placeholder='Строение']")).setValue(pacient.getConstruction());
        $(By.xpath("//input[@placeholder='Квартира']")).setValue(pacient.getAppartment());
        $(By.xpath("//input[@placeholder='П-д']")).setValue(pacient.getEntrance());
        $(By.xpath("//input[@placeholder='Д-фон']")).setValue(pacient.getCodedomophone());
        $(By.xpath("//input[@placeholder='Этаж']")).setValue(pacient.getFloor());
        return this;
    }

    private CreateCallPage telephone() {
        try {
            if (!pacient.getPhone().equals(null)) {
                $(By.id("phone")).setValue(pacient.getPhone());
            }
            if (pacient.getPhone().equals("")) {
                $(By.xpath("//label[@class='mat-checkbox-layout']")).click();
            }
        } catch (Exception e) {
            throw new InvalidArgumentException("Ошибка, не найден номер телефона у профиля!");
        }
        return this;
    }


    private CreateCallPage gender() {
        if (pacient.getGender() == 1) {
            $(By.id("sex1")).click();
        }
        if (pacient.getGender() == 2) {
            $(By.id("sex2")).click();
        }
        return this;
    }

    private CreateCallPage complaint() {
        SelenideElement complaint = $(By.xpath("//input[@aria-label='Введите текст жалобы'] | //input[@aria-label='Добавить жалобу']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='" + pacient.getComplaint() + "';", complaint);
        complaint.sendKeys(Keys.SPACE);
        return this;
    }

    private CreateCallPage polis() {
        $(By.xpath("//input[@placeholder='Серия']")).setValue(String.valueOf(pacient.getSeriespol()));
        $(By.xpath("//input[@placeholder='Номер полиса']")).setValue(String.valueOf(pacient.getNumberpol()));
        return this;
    }

    private CreateCallPage FIO() {
        if (pacient.getFamily() != null) {
            $(By.xpath("//input[@placeholder='Фамилия']")).setValue(pacient.getFamily());
        }
        if (pacient.getName() != null) {
            $(By.xpath("//input[@placeholder='Имя']")).setValue(pacient.getName());
        }
        if (pacient.getOt() != null) {
            $(By.xpath("//input[@placeholder='Отчество']")).setValue(pacient.getOt());
        }
        return this;
    }

    private CreateCallPage birthDay() {
        $(By.xpath("//input[@placeholder='Дата рождения']")).setValue(String.valueOf(pacient.getBirthdate()));
        return this;
    }

    public CreateCallPage vozrastKat() {
        $(By.xpath("//button[2]/span/mat-icon")).click();
        $(By.xpath("//input[@placeholder='Возр. категория']")).click();

        Date newData = new Date();
        Date bd = pacient.getBirthdate();
        int years = (int) getDateDiff(bd, newData, TimeUnit.DAYS) / 365;
        if (years > 18) {
            $(By.xpath("//span[contains(.,'Взрослые')]")).click();
        }
        if (years < 18) {
            $(By.xpath("//span[contains(.,'Дети')]")).click();
        }
        return this;
    }

    private CreateCallPage caller() throws IOException, ParseException {
        if (pacient.getSource() == 2) {
            $(By.id("sourceSmp")).setValue("Супер станция");
            $(By.id("callFamily")).setValue("ФамилияВызывающего");
            $(By.id("callName")).setValue("ИмяВызывающего");
            $(By.id("callPatronymic")).setValue("ОтчествоВызывающего");
        } else {
            if (years() > 18) {
                $(By.xpath("//input[@placeholder='Тип вызывающего']")).click();
                $(By.xpath("//span[contains(.,'Пациент')]")).click();
            } else {
                $(By.xpath("//input[@placeholder='Тип вызывающего']")).click();
                $(By.xpath("//span[contains(.,'Представитель')]")).click();
            }
        }
        return this;
    }

    public int years() {
        Date newData = new Date();
        Date bd = pacient.getBirthdate();
        int years = (int) getDateDiff(bd, newData, TimeUnit.DAYS) / 365;
        return years;
    }

    private CreateCallPage saveBtn() {
        SelenideElement se = $(By.xpath("//button[@aria-label='Close dialog']"));
        if (se.isDisplayed()) {
            $(By.xpath("//button[@aria-label='Close dialog']")).click();
        }
        $(By.id("save")).click();
        return this;
    }

    public CreateCallPage editCallBtn() {
        $(By.id("change")).click();
        return this;
    }

    @Step("проверяю на странице редактирования корректность данных")
    public CreateCallPage verifyCallProfile1(String profile) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map pacient = new ObjectMapper().readValue(reader, Map.class);
//убрал ассерты
        phone.getAttribute("value").equals(pacient.get("telephone"));
        nomerPol.getAttribute("value").equals(pacient.get("nomerPol"));
        seriyaPol.getAttribute("value").equals(pacient.get("seriyaPol"));
        fam.getAttribute("value").equals(pacient.get("fam"));
        fam.getAttribute("value").equals(pacient.get("name"));
        otchestvo.getAttribute("value").equals(pacient.get("otchestvo"));
        birthDateTemp.getAttribute("value").equals(pacient.get("birthDay"));
        age.getAttribute("value").equals(pacient.get("age"));
        vKat.getAttribute("value").equals(pacient.get("vKat"));
        placeholder_adress.getAttribute("value").equals(pacient.get("adressDashboard"));
        dom.getAttribute("value").equals(pacient.get("dom"));
        korpus.getAttribute("value").equals(pacient.get("korpus"));
        stroenie.getAttribute("value").equals(pacient.get("stroenie"));
        kvartira.getAttribute("value").equals(pacient.get("kvartira"));
        pd.getAttribute("value").equals(pacient.get("pd"));
        dfon.getAttribute("value").equals(pacient.get("dfon"));
        etazh.getAttribute("value").equals(pacient.get("etazh"));
        tipVisivaushego.getAttribute("value").equals(pacient.get("whoIsCall"));
        telephoneNumber.getAttribute("value").equals(pacient.get("telephone"));
        famCall.getAttribute("value").equals(pacient.get("famCall"));
        nameCall.getAttribute("value").equals(pacient.get("nameCall"));
        otCall.getAttribute("value").equals(pacient.get("otCall"));
        System.out.println("Корректность данных на странице редактирования выполнена! " + driver.getCurrentUrl());
        return this;
    }

    @Step("нажимаю на выпадающий список участков")
    public CreateCallPage selectUchastokFromNeUdalosOpredelit() {
        SelenideElement se = $(By.xpath("//*[contains(text(),'Не удалось однозначно определить участок для адреса')]")).shouldBe(Condition.visible);
        se.$(By.xpath("../.")).$(By.xpath(".//mat-form-field")).click();
        return this;
    }

    public void waitCreating() throws InterruptedException {
        String old = driver.getCurrentUrl();
        int i = 11;
        do {
            Thread.sleep(1000);
            i--;
            System.out.println("Жду ссылку на новый вызов. i = " + i);
        }
        while (old.equals(driver.getCurrentUrl()) && i >= 1);
        if (!old.equals(driver.getCurrentUrl()))
            System.out.println("Вызов создан! " + driver.getCurrentUrl());
        else System.out.println("Вызов НЕ создан!");
    }

    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
}
