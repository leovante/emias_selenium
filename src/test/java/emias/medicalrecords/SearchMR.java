package emias.medicalrecords;

import com.commons.retryCountListner.RetryCountIfFailed;
import com.datas.Datas;
import com.testRunner.TestNGBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class SearchMR extends TestNGBase {
    @Test(groups = "MR", description = "поиск медзаписей на странице мкаб")
    @Epic("Поиск медзаписи")
    @RetryCountIfFailed(2)
    public void searchMR_redirectFromMkabPage() {
        Datas d = new Datas().setMedicalRecord("Антропометрия");
        IPage.misHome().mr_mkab();
        IPage.ehr_medicalrecordsMKAB(d)
                .searchField()
                .validateMrIsExistOnSearchResult();
    }

    @Test(groups = "MR", description = "поиск медзаписей на странице ТАП")
    @Epic("Поиск медзаписи")
    @RetryCountIfFailed(2)
    public void searchMROnPageTap() {
        Datas d = new Datas().setMedicalRecord("Осмотр гастроэнтеролога");
        IPage.misHome().mrFromTap();
        IPage.ehrMedrecords(d)
                .newMrMenuBtn()
                .allPatternsBtn()
                .searchField()
                .validateMrIsExistOnSearchResult();
    }
}