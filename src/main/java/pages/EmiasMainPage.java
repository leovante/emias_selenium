package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    @FindBy(id = "loaderleftspacer")
    WebElement spiner;

    public EmiasMainPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void clickCallDoctorButton() throws InterruptedException {
        //wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.id("loaderleftspacer")))); не работает
        //wait.until(ExpectedConditions.stalenessOf(spiner));
        if (!webDriver.findElements(By.id("loaderleftspacer")).isEmpty()) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.id("loaderleftspacer"))));
        } else {
        }
//        wait.until(ExpectedConditions.elementToBeClickable(callDoctorButton));
//        wait.until(ExpectedConditions.elementToBeClickable(callDoctorButton));
//        wait.until(ExpectedConditions.visibilityOf(callDoctorButton));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='Portlet_6']/div[2]/div/a/span")));
//        wait.until(ExpectedConditions.textToBePresentInElement(By.xpath("//div[@id='Portlet_6']/div[2]/div/a/span"), "Вызов врача на дом"));
        //Thread.sleep(5000);
        System.out.println("click callDoctorButton");

        WebElement myelement = webDriver.findElement(By.xpath("//div[@id='Portlet_6']/div[2]/div/a/span"));
        JavascriptExecutor jse2 = (JavascriptExecutor)webDriver;
        jse2.executeScript("arguments[0].scrollIntoView()", myelement);

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
