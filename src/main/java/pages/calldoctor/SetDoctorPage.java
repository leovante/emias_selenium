package pages.calldoctor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractPage;
import pages.utilities.JSWaiter;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;


public class SetDoctorPage extends AbstractPage {

    SelenideElement appenOnThisDay = $(By.xpath("//span[contains(.,'Назначить на сегодня')]"));
    SelenideElement loadCurrently = $(By.xpath("//span[contains(.,'ЗАГРУЗКА СЕГОДНЯ')]"));

    public SetDoctorPage() {

    }

    @Step("получить имя врача")
    public String getDoctorName(int a) {
        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'ЗАГРУЗКА СЕГОДНЯ')]")));

        loadCurrently.click();


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

    @Step("получить имя врача")
    public String getDoctorName(String badDoctorName) {
        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'ЗАГРУЗКА СЕГОДНЯ')]")));

        loadCurrently.click();

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
    public void appendDoctor(String doctorName) {
        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., '" + doctorName + "')]")));


        $(By.xpath("//div[contains(text(),'" + doctorName + "')]")).should(Condition.visible);
        $(By.xpath("//div[contains(text(),'" + doctorName + "')]")).click();
        appenOnThisDay.click();
    }
}