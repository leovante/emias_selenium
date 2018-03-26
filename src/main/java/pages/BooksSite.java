package pages;

import org.openqa.selenium.WebDriver;

public class BooksSite {
    WebDriver webDriver;

    public LoginPage loginPage() {return new LoginPage(webDriver);}

    /*public BooksSite(WebDriver driver) {
        webDriver = driver;
    }

    public MainPage mainPage() {
        return new MainPage(webDriver);
    }

    public SearchResultsPage searchResultsPage(){
        return new SearchResultsPage(webDriver);
    }

    public BookInfoPage bookinfoPage(){return new BookInfoPage();}
    */

}
