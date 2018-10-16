package emias.calldoctor;

import emias.AbstractTestGrid;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

public class EnterSite extends AbstractTestGrid {

    public EnterSite enterCalldoctor() {
        page.loginPage().login(site, login, pass);
        page.homePage().callDoctorBtn();
        switchTo().window(1);
        return this;
    }

    public EnterSite enterPortal() {
        open("https://uslugi.mosreg.ru/zdrav/");
        return this;
    }
}