package emias.callDoctor;

import com.codeborne.selenide.SelenideElement;
import emias.AbstractTestGrid;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class EnterSite extends AbstractTestGrid {
    @Step("Захожу в диспетчер через МИС")
    public EnterSite enterCalldoctorFromMis() {
        if (connection == null) {
            page.loginPage().login(site, login, pass);
            page.homePageMis().callDoctorBtn();
            switchTo().window(1);
        } else {
            System.out.println("Открываю только модуль диспетчер по ссылке:\n" + connection);
            open(connection);
        }
        return this;
    }

    @Step("Захожу в диспетчер через МИС под учеткой Генератор")
    public EnterSite enterCalldoctorFromMisGenerator(String name, String pass) {
        page.loginPage().login("http://emias.mosreg.ru/demonstration", name, pass);
        page.homePageMis().callDoctorBtn();
        switchTo().window(1);
        return this;
    }

    @Step("Захожу в МИС")
    public EnterSite enterMIS() {
        page.loginPage().login(site, login, pass);
        return this;
    }

    @Step("Захожу в Портал")
    public EnterSite enterPortal() {
        open("https://uslugi.mosreg.ru/zdrav/");
        return this;
    }

    @Step("Захожу в КЦ")
    public EnterSite enterCallCenter() {
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