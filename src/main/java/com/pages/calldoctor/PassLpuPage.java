package com.pages.calldoctor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.datas.calldoctor.Doctor;
import com.pages.WebPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class PassLpuPage extends WebPage {
    Doctor doctor;

    public PassLpuPage() {
    }

    public PassLpuPage(Doctor doctor)  {
        this.doctor = doctor;
    }

    @Step("Передаю в другое подразделение на страинце поиска ЛПУ")
    public PassLpuPage transfer() {
        $x("//*[text()='" + doctor.getDepartment() + "']")
                .hover()
                .click();
        $x("//*[contains(text(),'Передать')]")
                .hover()
                .click();
        sleep(1000);
        $(By.id("toLpuYes"))
                .hover()
                .click();
        return this;
    }

    @Step("Проверяю условия отображения подразделений для взрослого вызова")
    public PassLpuPage validate_view_to_adult() {
        SelenideElement se = $x("//*[contains(text(),'Взрослая поликлиника')]").shouldBe(Condition.visible);
        Assert.assertTrue(se.isDisplayed(), "Взрослая поликлиника не найдена");
        sleep(1000);
        SelenideElement se2 = $x("//*[contains(text(),'Детская поликлиника')]");
        Assert.assertFalse(se2.isDisplayed(), "Детская поликлиника отображается");
        return this;
    }

    public PassLpuPage search_lpu(){
        $x("//*[@placeholder='Поиск ЛПУ']").setValue(doctor.getDepartment());
        return this;
    }
}