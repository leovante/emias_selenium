package pages.callcenter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AbstractPage;


public class FindPatientPage extends AbstractPage {
    public FindPatientPage(WebDriver driver) {
        super(driver);
    }

    public void findPatient(String nPol, String birthDay) {
        driver.findElement(By.name("snPol")).sendKeys(nPol);
        driver.findElement(By.name("birthday")).sendKeys(birthDay);
        driver.findElement(By.xpath("//button[@class='btn btn-success pull-right form-control']")).click();
        //Thread.sleep(2000);
    }
}
