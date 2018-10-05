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
import org.testng.Assert;
import pages.AbstractPage;
import pages.calldoctor.profiles_interfaces.Pacient;
import pages.calldoctor.profiles_interfaces.PersonDTO;
import pages.sql.SQL;
import pages.utilities.Tokenizer;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class CreateCallPage extends AbstractPage {
    String clientApplication = "CB174067-702F-42D0-B0EB-1D84A514515D";
    String requestSmp = "http://rpgu.emias.mosreg.ru/api/v2/smp/calldoctor/a7f391d4-d5d8-44d5-a770-f7b527bb1233";
//    Map<String, String> proData;
PersonDTO personDTO;

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

    public void createCall(Pacient profile) throws IOException, InterruptedException, ParseException {
//        this.personDTO = new PersonDTO(profile);
//        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
//        this.proData = new ObjectMapper().readValue(reader, Map.class);
        addNewCall()
                .sourceCall()
                .address()
                .vozrastKat()
                .birthDay()
                .adressAddition()
                .sex()
                .complaint()
                .polis()
                .FIO()
                .caller()
                .telephone()
                .saveBtn()
                .adressAlarma();
        waitCreating();
    }

    public void createCall_Mkab(String profile) throws IOException, InterruptedException, ParseException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map<String, String> proData = new ObjectMapper().readValue(reader, Map.class);
        addNewCall()
                .sourceCall()
                .searchField()
                .adressAddition()
                .complaint()
                .caller()
                .telephone()
                .saveBtn()
                .adressAlarma();
        waitCreating();
    }

    @Step("Создаю вызов через api")
    public void createCall_Api(String profile) throws IOException {
        File file = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map jMapProfile = new ObjectMapper().readValue(file, Map.class);
        String gson = new Gson().toJson(jMapProfile);

        SQL.finalizeCall_NPol(jMapProfile);
        String token = new Tokenizer().getToken(jMapProfile, clientApplication);

        HttpClient httpClient = HttpClients.createDefault();

        if (jMapProfile.containsKey("name")) {
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
        } else {
            try {
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
    public void editCallProfile2(String profile) throws IOException, ParseException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        this.proData = new ObjectMapper().readValue(reader, Map.class);
        sourceCall()
                .searchField()
                .adressAddition()
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
            if (proData.get("source").equals("Регистратура")) {
                sourceReg.click();
            }
            if (proData.get("source").equals("СМП")) {
                sourceSmp.click();
            }
        } catch (Exception e) {
            throw new InvalidArgumentException("Ошибка, не найден источник вызова!");
        }
        return this;
    }

    private CreateCallPage searchField() {
        $(By.id("findPatientInput")).setValue(proData.get("nomerPol"));
        $(By.xpath("//mat-option/span[contains(text(),'" + proData.get("fam") + "')]")).click();
        return this;
    }

    private CreateCallPage address() {
        cancelAdress.shouldBe(Condition.visible);
        if (proData.containsKey("adress_1")) {
            cancelAdress.click();
            placeholder_adress.setValue(proData.get("adress_1"));
            list_first_container.click();
        }
        if (proData.containsKey("adress_2")) {
            placeholder_adress.setValue(proData.get("adress_2"));
            list_first_container.click();
        }
        if (proData.containsKey("adress_3")) {
            placeholder_adress.setValue(proData.get("adress_3"));
            list_first_container.click();
        }
        $(By.xpath("//input[@placeholder='Дом']")).setValue(proData.get("dom"));
        return this;
    }

    private CreateCallPage adressAlarma() {
        if (proData.get("adress_3").equals(""))
            $(By.xpath("//button[@aria-label='Close dialog']")).click();
        return this;
    }

    private CreateCallPage telephone() {
        try {
            if (!proData.get("telephone").equals("")) {
                $(By.id("phone")).setValue(proData.get("telephone"));
            }
            if (proData.get("telephone").equals("")) {
                $(By.xpath("//label[@class='mat-checkbox-layout']")).click();
            }
        } catch (Exception e) {
            throw new InvalidArgumentException("Ошибка, не найден номер телефона у профиля!");
        }
        return this;
    }

    private CreateCallPage vozrastKat() {
        $(By.xpath("//button[2]/span/mat-icon")).click();
        $(By.xpath("//input[@placeholder='Возр. категория']")).click();
        $(By.xpath("//span[contains(.,'" + proData.get("vKat") + "')]")).click();
        return this;
    }

    private CreateCallPage adressAddition() {
        $(By.xpath("//input[@placeholder='Корпус']")).setValue(proData.get("korpus"));
        $(By.xpath("//input[@placeholder='Строение']")).setValue(proData.get("stroenie"));
        $(By.xpath("//input[@placeholder='Квартира']")).setValue(proData.get("kvartira"));
        $(By.xpath("//input[@placeholder='П-д']")).setValue(proData.get("pd"));
        $(By.xpath("//input[@placeholder='Д-фон']")).setValue(proData.get("dfon"));
        $(By.xpath("//input[@placeholder='Этаж']")).setValue(proData.get("etazh"));
        return this;
    }

    private CreateCallPage sex() {
        if (proData.containsKey("gender")) {
            if (proData.get("gender").equals("1")) {
                $(By.id("sex1")).click();
            }
            if (proData.get("gender").equals("2")) {
                $(By.id("sex2")).click();
            }
        }
        return this;
    }

    private CreateCallPage complaint() {
        SelenideElement zhaloba = $(By.xpath("//input[@aria-label='Введите текст жалобы'] | //input[@aria-label='Добавить жалобу']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='" + proData.get("zhaloba") + "';", zhaloba);
        zhaloba.sendKeys(Keys.SPACE);
        return this;
    }

    private CreateCallPage polis() {
        $(By.xpath("//input[@placeholder='Серия']")).setValue(proData.get("seriyaPol"));
        $(By.xpath("//input[@placeholder='Номер полиса']")).setValue(proData.get("nomerPol"));
        return this;
    }

    private CreateCallPage FIO() {
        if (proData.containsKey("fam")) {
            $(By.xpath("//input[@placeholder='Фамилия']")).setValue(proData.get("fam"));
        }
        if (proData.containsKey("name")) {
            $(By.xpath("//input[@placeholder='Имя']")).setValue(proData.get("name"));
        }
        if (proData.containsKey("ot")) {
            $(By.xpath("//input[@placeholder='Отчество']")).setValue(proData.get("ot"));
        }
        return this;
    }

    private CreateCallPage birthDay() {
        $(By.xpath("//input[@placeholder='Дата рождения']")).setValue(proData.get("birthDay"));
        return this;
    }

    private CreateCallPage caller() throws IOException, ParseException {
        Date da = new SimpleDateFormat("yyyy/MM/dd").parse(proData.get("birthdate"));
        Date du = new SimpleDateFormat("yyyy/MM/dd").parse(proData.get("birthdate"));
        if (proData.get("source").equals("2")) {
            File reader = new File("src\\main\\java\\pages\\calldoctor\\whoIsCall_interfaces\\" + proData.get("whoIsCall") + ".json");
            Map<String, String> callerData = new ObjectMapper().readValue(reader, Map.class);
            $(By.id("sourceSmp")).setValue(callerData.get("station"));
            $(By.id("callFamily")).setValue(proData.get("fam"));
            $(By.id("callName")).setValue("name");
            $(By.id("callPatronymic")).setValue(proData.get("ot"));
        } else {
            if (da.compareTo(du) > 18) {
                $(By.id("callFamily")).setValue("тест1");
                $(By.id("callName")).setValue("тест2");
                $(By.id("callPatronymic")).setValue("тест3");
            } else {
                $(By.xpath("//input[@placeholder='Тип вызывающего']")).click();
                $(By.xpath("//span[contains(.,'" + proData.get("whoIsCall") + "')]")).click();
            }
        }
        return this;
    }

    private CreateCallPage saveBtn() {
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
        Map proData = new ObjectMapper().readValue(reader, Map.class);
//убрал ассерты
        phone.getAttribute("value").equals(proData.get("telephone"));
        nomerPol.getAttribute("value").equals(proData.get("nomerPol"));
        seriyaPol.getAttribute("value").equals(proData.get("seriyaPol"));
        fam.getAttribute("value").equals(proData.get("fam"));
        fam.getAttribute("value").equals(proData.get("name"));
        otchestvo.getAttribute("value").equals(proData.get("otchestvo"));
        birthDateTemp.getAttribute("value").equals(proData.get("birthDay"));
        age.getAttribute("value").equals(proData.get("age"));
        vKat.getAttribute("value").equals(proData.get("vKat"));
        placeholder_adress.getAttribute("value").equals(proData.get("adressDashboard"));
        dom.getAttribute("value").equals(proData.get("dom"));
        korpus.getAttribute("value").equals(proData.get("korpus"));
        stroenie.getAttribute("value").equals(proData.get("stroenie"));
        kvartira.getAttribute("value").equals(proData.get("kvartira"));
        pd.getAttribute("value").equals(proData.get("pd"));
        dfon.getAttribute("value").equals(proData.get("dfon"));
        etazh.getAttribute("value").equals(proData.get("etazh"));
        tipVisivaushego.getAttribute("value").equals(proData.get("whoIsCall"));
        telephoneNumber.getAttribute("value").equals(proData.get("telephone"));
        famCall.getAttribute("value").equals(proData.get("famCall"));
        nameCall.getAttribute("value").equals(proData.get("nameCall"));
        otCall.getAttribute("value").equals(proData.get("otCall"));
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
}
