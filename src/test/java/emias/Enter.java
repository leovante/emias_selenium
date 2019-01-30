package emias;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static pages.AbstractPage.LOGGER;

public class Enter extends AbstractTestGrid {
    public static String DISP_CARD_URL = "http://service.emias.mosreg.ru/demo/disp;doctorId=1239;doctorGuid=71f2edcf-8395-4c0d-b011-be9b4a437718;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=KgHJ4f8mS1LP3YV%2bZnTy4d10h8xgdeJ7fxS9qjcEI2zdlg3AbSqDvDKxOODzM4juNRHlsSkSIyj4kRjxtqO2Tl0cw2fGBAG%2bbeuWsiRvKlaM%2frSG86U24eBF%2fabwRz%2ftxzhF0eY%2f8umxvbD95%2bBHNuxgBEJxIe3gmMwKo74dZFmzZUWhv4TXVSEWr%2bsbrFUHqTCibgPM2FYtEPOcCtBGMWsKKPCpeKwImyB8m2g3hWBxA7O2YhSgoY0Q%2bx%2bBJyqL4dBCMXNQ4g0mS0d9IjPdG9mR69ImYvrlwxdZdldDCelWygW0/card/3169?ticket=KgHJ4f8mS1LP3YV%2bZnTy4d10h8xgdeJ7fxS9qjcEI2zdlg3AbSqDvDKxOODzM4juNRHlsSkSIyj4kRjxtqO2Tl0cw2fGBAG%2bbeuWsiRvKlaM%2frSG86U24eBF%2fabwRz%2ftxzhF0eY%2f8umxvbD95%2bBHNuxgBEJxIe3gmMwKo74dZFmzZUWhv4TXVSEWr%2bsbrFUHqTCibgPM2FYtEPOcCtBGMWsKKPCpeKwImyB8m2g3hWBxA7O2YhSgoY0Q%2bx%2bBJyqL4dBCMXNQ4g0mS0d9IjPdG9mR69ImYvrlwxdZdldDCelWygW0&mkabId=0&dvtId=385541&docPrvdId=1239&MisUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration&ReturnUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration%2fSchedule";
    public static String DISP_JOURNAL_URL = "http://service.emias.mosreg.ru/demo/disp/log;doctorId=1239;doctorGuid=71f2edcf-8395-4c0d-b011-be9b4a437718;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=UtduJYr%2fHQzIc4GpRM7n4E4M6TN0uXaja1Tx5GtHDpYRoDdlgS%2fmbGWZqEa0AR%2fPYaH6OQe8jFKM1q%2bOrq%2b6p44Q2xXUuRFb2PN%2bGN5ftNbln6EqRgNPDJgXDJbryHbJmOKJoJ5ocxApTm9jZBPofnwHkZvu%2bAAi1oBXTt6XRDXp3wijkRKZh7dwZH3pGMxdRP6QxW4QJhlMbDNTr4twWAr4tIozibowZTUza2kuJPM1IyG6biJkBKoBrjypNWQOSJ40akxr0nMKrN%2fA0ac0GN%2f37u2clJj4MKveA0lcDJ4z5Kao?ticket=UtduJYr%2fHQzIc4GpRM7n4E4M6TN0uXaja1Tx5GtHDpYRoDdlgS%2fmbGWZqEa0AR%2fPYaH6OQe8jFKM1q%2bOrq%2b6p44Q2xXUuRFb2PN%2bGN5ftNbln6EqRgNPDJgXDJbryHbJmOKJoJ5ocxApTm9jZBPofnwHkZvu%2bAAi1oBXTt6XRDXp3wijkRKZh7dwZH3pGMxdRP6QxW4QJhlMbDNTr4twWAr4tIozibowZTUza2kuJPM1IyG6biJkBKoBrjypNWQOSJ40akxr0nMKrN%2fA0ac0GN%2f37u2clJj4MKveA0lcDJ4z5Kao&mkabId=0&dvtId=0&docPrvdId=1239&MisUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration&ReturnUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration%2fMain%2fDefault";
    public static String CALLDOCTOR_URL = "http://service.emias.mosreg.ru/demo/call-doctor/board;docprvdid=1239?ticket=892hJ4D5%2fh7YSK687rMnhjktSYivom5%2fh4RynHYnkypzFGqTrNMqHzxndlQYO7UwCEcJYvn%2bA6WY%2fryHmifox0ek0QRvsYC9G%2b2%2bVhXbsmDMuqZpDgpALTwB8SCfjrcMuKt4BlLMTYVllviNhYhxT333Xly6h8ut6UuyXDhMFH710Thr3kOb9FnaS4IO65biOSXCdbNOFW6CQYsyBCWBA1CabRYhio5O90tB%2b5zHwzktR6jODkUmJjXYbYtUDhQhOgu2p2EGQOnIOTDE99ym%2fA1naEqKiXQwA52oD3GKyfRxgMiy";
    public static String CALLDOCTOR_TEMNIKOV_URL = "http://service.emias.mosreg.ru/demo/call-doctor/board;docprvdid=1239?ticket=892hJ4D5%2fh7YSK687rMnhjktSYivom5%2fh4RynHYnkypzFGqTrNMqHzxndlQYO7UwCEcJYvn%2bA6WY%2fryHmifox0ek0QRvsYC9G%2b2%2bVhXbsmDMuqZpDgpALTwB8SCfjrcMuKt4BlLMTYVllviNhYhxT333Xly6h8ut6UuyXDhMFH710Thr3kOb9FnaS4IO65biOSXCdbNOFW6CQYsyBCWBA1CabRYhio5O90tB%2b5zHwzktR6jODkUmJjXYbYtUDhQhOgu2p2EGQOnIOTDE99ym%2fA1naEqKiXQwA52oD3GKyfRxgMiy";
    public static String CALLDOCTOR_ADMIN_URL = "http://service.emias.mosreg.ru/demo/call-doctor/board;docprvdid=1303?ticket=ALsZnQD8yyO4vuarKGOgWqbmZA6JZqh1LzoJpD7%2BVBoddVYVq%2BOi63EkZf1zhjOBL9ldCtJNbUc3PqB4bJGvXdWXJtswpKlbvGGtceybMZJJZx2ClZOb1OOd8BNTMJcLY3s9UDHPTVTMRLqmFLUKwMI%2Fb0sf5sqisyd9k8oXySbTlA5Nz36KZFQFjY7f%2FANfItbuWdVoc%2B%2FfnDrmPPymQYYN8QbpCn4sPixtMmeScYZewlDrapWie6ZgvUhnJOg2UK51HhgsZhxOlAp9%2Bp6c7G8VaT89LAetCemJL51uxozXTljN&ReturnUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration%2FMain%2FDefault";

