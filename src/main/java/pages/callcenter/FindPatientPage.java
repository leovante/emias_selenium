package pages.callcenter;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.AbstractPage;
import pages.calldoctor.profiles_interfaces.Pacient;

import static com.codeborne.selenide.Selenide.$;


public class FindPatientPage extends AbstractPage {
    private Pacient pacient;
    SelenideElement fondPatient1 = $(By.xpath("//*[@id='fond-patients']/tr/td[2]"));
    SelenideElement fondPatient2 = $(By.xpath("//*[@id='fond-patients']/tr/td[3]"));
    SelenideElement fondPatient3 = $(By.xpath("//*[@id='fond-patients']/tr/td[4]"));
    SelenideElement polis = $(By.name("snPol"));
    SelenideElement find = $(By.xpath("//button[@id='search-patient']"));
    SelenideElement fio = $(By.name("surnameNamePatronymic"));
    SelenideElement birthday = $(By.name("birthday"));

    public FindPatientPage() {
    }

    public FindPatientPage findByPolis(Pacient pacient)  {
        this.pacient = pacient;
        findPatient(pacient);
        return this;
    }

    public FindPatientPage findByFio(Pacient pacient)  {
        this.pacient = pacient;
        findFio(pacient);
        return this;
    }

    public void findPatient(Pacient pacient)  {
        polis.val(pacient.getNumberpol()) ;
        find.click();
    }

    public void findFio(Pacient pacient) {
        fio.val(pacient.getFamily()+" "+pacient.getName()+" "+pacient.getOt());
        birthday.val(pacient.getBirthdate("dd-MM-yyyy"));
        find.click();
    }
}
