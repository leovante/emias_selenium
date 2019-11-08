package emias.medicalrecords;

import com.datas.Datas;
import com.utils.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class DeleteTest extends TestBase {
    @Test(groups = "MR", description = "проверка что удаляется МЗ")
    @Epic("Удаление медзаписи")
    @RetryCountIfFailed(2)
    public void deleteMR() {
        Datas data = new Datas().setMedicalRecord("Осмотр гастроэнтеролога");
        page.ehrMedrecords(data)
                .loginFromTap()
                .newMrMenuBtn()
                .allPatternsBtn()
                .searchField()
                .openMr()
                .view()
                .allActions()
                .save();
        page.ehrMedrecords(data)
                .medicalRecordsMenuBtn()
                .searchMR()
                .podpisanaSortColumn()
                .deleteMR()
                .verifyMrIsDeleted();
        // TODO: 10/30/2019 нужно предварительно чистить ТАП от медзаписей
    }
}