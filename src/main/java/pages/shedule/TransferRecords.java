package pages.shedule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(xpath = "//button[@id='btn_transfer']/span[2]")
    WebElement btn_transfer;

    @FindBy(xpath = "//button[@id='btn_transfer_schedule']/span")
    WebElement btn_transfer_schedule;

    @FindBy(xpath = "//table[@id='collision_grid']/tbody/tr[2]")
    WebElement doctors_recive_record;

    @FindBy(xpath = "//table[@id='collision_item_grid']/tbody/tr[2]")
    WebElement doctors_record;


    public TransferRecords(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void trancRecord(String name) throws InterruptedException {
        String secondDoctor = name;
        waitAll();
        waitWhileClickable(btn_transfer);
        btn_transfer.click();//большая кнопка перенести
        waitWhileClickable(btn_transfer_schedule);
        btn_transfer_schedule.click();//всплывающее окно перенести
        waitWhileClickable(doctors_recive_record);
        doctors_recive_record.click();
        waitWhileClickable(doctors_record);
        doctors_record.click();

        Actions action = new Actions(webDriver).contextClick(doctors_record);
        action.build().perform();//нажал правой кнопкой на вызов пациента
        webDriver.findElement(By.xpath("(//li[@id='SCH_CollisionResolve']/a/span)[2]")).click();
        selectDoctorFromTranWindow(secondDoctor);

        webDriver.findElement(By.xpath("(//table[@id='resolve_collision_grid']/tbody"))
                .findElement(By.xpath("tr[@role='row']"))
                .findElement(By.xpath("td[@title='23:45']")).click();
        webDriver.findElement(By.xpath("//button[@id='btn_transfer_collision']/span")).click();
        waitAll();
    }

    public void selectDoctor(String doctorInlet) throws InterruptedException {
        waitAll();
        waitAll();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'" + doctorInlet + "')]")));
        webDriver.findElement(By.xpath("//*[contains(text(),'" + doctorInlet + "')]")).click();
        waitAll();
        waitAll();
    }

    public void selectDoctorFromTranWindow(String doctorInlet) throws InterruptedException {
        blockOverlay();
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='resolve_collision_docprvdgrid1']")));
        List<WebElement> doctors = webDriver.findElement(By
                .xpath("//div[@id='gview_resolve_collision_docprvdgrid1']/div[3]/div/table/tbody"))
                .findElements(By.xpath("tr/td[2]/div"));
        //.findElement(By.xpath("tr[@role='row'][contains(text(),'" + doctorInlet + "')]")).click();
        //.findElement(By.linkText(doctorInlet)).click();
        //.findElement(By.xpath("*span[text()='" + doctorInlet + "']")).click();
        for (WebElement doctor : doctors) {
            //WebElement doctorLink = doctor.findElement(By.tagName("td"));

            WebElement doctorLink = doctor.findElement(By.tagName("span"));
            String doctorLinkText = doctorLink.getText();
            WebElement doctorLink1 = doctor.findElement(By.xpath("//span"));
            String doctorLinkTex1 = doctorLink1.getText();
            WebElement doctorLink4 = doctor.findElement(By.xpath("span"));
            String doctorLinkText4 = doctorLink4.getText();
//            if (doctorLink.getAttribute("title").contains(doctorInlet)) {
//                doctorLink.click();
//                break;
//            }
            if (doctorLinkText.equals(doctorInlet)) {
                doctor.click();
                break;
            }
        }
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

    public boolean blockOverlay() {
        boolean BlockAssert = !webDriver.findElements(By.xpath("//div[@class='blockUI blockOverlay']")).isEmpty();
        if (BlockAssert) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.xpath("//div[@class='blockUI blockOverlay']"))));
        }
        return BlockAssert;
    }

    public void waitWhileClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void verifyTransferShedule() throws InterruptedException {
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div"))//поле с заявками
                .findElement(By.xpath("//*[contains(text(),'07:00 ')]"));

        /*
        <div class="fc-event-head fc-event-skin" style="background-color:#3366CC;border-color:#3366CC;color:#FFFFFF"><div class="fc-event-time"
        style="text-align: center;">23:45 <div class="fc-event-icons"></div></div></div>
         */
    }
}


