package com.pages.calldoctor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.pages.PageBase;
import com.pages.calldoctor.doctors_interfaces.Doctor;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SetLpuPageBase extends PageBase {
    public SetLpuPageBase() throws IOException {
    }

    @Step("Передаю в другое подразделение на страинце поиска ЛПУ")
    public void transfer(Doctor doctor) throws IOException, InterruptedException {
        $x("//*[text()='" + doctor.getDepartment() + "']")
                .hover()
                .click();
        $x("//*[contains(text(),'Передать')]")
                .hover()
                .click();
        $(By.id("toLpuYes"))
                .hover()
                .click();
    }

    @Step("Проверяю условия отображения подразделений для взрослого вызова")
    public void validateViewToAdult() throws IOException, InterruptedException {
        SelenideElement se = $x("//*[contains(text(),'Взрослая поликлиника')]").shouldBe(Condition.visible);
        Assert.assertTrue(se.isDisplayed(), "Взрослая поликлиника не найдена");
        Thread.sleep(1000);
        SelenideElement se2 = $x("//*[contains(text(),'Детская поликлиника')]");
        Assert.assertFalse(se2.isDisplayed(), "Детская поликлиника отображается");
    }
}