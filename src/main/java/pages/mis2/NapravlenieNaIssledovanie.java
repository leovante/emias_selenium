package pages.mis2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.AbstractPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NapravlenieNaIssledovanie extends AbstractPage {

    public NapravlenieNaIssledovanie() {
    }

    public void addNapravlenie() {
        open("http://emias.mosreg.ru/mis/PET_Tehn/LabResearch#");
        $(By.id("Login")).setValue("Admin");
        $(By.id("Password")).setValue("RChS2014");
        $(By.id("loginBtn")).click();
        $(By.id("btnAddLabResearch")).click();
        $(By.xpath("(//img[@alt='Выбор'])[2]")).click();
        $(By.id("sinpLabResearchDialog_MKABSelector")).setValue("Сырбу");
        $(By.xpath("//*[contains(text(),'СЫРБУ ВЛАДИМИР АНДРЕЕВИЧ')]")).click();
        $(By.xpath("//*[contains(text(),'Выбрать')]")).click();

        $(By.xpath("(//img[@alt='Выбор'])[4]")).click();
        $(By.id("sinpLabResearchDialog_MKBSelector")).sendKeys("буб");
        $(By.id("btnfindLabResearchDialog_MKBSelector")).click();
        $(By.xpath("//*[contains(text(),'Бубонная чума')]")).click();
        $(By.id("btnselLabResearchDialog_MKBSelector")).$(By.xpath("*[contains(text(),'Выбрать')]")).click();

        $(By.xpath("(//img[@alt='Выбор'])[5]")).click();
        $(By.id("sinpLabResearchDialog_DocPRVDSelector")).sendKeys("черн");
        $(By.id("sinpLabResearchDialog_DocPRVDSelector")).sendKeys(Keys.ENTER);
        $(By.xpath("//*[contains(text(),'Чернова')]")).click();
        $(By.id("btnselLabResearchDialog_DocPRVDSelector")).$(By.xpath("*[contains(text(),'Выбрать')]")).click();
//        driver.findElement(By.xpath("//tr[@id='1003']/td[2]/div/span[2]")).click();
//        driver.findElement(By.xpath("//button[@id='btnselLabResearchDialog_DocPRVDSelector']/span")).click();
        $(By.xpath("//a[@id='LabResearchCause-button']/span")).click();
        $(By.xpath("//a[contains(text(),'Направление из стационара')]")).click();
        $(By.id("LabResearchTarget-button")).click();
        $(By.xpath("//a[contains(text(),'Диагностическое исследование')]")).click();
        $(By.id("Comment")).click();
        $(By.id("Comment")).sendKeys("ТЕСТ");

        $(By.xpath("(//img[@alt='Выбор'])[7]")).click();
        $(By.id("sinpresearchTypeKindgrid")).sendKeys("комп");
        $(By.id("sinpresearchTypeKindgrid")).sendKeys(Keys.ENTER);
        $(By.xpath("(//tr[@id='4']/td[2])[2]")).click();
        $(By.xpath("//button[@id='btnselresearchTypeKindgrid']/span")).click();
        $(By.xpath("(//img[@alt='Выбор'])[9]")).click();
        $(By.xpath("//tr[@id='1213']/td[2]")).click();
        $(By.xpath("//button[@id='btnselLabResearchDialog_ResearchTypeSelector']/span")).click();
        $(By.xpath("//*[contains(text(),'Записать...')]")).click();


        $(By.xpath("(//img[@alt='Выбор'])[6]")).click();
        $(By.id("sinpclrlabResearchLpuSelector")).click();
        $(By.id("sinplabResearchLpuSelector")).click();
        $(By.id("sinplabResearchLpuSelector")).clear();
        $(By.id("sinplabResearchLpuSelector")).sendKeys("777");
        $(By.id("sinplabResearchLpuSelector")).sendKeys(Keys.ENTER);
        $(By.xpath("//tr[@id='24150']/td[4]")).click();
        $(By.xpath("//tr[@id='24150']/td[4]")).click();
        $(By.xpath("//button[@id='btnSchedule']/span")).click();

        $(By.xpath("//button/strong")).click();
        $(By.xpath("//div[2]/button")).click();
        $(By.xpath("//div[2]/div/table/tbody/tr[2]/td[4]/button")).click();
        $(By.xpath("//button[34]/span")).click();

        $(By.xpath("(//img[@alt='Выбор'])[6]")).click();
        $(By.xpath("//*[contains(text(),'Стенд ЕМИАС МО')]")).click();
        $(By.xpath("//button[@id='btnsellabResearchLpuSelector']/span")).click();

        $(By.xpath("//div[@id='new_polis']/form/button")).click();
    }
}