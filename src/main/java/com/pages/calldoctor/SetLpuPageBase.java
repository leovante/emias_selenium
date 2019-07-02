package com.pages.calldoctor;

import com.pages.PageBase;
import com.pages.calldoctor.doctors_interfaces.Doctor;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SetLpuPageBase extends PageBase {
    @Step("Передаю в другое подразделение на страинце поиска ЛПУ")
    public void transfer(Doctor doctor) throws IOException {
        $x("//*[text()='" + doctor.getDepartment() + "']").click();
        $x("//*[contains(text(),'Передать')]").click();
        $(By.id("toLpuYes")).click();
    }
}