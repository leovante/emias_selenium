package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Pages;

public class CallDoctor {
    private WebDriver webDriver;
    Steps step;
    Pages website;

    public CallDoctor(WebDriver driver) {
        webDriver = driver;
        website = new Pages(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void createCall() throws InterruptedException {
//        website.mainPage().callDoctorBtn();
//        website.callDoctorPage().switchToPage();
        webDriver.get("http://109.95.224.42:2165/test/call/call_doctor_ui/call-doctor;6628/board?ticket=rIjLfkzppVn535yZNj87yX%2bn%2flsaAQCvx%2f6oVgRslUhRxpjtjkE3e1xmu%2b8Oy5eSmWXcfaQ8A4Gz00wHkDVLg126daSKZsclYDKgmDUflgln66XRS1YyCvKTwov6E76m2wSPN4ptJ2Z7eSG9Bst2%2b5Vuf9Y2YzqosTC8TSyL%2fQO3JxsTQx%2bqj2IjwDOrVErC9uWF49Nhzrhud0t6pIU2UmFN1W5oi3ZSbkAzDm2wXAJtWumTCvZDVahRTQaxk8oJrXfyf3jSpJtCpMKxSY9WqRm1yDE2U4csJGEvp%2faas6WNWzF2&ReturnUrl=http%3a%2f%2fmis.softrust.ru%2fwhc%2fMain%2fDefault");
        website.callDoctorPage().createCall();
    }
}
