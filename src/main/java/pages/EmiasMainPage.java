package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmiasMainPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@id='Portlet_6']/div[2]/div/a/span")
    WebElement callDoctorButton;

    public EmiasMainPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);
        PageFactory.initElements(webDriver, this);
    }

    public void clickCallDoctorButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(callDoctorButton));
        Thread.sleep(3000);
        System.out.println("click callDoctorButton");
        callDoctorButton.click();
    }

    //БЛОК УПРАВЛЕНИЕ ПОТОКАМИ ПАЦИЕНТОВ
    public void raspisaniePriema(){

    }

    public void vedenieRaspisaniya(){

    }

    public void listiOzhidaniya(){

    }

    public void medicalCardsUprPotok(){

    }

    public void perenosZapisey(){

    }

    public void vipiskaNapravleniy(){

    }

    //БЛОК МЕДИЦИНСКИЕ КАРТЫ
    public void medicalCardsMedCard(){

    }

    public void zhurnalZayavleniy(){

    }

    //БЛОК НОРМАТИВНО-СПРАВОЧНАЯ ИНФОРМАЦИЯ
    public void normativnoSpravochnayaInfo(){

    }

    //БЛОК УЧЕТ ВРЕМЕННОЙ НЕТРУДОСПОСОБНОСТИ
    public void uchetListkovNetrudospsobnosti(){

    }

    //БЛОК СВИДЕТЕЛЬСТВА О СМЕРТИ
    public void uchetSpravokOsmerti(){

    }

    public void uchetUmershih(){

    }

    //БЛОК РЕЦЕПТЫ
    public void federalniyRecept(){

    }

    public void regionalniyRecept(){

    }

    //БЛОК АНАЛИТИКА И СТАТИСТИКА
    public void systemnieOtcheti(){

    }

    public void otchetiHtml(){

    }

    //БЛОК ЛАБОРАТОРНЫЕ ИССЛЕДОВАНИЯ
    public void napravleniyaNaIssledovaniya(){

    }

    //БЛОК УЧЕТ БЕРЕМЕННЫХ
    public void uchetBeremennih(){

    }
}
