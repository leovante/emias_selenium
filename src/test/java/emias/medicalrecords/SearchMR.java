package emias.medicalrecords;

import com.datas.Datas;
import com.utils.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class SearchMR extends TestBase {
    @Test(groups = "MR", description = "поиск медзаписей на странице мкаб")
    @Epic("Поиск медзаписи")
    @RetryCountIfFailed(2)
    public void searchMR_redirectFromMkabPage() {
        Datas d = new Datas().setMedical_record("Антропометрия");
        page.misHome().mr_mkab();
        page.ehr_medicalrecordsMKAB(d)
                .searchField()
                .validateMrIsExistOnSearchResult();
    }

    @Test(groups = "MR", description = "поиск медзаписей на странице ТАП")
    @Epic("Поиск медзаписи")
    @RetryCountIfFailed(2)
    public void cancelBtnOnOldMR() {
        Datas d = new Datas().setMedical_record("Осмотр гастроэнтеролога");
        page.misHome().mr_tap();
        page.ehrMedicalrecords(d)
                .newMrMenuBtn()
                .allPatternsBtn()
                .searchField()
                .validateMrIsExistOnSearchResult();
    }
}