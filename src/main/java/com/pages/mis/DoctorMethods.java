package com.pages.mis;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.datas.calldoctor.Doctor;
import com.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class DoctorMethods extends BasePage {
    SelenideElement doctorRow = $(By.xpath("//tr[@role='row'][@tabindex='-1']"));

    public DoctorMethods() throws IOException {
    }

    @Step("получить уникального врача")
    public String getUnicalDoctor(String docName) {
        doctorRow.shouldBe(Condition.visible);
        List<String> dontUseNames = new ArrayList<String>();
        Collections.addAll(dontUseNames, "Ай Бо Лит", "Ар Ти Шок", "test test testovych", "Ай Бо ЛитАвтоТест", "null");
        dontUseNames.add(docName);
//        logger2.info((Supplier<String>) dontUseNames);
        String doctorStringName = docName;
        List<WebElement> doctorList = driver
                .findElement(By.xpath("//table[@id='schw_docprvdgrid1'][@role='grid']/tbody"))//нашел таблицу
                .findElements(By.xpath("tr[@role='row'][@tabindex='-1']/td[3]/div/span[1]"));//нашел строки врачей
        for (WebElement doctor : doctorList) {
            int count = 0;
            doctorStringName = doctor.getText();
            for (WebElement doctorCount : doctorList) {
                String doctorStringName2 = doctorCount.getText();
                if (doctorStringName.equals(doctorStringName2))
                    count++;
                if (count > 1)
                    break;
            }
            if (count == 1 && !dontUseNames.contains(doctorStringName))
                break;
        }
        dontUseNames.add(doctorStringName);//чот не срабатывает
        return doctorStringName;
    }

    @Step("получить уникального врача")
    public String getUnicalDoctor3(int doctorNum) {
        doctorRow.shouldBe(Condition.visible);
        List<String> badNames = new ArrayList<String>();
        Collections.addAll(badNames, "Ай Бо Лит", "Ар Ти Шок", "test test testovych", "null", "Моков Павел Александрович", "Ай Бо ЛитАвтоТест");
        List<WebElement> doctorList = driver
                .findElement(By.xpath("//table[@id='schw_docprvdgrid1'][@role='grid']/tbody"))//нашел таблицу
                .findElements(By.xpath("tr[@role='row'][@tabindex='-1']/td[3]/div/span[1]"));//нашел строки врачей
        int internalDocNum = doctorNum;
        String doctorName = null;
        for (WebElement doctor : doctorList) {
            doctorName = doctor.getText();
            if (badNames.contains(doctorName)) {
            } else {
                if (internalDocNum == 1)
                    break;
                else {
                    internalDocNum = internalDocNum - 1;
                }
            }
        }
        return doctorName;
    }

    @Step("получить уникального врача")
    public String getUnicalDoctor2(String docName) {
        doctorRow.shouldBe(Condition.visible);
        List<String> dontUseNames = new ArrayList<String>();
        Collections.addAll(dontUseNames, "Ай Бо Лит", "Ай Бо ЛитАвтоТест", "Ар Ти Шок", "test test testovych", "null");
        dontUseNames.add(docName);
//        logger2.info((Supplier<String>) dontUseNames);
        String doctorStringName = docName;
        List<WebElement> doctorList = driver
                .findElement(By.xpath("//table[@id='docprvdgrid1'][@role='grid']/tbody"))//нашел таблицу
                .findElements(By.xpath("tr[@role='row'][@tabindex='-1']/td[2]/div/span[1]"));//нашел строки врачей
        for (WebElement doctor : doctorList) {
            int count = 0;
            doctorStringName = doctor.getText();
            for (WebElement doctorCount : doctorList) {
                String doctorStringName2 = doctorCount.getText();
                if (doctorStringName.equals(doctorStringName2))
                    count++;
                if (count > 1)
                    break;
            }
            if (count == 1 && !dontUseNames.contains(doctorStringName))
                break;
        }
        dontUseNames.add(doctorStringName);
        return doctorStringName;
    }

    @Step("выбрать врача")
    public DoctorMethods selectDoctor(String doctorInlet) {
        $(By.xpath("//td/div/span[contains(text(),'" + doctorInlet + "')]")).click();
        return this;
    }

    public DoctorMethods selectDoctor(Doctor doctor) {
        $(By.xpath("//td/div/span[contains(text(),'" +
                doctor.getFamily() + " " +
                doctor.getName() + " " +
                doctor.getOt() +
                "')]")).click();
        return this;
    }


}