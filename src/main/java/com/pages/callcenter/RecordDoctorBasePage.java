package com.pages.callcenter;

import com.codeborne.selenide.SelenideElement;
import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.PacientImpl;
import com.pages.BasePage;
import org.openqa.selenium.By;

import java.io.IOException;
import java.text.ParseException;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static org.testng.Assert.assertTrue;

public class RecordDoctorBasePage extends BasePage {
    private PacientImpl pacientImpl;
    private Doctor doctor;
    SelenideElement allrecord = $(By.xpath("//*[@id='all-patient-records-tab']"));
    SelenideElement reschedule = $(By.xpath("//button[@title='Перенести запись']"));
    SelenideElement recordDate = $(By.xpath("//tr[contains(.,'Ай Бо Лит')]//button[@class='btn btn-little btn-block btn-success']"));
    SelenideElement recordTime = $(By.xpath("//*[@id='day-doc-schedule']/div/div/div[2]/button[17]"));
    SelenideElement recordTimeRandom = $(By.xpath("//*[@id='day-doc-schedule']/div/div/div[2]/button[@class='btn btn-success']"));
    SelenideElement rerecord = $(By.xpath("//*[@id='record-to-doc-form']/div/div[2]/button"));
    SelenideElement yes = $(By.xpath("//*[@id='ccInfoModal']/div/div/div[3]/button[2]"));
    SelenideElement delete = $(By.xpath("//button[@title='Удалить запись']"));
    SelenideElement lpuName = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[1]"));
    SelenideElement specName = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[2]"));
    SelenideElement doctorFIO = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[3]"));
    SelenideElement kabName = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[4]"));
    SelenideElement dateTicket = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[5]"));
    SelenideElement timeTicket = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[6]"));
    SelenideElement numTicket = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[7]"));
    SelenideElement timerec = $(By.xpath("//button[@class='btn btn-success']")); //(text(),'17:30')
    SelenideElement recordbutton = $(By.xpath("//*[contains(text(),'Записать на прием')]"));
    SelenideElement closemodal = $(By.xpath("//*[@id='ccInfoModal']/div/div/div[3]/button"));
    SelenideElement talonNumber2 = $(By.xpath("//*[@id='talon-list']/tr/td[2]"));
    SelenideElement docName2 = $(By.xpath("//*[@id='talon-list']/tr/td[4]"));
    SelenideElement talonTime2 = $(By.xpath("//*[@id='talon-list']/tr/td[7]"));
    SelenideElement zapis = $(By.xpath("//*[@id='talon-list']"));

    String name2;
    String time2;
    String number2;

    public RecordDoctorBasePage() throws IOException {
    }

    public RecordDoctorBasePage visitDoctor(PacientImpl pacientImpl) throws IOException, InterruptedException, ParseException {
        this.pacientImpl = pacientImpl;
        recordDoctor2();
        return this;
    }

    public RecordDoctorBasePage visitDoctorAssertTalon(PacientImpl pacientImpl) throws IOException, InterruptedException, ParseException {
        this.pacientImpl = pacientImpl;
        recordDoctor2()
                .assertDoc();
        return this;
    }

    public RecordDoctorBasePage visitDoctorRewritable(PacientImpl pacientImpl) throws IOException, InterruptedException, ParseException {
        this.pacientImpl = pacientImpl;
        recordDoctor()
                .workRecord();
        return this;
    }

    public RecordDoctorBasePage deleteVisitDoctor(PacientImpl pacientImpl) throws IOException, InterruptedException, ParseException {
        this.pacientImpl = pacientImpl;
        recordDoctor()
                .deleteRecord();
        return this;
    }

    public RecordDoctorBasePage recordDoctor() throws InterruptedException {
        changeLpu(doctor.getDepartment());
        changeSpec(doctor.getSpecialization());
        changeDoc(doctor.getName());
        timerec.shouldBe(enabled).click();
        recordbutton.shouldBe(enabled).click();
        closemodal.shouldBe(enabled).click();
        return this;
    }

    public RecordDoctorBasePage recordDoctor2() throws InterruptedException {
        changeLpu("СТЕНД ЕМИАС МО");
        changeSpec("Терапия");
        changeDoc(doctor.getName());
        timerec.shouldBe(enabled).click();
        recordbutton.shouldBe(enabled).click();

        return this;
    }

