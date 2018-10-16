package emias.calldoctor;

import emias.AbstractTestGrid;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

public class EnterSite extends AbstractTestGrid {

    public EnterSite enterCalldoctorFromMis() {
        page.loginPage().login(site, login, pass);
        page.homePageMis().callDoctorBtn();
        switchTo().window(1);
        return this;
    }

    public EnterSite enterCalldoctorFromMisAdmin() {
        page.loginPage().login("http://emias.mosreg.ru/demonstration", "Admin", "RChS2014");
        page.homePageMis().callDoctorBtn();
        switchTo().window(1);
        return this;
    }

    public EnterSite enterPortal() {
        open("https://uslugi.mosreg.ru/zdrav/");
        return this;
    }
}