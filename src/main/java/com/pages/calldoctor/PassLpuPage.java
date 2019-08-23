package com.pages.calldoctor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.datas.calldoctor.Doctor;
import com.pages.PageBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PassLpuPage extends PageBase {
    Doctor doctor;

    public PassLpuPage() throws IOException {
    }

    public PassLpuPage(Doctor doctor) throws IOException {
        this.doctor = doctor;
    }

    @Step("Передаю в другое подразделение на страинце поиска ЛПУ")
    public PassLpuPage transfer() throws IOException, InterruptedException {
        $x("//*[text()='" + doctor.getDepartment() + "']")
                .hover()
                .click();
        $x("//*[contains(text(),'Передать')]")
                .hover()
                .click();
        $(By.id("toLpuYes"))
                .hover()
                .click();
        return this;
    }

    @Step("Проверяю условия отображения подразделений для взрослого вызова")
    public PassLpuPage validate_view_to_adult() throws IOException, InterruptedException {
        SelenideElement se = $x("//*[contains(text(),'Взрослая поликлиника')]").shouldBe(Condition.visible);
        Assert.assertTrue(se.isDisplayed(), "Взрослая поликлиника не найдена");
        Thread.sleep(1000);
        SelenideElement se2 = $x("//*[contains(text(),'Детская поликлиника')]");
        Assert.assertFalse(se2.isDisplayed(), "Детская поликлиника отображается");
        return this;
    }

    public PassLpuPage search_lpu(){
        $x("//*[@placeholder='Поиск ЛПУ']").setValue(doctor.getDepartment());
        return this;
    }
}