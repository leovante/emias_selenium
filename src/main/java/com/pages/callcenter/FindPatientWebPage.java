package com.pages.callcenter;

import com.codeborne.selenide.SelenideElement;
import com.datas.calldoctor.PacientImpl;
import com.pages.WebPage;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;

public class FindPatientWebPage extends WebPage {
    private PacientImpl pacientImpl;
    SelenideElement fondPatient1 = $(By.xpath("//*[@id='fond-patients']/tr/td[2]"));
    SelenideElement fondPatient2 = $(By.xpath("//*[@id='fond-patients']/tr/td[3]"));
    SelenideElement fondPatient3 = $(By.xpath("//*[@id='fond-patients']/tr/td[4]"));
    SelenideElement polis = $(By.name("snPol"));
    SelenideElement find = $(By.xpath("//button[@id='search_lpu-patient']"));
    SelenideElement fio = $(By.name("surnameNamePatronymic"));
    SelenideElement birthday = $(By.name("birthday"));

    public FindPatientWebPage() throws IOException {
    }

    public FindPatientWebPage findByPolis(PacientImpl pacientImpl) {
        this.pacientImpl = pacientImpl;
        findPatient(pacientImpl);
        return this;
    }

    public FindPatientWebPage findByFio(PacientImpl pacientImpl) {
        this.pacientImpl = pacientImpl;
        findFio(pacientImpl);
        return this;
    }

    public void findPatient(PacientImpl pacientImpl) {
        polis.val(pacientImpl.getNumberpol());
        find.click();
    }

    public void findFio(PacientImpl pacientImpl) {
        fio.val(pacientImpl.getFamily() + " " + pacientImpl.getName() + " " + pacientImpl.getOt());
        birthday.val(pacientImpl.getBirthdate("dd-MM-yyyy"));
        find.click();
    }
}
