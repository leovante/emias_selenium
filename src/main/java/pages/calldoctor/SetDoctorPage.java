package pages.calldoctor;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.utilities.JSWaiter;

import java.util.List;


public class SetDoctorPage extends BasePage {

    @FindBy(xpath = "//div[@style='width: 50%; background-color: rgb(23, 150, 112);']")
    WebElement thisDayLoadGreen;

    @FindBy(xpath = "//div[@style='width: 50%; background-color: rgb(252, 194, 54);']")
    WebElement thisDayLoadYellow;

    @FindBy(xpath = "//span[contains(.,'Назначить на сегодня')]")
    WebElement appenOnThisDay;

    @FindBy(xpath = "//span[contains(.,'ЗАГРУЗКА СЕГОДНЯ')]")
    WebElement loadCurrently;

    public SetDoctorPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получить имя врача")
    public String getDoctorName(int a) {
        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'ЗАГРУЗКА СЕГОДНЯ')]")));

        click(loadCurrently);


        String doctorName = null;
        List<WebElement> doctorList = driver
                .findElement(By.xpath("//datatable-scroller"))//нашел таблицу
                .findElements(By.xpath("datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell/div/div"));//ячейки, содержащие имя врачей
        for (WebElement doctor : doctorList) {
            doctorName = doctor.getText();
            if (doctorName != null)
                break;
        }
        return doctorName;
    }

    @Step("Получить имя врача")
    public String getDoctorName(String badDoctorName) {
        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'ЗАГРУЗКА СЕГОДНЯ')]")));

        click(loadCurrently);

        String doctorName = null;
        List<WebElement> doctorList = driver
                .findElement(By.xpath("//datatable-scroller"))//нашел таблицу
                .findElements(By.xpath("datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell/div/div"));//ячейки, содержащие имена врачей
        for (WebElement doctor : doctorList) {
            doctorName = doctor.getText();
            if (doctorName != null && doctorName != badDoctorName)
                break;
        }
        return doctorName;
    }

    @Step("назначиь врача")
    public void appendDoctor(String doctorName) throws InterruptedException {
        Thread.sleep(1000);
        click(driver.findElement(By.xpath("//div[contains(text(),'" + doctorName + "')]")));
        click(appenOnThisDay);
    }
}