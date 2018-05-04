package pages.shedule;


import org.antlr.stringtemplate.language.Expr;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Pages;
import pages.WaitAll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdmissionSchedule {
    private WebDriver webDriver;
    Pages website;
    private WebDriverWait wait;
    WaitAll waitAll;

    @FindBy(xpath = "//div[@id='schedule']/div/div/div/div[3]/div")
    WebElement RecordsArea;

    @FindBy(xpath = "//button[@id='selectPatientButton']/span")
    WebElement selectPatientButton;

    @FindBy(xpath = "//button[@id='{2}']/span")
    WebElement pervichniy;

    @FindBy(xpath = "//table[@id='mkabgrid1']/tbody/tr[2]/td[3]")
    WebElement hernya;

    @FindBy(xpath = "//div[@style='background-color:#508132;border-color:#508132;color:#FFFFFF']")
    WebElement recordElement;

    @FindBy(xpath = "//tr[@role='row'][@tabindex='-1']")
    WebElement doctorRow;

    public AdmissionSchedule(WebDriver driver) {
        webDriver = driver;
        website = new Pages(webDriver);
        wait = new WebDriverWait(webDriver, 60);
        waitAll = new WaitAll(webDriver);
        PageFactory.initElements(webDriver, this);
    }

//    выбрать первого врача
//    найти новую запись - прием по очереди и создать запись пациента

/*
    public void selectDoctor(String doctorInlet) {
        wait.until(ExpectedConditions
                .elementToBeClickable(webDriver.findElement(By.xpath("/*/
/*[contains(text(),'" + doctorInlet + "')]"))));
        webDriver.findElement(By.xpath("/*/
/*[contains(text(),'" + doctorInlet + "')]")).click();
    }
*/

    public void createRecord() throws InterruptedException {
        waitAll.waitBlock();
        wait.until(ExpectedConditions.elementToBeClickable(RecordsArea));
        waitAll.waitBlock();
        String first_doctor_fullname = website.admissionSchedule().getUnicalDoctor(null);
        website.manageShedule().selectDoctor(first_doctor_fullname);
        WebElement task = RecordsArea.findElement(By.xpath("//div[@style='background-color:#508132;border-color:#508132;color:#FFFFFF']"));
        wait.until(ExpectedConditions.elementToBeClickable(task));
        task.click();

        wait.until(ExpectedConditions.elementToBeClickable(hernya));
        Actions action = new Actions(webDriver);
        action.sendKeys(Keys.ENTER).perform();
        hernya.click();
        wait.until(ExpectedConditions.elementToBeClickable(selectPatientButton));
        selectPatientButton.click();//выбрать
        wait.until(ExpectedConditions.elementToBeClickable(pervichniy));
        pervichniy.click();//первичный
    }


    public void verifyCreatedRecord() {
        waitAll.waitBlock();
        webDriver.findElement(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div"))//поле с заявками
                .findElement(By.xpath("//div[@style='background-color:#DB3F23;border-color:#DB3F23;color:#FFFFFF']"));
        //тут нужно сделать ассертТруе
    }

    public String getUnicalDoctor(String docName) {
        waitAll();
        waitWhileClickable(doctorRow);
        List<String> dontUseNames = new ArrayList<String>();
        Collections.addAll(dontUseNames, "Ай Бо Лит", "Ар Ти Шок", "test test testovych", "null");
        dontUseNames.add(docName);

        System.out.println(dontUseNames);

        waitAll();

        //String doctorNameNull = doctorName;
        String doctorStringName = docName;

        List<WebElement> doctorList = webDriver
                .findElement(By.xpath("//table[@id='docprvdgrid1']/tbody"))//наашел таблицу
                .findElements(By.xpath("tr[@role='row'][@tabindex='-1']/td[3]/div/span[1]"));//нашел строки врачей

        for (WebElement doctor : doctorList) {
            int count = 0;
            doctorStringName = doctor.getText();
            //System.out.println("Первый список: " + doctorStringName + " " + count);

            for (WebElement doctorCount : doctorList) {
                String doctorStringName2 = doctorCount.getText();
                //System.out.println("Второй список: " + doctorStringName2 + " " + count);

                if (doctorStringName.equals(doctorStringName2))
                    count++;
                if (count > 1)
                    break;
            }

            if (count == 1 && !dontUseNames.contains(doctorStringName))
                break;
        }
        dontUseNames.add(doctorStringName);//чот не срабатывает
        return doctorStringName;
    }


    public boolean waitAll() {
        boolean BlockAssert = !webDriver.findElements(By.xpath("//div[@class='blockUI blockOverlay']")).isEmpty();
        if (BlockAssert) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.xpath("//div[@class='blockUI blockOverlay']"))));
        }
        boolean WidgetAssert = !webDriver.findElements(By.xpath("//div[@class='ui-widget-overlay']")).isEmpty();
        if (WidgetAssert) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.xpath("//div[@class='ui-widget-overlay']"))));
        }
        boolean loaderLeftSpacer = !webDriver.findElements(By.id("loaderleftspacer")).isEmpty();
        if (loaderLeftSpacer) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.id("loaderleftspacer"))));
        }
        return BlockAssert;
    }


    public void waitWhileClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
