package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends AbstractPage {

    SelenideElement loginInputField = $(By.id("Login"));
    SelenideElement passInputField = $(By.id("Password"));
    SelenideElement loginButton = $(By.id("loginBtn"));

    public LoginPage() {
    }

    public void login(String site, String login, String pass) {
        open(site);
        $(By.id("Login")).setValue(login);
        $(By.id("Password")).setValue(pass);
        $(By.id("loginBtn")).click();
    }

    public void enterLoginText(String text) {
        loginInputField.clear();
        loginInputField.sendKeys(text);
    }

    public void enterPasswordText(String text) {
        passInputField.clear();
        passInputField.sendKeys(text);
    }

    public void defaultSetting() {
        $(By.id("curuserinfo")).click();
        $(By.id("postsradio")).$(By.xpath("*[contains(.,'Стенд ЕМИАС МО')]")).click();
        $(By.xpath("//*[contains(text(),'ui-dialog-title-postsradio')]")).$(By.xpath("*[contains(text(),'Выбрать')]")).click();
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}