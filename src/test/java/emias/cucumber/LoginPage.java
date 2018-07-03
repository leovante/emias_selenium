package emias.cucumber;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @NameOfElement("Логин")
    @FindBy(id = "Login")
    public SelenideElement login;

    @NameOfElement("Пароль")
    @FindBy(id = "Password")
    public SelenideElement password;

    @NameOfElement("Войти")
    @FindBy(id = "loginBtn")
    public SelenideElement enter;


//    @NameOfElement("Фрейм входа в кабинет")
//    @FindBy(css = ".modal-content")
//    public SelenideElement frameEnterToCabinet;
//
//    @NameOfElement("Укажите страну")
//    @FindBy(css = "#countryInput")
//    public SelenideElement countryInput;
//
//    @NameOfElement("Даты поездки")
//    @FindBy(css = "#preview")
//    public SelenideElement datesJourney;
//
//    @NameOfElement("Выпадающий календарь")
//    @FindBy(css = ".period-control-popup")
//    public SelenideElement popupCalendar;
//
//    @NameOfElement("Кто едет")
//    @FindBy(xpath = ".//*[.='Кто едет']")
//    public SelenideElement whoIsTravel;
//
//    @NameOfElement("дд.мм.гггг")
//    @FindBy(xpath = ".//input[@placeholder='дд.мм.гггг']")
//    public SelenideElement travelerBirthDate;
//
//    @NameOfElement("Рассчитать полис")
//    @FindBy(xpath = "//button[.='Рассчитать полис']")
//    public SelenideElement polisCount;

//    public void clickAnyAvailableDate()
//    {
//        popupCalendar.$(xpath("(./div[1]/button)[2]")).click();
//        popupCalendar.$("span[data-ng-click]").click();
//        popupCalendar.$("span[data-ng-click]").click();
//    }
}