    @Step("Захожу в диспетчер через МИС под temnikov")
    public Enter enterCalldoctorFromMis() {
        if (use_url != null && use_url.equals("false")) {
            page.loginPage().login(site, login, pass);
            page.homePageMis().callDoctorBtn();
            switchTo().window(1);
        } else {
            LOGGER.info("Открываю только модуль диспетчер по ссылке:\n" + CALLDOCTOR_TEMNIKOV_URL);
            open(CALLDOCTOR_TEMNIKOV_URL);
        }
        return this;
    }

    @Step("Захожу в диспетчер через МИС под админом")
    public Enter enterCalldoctorFromMis_Admin() {
        if (use_url != null && use_url.equals("false")) {
            page.loginPage().loginAdmin();
            page.homePageMis().callDoctorBtn();
            switchTo().window("Медицинская Информационная Система");
        } else {
            LOGGER.info("Открываю только модуль диспетчер по ссылке:\n" + CALLDOCTOR_ADMIN_URL);
            open(CALLDOCTOR_ADMIN_URL);
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
    public Enter enterDispJournalFromMis() throws InterruptedException {
        if (use_url != null && use_url.equals("false")) {
            page.loginPage().login(site, login, pass);
            page.homePageMis().dispCardJournalBtn();
            switchTo().window("Медицинская Информационная Система");
        } else {
            LOGGER.info("Открываю только журнал модуля диспансеризация по ссылке:\n" + DISP_JOURNAL_URL);
            open(DISP_JOURNAL_URL);
        }
        return this;
    }
}