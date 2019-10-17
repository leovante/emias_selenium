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
    public void signOldMr() {
        Datas d = new Datas().setMedicalRecord("Осмотр гастроэнтеролога");
        page.misHome().mrFromTap();
        page.ehrMedrecords(d)
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
    public void signNewMr() {
        Datas d = new Datas().setMedicalRecord("Консультация врача гастроэнтеролога");
        page.misHome().mrFromTap();
        page.ehrMedrecords(d)
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
    public void editMrAfterSave()  {
        Datas d = new Datas().setMedicalRecord("Осмотр гастроэнтеролога");
        page.misHome().mrFromTap();
        page.ehrMedrecords(d)
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