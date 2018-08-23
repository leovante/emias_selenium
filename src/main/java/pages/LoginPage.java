package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

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
        setCookieOfDepartment();
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

    public void clickLoginButton() {
        loginButton.click();
    }

    public void changeDepartment() {
        $(By.id("curuserinfo")).click();
        $(By.id("postsradio")).$(By.xpath("*[local-name()='Стенд ЕМИАС МО']")).click();
//        $(By.id("postsradio")).$(By.xpath("*[contains(text(),'Подразделение: ')]/following::text()[1]")).click();
//  <div class="lessthanhalf" >
//  <h4> Listing</h4>
//  <strong style="background: rgb(204, 136, 136); border: 2px solid red;">Load #:</strong>
//                262567
//                <br>
//  <strong style="background: rgb(204, 136, 136); border: 2px solid red;">Date Listed:</strong>
//                12/14/2017
//                <br>

        //div[@class='lessthanhalf']/strong[contains(text(),'Load')]‌​/following::text()[1‌​]
//        $(By.id("postsradio")).$(By.xpath("*[contains(.,'Стенд ЕМИАС МО')]")).click();
        $(By.xpath("//*[contains(text(),'ui-dialog-title-postsradio')]")).$(By.xpath("*[contains(text(),'Выбрать')]")).click();
    }

    public void setCookieOfDepartment() {
        String name = "__cp354";
        String value = "1239";
        Cookie department = new Cookie(name, value);
        WebDriverRunner.getWebDriver().manage().addCookie(department);

        /*example
        Cookie ck = new Cookie("4langcookie", "en");
        WebDriverRunner.getWebDriver().manage().addCookie(ck);
        open("http://www.test.com");
         */
    }
}