package pages.mis;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import pages.AbstractPage;
import utils.Config;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends AbstractPage {
    Config conf;

    public LoginPage() {
        conf = new Config();
    }

    @Step("Открываю стенд")
    public void loginMis() {
        open(conf.getUrl());
        $(By.id("Login")).setValue(conf.getLogin());
        $(By.id("Password")).setValue(conf.getPassword());
        $(By.id("loginBtn")).click();
    }

    @Step("изменяю куки для входа под юр.лицом")
    public void setCookieOfDepartment() {
        String name = "__cp354";
        String value = "1239";
        Cookie department = new Cookie(name, value);
        WebDriverRunner.getWebDriver().manage().addCookie(department);
    }

    @Step("Вход в модуль диспетчер")
    public void calldoctor() {
        open(conf.getCalldoctor());
    }

    @Step("Захожу в диспетчер через МИС под админом")
    public void calldoctorFromMis() {
        open(conf.getUrl());
        $(By.id("Login")).setValue(conf.getAdminLogin());
        $(By.id("Password")).setValue(conf.getAdminPassword());
        $(By.id("loginBtn")).click();
        $(By.xpath("//span[contains(.,'Диспетчер')]")).click();
    }

    @Step("Вход в модуль диспансеризация через журнал")
    public void dispJournal() {
        open(conf.getDispJournal());
    }

    @Step("Вход в карту диспансеризации")
    public void dispCard() {
        open(conf.getDispCard());
    }

    @Step("Вход в карту диспансеризации")
    public void callCenter() {
        SelenideElement log = $(By.id("USER_LOGIN"));
        SelenideElement pass = $(By.id("USER_PASSWORD"));
        SelenideElement loginButton = $(By.xpath("//button[@type='submit']"));
        open("http://call.emias.mosreg.ru/");
        log.val("ccg");
        pass.val("ccg123");
        loginButton.click();
        open("http://call.emias.mosreg.ru/call2_dev/to_work//");
    }
}