package emias.calldoctor;

import com.codeborne.selenide.SelenideElement;
import emias.AbstractTestGrid;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
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

    public EnterSite enterCallCenter(){
        SelenideElement log = $(By.id("USER_LOGIN"));
        SelenideElement pass = $(By.id("USER_PASSWORD"));
        SelenideElement loginButton = $(By.xpath("//button[@type='submit']"));
        open("http://call.emias.mosreg.ru/");
        log.val("ccg");
        pass.val("ccg123");
        loginButton.click();
        open("http://call.emias.mosreg.ru/call2_dev/to_work//");
        return this;
    }
}