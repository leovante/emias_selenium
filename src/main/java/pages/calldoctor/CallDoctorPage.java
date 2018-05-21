package pages.calldoctor;

        import org.openqa.selenium.*;
        import org.openqa.selenium.interactions.Actions;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.ui.ExpectedCondition;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.Assert;
        import pages.BasePage;
        import pages.utilities.JSWaiter;

        import java.util.ArrayList;
        import java.util.List;

        import static org.testng.AssertJUnit.assertTrue;


public class CallDoctorPage extends BasePage {

    @FindBy(xpath = "//button[@id='btn_delete']/span[2]")
    WebElement deleteShedule;

    @FindBy(xpath = "//div[@class='autocomplete-list-container'")
    WebElement containerKladr;

    public CallDoctorPage(WebDriver driver) {
        super(driver);
    }

    public void createCallOtRegistratura() throws InterruptedException {
        Actions action = new Actions(driver);
        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));

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
//        telephoneNumber.sendKeys("+79511582714");

////        telephoneNumber.sendKeys("9511582714");
        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("arguments[0].value='+79511582714';", telephoneNumber);
//        action.sendKeys(Keys.getKeyFromUnicode('\uE01A'));
        telephoneNumber.click();
//        action.sendKeys("9511582714");
        action.sendKeys(Keys.ENTER);

        WebElement chkBox = driver.findElement(By.xpath("//mat-checkbox[@id='mat-checkbox-1']/label/div"));
        wait.until(ExpectedConditions.elementToBeClickable(chkBox));
        chkBox.click();

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
//        zhaloba.sendKeys("автотест");

//        WebElement wb = driver.findElement(By.name("phone"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='автотест';", zhaloba);
//        jse.executeScript("document.getElementById('ssn').value='555-55-5555';");
        zhaloba.sendKeys(Keys.SPACE);
        action.sendKeys(Keys.ENTER).perform();

/*кто пациент*/
        WebElement seriyaPol = driver.findElement(By.xpath("//input[@placeholder='Серия']"));
        wait.until(ExpectedConditions.elementToBeClickable(seriyaPol));
        seriyaPol.sendKeys("111111");

        WebElement nomerPol = driver.findElement(By.xpath("//input[@placeholder='Номер полиса']"));
        wait.until(ExpectedConditions.elementToBeClickable(nomerPol));
        nomerPol.sendKeys("222222");

        WebElement fam = driver.findElement(By.xpath("//input[@placeholder='Фамилия']"));
        wait.until(ExpectedConditions.elementToBeClickable(fam));
        fam.sendKeys("Автотемников");

        WebElement name = driver.findElement(By.xpath("//input[@placeholder='Имя']"));
        wait.until(ExpectedConditions.elementToBeClickable(name));
        name.sendKeys("Автодмитрий");

        WebElement otchestvo = driver.findElement(By.xpath("//input[@placeholder='Отчество']"));
        wait.until(ExpectedConditions.elementToBeClickable(otchestvo));
        otchestvo.sendKeys("Автоолегович");
/*кто вызывает*/
        WebElement tipVisivaushego = driver.findElement(By.xpath("//input[@placeholder='Тип вызывающего']"));
        wait.until(ExpectedConditions.elementToBeClickable(tipVisivaushego));
        tipVisivaushego.click();

        WebElement pacient = driver.findElement(By.xpath("//span[contains(.,'Пациент')]"));
        wait.until(ExpectedConditions.elementToBeClickable(pacient));
        pacient.click();

