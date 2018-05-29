package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "Login")
    WebElement loginInputField;

    @FindBy(id = "Password")
    WebElement passInputField;

    @FindBy(id = "loginBtn")
    WebElement loginButton;


    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void login(){
        driver.get("http://emias.mosreg.ru/demonstration");
        enterLoginText("temnikov");
        enterPasswordText("1212");
        clickLoginButton();

//        switch () {
//                case 1:
//                webDriver.get("http://emias.mosreg.ru/mis/test_emias");
//                website.loginPage().enterLoginText("seleniumAdmin");
//                website.loginPage().enterPasswordText("1212");
//                break;
//                case 2:
//                webDriver.get("http://mis.softrust.ru/whc/Home");
//                website.loginPage().enterLoginText("admin");
//                website.loginPage().enterPasswordText("11");
//                break;
//                case 3:
//                webDriver.get("http://emias.mosreg.ru/mis/test_emias");
//                website.loginPage().enterLoginText("seleniumDoctor");
//                website.loginPage().enterPasswordText("1");
//                break;
//                }
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


}


//    @FindBy(how = How.XPATH, using = "//a[contains(.,'İŞVEREN')]")
//    public WebElement recruiter;
//
//    @FindBy(how = How.XPATH, using = "//a[contains(.,'ÜYE GİRİŞİ')]")
//    public WebElement loginButton;
//
//    public void closePopupIfExists () throws InterruptedException {handlePopup(By.cssSelector(".ui-dialog-titlebar-close"));}
//
//    public void openHomePage (){
//        driver.navigate().to("http://www.kariyer.net/");
//    }
//
//    public void printTitle() {
//        System.out.println("Page title is: " + driver.getTitle());
//    }
//
//    public void clickLogin () {click(loginButton);}
