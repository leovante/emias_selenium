package pages.callCenter;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.AbstractPage;
import pages.calldoctor.profiles_interfaces.Pacient;

import static com.codeborne.selenide.Selenide.$;

public class WaitingListPage extends AbstractPage {
    private Pacient pacient;
    SelenideElement waitspec = $(By.xpath("//div[@id='department-12102']/button[1]"));
    SelenideElement waitbutton = $(By.xpath("//*[contains(text(),'Записать в лист ожидания')]"));
    SelenideElement complain = $(By.xpath("//*[@id='complain']"));
    SelenideElement oform = $(By.xpath("//*[@id='createWaitingListRecordForm']/div[2]/div[2]/button"));
//    @FindBy(xpath = "//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']")
//    WebElement lpu;

    public WaitingListPage() {
    }

    public WaitingListPage waitingList(Pacient pacient) {
        $(By.xpath("//button[contains(.,'СТЕНД ЕМИАС МО')]")).click();
        waitspec.click();
        waitbutton.click();
        complain.sendKeys("тест ожидания");
        oform.click();
        return this;
    }

    public void assertWL(String arg0, String arg1, String arg2){
        System.out.println("Код гавно2");
        SelenideElement lpuName2 = $(By.xpath("//*[@id='waiting-list']/tr[2]/td[1]/div[1]/ul/li/div/h4"));
        SelenideElement adress = $(By.xpath("//*[@id='waiting-list']/tr[2]/td[1]/div[1]/ul/li/div/p[1]"));
        SelenideElement istok = $(By.xpath("//*[@id='waiting-list']/tr[2]/td[1]/div[1]/ul/li/div/p[3]"));
        SelenideElement createData = $(By.xpath("//*[@id='waiting-list']/tr[2]/td[1]/div[1]/ul/li/div/p[4]"));


        String eq1 = lpuName2.getText();
        String eq2 = adress.getText();
        String eq3 = istok.getText();
        String eq4 = createData.getText();

        Assert.assertTrue(eq1.contains(arg0));
        System.out.println(eq1+" есть");
        Assert.assertTrue(arg1.contains(eq2));
        System.out.println(eq2+" есть");
        Assert.assertTrue(eq3.contains(arg2));
        System.out.println(eq3+" есть");
        Assert.assertTrue(eq4 != null);
        System.out.println(eq4+" есть");

    }

    public void assertWLHis(){
        System.out.println("Код гавно2");

        SelenideElement autor = $(By.xpath("//*[@id='waiting-list-history']/table/tbody[2]/tr/td[2]"));
        SelenideElement changes = $(By.xpath("//*[@id='waiting-list-history']/table/tbody[2]/tr/td[3]"));
        SelenideElement stat = $(By.xpath("//*[@id='waiting-list-history']/table/tbody[2]/tr/td[4]"));

        String eq2 = autor.getText();
        String eq3 = changes.getText();
        String eq4 = stat.getText();

        System.out.println(eq2);
        System.out.println(eq3);
        System.out.println(eq4);

        Assert.assertTrue(eq2.contains("Колл-центр"));
        System.out.println(eq2+" есть");
        Assert.assertTrue(eq3.contains("Статус"));
        System.out.println(eq3+" есть");
        Assert.assertTrue(eq4.contains("Создана"));
        System.out.println(eq4+" есть");

    }
}
