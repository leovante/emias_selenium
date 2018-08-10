package pages.calldoctor;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.PressEscape;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import pages.AbstractPage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertTrue;


public class CreateCallPage extends AbstractPage {
    SelenideElement cancelAdress = $(By.id("4198BD84-7A21-4E38-B36B-3ECB2E956408"));
    SelenideElement cancelBirthDate = $(By.xpath("//button[@aria-label='Clear']/span/mat-icon"));
    SelenideElement list_first_container = $(By.xpath("//div[@class='autocomplete-list-container']/ul/li"));
    SelenideElement placeholder_adress = $(By.xpath("//input[@placeholder='Адрес']"));
    SelenideElement dom = $(By.xpath("//input[@placeholder='Дом']"));
    SelenideElement telephoneNumber = $(By.id("phone"));
    SelenideElement chkBoxTelephone = $(By.xpath("//label[@class='mat-checkbox-layout']/div"));
    SelenideElement hz = $(By.xpath("//button[2]/span/mat-icon"));
    SelenideElement vKat = $(By.xpath("//input[@placeholder='Возр. категория']"));
    SelenideElement hz2 = $(By.xpath("//span[contains(.,'Взрослый')]"));
    SelenideElement korpus = $(By.xpath("//input[@placeholder='Корпус']"));
    SelenideElement stroenie = $(By.xpath("//input[@placeholder='Строение']"));
    SelenideElement kvartira = $(By.xpath("//input[@placeholder='Квартира']"));
    SelenideElement pd = $(By.xpath("//input[@placeholder='П-д']"));

    SelenideElement dfon = $(By.xpath("//input[@placeholder='Д-фон']"));
    SelenideElement etazh = $(By.xpath("//input[@placeholder='Этаж']"));
    SelenideElement zhaloba = $(By.xpath("//input[@aria-label='Добавить жалобу']"));
    SelenideElement seriyaPol = $(By.xpath("//input[@placeholder='Серия']"));
    SelenideElement nomerPol = $(By.xpath("//input[@placeholder='Номер полиса']"));
    SelenideElement fam = $(By.xpath("//input[@placeholder='Фамилия']"));
    SelenideElement name = $(By.xpath("//input[@placeholder='Имя']"));
    SelenideElement otchestvo = $(By.xpath("//input[@placeholder='Отчество']"));

    SelenideElement tipVisivaushego = $(By.xpath("//input[@placeholder='Тип вызывающего']"));
    SelenideElement predstav = $(By.xpath("//span[contains(.,'Представитель')]"));
    SelenideElement saveBtns = $(By.xpath("//span[contains(text(),'Сохранить')]"));
    SelenideElement callFamily = $(By.id("callFamily"));
    SelenideElement callName = $(By.id("callName"));
    SelenideElement callPatronymic = $(By.id("callPatronymic"));
    SelenideElement birthDateTemp = $(By.id("birthDateTemp"));
    SelenideElement source0 = $(By.id("source0"));
    SelenideElement sourceSmp = $(By.id("sourceSmp"));
    SelenideElement phone = $(By.id("phone"));
    SelenideElement age = $(By.id("age"));
    SelenideElement famCall = $(By.id("callFamily"));
    SelenideElement nameCall = $(By.id("callName"));
    SelenideElement otCall = $(By.id("callPatronymic"));
    SelenideElement naidena_mkab = $(By.xpath("//div[contains(.,'Найдена МКАБ пациента Петров')]"));
    SelenideElement redactirovanieVizova = $(By.xpath("//div[contains(text(),'Редактирование вызова')]"));

    public CreateCallPage() {
    }

