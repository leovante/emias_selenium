package com.pages.callcenter;

import com.codeborne.selenide.SelenideElement;
import com.pages.PageBase;
import com.pages.calldoctor.pacients.PacientImpl;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class CallDoctorPageBase extends PageBase {
    private PacientImpl pacientImpl;

    public CallDoctorPageBase() {
    }

    public CallDoctorPageBase calldoctor(PacientImpl pacientImpl) throws InterruptedException {

        Thread.sleep(2000);
        $(By.xpath("//div[@class='fast-buttons']//button[text()='Вызов врача']")).click();
        Thread.sleep(2000);
        $(By.id("search-patient")).click();
        Thread.sleep(2000);
        $(By.xpath("//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']")).click();
        $(By.name("snPol")).sendKeys("38-09 560219");
        $(By.name("birthday")).sendKeys("30111975");
        $(By.xpath("//button[@id='search-patient']")).click();
        //Thread.sleep(2000);
        $(By.name("address")).sendKeys("адрес");
        Thread.sleep(2000);
        $(By.name("porch")).sendKeys("38");
        $(By.name("floor")).sendKeys("9");
        $(By.name("intercomCode")).sendKeys("98");
        $(By.name("phone")).sendKeys("1234567890");
        $(By.name("complaint")).sendKeys("все болит, ничего не помогает");
        $(By.xpath("//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']")).click();
        $(By.xpath("//div[@id='patientLpuList']/button")).click();
        $(By.xpath("//*[@id='select2-searchByCities-container']")).click();
        $(By.xpath("//input[@class='select2-search__field']")).sendKeys("Красногорский");
        $(By.xpath("//input[@class='select2-search__field']")).sendKeys(Keys.RETURN);
        //Thread.sleep(2000);
        $(By.xpath("//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']")).click();
        Thread.sleep(2000);
        $(By.xpath("//button[@id='call-doctor-button']")).click();
        Thread.sleep(2000);
        $(By.xpath("//*[@id='ccInfoModal']/div/div/div[3]/button")).click();
        Thread.sleep(2000);
        $(By.xpath("//tbody[@id='call-doc-list']//button[@class='btn btn-danger']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }

    public CallDoctorPageBase calldoctorSMP(PacientImpl pacientImpl) throws InterruptedException {
        $(By.xpath("//div[@class='fast-buttons']//button[text()='Вызов врача']")).click();
        $(By.xpath("//*[@id='searchLPUForm']/div[1]/div/input")).val("СТЕНД ЕМИАС МО");
        $(By.xpath("//*[@id='patientLpuList']/div[2]/button")).click();
        writePatSMP(pacientImpl);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }

    public void writePat(String comp,String porch,String floor,String intercomCode, String adr){
        $(By.name("complaint")).val(comp);
        $(By.name("porch")).val(porch);
        $(By.name("floor")).val(floor);
        $(By.name("intercomCode")).val(intercomCode);
        $(By.name("phone")).val("1234567899");
        $(By.name("address")).clear();
        $(By.name("address")).val(adr);
    }

    public void writePatSMP(PacientImpl pacientImpl) {
        $(By.name("surnameNamePatronymic")).val(pacientImpl.getFamily() + " " + pacientImpl.getName() + " " + pacientImpl.getOt());
        $("#isChild").click();
        $(By.xpath("//*[@id='createHomeVisitForm']/div/div/label[2]/input")).click();
        $(By.name("complaint")).val(pacientImpl.getComplaint());
//        $(By.name("address")).clear();
        $(By.name("address")).val(pacientImpl.getAddress());
        $(By.name("phone")).val("1234567899");
    }

    public CallDoctorPageBase eqCallDoc(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9) throws InterruptedException {
        SelenideElement lp = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[1]"));
        SelenideElement fi = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[2]"));
        SelenideElement bir = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[3]"));
        SelenideElement adr = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[4]"));
        SelenideElement por = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[5]"));
        SelenideElement flo = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[6]"));
        SelenideElement in = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[7]"));
        SelenideElement pho = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[8]"));
        SelenideElement com = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[9]"));

        String lpu=lp.getText();
        String fio=fi.getText();
        String birthday=bir.getText();
        String adress=adr.getText();
        String porch=por.getText();
        String floor=flo.getText();
        String intercom=in.getText();
        String phone=pho.getText();
        String complaint=com.getText();

        Assert.assertTrue(lpu.contains("Стенд ЕМИАС МО"));
        LOGGER.info(lpu + " есть");
        Assert.assertTrue(arg2.contains(fio));
        LOGGER.info(fio + " есть");
        Assert.assertTrue(arg3.contains(birthday));
        LOGGER.info(birthday + " есть");
        Assert.assertTrue(arg4.contains(adress));
        LOGGER.info(adress + " есть");
        Assert.assertTrue(arg5.contains(porch));
        LOGGER.info(porch + " есть");
        Assert.assertTrue(arg6.contains(floor));
        LOGGER.info(floor + " есть");
        Assert.assertTrue(arg7.contains(intercom));
        LOGGER.info(intercom + " есть");
        Assert.assertTrue(arg8.contains(phone));
        LOGGER.info(phone + " есть");
        Assert.assertTrue(arg9.contains(complaint));
        LOGGER.info(complaint + " есть");
        return this;
    }

    public CallDoctorPageBase eqCallDocSMP(String arg1, String arg2, String arg3, String arg4, String arg5) throws InterruptedException {
        SelenideElement lp = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[1]"));
        SelenideElement fi = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[2]"));
        SelenideElement bir = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[3]"));
        SelenideElement adr = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[4]"));
        SelenideElement por = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[5]"));
        SelenideElement flo = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[6]"));
        SelenideElement in = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[7]"));
        SelenideElement pho = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[8]"));
        SelenideElement com = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[9]"));

        String lpu=lp.getText();
        String fio=fi.getText();
        String birthday=bir.getText();
        String adress=adr.getText();
        String porch=por.getText();
        String floor=flo.getText();
        String intercom=in.getText();
        String phone=pho.getText();
        String complaint=com.getText();

        Assert.assertTrue(lpu.contains("Стенд ЕМИАС МО"));
        LOGGER.info(lpu + " есть");
        Assert.assertTrue(arg1.contains(fio));
        LOGGER.info(fio + " есть");
        Assert.assertTrue(birthday.contains(""));
        LOGGER.info(birthday + " есть");
        Assert.assertTrue(arg3.contains(adress));
        LOGGER.info(adress + " есть");
        Assert.assertTrue(porch.contains(""));
        LOGGER.info(porch + " есть");
        Assert.assertTrue(floor.contains(""));
        LOGGER.info(floor + " есть");
        Assert.assertTrue(intercom.contains(""));
        LOGGER.info(intercom + " есть");
        Assert.assertTrue(arg4.contains(phone));
        LOGGER.info(phone + " есть");
        Assert.assertTrue(arg5.contains(complaint));
        LOGGER.info(complaint + " есть");
        return this;
    }

    public void getLpu(String arg0){
        $(By.xpath("//*[@id='searchLPUForm']/div[1]/div/input")).val(arg0);
        $(By.xpath("//*[@id='patientLpuList']/div[2]/button")).click();
    }
}
