package emias.calldoctor;

import emias.AbstractTestGrid;

import static com.codeborne.selenide.Selenide.switchTo;

public class EnterCalldoctor extends AbstractTestGrid {

    public EnterCalldoctor loginMis_Calldoctor() {
        page.loginPage().login(site, login, pass);
        page.homePage().callDoctorBtn();
        switchTo().window(1);
        return this;
    }
}