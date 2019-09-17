package emias.beforeRun;

import com.api.TestStend;

import java.io.IOException;

import static com.pages.BasePage.logger2;

public class BeforeRun {
    private TestStend testStend = new TestStend();
    private boolean checkCreateCall = true;
    private boolean checkKladrFind = true;
    private boolean ehr_medrecords = true;
    private boolean disp_journal = true;
    private boolean disp_card = true ;
    private boolean calldoctor = true;
    private boolean calldoctorVz = true;

    public BeforeRun(String grid) throws IOException {
        if (Boolean.parseBoolean(grid)) {
            instasiator();
            validator();
        }
    }

    private void instasiator() throws IOException {
        checkCreateCall = testStend.call_doctor_ef_api();
        checkKladrFind = testStend.kladrsave();
        // TODO: 7/23/2019 заменитьна проверку по api
//        ehr_medrecords = testStend.ehr_medrecords();
//        disp_journal = testStend.disp_journal();
//        disp_card = testStend.disp_card();
//        calldoctor = testStend.calldoctor();
//        calldoctorVz = testStend.calldoctorVz();
//        new WebDriverRunner().closeWebDriver();
    }

    private void validator() {
        if (!checkCreateCall |
                !checkKladrFind |
                !ehr_medrecords |
                !disp_journal |
                !disp_card |
                !calldoctor |
                !calldoctorVz) {
            logger2.info(
                    "\nпроверка api диспетчера: " + checkCreateCall +
                            "\nпроверка api КЛАДР: " + checkKladrFind +
                            "\nпроверка медзаписей: " + ehr_medrecords +
                            "\nжурнал диспы: " + disp_journal +
                            "\nкарта диспы: " + disp_card +
                            "\nдиспетчер: " + calldoctor +
                            "\nдиспетчер взрослая поликлиника: " + calldoctorVz
            );
            System.exit(0);
        }
    }
}