    public RecordDoctorBasePage assertDir(String lpu, String special, String fioDoc, String kab) throws InterruptedException {
        Thread.sleep(2000);
        SelenideElement specialist = $(By.xpath("//*[@id='a7f391d4-d5d8-44d5-a770-f7b527bb12330b58bf2f-b6ff-423e-bff8-018953417c50']/td[1]/br[1]"));
        String spec1= specialist.getText();
        logger2.info(spec1);
        String eq1 = lpuName.getText();
        String eq2 = specName.getText();
        String eq3 = doctorFIO.getText();
        String eq4 = kabName.getText();
        String eq5 = dateTicket.getText();
        String eq6 = timeTicket.getText();

        logger2.info("Код гавно2");

        logger2.info("текст в lpu и eq1 = " + lpu + " и " + eq1);
        logger2.info("текст в фио док и eq3 = " + fioDoc + " и " + eq3);

        assertTrue(eq1.contains("Стенд ЕМИАС МО | Московская область, г. Неизвестный, ул. Светлая, д. 5"));
        logger2.info("Лпу есть");
        assertTrue(eq2.contains(special));
        logger2.info("Специальность есть");
        assertTrue(eq3.contains(fioDoc));
        logger2.info(eq3 + " есть");
        assertTrue(kab.contains(eq4));
        logger2.info(eq4 + " есть");
        assertTrue(eq5 != null);
        logger2.info(eq5 + " есть");
        assertTrue(eq6 != null);
        logger2.info(eq6 + " есть");
        return this;

    }

    public RecordDoctorBasePage assertDoc() throws InterruptedException {
        Thread.sleep(2000);
        SelenideElement specialist = $(By.xpath("//*[@id='a7f391d4-d5d8-44d5-a770-f7b527bb12330b58bf2f-b6ff-423e-bff8-018953417c50']/td[1]/br[1]"));
        String spec1= specialist.getText();
        logger2.info(spec1);
        String eq1 = lpuName.getText();
        String eq2 = specName.getText();
        String eq3 = doctorFIO.getText();
        String eq4 = kabName.getText();
        String eq5 = dateTicket.getText();
        String eq6 = timeTicket.getText();
        String eq7 = numTicket.getText();

        logger2.info("Код гавно2");

//        logger2.info("текст в lpu и eq1 = "+lpu+" и "+eq1);

//        assertThat(lpu).isEqualToIgnoringCase(eq1);
        assertTrue(eq1.contains("Стенд ЕМИАС МО Московская область, г. Неизвестный, ул. Светлая, д. 5"));
        logger2.info("Лпу есть");
        assertTrue(eq2.contains("Терапевты"));
        logger2.info("Специальность есть");
        assertTrue(eq3.contains(doctor.getName()));
        logger2.info(eq3 + " есть");
        assertTrue(eq4.contains(doctor.getCabinet()));
        logger2.info(eq4 + " есть");
        assertTrue(eq5 != null);
        logger2.info(eq5 + " есть");
        assertTrue(eq6 != null);
        logger2.info(eq6 + " есть");
        assertTrue(eq7 != null);
        logger2.info(eq7 + " есть");
        closemodal.click();
        return this;
    }

    public RecordDoctorBasePage EqualDoc() throws InterruptedException {
        logger2.info("метка1");
        String eq1 = lpuName.getText();
        String eq2 = specName.getText();
        String eq3 = doctorFIO.getText();
        String eq4 = kabName.getText();
        String eq5 = dateTicket.getText();
        String eq6 = timeTicket.getText();
        String eq7 = numTicket.getText();
        closemodal.click();

        logger2.info("метка2");
        Thread.sleep(2000);

        allrecord.click();
        Thread.sleep(2000);

        String equal7 = $(By.xpath("//*[@id='talon-list']/tr/td[2]")).getText();
        String equal2 = $(By.xpath("//*[@id='talon-list']/tr/td[4]")).getText();
        String equal3 = $(By.xpath("//*[@id='talon-list']/tr/td[3]")).getText();
        String equal6 = $(By.xpath("//*[@id='talon-list']/tr/td[7]")).getText();
        String istok = $(By.xpath("//*[@id='talon-list']/tr/td[5]")).getText();
        String equal5 = $(By.xpath("//*[@id='talon-list']/tr/td[6]")).getText();
        logger2.info("Код гавно2");

        assertTrue(equal2.contains("Терапия"));
        logger2.info(eq2 + " есть");
        assertTrue(equal3.contains("Ай Бо Лит"));
        logger2.info(eq3 + " есть");
        assertTrue(equal6.contains(eq6));
        logger2.info(eq6 + " есть");
        assertTrue(equal7.contains(eq7));
        logger2.info(eq7 + " есть");
        assertTrue(istok.contains("Колл-центр"));
        logger2.info("Код гавно3");
        return this;
    }

