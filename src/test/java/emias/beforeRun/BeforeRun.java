package emias.beforeRun;

import com.api.TestStend;
import com.codeborne.selenide.WebDriverRunner;
import org.springframework.boot.test.autoconfigure.properties.SkipPropertyMapping;
import org.testng.SkipException;

import java.io.IOException;

public class BeforeRun {
    TestStend testStend = new TestStend();
    boolean checkCreateCall;
    boolean checkKladrFind;
    boolean ehr_medrecords;
    boolean disp_journal;
    boolean disp_card;
    boolean calldoctor;
    boolean calldoctorVz;

    public BeforeRun() throws IOException {
        instasiator();
        validator();
    }

    void instasiator() throws IOException {
        checkCreateCall = testStend.call_doctor_ef_api();
        checkKladrFind = testStend.kladrsave();
        ehr_medrecords = testStend.ehr_medrecords();
        disp_journal = testStend.disp_journal();
        disp_card = testStend.disp_card();
        calldoctor = testStend.calldoctor();
        calldoctorVz = testStend.calldoctorVz();
        new WebDriverRunner().closeWebDriver();
    }

    void validator() {
        if (!checkCreateCall |
                !checkKladrFind |
                !ehr_medrecords |
                !disp_journal |
                !disp_card |
                !calldoctor |
                !calldoctorVz) {
            throw new SkipException(
                    "\nпроверка api диспетчера: " + checkCreateCall +
                            "\nпроверка api КЛАДР: " + checkKladrFind +
                            "\nпроверка медзаписей: " + ehr_medrecords +
                            "\nжурнал диспы: " + disp_journal +
                            "\nкарта диспы: " + disp_card +
                            "\nдиспетчер: " + calldoctor +
                            "\nдиспетчер взрослая поликлиника: " + calldoctorVz
            );
        }
    }
}