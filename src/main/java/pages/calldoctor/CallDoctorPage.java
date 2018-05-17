package pages.calldoctor;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.utilities.JSWaiter;
import pages.Pages;

import java.util.ArrayList;


public class CallDoctorPage extends BasePage {

    @FindBy(xpath = "//button[@id='btn_delete']/span[2]")
    WebElement deleteShedule;

    @FindBy(xpath = "//div[@class='autocomplete-list-container'")
    WebElement containerKladr;

    public CallDoctorPage(WebDriver driver) {
        super(driver);
        //wait = new WebDriverWait(webDriver, 60);
    }

    public void createCallOtRegistratura() throws InterruptedException {
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button")));
        driver.findElement(By.xpath("//button")).click();
/*адрес*/
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("mat-input-23")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span/mat-icon")));
        driver.findElement(By.xpath("//span/mat-icon")).click();

        driver.findElement(By.id("mat-input-23")).sendKeys("Московская");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='autocomplete-list-container']/ul/li")));
        JSWaiter.waitJQueryAngular();
        WebElement mosObl = driver.findElement(By.xpath("//div[@class='autocomplete-list-container']/ul/li"));
        click(mosObl);

        driver.findElement(By.id("mat-input-23")).sendKeys("Коломна");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='autocomplete-list-container']/ul/li")));
        JSWaiter.waitJQueryAngular();
        WebElement kolomna = driver.findElement(By.xpath("//div[@class='autocomplete-list-container']/ul/li"));
        click(kolomna);

        driver.findElement(By.id("mat-input-23")).sendKeys("Первомайская");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='autocomplete-list-container']/ul/li")));
        JSWaiter.waitJQueryAngular();
        WebElement pervomay = driver.findElement(By.xpath("//div[@class='autocomplete-list-container']/ul/li"));
        click(pervomay);
/*обязательные поля*/
        WebElement dom = driver.findElement(By.xpath("//input[@placeholder='Дом']"));
        wait.until(ExpectedConditions.elementToBeClickable(dom));
        dom.sendKeys("1");

        WebElement telephoneNumber = driver.findElement(By.id("phone"));
        wait.until(ExpectedConditions.elementToBeClickable(telephoneNumber));
        telephoneNumber.sendKeys("9511582714");

//        WebElement chkBox = driver.findElement(By.xpath("//mat-checkbox[@id='mat-checkbox-1']/label/div"));
//        wait.until(ExpectedConditions.elementToBeClickable(chkBox));
//        chkBox.click();


        WebElement hz = driver.findElement(By.xpath("//button[2]/span/mat-icon"));
        wait.until(ExpectedConditions.elementToBeClickable(hz));
        hz.click();

        WebElement hz2 = driver.findElement(By.xpath("//span[contains(.,'Взрослый')]"));
        wait.until(ExpectedConditions.elementToBeClickable(hz2));
        hz2.click();
/*--------*/
        WebElement korpus = driver.findElement(By.xpath("//input[@placeholder='Корпус']"));
        wait.until(ExpectedConditions.elementToBeClickable(korpus));
        korpus.sendKeys("2");

        WebElement stroenie = driver.findElement(By.xpath("//input[@placeholder='Строение']"));
        wait.until(ExpectedConditions.elementToBeClickable(stroenie));
        stroenie.sendKeys("3");

        WebElement kvartira = driver.findElement(By.xpath("//input[@placeholder='Квартира']"));
        wait.until(ExpectedConditions.elementToBeClickable(kvartira));
        kvartira.sendKeys("4");

        WebElement pd = driver.findElement(By.xpath("//input[@placeholder='П-д']"));
        wait.until(ExpectedConditions.elementToBeClickable(pd));
        pd.sendKeys("5");

        WebElement dfon = driver.findElement(By.xpath("//input[@placeholder='Д-фон']"));
        wait.until(ExpectedConditions.elementToBeClickable(dfon));
        dfon.sendKeys("6");

        WebElement etazh = driver.findElement(By.xpath("//input[@placeholder='Этаж']"));
        wait.until(ExpectedConditions.elementToBeClickable(etazh));
        etazh.sendKeys("7");
/*жалоба*/
        WebElement zhaloba = driver.findElement(By.xpath("//input[@aria-label='Введите текст жалобы']"));
        wait.until(ExpectedConditions.elementToBeClickable(zhaloba));
        zhaloba.sendKeys("автотест");
        //action.sendKeys(Keys.TAB).perform();
/*кто пациент*/
        WebElement seriyaPol = driver.findElement(By.xpath("//input[@placeholder='Серия']"));
        wait.until(ExpectedConditions.elementToBeClickable(seriyaPol));
        seriyaPol.sendKeys("111111");

        WebElement nomerPol = driver.findElement(By.xpath("//input[@placeholder='Номер полиса']"));
        wait.until(ExpectedConditions.elementToBeClickable(nomerPol));
        nomerPol.sendKeys("222222");

        WebElement fam = driver.findElement(By.xpath("//input[@placeholder='Фамилия']"));
        wait.until(ExpectedConditions.elementToBeClickable(fam));
        fam.sendKeys("Темников");

        WebElement name = driver.findElement(By.xpath("//input[@placeholder='Имя']"));
        wait.until(ExpectedConditions.elementToBeClickable(name));
        name.sendKeys("Дмитрий");

        WebElement otchestvo = driver.findElement(By.xpath("//input[@placeholder='Отчество']"));
        wait.until(ExpectedConditions.elementToBeClickable(otchestvo));
        otchestvo.sendKeys("Олегович");
        /*кто вызывает*/
        WebElement tipVisivaushego = driver.findElement(By.xpath("//input[@placeholder='Тип вызывающего']"));
        wait.until(ExpectedConditions.elementToBeClickable(tipVisivaushego));
        tipVisivaushego.click();


        WebElement pacient = driver.findElement(By.xpath("//span[contains(.,'Пациент')]"));
        wait.until(ExpectedConditions.elementToBeClickable(pacient));
        pacient.click();

//        WebElement hz3 = driver.findElement(By.xpath("//button[3]/span/span"));
//        WebElement hz3 = driver.findElement(By.xpath("//div/div/button[2]/span/span[contains(text(),'Сохранить')]"));
        WebElement hz3 = driver.findElement(By.xpath("//*[matches(text(),'(^|\\W)Сохранить($|\\W)','i')]"));
        wait.until(ExpectedConditions.elementToBeClickable(hz3));
        hz3.click();
    }

    public void switchToPage() {
        String mainWindowHandle = driver.getWindowHandle();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getTitle());

//        for (String win : tabs) {
//            driver.switchTo().window(win);
//            // other operation
//            System.out.println(driver.getTitle());
//        }
// //back to old window
//        driver.switchTo().window(mainWindowHandle);
//        System.out.println(driver.getTitle());
    }

    public void verifyCreateCall() {


    }
}
