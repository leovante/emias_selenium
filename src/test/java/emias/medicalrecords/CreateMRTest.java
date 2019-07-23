package emias.medicalrecords;

import com.datas.Datas;
import com.utils.TestMethodCapture;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

@Listeners(TestMethodCapture.class)
public class CreateMRTest extends TestBase {
    @Test(groups = "MR", description = "проверка что подписывается старый шаблон")
    @Epic("Создание медзаписи")
    @RetryCountIfFailed(2)
    public void test_sign_old_mr() throws InterruptedException {
        Datas d = new Datas();
        d.setMedical_record("Осмотр гастроэнтеролога");

        open(configFile.getMr_tap());
        page.ehr_medicalrecords(d)
                .new_mr_menuBtn()
                .all_patterns()
                .search_field()
                .open_MR()
                .prosmotret()
                .podpisat()
                .assert_sign_succesfull();
    }

    @Test(groups = "MR", description = "проверка что подписывается новый шаблон")
    @Epic("Создание медзаписи")
    @RetryCountIfFailed(2)
    public void test_sign_new_mr() throws InterruptedException {
        Datas d = new Datas();
        d.setMedical_record("Консультация врача гастроэнтеролога");

        open(configFile.getMr_tap());
        page.ehr_medicalrecords(d)
                .new_mr_menuBtn()
                .all_patterns()
                .search_field()
                .open_MR()
                .prosmotret()
                .podpisat()
                .assert_sign_succesfull();
    }

    @Test(groups = "MR", description = "проверка что медзапись сохраняется после редактирования")
    @Epic("Создание медзаписи")
    @RetryCountIfFailed(2)
    public void test_edit_mr_after_save() throws Exception {
        Datas d = new Datas();
        d.setMedical_record("Осмотр гастроэнтеролога");

        open(configFile.getMr_tap());
        page.ehr_medicalrecords(d)
                .new_mr_menuBtn()
                .all_patterns()
                .search_field()
                .open_MR()
                .prosmotret()
                .all_actions()
                .save()
                .edit()
                .prosmotret()
                .all_actions()
                .save();
    }
}