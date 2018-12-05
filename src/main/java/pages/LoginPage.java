package pages;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends AbstractPage {
    public LoginPage() {
    }

    public void login(String site, String login, String pass) {
        if (site == null) {
            open("http://emias.mosreg.ru/demonstration");
            setCookieOfDepartment();
            $(By.id("Login")).setValue("temnikov");
            $(By.id("Password")).setValue("1214");
        } else {
            open(site);
            setCookieOfDepartment();
            $(By.id("Login")).setValue(login);
            $(By.id("Password")).setValue(pass);
        }
        $(By.id("loginBtn")).click();
    }

    public void loginAdmin() {
        open("http://emias.mosreg.ru/demonstration/");
        $(By.id("Login")).setValue("admin");
        $(By.id("Password")).setValue("RChS2014");
        $(By.id("loginBtn")).click();
    }

    public void login(String login, String pass) {
        setCookieOfDepartment();
        $(By.id("Login")).setValue(login);
        $(By.id("Password")).setValue(pass);
        $(By.id("loginBtn")).click();
    }

    public void setCookieOfDepartment() {
        String name = "__cp354";
        String value = "1239";
        Cookie department = new Cookie(name, value);
        WebDriverRunner.getWebDriver().manage().addCookie(department);
    }
}