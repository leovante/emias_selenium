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
        open(site);
        setCookieOfDepartment();
        $(By.id("Login")).setValue(login);
        $(By.id("Password")).setValue(pass);
        $(By.id("loginBtn")).click();
    }

    public void loginDefault(String site, String login, String pass) {
        open(site);
        $(By.id("Login")).setValue(login);
        $(By.id("Password")).setValue(pass);
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