package emias;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static pages.AbstractPage.LOGGER;

public class Enter extends AbstractTestGrid {

    @Step("Захожу в диспетчер через МИС")
    public Enter enterCalldoctorFromMis() {
        if (use_url != null && use_url.equals("false")) {
            page.loginPage().login(site, login, pass);
            page.homePageMis().callDoctorBtn();
            switchTo().window(1);
        } else {
            LOGGER.info("Открываю только модуль диспетчер по ссылке:\n" + CALLDOCTOR_URL);
            open(CALLDOCTOR_URL);
        }
        return this;
    }

    @Step("Захожу в диспетчер через МИС под учеткой Генератор")
    public Enter enterCalldoctorFromMisGenerator(String name, String pass) {
        page.loginPage().login("http://emias.mosreg.ru/demonstration", name, pass);
        page.homePageMis().callDoctorBtn();
        switchTo().window(1);
        return this;
    }

    @Step("Захожу в МИС")
    public Enter enterMIS() {
        page.loginPage().login(site, login, pass);
        return this;
    }

    @Step("Захожу в Портал")
    public Enter enterPortal() {
        open("https://uslugi.mosreg.ru/zdrav/");
        return this;
    }

    @Step("Захожу в КЦ")
    public Enter enterCallCenter() {
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

    @Step("Захожу в диспансеризацию через МИС")
    public Enter enterDispFromMis() {
        if (CALLDOCTOR_URL == null) {
            page.loginPage().login(site, login, pass);
            page.homePageMis().dispCardJournalBtn();
            switchTo().window(1);
        } else {
            LOGGER.info("Открываю только модуль диспансеризация по ссылке:\n" + DISP_JOURNAL_URL);
            open(DISP_JOURNAL_URL);
        }
        return this;
    }
}