//        WebElement hz3 = driver.findElement(By.xpath("//button/span/span"));
//        WebElement hz3 = driver.findElement(By.xpath("//div/div/button[2]/span/span[contains(text(),'Сохранить')]"));
//        WebElement saveBtns = driver.findElement(By.xpath("//span[contains(text(),'Сохранить')]"));
        WebElement saveBtns = driver.findElement(By.xpath("//button[3]/span/span"));
        saveBtns.click();
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

    public void verifyCreateCall() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Подробно о вызове')]")));


        WebElement adress = driver.findElement(By
                .xpath("//span[contains(text(),'Московская обл., г. Коломна, ул. Первомайская, д.1, стр.3, корп.2, кв.4')]"));
        wait.until(ExpectedConditions.elementToBeClickable(adress));

        WebElement registr = driver.findElement(By.xpath("//span[contains(text(),'Регистратура')]"));
        wait.until(ExpectedConditions.elementToBeClickable(registr));

        WebElement family = driver.findElement(By.xpath("//span[contains(text(),'Автотемников')]"));
        wait.until(ExpectedConditions.elementToBeClickable(family));

        WebElement name = driver.findElement(By.xpath("//span[contains(text(),'Автодмитрий')]"));
        wait.until(ExpectedConditions.elementToBeClickable(name));

        WebElement otchestvo = driver.findElement(By.xpath("//span[contains(text(),'Автоолегович')]"));
        wait.until(ExpectedConditions.elementToBeClickable(otchestvo));

        WebElement vozrastKat = driver.findElement(By.xpath("//span[contains(text(),'Взрослый')]"));
        wait.until(ExpectedConditions.elementToBeClickable(vozrastKat));

        WebElement polis = driver.findElement(By.xpath("//span[contains(text(),'111111')]"));
        wait.until(ExpectedConditions.elementToBeClickable(polis));

        WebElement polis2 = driver.findElement(By.xpath("//span[contains(text(),'222222')]"));
        wait.until(ExpectedConditions.elementToBeClickable(polis2));

        WebElement pacient = driver.findElement(By.xpath("//span[contains(text(),'Пациент')]"));
        wait.until(ExpectedConditions.elementToBeClickable(pacient));

        WebElement kartaSozdana = driver.findElement(By.xpath("//span[contains(text(),'Карта создана')]"));
        wait.until(ExpectedConditions.elementToBeClickable(kartaSozdana));

        WebElement data = driver.findElement(By.xpath("//span[contains(text(),'ДАТА')]"));
        wait.until(ExpectedConditions.elementToBeClickable(data));

        WebElement autor = driver.findElement(By.xpath("//span[contains(text(),'АВТОР')]"));
        wait.until(ExpectedConditions.elementToBeClickable(autor));

        WebElement chtoIzmen = driver.findElement(By.xpath("//span[contains(text(),'ЧТО ИЗМЕНИЛОСЬ')]"));
        wait.until(ExpectedConditions.elementToBeClickable(chtoIzmen));

        WebElement izmenenie = driver.findElement(By.xpath("//span[contains(text(),'ИЗМЕНЕНИЕ')]"));
        wait.until(ExpectedConditions.elementToBeClickable(izmenenie));
    }

    public void cancelRecord() {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Подробно о вызове')]")));

        WebElement cancelBtns = driver.findElement(By.xpath("//span[contains(text(),'Отменить вызов')]"));
        wait.until(ExpectedConditions.elementToBeClickable(cancelBtns));
        cancelBtns.click();

        WebElement cancelField = driver.findElement(By.xpath("//input[@placeholder='Причина отмены вызова']"));
        wait.until(ExpectedConditions.elementToBeClickable(cancelField));
        cancelField.sendKeys("отмена автотест");

        WebElement cancelFieldBtn = driver.findElement(By.xpath("//a[@title='Отменить вызов']"));
        wait.until(ExpectedConditions.elementToBeClickable(cancelFieldBtn));
        cancelFieldBtn.click();
    }

    public void verifyCancelOnDashbord() {
        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button")));

        WebElement waitOperationFrame = driver.findElement(By.xpath("//span[contains(text(),'Ожидают обработки')]"));
        assertTrue("Фрейм 'Ожидают обработки' - не найден", waitOperationFrame.isDisplayed() == false);

/*
        WebElement waitOperation = driver.findElement(By.xpath("//span[contains(text(),'Ожидают обработки')]"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
                .xpath("//span[contains(text(),'Ожидают обработки')]")));
        waitOperation.click();
*/

/*
        WebElement close = driver.findElement(By.xpath("//img[@src='assets/img/close.png']"));
        wait.until(ExpectedConditions.elementToBeClickable(close));
        close.click();

        WebElement podrobnoOVizove = driver.findElement(By.xpath("//div[contains(text(),'Подробно о вызове')]"));
        wait.until(ExpectedConditions.visibilityOfAllElements(podrobnoOVizove));
*/

    }

    public void verifyFullPageBtn() {
        WebElement cancelBtns = driver.findElement(By.xpath("//span[contains(text(),'Изменить')]"));
        cancelBtns.click();

        WebElement editRecord = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Редактирование вызова')]")));

        WebElement saveBtns = driver.findElement(By.xpath("//button[4]/span"));
        saveBtns.click();
    }
}