    @Step("создаю пустой вызов")
    public void createCallProfile0(String profile) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map<String, String> proData = new ObjectMapper().readValue(reader, Map.class);
        addNewCall()
                .adress(proData)
                .telephoneChk()
                .complaint(proData)
                .vozrastKat(proData)
                .saveBtn()
                .adressAlarma();
    }

    @Step("создаю вызов -МКАБ +Регистр")
    public void createCallProfile1(String profile, String nameGen) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map<String, String> proData = new ObjectMapper().readValue(reader, Map.class);
        addNewCall()
                .adress(proData)
                .telephone(proData)
                .vozrastKat(proData)
                .adressAddition(proData)
                .sex(proData)
                .complaint(proData)
                .polis(proData)
                .FIO(nameGen, proData)
                .birthDay(proData)
                .caller(proData)
                .saveBtn();
    }

    @Step("создаю вызов с МКАБ + СМП")
    public void createCallProfile2(String nameGen) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\Profile2.json");
        Map<String, String> proData = new ObjectMapper().readValue(reader, Map.class);
        addNewCall()
                .sourceSMP(proData)
                .searchField(proData)
                .adressAddition(proData)
                .telephone(proData)
                .complaint(proData)
                .caller(nameGen, proData)
                .saveBtn();
    }

    @Step("создаю вызов с МКАБ + СМП")
    public void editCallProfile2(String profile, String nameGen) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map<String, String> proData = new ObjectMapper().readValue(reader, Map.class);
        sourceSMP(proData)
                .searchField(proData)
                .adressAddition(proData)
                .telephone(proData)
                .complaint(proData)
                .caller(nameGen, proData)
                .saveBtn();
    }

    @Step("создаю вызов от СМП по api Ребёнок без КЛАДР по МКАБ")
    public void createCallProfile3(String nameGen) {
        HttpClient httpClient = HttpClients.createDefault();
        JSONObject json = new JSONObject();
        json.put("name", nameGen);
        json.put("family", "Тестовый");
        json.put("ot", "СМП");
        json.put("birthdate", "2002-01-10");
        json.put("seriespol", "");
        json.put("numberpol", "5098799789000154");//реальный мкаб
        json.put("gender", "2");
        json.put("address", "это неформализованный адрес");
        json.put("complaint", "тестовый вызов");
        json.put("diagnosis", "j20");
        json.put("type", "4");
        json.put("codedomophone", "12№#!@-тут символы");
        json.put("phone", "+79606223551");
        json.put("source", "2");
        json.put("sourceName", "СМП");
        json.put("sourceCode", "2");
        json.put("entrance", "12");
        json.put("floor", "5");

        try {
            HttpPost request = new HttpPost("http://12.8.1.126:2224/api/v2/smp/calldoctor/a7f391d4-d5d8-44d5-a770-f7b527bb1233");
            request.addHeader("content-type", "application/json");
            request.addHeader("Authorization", "fb6e439f-c34f-4ee0-b2ba-38c1be5116a3");

            StringEntity params = new StringEntity(json.toString(), "UTF-8");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            if (response != null) {
                InputStream in = response.getEntity().getContent();
                System.out.println(in);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error, " + "Cannot Estabilish Connection");
        } finally {
//            driver.close();
        }
    }

    @Step("создаю вызов от СМП по api Взрослый по КЛАДР без МКАБ")
    public void createCallProfile6(String nameGen) {
        HttpClient httpClient = HttpClients.createDefault();

        JSONObject kladraddress = new JSONObject();
        kladraddress.put("addressString", "Белгородская обл., г. Белгород, ул. Есенина, д.11а, стр.2, корп.3, кв.4");
        kladraddress.put("addressStringMin", "Белгородская обл., г. Белгород, ул. Есенина");
        kladraddress.put("appartment", "4");
        kladraddress.put("building", "3");
        kladraddress.put("construction", "2");
        kladraddress.put("number", "11а");
        kladraddress.put("code", "31000001000007700");

        JSONObject json = new JSONObject();
        json.put("name", nameGen);
        json.put("family", "Тестов");
        json.put("ot", "Тестович");
        json.put("birthdate", "2000-01-01");
        json.put("seriespol", "404");
        json.put("numberpol", "501");
        json.put("gender", "1");
        json.put("complaint", "тестовый вызов по апи от СМП");
        json.put("diagnosis", "j20");
        json.put("type", "4");
        json.put("codedomophone", "12№#!@-тут символы");
        json.put("phone", "+79606223551");
        json.put("source", "2");
        json.put("sourceName", "СМП");
        json.put("sourceCode", "2");
        json.put("entrance", "12");
        json.put("floor", "5");
        json.put("kladraddress", kladraddress);

        try {
            HttpPost request = new HttpPost("http://12.8.1.126:2224/api/v2/smp/calldoctor/a7f391d4-d5d8-44d5-a770-f7b527bb1233");
            request.addHeader("content-type", "application/json");
            request.addHeader("Authorization", "fb6e439f-c34f-4ee0-b2ba-38c1be5116a3");

            StringEntity params = new StringEntity(json.toString(), "UTF-8");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            if (response != null) {
                InputStream in = response.getEntity().getContent();
                System.out.println(in);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error, " + "Cannot Estabilish Connection");
        } finally {
//            driver.close();
        }
    }

    @Step("создаю пустой вызов ребенка М")
    public void createCallProfile7() throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\Profile7.json");
        Map<String, String> proData = new ObjectMapper().readValue(reader, Map.class);
        addNewCall()
                .adress(proData)
                .telephoneChk()
                .complaint(proData)
                .vozrastKat(proData)
                .sex(proData)
                .saveBtn()
                .adressAlarma();
    }

    @Step("создаю пустой вызов ребенка Ж")
    public void createCallProfile8() throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\Profile8.json");
        Map<String, String> proData = new ObjectMapper().readValue(reader, Map.class);
        addNewCall()
                .adress(proData)
                .telephoneChk()
                .complaint(proData)
                .vozrastKat(proData)
                .sex(proData)
                .saveBtn()
                .adressAlarma();
    }

    @Step("создаю пустой вызов ребенка Без Пола")
    public void createCallProfile9() throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\Profile8.json");
        Map<String, String> proData = new ObjectMapper().readValue(reader, Map.class);
        addNewCall()
                .adress(proData)
                .telephoneChk()
                .complaint(proData)
                .vozrastKat(proData)
                .saveBtn()
                .adressAlarma();
    }

    @Step("создаю пустой вызов взрослого М")
    public void createCallProfile10() throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\Profile10.json");
        Map<String, String> proData = new ObjectMapper().readValue(reader, Map.class);
        addNewCall()
                .adress(proData)
                .telephoneChk()
                .complaint(proData)
                .vozrastKat(proData)
                .sex(proData)
                .saveBtn()
                .adressAlarma();
    }

    @Step("создаю пустой вызов взрослого Ж")
    public void createCallProfile11(String profile) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map<String, String> proData = new ObjectMapper().readValue(reader, Map.class);
        addNewCall()
                .adress(proData)
                .telephoneChk()
                .complaint(proData)
                .vozrastKat(proData)
                .sex(proData)
                .saveBtn()
                .adressAlarma();
    }

    @Step("создаю пустой вызов взрослого Без Пола")
    public void createCallProfile12(String profile) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map<String, String> proData = new ObjectMapper().readValue(reader, Map.class);
        addNewCall()
                .adress(proData)
                .telephoneChk()
                .complaint(proData)
                .vozrastKat(proData)
                .saveBtn()
                .adressAlarma();
    }

    @Step("создаю пустой вызов Без Возр Кат, Без Пола, СМП")
    public void createCallProfile13(String profile, String nameGen) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map<String, String> proData = new ObjectMapper().readValue(reader, Map.class);
        addNewCall()
                .adress(proData)
                .sourceSMP(proData)
                .caller(nameGen, proData)
                .telephone(proData)
                .complaint(proData)
                .saveBtn()
                .adressAlarma();
    }

    @Step("создаю вызов от СМП по api Ребёнок без КЛАДР по МКАБ")
    public void createCallProfileDetkina() {
//        String token = new Tokenizer();

        HttpClient httpClient = HttpClients.createDefault();
        JSONObject json = new JSONObject();
        json.put("name", "Лариса");
        json.put("family", "Деткина");
        json.put("ot", "Львовна");
        json.put("birthdate", "2018-01-01");
        json.put("seriespol", "1111");
        json.put("numberpol", "11111111");//реальный мкаб
        json.put("gender", "1");
        json.put("address", "Московская обл., Щелковский р-н, г Щелково, ул Заводская, дом 7, кв. 3");
        json.put("complaint", "автотест проверка блока участкового врача при формализованном адресе");
        json.put("diagnosis", "j20");
        json.put("type", "4");
        json.put("codedomophone", "12№#!@-тут символы");
        json.put("phone", "+71111111111");
        json.put("source", "2");
        json.put("sourceName", "СМП");
        json.put("sourceCode", "2");
        json.put("entrance", "");
        json.put("floor", "");

        try {
            HttpPost request = new HttpPost("http://12.8.1.126:2224/api/v2/smp/calldoctor/a7f391d4-d5d8-44d5-a770-f7b527bb1233");
            request.addHeader("content-type", "application/json");
            request.addHeader("Authorization", "fb6e439f-c34f-4ee0-b2ba-38c1be5116a3");

            StringEntity params = new StringEntity(json.toString(), "UTF-8");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            if (response != null) {
                InputStream in = response.getEntity().getContent();
                System.out.println(in);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error, " + "Cannot Estabilish Connection");
        } finally {
//            driver.close();
        }
    }


    // TODO: 7/19/2018 доделать
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
        return this;
    }

    private CreateCallPage addNewCall() {
        $(By.id("addNewCall")).click();
        return this;
    }

    private CreateCallPage sourceSMP(Map<String, String> proData) {
        $(By.id("source0")).click();
        $(By.id("phone")).setValue(proData.get("telephone"));
        return this;
    }

    private CreateCallPage searchField(Map<String, String> proData) {
        $(By.id("findPatientInput")).setValue(proData.get("nomerPol"));
        $(By.xpath("//mat-option/span[contains(text(),'" + proData.get("fam") + "')]")).click();
        return this;
    }

    private CreateCallPage adress(Map<String, String> proData) {
        $(By.id("4198BD84-7A21-4E38-B36B-3ECB2E956408"));
        if (!proData.get("adress_1").isEmpty()) {
            $(By.id("4198BD84-7A21-4E38-B36B-3ECB2E956408")).click();
            $(By.xpath("//input[@placeholder='Адрес']")).setValue(proData.get("adress_1"));
            $(By.xpath("//div[@class='autocomplete-list-container']/ul/li")).click();
        }
        if (!proData.get("adress_2").isEmpty()) {
            $(By.xpath("//input[@placeholder='Адрес']")).setValue(proData.get("adress_2"));
            $(By.xpath("//div[@class='autocomplete-list-container']/ul/li")).click();
        }
        if (!proData.get("adress_3").isEmpty()) {
            $(By.xpath("//input[@placeholder='Адрес']")).setValue(proData.get("adress_3"));
            $(By.xpath("//div[@class='autocomplete-list-container']/ul/li")).click();
        }
        $(By.xpath("//input[@placeholder='Дом']")).setValue(proData.get("dom"));
        return this;
    }

    private CreateCallPage adressAlarma() {
        $(By.xpath("//button[@aria-label='Close dialog']")).click();
        return this;
    }

    private CreateCallPage telephone(Map<String, String> proData) {
        $(By.id("phone")).setValue(proData.get("telephone"));
        return this;
    }

    private CreateCallPage telephoneChk() {
        $(By.xpath("//label[@class='mat-checkbox-layout']")).click();
        return this;
    }

    private CreateCallPage vozrastKat(Map proData) {
        $(By.xpath("//button[2]/span/mat-icon")).click();
        $(By.xpath("//input[@placeholder='Возр. категория']")).click();
        $(By.xpath("//span[contains(.,'" + proData.get("vKat") + "')]")).click();
        return this;
    }

    private CreateCallPage adressAddition(Map<String, String> proData) {
        $(By.xpath("//input[@placeholder='Корпус']")).setValue(proData.get("korpus"));
        $(By.xpath("//input[@placeholder='Строение']")).setValue(proData.get("stroenie"));
        $(By.xpath("//input[@placeholder='Квартира']")).setValue(proData.get("kvartira"));
        $(By.xpath("//input[@placeholder='П-д']")).setValue(proData.get("pd"));
        $(By.xpath("//input[@placeholder='Д-фон']")).setValue(proData.get("dfon"));
        $(By.xpath("//input[@placeholder='Этаж']")).setValue(proData.get("etazh"));
        return this;
    }

    private CreateCallPage sex(Map<String, String> proData) {
        $(By.id(proData.get("sex"))).click();
        return this;
    }

    private CreateCallPage complaint(Map proData) {
        SelenideElement zhaloba = $(By.xpath("//input[@aria-label='Введите текст жалобы'] | //input[@aria-label='Добавить жалобу']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='" + proData.get("zhaloba") + "';", zhaloba);
        zhaloba.sendKeys(Keys.SPACE);
        return this;
    }

    private CreateCallPage polis(Map<String, String> proData) {
        $(By.xpath("//input[@placeholder='Серия']")).setValue(proData.get("seriyaPol"));
        $(By.xpath("//input[@placeholder='Номер полиса']")).setValue(proData.get("nomerPol"));
        return this;
    }

    private CreateCallPage FIO(String nameGen, Map<String, String> proData) {
        $(By.xpath("//input[@placeholder='Фамилия']")).setValue(proData.get("fam"));
        $(By.xpath("//input[@placeholder='Имя']")).setValue(nameGen);
        $(By.xpath("//input[@placeholder='Отчество']")).setValue(proData.get("otchestvo"));
        return this;
    }

    private CreateCallPage FIO(Map<String, String> proData) {
        $(By.xpath("//input[@placeholder='Фамилия']")).setValue(proData.get("fam"));
        $(By.xpath("//input[@placeholder='Имя']")).setValue(proData.get("name"));
        $(By.xpath("//input[@placeholder='Отчество']")).setValue(proData.get("otchestvo"));
        return this;
    }

    private CreateCallPage birthDay(Map<String, String> proData) {
        $(By.xpath("//input[@placeholder='Дата рождения']")).setValue(proData.get("birthDay"));
        return this;
    }

    private CreateCallPage caller(Map<String, String> proData) {
        if (proData.get("whoIsCall").equals("Пациент")) {
            $(By.xpath("//input[@placeholder='Тип вызывающего']")).click();
            $(By.xpath("//span[contains(.,'" + proData.get("whoIsCall") + "')]")).click();
        }
        if (proData.get("whoIsCall").equals("Представитель")) {
            $(By.id("sourceSmp")).setValue(proData.get("station"));
            $(By.id("callFamily")).setValue(proData.get("callFamily"));
            $(By.id("callPatronymic")).setValue(proData.get("callPatronymic"));
        }
        return this;
    }

    private CreateCallPage caller(String nameGen, Map<String, String> proData) {
        if (proData.get("whoIsCall").equals("Пациент")) {
            $(By.xpath("//input[@placeholder='Тип вызывающего']")).click();
            $(By.xpath("//span[contains(.,'" + proData.get("whoIsCall") + "')]")).click();
        }
        if (proData.get("whoIsCall").equals("Представитель")) {
            $(By.id("sourceSmp")).setValue(proData.get("sourceSMP"));
            $(By.id("callFamily")).setValue(proData.get("callFamily"));
            $(By.id("callName")).setValue(nameGen);
            $(By.id("callPatronymic")).setValue(proData.get("callPatronymic"));
        }
        if (proData.get("whoIsCall").equals("СМП")) {
            $(By.id("sourceSmp")).setValue(proData.get("sourceSMP"));
            $(By.id("callFamily")).setValue(proData.get("callFamily"));
            $(By.id("callName")).setValue(nameGen);
            $(By.id("callPatronymic")).setValue(proData.get("callPatronymic"));
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

//    @Step("редактирую вызов без привязывания МКАБ")
//    public CreateCallPage editCallProfile5(String nameGen) throws IOException {
//
//
//        /*адрес*/
//
//        cancelAdress.click();
//        placeholder_adress.click();
//
//        placeholder_adress.sendKeys(adressPro5_1);
//        click(list_first_container);
//
//        placeholder_adress.sendKeys(adressPro5_2);
//        click(list_first_container);
//
//        placeholder_adress.sendKeys(adressPro5_3);
//        click(list_first_container);
//
//
//        /*обязательные поля*/
//
//        sendKeysJS(dom, domPro5);
//        click(cancelBirthDate);
//        sendKeysJS(birthDateTemp, birthDayPro5);
//
//        telephoneNumber.clear();
//        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
//        jse1.executeScript("arguments[0].value='" + telephonePro5 + "';", telephoneNumber);
//        telephoneNumber.click();
//        action.sendKeys(Keys.SPACE).perform();
//
//
//        /*необязательные поля*/
//
//        click(source0);
//        sendKeysJS(korpus, korpusPro5);
//        sendKeysJS(stroenie, stroeniePro5);
//        sendKeysJS(kvartira, kvartiraPro5);
//        sendKeysJS(pd, pdPro5);
//        sendKeysJS(dfon, dfonPro5);
//        sendKeysJS(etazh, etazhPro5);
//        sendKeysJS(sourceSmp, stationSMPPro5);
//
//
//        /*жалоба*/
//
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("arguments[0].value='" + zhalobaPro5 + "';", zhaloba);
//        zhaloba.sendKeys(Keys.SPACE);
//        action.sendKeys(Keys.ENTER).perform();
//
//
//        /*кто пациент*/
//
//        sendKeysJS(seriyaPol, seriyaPolPro5);
//        sendKeysJS(nomerPol, nomerPolPro5);
//        click(fam);
//        sendKeysJS(fam, famPro5);
//        sendKeysJS(name, nameGen);
//        sendKeysJS(otchestvo, otchestvoPro5);
//
//
//        /*кто вызывает*/
//
////        tipVisivaushego.click();
////        pacient.click();
//        sendKeysJS(sourceSmp, stationSMPPro5);
//        sendKeysJS(callFamily, famCallPro5);
//        sendKeysJS(callName, nameCallPro5);
//        sendKeysJS(callPatronymic, otCallPro5);
//
//        click(saveBtns);
//        return this;
//    }

//    @Step("редактирую вызов c МКАБ")
//    public void editCallToMkab() {
//        Actions action = new Actions(driver);
//
//        /*адрес*/
//
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*")));
//        click(cancelAdress);
//        click(placeholder_adress);
//
//        placeholder_adress.sendKeys("Московская");
//        click(list_first_container);
//
//        placeholder_adress.sendKeys("Коломна");
//        click(list_first_container);
//
//        placeholder_adress.sendKeys("Первомайская");
//        click(list_first_container);
//
//
//        /*обязательные поля*/
//
//        dom.clear();
//        click(dom);
//        dom.sendKeys("1");
//
////        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
////        jse1.executeScript("arguments[0].value='+7 (951) 158-27-14';", telephoneNumber);
////        click(telephoneNumber);
////        action.sendKeysJS(Keys.ENTER);
//        click(chkBoxTelephone);
//        click(hz);
//        click(vKat);
//        hz2.click();
//
//
//        /*необязательные поля*/
//
//        korpus.clear();
//        korpus.sendKeys("2");
//        stroenie.clear();
//        stroenie.sendKeys("3");
//        kvartira.clear();
//        kvartira.sendKeys("4");
//        pd.clear();
//        pd.sendKeys("5");
//        dfon.clear();
//        dfon.sendKeys("6");
//        etazh.clear();
//        etazh.sendKeys("7");
//
//
//        /*жалоба*/
//
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("arguments[0].value='автотест';", zhaloba);
//        zhaloba.sendKeys(Keys.SPACE);
//        action.sendKeys(Keys.ENTER).perform();
//
//
//        /*кто пациент*/
//
//        seriyaPol.clear();
//        seriyaPol.sendKeys("321");
//        nomerPol.clear();
//        nomerPol.sendKeys("54321");
////        click(fam);
////        fam.sendKeysJS("Автотемников");
////        name.sendKeysJS("Автодмитрий");
////        otchestvo.sendKeysJS("Автоолегович");
//
//
//        /*кто вызывает*/
//
//        tipVisivaushego.click();
//        predstav.click();
////        click(callFamily);
//        callFamily.clear();
//        callFamily.sendKeys("Автотемниковизменил");
//        callName.clear();
//        callName.sendKeys("Автодмитрийизменил");
//        callPatronymic.clear();
//        callPatronymic.sendKeys("Автоолеговичизменил");
//
//        assertTrue(naidena_mkab.isEnabled());
//    }

    @Step("проверяю на странице редактирования корректность данных")
    public CreateCallPage verifyCallProfile1(String profile, String nameGen) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);

        assertTrue(
                phone.getAttribute("value").equals(proData.get("telephone")));
        assertTrue(
                nomerPol.getAttribute("value").equals(proData.get("nomerPol")));
        assertTrue(
                seriyaPol.getAttribute("value").equals(proData.get("seriyaPol")));
        assertTrue(
                fam.getAttribute("value").equals(proData.get("fam")));
        assertTrue(
                name.getAttribute("value").equals(nameGen));
        assertTrue(
                otchestvo.getAttribute("value").equals(proData.get("otchestvo")));
        assertTrue(
                birthDateTemp.getAttribute("value").equals(proData.get("birthDay")));
        assertTrue(
                age.getAttribute("value").equals(proData.get("age")));
        assertTrue(
                vKat.getAttribute("value").equals(proData.get("vKat")));
        assertTrue(
                placeholder_adress.getAttribute("value").equals(proData.get("adressDashboard")));
        assertTrue(
                dom.getAttribute("value").equals(proData.get("dom")));
        assertTrue(
                korpus.getAttribute("value").equals(proData.get("korpus")));
        assertTrue(
                stroenie.getAttribute("value").equals(proData.get("stroenie")));
        assertTrue(
                kvartira.getAttribute("value").equals(proData.get("kvartira")));
        assertTrue(
                pd.getAttribute("value").equals(proData.get("pd")));
        assertTrue(
                dfon.getAttribute("value").equals(proData.get("dfon")));
        assertTrue(
                etazh.getAttribute("value").equals(proData.get("etazh")));
        assertTrue(
                tipVisivaushego.getAttribute("value").equals(proData.get("whoIsCall")));
        assertTrue(
                telephoneNumber.getAttribute("value").equals(proData.get("telephone")));
        assertTrue(
                famCall.getAttribute("value").equals(proData.get("famCall")));
        assertTrue(
                nameCall.getAttribute("value").equals(proData.get("nameCall")));
        assertTrue(
                otCall.getAttribute("value").equals(proData.get("otCall")));
        return this;
    }
}