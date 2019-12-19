package emias.medicalrecords;

import com.commons.retryCountListner.RetryCountIfFailed;
import com.datas.Datas;
import com.testRunner.TestNGBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class CreateTest extends TestNGBase {
    @Test(groups = "MR", description = "проверка что подписывается старый шаблон")
    @Epic("Создание медзаписи")
    @RetryCountIfFailed(2)
    public void signOldMr() {
        Datas d = new Datas().setMedicalRecord("Осмотр гастроэнтеролога");
        IPage.misHome().mrFromTap();
        IPage.ehrMedrecords(d)
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
        IPage.misHome().mrFromTap();
        IPage.ehrMedrecords(d)
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
    public void editMrAfterSave() {
        Datas d = new Datas().setMedicalRecord("Осмотр гастроэнтеролога");
        IPage.misHome().mrFromTap();
        IPage.ehrMedrecords(d)
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