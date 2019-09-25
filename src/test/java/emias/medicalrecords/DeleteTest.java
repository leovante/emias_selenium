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
    public void deleteMR() throws InterruptedException {
        Datas d = new Datas().setMedical_record("Осмотр гастроэнтеролога");
        page.misHome().mr_tap();
        page.ehrMedicalrecords(d)
                .newMrMenuBtn()
                .allPatternsBtn()
                .searchField()
                .openMr()
                .view()
                .allActions()
                .save();
        page.ehrMedicalrecords(d)
                .medicalRecordsMenuBtn()
                .searchMR()
                .podpisanaSortColumn()
                .deleteMR()
                .verifyMrIsDeleted();
    }
}