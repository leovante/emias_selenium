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

    public void openLoginPage(){

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
