package emias.calldoctor;

import emias.AbstractTestGrid;

import static com.codeborne.selenide.Selenide.switchTo;

public class BeforeCalldoctor extends AbstractTestGrid {

    public BeforeCalldoctor loginMis_Calldoctor() {
        page.loginPage().login(site, login, pass);
        page.homePage().callDoctorBtn();
        switchTo().window(1);
        curUrlCalldoctor = driver.getCurrentUrl();
        return this;
    }
}