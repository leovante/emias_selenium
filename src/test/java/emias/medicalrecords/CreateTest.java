package emias.medicalrecords;

import com.datas.Datas;
import com.utils.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class CreateTest extends TestBase {
    @Test(groups = "MR", description = "проверка что подписывается старый шаблон")
    @Epic("Создание медзаписи")
    @RetryCountIfFailed(2)
    public void test_sign_old_mr() throws InterruptedException {
        Datas d = new Datas().setMedical_record("Осмотр гастроэнтеролога");
        page.misHome().mr_tap();
        page.ehrMedicalrecords(d)
                .newMrMenuBtn()
                .allPatternsBtn()
                .searchField()
                .openMr()
                .view()
                .podpisat()
                .assertSignSuccesfull();
    }

    @Test(groups = "MR", description = "проверка что подписывается новый шаблон")
    @Epic("Создание медзаписи")
    @RetryCountIfFailed(2)
    public void test_sign_new_mr() throws InterruptedException {
        Datas d = new Datas().setMedical_record("Консультация врача гастроэнтеролога");
        page.misHome().mr_tap();
        page.ehrMedicalrecords(d)
                .newMrMenuBtn()
                .allPatternsBtn()
                .searchField()
                .openMr()
                .view()
                .podpisat()
                .assertSignSuccesfull();
    }

    @Test(groups = "MR", description = "проверка что медзапись сохраняется после редактирования")
    @Epic("Создание медзаписи")
    @RetryCountIfFailed(2)
    public void test_edit_mr_after_save() throws Exception {
        Datas d = new Datas().setMedical_record("Осмотр гастроэнтеролога");
        page.misHome().mr_tap();
        page.ehrMedicalrecords(d)
                .newMrMenuBtn()
                .allPatternsBtn()
                .searchField()
                .openMr()
                .view()
                .allActions()
                .save()
                .edit()
                .view()
                .allActions()
                .save();
    }


}