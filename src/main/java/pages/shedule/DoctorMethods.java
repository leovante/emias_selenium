package pages.shedule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Pages;
import pages.Waiter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DoctorMethods {
    private WebDriver webDriver;
    Pages website;
    private WebDriverWait wait;

    @FindBy(xpath = "//tr[@role='row'][@tabindex='-1']")
    WebElement doctorRow;

    public DoctorMethods(WebDriver driver){
        webDriver = driver;
        website = new Pages(webDriver);
        PageFactory.initElements(webDriver, this);
        wait = new WebDriverWait(webDriver, 60);
    }

    public String getUnicalDoctor2 (String docName) {
        website.waitLoad().waitAll();
        waitWhileClickable(doctorRow);
        List<String> dontUseNames = new ArrayList<String>();
        Collections.addAll(dontUseNames, "Ай Бо Лит", "Ар Ти Шок", "test test testovych", "null");
        dontUseNames.add(docName);

        System.out.println(dontUseNames);
        website.waitLoad().waitAll();

        String doctorStringName = docName;
        website.waitLoad().waitAll();
        List<WebElement> doctorList = webDriver
                .findElement(By.xpath("//table[@id='schw_docprvdgrid1'][@role='grid']/tbody"))//нашел таблицу
                .findElements(By.xpath("tr[@role='row'][@tabindex='-1']/td[3]/div/span[1]"));//нашел строки врачей
        for (WebElement doctor : doctorList) {
            int count = 0;
            doctorStringName = doctor.getText();

            for (WebElement doctorCount : doctorList) {
                String doctorStringName2 = doctorCount.getText();

                if (doctorStringName.equals(doctorStringName2))
                    count++;
                if (count > 1)
                    break;
            }

            if (count == 1 && !dontUseNames.contains(doctorStringName))
                break;
        }
        dontUseNames.add(doctorStringName);
        System.out.println("+ " + doctorStringName);
        return doctorStringName;
    }

    public String getUnicalDoctor(String docName) {
        website.waitLoad().waitAll();
        waitWhileClickable(doctorRow);
        List<String> dontUseNames = new ArrayList<String>();
        Collections.addAll(dontUseNames, "Ай Бо Лит", "Ар Ти Шок", "test test testovych", "null");
        dontUseNames.add(docName);

        System.out.println(dontUseNames);
        website.waitLoad().waitAll();

        String doctorStringName = docName;
        website.waitLoad().waitAll();
        List<WebElement> doctorList = webDriver
                .findElement(By.xpath("//table[@id='docprvdgrid1'][@role='grid']/tbody"))//нашел таблицу
                .findElements(By.xpath("tr[@role='row'][@tabindex='-1']/td[2]/div/span[1]"));//нашел строки врачей
        for (WebElement doctor : doctorList) {
            int count = 0;
            doctorStringName = doctor.getText();

            for (WebElement doctorCount : doctorList) {
                String doctorStringName2 = doctorCount.getText();

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

    public void selectDoctor(String doctorInlet) throws InterruptedException {
        website.waitLoad().waitAll();
        website.waitLoad().waitAll();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'" + doctorInlet + "')]")));
        webDriver.findElement(By.xpath("//*[contains(text(),'" + doctorInlet + "')]")).click();
        website.waitLoad().waitAll();
        website.waitLoad().waitAll();
    }


    public void waitWhileClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
