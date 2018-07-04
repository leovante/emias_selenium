package pages.mis;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractPage;
import pages.utilities.Waiter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DoctorMethods extends AbstractPage {

    @FindBy(xpath = "//tr[@role='row'][@tabindex='-1']")
    @CacheLookup
    WebElement doctorRow;

    public DoctorMethods(WebDriver driver) {
        super(driver);
    }

    @Step("получить уникального врача")
    public String getUnicalDoctor(String docName) {
        Waiter.waitAllEmias();

        waitClickable(doctorRow);
        List<String> dontUseNames = new ArrayList<String>();
        Collections.addAll(dontUseNames, "Ай Бо Лит", "Ар Ти Шок", "test test testovych", "null");
        dontUseNames.add(docName);

        System.out.println(dontUseNames);
        Waiter.waitAllEmias();


        String doctorStringName = docName;

        List<WebElement> doctorList = driver
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
        dontUseNames.add(doctorStringName);//чот не срабатывает
        return doctorStringName;
    }

    @Step("получить уникального врача")
    public String getUnicalDoctor3(int doctorNum) {
        Waiter.waitAllEmias();
        waitClickable(doctorRow);

        List<String> badNames = new ArrayList<String>();
        Collections.addAll(badNames, "Ай Бо Лит", "Ар Ти Шок", "test test testovych", "null", "Моков Павел Александрович");

        List<WebElement> doctorList = driver
                .findElement(By.xpath("//table[@id='schw_docprvdgrid1'][@role='grid']/tbody"))//нашел таблицу
                .findElements(By.xpath("tr[@role='row'][@tabindex='-1']/td[3]/div/span[1]"));//нашел строки врачей

        int internalDocNum = doctorNum;
        String doctorName = null;
        for (WebElement doctor : doctorList) {
            doctorName = doctor.getText();

//                !badNames.contains(doctorNamePro1)


            if (badNames.contains(doctorName)) {
            } else {
                if (internalDocNum == 1)
                    break;
                else {
                    internalDocNum = internalDocNum - 1;
                }
            }
        }

        return doctorName;
    }

    @Step("получить уникального врача")
    public String getUnicalDoctor2(String docName) {
        Waiter.waitAllEmias();

        waitClickable(doctorRow);
        List<String> dontUseNames = new ArrayList<String>();
        Collections.addAll(dontUseNames, "Ай Бо Лит", "Ар Ти Шок", "test test testovych", "null");
        dontUseNames.add(docName);

        System.out.println(dontUseNames);
        Waiter.waitAllEmias();


        String doctorStringName = docName;

        List<WebElement> doctorList = driver
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

    @Step("выбрать врача")
    public void selectDoctor(String doctorInlet) {
        Waiter.waitAllEmias();
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//td/div/span[contains(text(),'" + doctorInlet + "')]"))).click();
        Waiter.waitAllEmias();
    }
}