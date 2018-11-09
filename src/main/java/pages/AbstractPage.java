package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.calldoctor.profiles_interfaces.Pacient;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AbstractPage {
    public WebDriver driver;

    public AbstractPage() {
        this.driver = getWebDriver();
    }

    public void ShouldBeVisible(String text) {
        $(By.xpath("//*[contains(text(),'" + text + "')]")).shouldBe(Condition.visible);
    }

    public String parseTelephone(Pacient pacient) {
        String telephone = pacient.getPhone();
        if (pacient.getSource() == 4) {
            telephone = telephone.substring(0, 1) + "7 (" +
                    telephone.substring(1, 4) + ") " +
                    telephone.substring(4, 7) + "-" +
                    telephone.substring(7, 9) + "-" +
                    telephone.substring(9, telephone.length() - 1);
        }
        if (pacient.getSource() != 4) {
            telephone = telephone.substring(0, 2) + " (" +
                    telephone.substring(2, 5) + ") " +
                    telephone.substring(5, 8) + "-" +
                    telephone.substring(8, 10) + "-" +
                    telephone.substring(10, telephone.length());
        }
        return telephone;
    }

    public String currentTime(String format) {
        String time;
        SimpleDateFormat simpleDateFormatEdit = new SimpleDateFormat(format);
        Date date = Calendar.getInstance().getTime();
        time = simpleDateFormatEdit.format(date);
        return time;
    }
}