package com.pages.callcenter;

import com.codeborne.selenide.SelenideElement;
import com.pages.PageBase;
import com.pages.calldoctor.pacients.Pacient;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class FindPatientPageBase extends PageBase {
    private Pacient pacient;
    SelenideElement fondPatient1 = $(By.xpath("//*[@id='fond-patients']/tr/td[2]"));
    SelenideElement fondPatient2 = $(By.xpath("//*[@id='fond-patients']/tr/td[3]"));
    SelenideElement fondPatient3 = $(By.xpath("//*[@id='fond-patients']/tr/td[4]"));
    SelenideElement polis = $(By.name("snPol"));
    SelenideElement find = $(By.xpath("//button[@id='search-patient']"));
    SelenideElement fio = $(By.name("surnameNamePatronymic"));
    SelenideElement birthday = $(By.name("birthday"));

    public FindPatientPageBase() {
    }

    public FindPatientPageBase findByPolis(Pacient pacient) {
        this.pacient = pacient;
        findPatient(pacient);
        return this;
    }

    public FindPatientPageBase findByFio(Pacient pacient) {
        this.pacient = pacient;
        findFio(pacient);
        return this;
    }

    public void findPatient(Pacient pacient)  {
        polis.val(pacient.getNumberpol()) ;
        find.click();
    }

    public void findFio(Pacient pacient) {
        fio.val(pacient.getFamily()+" "+pacient.getName()+" "+pacient.getOt());
        birthday.val(pacient.getBirthdate("dd-MM-yyyy"));
        find.click();
    }
}