    public RecordDoctorBasePage EqualDetal() {

//        String eq1 = lpuName.getText();
//
//        String equal8 = $(By.xpath("//*[@id='talon-list']/tr/td[1]/div/ul/li/div/h4")).getText();
//        String equal9 = $(By.xpath("//*[@id='talon-list']/tr/td[1]/div/ul/li/div/p[4]")).getText();
//        String istok = $(By.xpath("//*[@id='talon-list']/tr/td[5]")).getText();
//
//        logger2.info("Код гавно3");
//
//        assertTrue(istok.contains("Колл-центр"));
//        assertTrue(equal8.contains(eq1));
//        logger2.info(eq1+" есть");
//        assertTrue(istok.contains(equal9));
//        logger2.info(" есть");
        SelenideElement lpuName2 = $(By.xpath("//*[@id='talon-list']/tr/td[1]/div/ul/li/div/h4"));
        //*[@id="talon-list"]/tr/td[1]/div/ul/li/div/h4
        SelenideElement adress = $(By.xpath("//*[@id='talon-list']/tr/td[1]/div/ul/li/div/p[1]"));
        SelenideElement istok = $(By.xpath("//*[@id='talon-list']/tr/td[1]/div/ul/li/div/p[3]"));
        SelenideElement createData = $(By.xpath("//*[@id='talon-list']/tr/td[1]/div/ul/li/div/p[4]"));


        String eq1 = lpuName2.getText();
        String eq2 = adress.getText();
        String eq3 = istok.getText();
        String eq4 = createData.getText();

        assertTrue(eq1.contains("Стенд ЕМИАС МО"));
        logger2.info(eq1 + " есть");
        assertTrue(eq2.contains("Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5"));
        logger2.info(eq2 + " есть");
        assertTrue(eq3.contains("Источник: Колл-центр"));
        logger2.info(eq3 + " есть");
        assertTrue(eq4 != null);
        logger2.info(eq4 + " есть");
        return this;
    }

    public void changeLpu(String arg0) throws InterruptedException {
        Thread.sleep(1000);
        SelenideElement lpu = $(By.xpath("//button[contains(.,'"+arg0+"')]"));
        lpu.shouldBe(enabled).click();
    }

    public void changeSpec(String arg0) throws InterruptedException {
        Thread.sleep(1000);
        SelenideElement spec = $(By.xpath("//button[@data-department-name='"+arg0+"']"));
        spec.shouldBe(enabled).click();
    }

    public void changeDoc(String arg0) throws InterruptedException {
        Thread.sleep(1000);
        SelenideElement fastDoc =
                $(By.xpath("//*[contains(text(),'"+arg0+"')]"))
                .$(By.xpath("../../."))
                .$(By.xpath(".//button[@class='btn btn-little btn-block btn-success']"));
        fastDoc.shouldBe(enabled);
        fastDoc.click();
    }

    public RecordDoctorBasePage createNewCall(String arg0) throws IOException {
        SelenideElement lpu = $(By.xpath("//button[contains(.,'СТЕНД ЕМИАС МО')]"));
        lpu.hover();
        lpu.click();
        SelenideElement spec = $(By.xpath("//button[@data-department-name='Терапия']"));
        spec.click();
        SelenideElement fastDoc =
                $(By.xpath("//*[contains(text(),'"+arg0+"')]"))
                        .$(By.xpath("../../."))
                        .$(By.xpath(".//button[@class='btn btn-little btn-block btn-success']"));
        fastDoc.click();

//        $(By.xpath("//button[contains(.,'СТЕНД ЕМИАС МО')]")).click();
//        $(By.xpath("//button[@data-department-name='Терапия']")).click();
//        $(By.xpath("//tr[contains(.,'" + arg0 + "')]//button[@class='btn btn-little btn-block btn-success']")).click();
        timerec.click();
        recordbutton.click();
        return this;
    }

    public void patientRecords() {
        allrecord.click();
        name2 = docName2.getText();
        time2 = talonTime2.getAttribute("innerHTML");
        number2 = talonNumber2.getAttribute("innerHTML");
        logger2.info(name2 + " " + time2 + " " + number2);

    }

    public RecordDoctorBasePage workRecord() {
        allrecord.click();
        reschedule.click();
        recordDate.click();
        recordTime.click();
        rerecord.click();
        return this;
    }

    public RecordDoctorBasePage deleteRecord() throws InterruptedException {
        logger2.info("Поехале");
        allrecord.click();
        delete.click();
        yes.click();
        close();
        return this;
    }

}
