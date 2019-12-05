package emias.medicalrecords;

import com.datas.Datas;
import com.commons.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class SearchMR extends TestBase {
    @Test(groups = "MR", description = "поиск медзаписей на странице мкаб")
    @Epic("Поиск медзаписи")
    @RetryCountIfFailed(2)
    public void searchMR_redirectFromMkabPage() {
        Datas d = new Datas().setMedicalRecord("Антропометрия");
        page.misHome().mr_mkab();
        page.ehr_medicalrecordsMKAB(d)
                .searchField()
                .validateMrIsExistOnSearchResult();
    }

    @Test(groups = "MR", description = "поиск медзаписей на странице ТАП")
    @Epic("Поиск медзаписи")
    @RetryCountIfFailed(2)
    public void searchMROnPageTap() {
        Datas d = new Datas().setMedicalRecord("Осмотр гастроэнтеролога");
        page.misHome().mrFromTap();
        page.ehrMedrecords(d)
                .newMrMenuBtn()
                .allPatternsBtn()
                .searchField()
                .validateMrIsExistOnSearchResult();
    }
}