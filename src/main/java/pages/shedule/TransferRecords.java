package pages.shedule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransferRecords {
    private WebDriver webDriver;
    private WebDriverWait wait;


    @FindBy(xpath = "//tr[@role='row'][@tabindex='-1']")
    WebElement doctorRow;


    public TransferRecords(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void clickDoctor() {


        webDriver.findElement(By.xpath("//div[@id='Portlet_2']/div[2]/div[5]/a/span")).click();
        webDriver.findElement(By.xpath("//tr[@id='345']/td[3]/div/span[2]")).click();
        webDriver.findElement(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div/div[2]/div/div/div")).click();
        webDriver.findElement(By.xpath("//button[@id='btn_transfer']/span[2]")).click();
        webDriver.findElement(By.xpath("//button[@id='btn_transfer_schedule']/span")).click();
        webDriver.findElement(By.xpath("(//tr[@id='345']/td[2])[2]")).click();
        webDriver.findElement(By.xpath("//tr[@id='1521261']/td[6]")).click();
        webDriver.findElement(By.xpath("//tr[@id='1521261']/td[6]")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | //tr[@id='1521261']/td[6] | ]]
        webDriver.findElement(By.xpath("//tr[@id='1521261']/td[7]")).click();
        webDriver.findElement(By.xpath("(//a[contains(text(),'Перенести запись')])[3]")).click();
        webDriver.findElement(By.xpath("//tr[@id='345']/td[2]/div")).click();
        webDriver.findElement(By.xpath("//tr[@id='4416']/td[2]/div/span[2]")).click();
        webDriver.findElement(By.xpath("//tr[@id='2624849']/td[2]")).click();
        webDriver.findElement(By.xpath("//button[@id='btn_transfer_collision']/span")).click();
        webDriver.findElement(By.xpath("//div[25]/div[3]/div/button/span")).click();
        webDriver.findElement(By.xpath("//tr[@id='345']/td[3]/div")).click();
        webDriver.findElement(By.xpath("//tr[@id='4416']/td[3]/div/span[2]")).click();
        webDriver.findElement(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div/div[2]/div/div/div")).click();
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
                .findElement(By.xpath("//table[@id='schw_docprvdgrid1']/tbody"))//наашел таблицу
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



    //нужно проверить что верстка таблицы с врачами аналогична в ДОМЕ как на страницы создания расписания.
    //если это так, то можно использовать паттерн PageElements
    //
}


