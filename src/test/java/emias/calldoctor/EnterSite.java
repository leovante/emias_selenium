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

    public EnterSite enterCalldoctorFromMisGenerator() {
        page.loginPage().login("http://emias.mosreg.ru/demonstration", "generator", "1212");
        page.homePageMis().callDoctorBtn();
        switchTo().window(1);
        return this;
    }

    public EnterSite enterPortal() {
        open("https://uslugi.mosreg.ru/zdrav/");
        return this;
    }

    public EnterSite loginMis() {
        page.loginPage().login(site, login, pass);
        return this;
    }
}