package pages.calldoctor;

import com.codeborne.selenide.SelenideElement;
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
import pages.AbstractPage;
import pages.calldoctor.profiles_interfaces.Profile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;


public class CreateCallPage extends AbstractPage implements Profile {

    public CreateCallPage() {
    }

    @Step("создаю пустой вызов")
    public void createCallProfile0() throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\Profile0.json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);
        addNewCall()
                .adress(proData)
                .telephoneChk()
                .complaint(proData)
                .vozrastKat()
                .complaint(proData)
                .saveBtn()
                .adressAlarma();
    }

    @Step("создаю вызов -МКАБ +Регистр")
    public void createCallProfile1(String nameGen) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\Profile1.json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);
        addNewCall()
                .adress(proData)
                .telephone(proData)
                .vozrastKat()
                .adressAddition(proData)
                .sexM()
                .complaint(proData)
                .polis(proData)
                .FIO(nameGen, proData)
                .birthDay(proData)
                .callerPatient()
                .saveBtn();
    }

    @Step("создаю вызов с МКАБ + СМП")
    public void createCallProfile2(String nameGen) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\Profile2.json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);
        addNewCall()
                .sourceSMP()
                .searchField()
                .adressAddition(proData)
                .polis(proData)
                .telephone(proData)
                .complaint(proData)
                .callerPredstavit(nameGen, proData)
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
        json.put("address", "это не формализованный адрес");
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
        kladraddress.put("code", "31000001000007700");
        kladraddress.put("construction", "2");
        kladraddress.put("number", "11а");

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

    // TODO: 7/19/2018 доделать
    private CreateCallPage setDeafult(){
        $(By.id("source1")).click();
        //кнопка очистки привязки полиса
        //найти все крестики на странице, засунуть в массив и нажать на все
        $(By.id("4198BD84-7A21-4E38-B36B-3ECB2E956408")).click();
        $(By.xpath("//input[@placeholder='Дом']")).clear();
        $(By.id("phone")).clear();
        $(By.xpath("//label[@class='mat-checkbox-layout']")).clear();
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

    private CreateCallPage sourceSMP() {
        $(By.id("source0")).click();
        return this;
    }

    private CreateCallPage searchField() {
        $(By.id("findPatientInput")).setValue(nomerPol);
        $(By.id("findPatientInput")).pressEnter();
        return this;
    }

    private CreateCallPage adress(Map proData) {
        $(By.id("4198BD84-7A21-4E38-B36B-3ECB2E956408")).click();
        //тут нужно сделать цикл, потому что адрес может быть разной длины
        $(By.xpath("//input[@placeholder='Адрес']")).setValue((String) proData.get(adress_1));
        $(By.xpath("//div[@class='autocomplete-list-container']/ul/li")).click();
        $(By.xpath("//input[@placeholder='Адрес']")).setValue(adress_2);
        $(By.xpath("//div[@class='autocomplete-list-container']/ul/li")).click();
        $(By.xpath("//input[@placeholder='Адрес']")).setValue(adress_3);
        $(By.xpath("//div[@class='autocomplete-list-container']/ul/li")).click();
        $(By.xpath("//input[@placeholder='Дом']")).setValue(dom);
        return this;
    }

    // TODO: 7/19/2018
    private CreateCallPage adressAlarma() {
        //тут нажимаем на кнопку - да во всплывающем окне
        return this;
    }

    private CreateCallPage telephone(Map proData) {
        $(By.id("phone")).setValue((String) proData.get(telephone));
        return this;
    }

    private CreateCallPage telephoneChk() {
        $(By.xpath("//label[@class='mat-checkbox-layout']")).click();
        return this;
    }

    private CreateCallPage vozrastKat() {
        $(By.xpath("//button[2]/span/mat-icon")).click();
        $(By.xpath("//input[@placeholder='Возр. категория']")).click();
        $(By.xpath("//span[contains(.,'Взрослые')]")).click();
        return this;
    }

    private CreateCallPage adressAddition(Map proData) {
        $(By.xpath("//input[@placeholder='Корпус']")).setValue((String) proData.get(korpus));
        $(By.xpath("//input[@placeholder='Строение']")).setValue((String) proData.get(stroenie));
        $(By.xpath("//input[@placeholder='Квартира']")).setValue((String) proData.get(kvartira));
        $(By.xpath("//input[@placeholder='П-д']")).setValue((String) proData.get(pd));
        $(By.xpath("//input[@placeholder='Д-фон']")).setValue((String) proData.get(dfon));
        $(By.xpath("//input[@placeholder='Этаж']")).setValue((String) proData.get(etazh));
        return this;
    }

    private CreateCallPage sexM() {
        $(By.id("sex1")).click();
        return this;
    }

    private CreateCallPage complaint(Map proData) {
        SelenideElement zhalob = $(By.xpath("//input[@aria-label='Введите текст жалобы']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='" + proData.get(zhaloba) + "';", zhalob);
        return this;
    }

    private CreateCallPage polis(Map proData) {
        $(By.xpath("//input[@placeholder='Серия']")).setValue((String) proData.get(seriyaPol));
        $(By.xpath("//input[@placeholder='Номер полиса']")).setValue((String) proData.get(nomerPol));
        return this;
    }

    private CreateCallPage FIO(String nameGen, Map proData) {
        $(By.xpath("//input[@placeholder='Фамилия']")).setValue((String) proData.get(fam));
        $(By.xpath("//input[@placeholder='Имя']")).setValue(nameGen);
        $(By.xpath("//input[@placeholder='Отчество']")).setValue((String) proData.get(otchestvo));
        return this;
    }

    private CreateCallPage FIO(Map proData) {
        $(By.xpath("//input[@placeholder='Фамилия']")).setValue((String) proData.get(fam));
        $(By.xpath("//input[@placeholder='Имя']")).setValue((String) proData.get(name));
        $(By.xpath("//input[@placeholder='Отчество']")).setValue((String) proData.get(otchestvo));
        return this;
    }

    private CreateCallPage birthDay(Map proData) {
        $(By.xpath("//input[@placeholder='Дата рождения']")).setValue((String) proData.get(birthDay));
        return this;
    }

    private CreateCallPage callerPatient() {
        $(By.xpath("//input[@placeholder='Тип вызывающего']")).click();
        $(By.xpath("//span[contains(.,'Пациент')]")).click();
        return this;
    }

    private CreateCallPage callerPredstavit(String nameGen, Map proData) {
        $(By.xpath("//input[@placeholder='Тип вызывающего']")).click();
        $(By.xpath("//span[contains(.,'Представитель')]")).click();
        $(By.id("sourceSmp")).setValue((String) proData.get(station));
        $(By.id("callFamily")).setValue((String) proData.get(callFamily));
        $(By.id("callName")).setValue(nameGen);
        $(By.id("callPatronymic")).setValue((String) proData.get(callPatronymic));
        return this;
    }

    private CreateCallPage saveBtn() {
        $(By.id("save")).click();
        return this;
    }
}