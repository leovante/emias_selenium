package emias.medicalrecords;

import com.codeborne.selenide.Condition;
import com.datas.Datas;
import com.utils.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;

public class BasicFunction extends TestBase {
    @Test(groups = "MR", description = "Работоспособность кнопки отменить у старой медзаписи")
    @Epic("Базовая работа компонентов")
    @RetryCountIfFailed(2)
    public void cancelBtnOnOldMR() {
        Datas data = new Datas().setMedicalRecord("Осмотр гастроэнтеролога");
        page.misHome().mrFromTap();
        page.ehrMedrecords(data)
                .newMrMenuBtn()
                .allPatternsBtn()
                .searchField()
                .openMr()
                .cancelBtn();
        Assert.assertTrue(
                $x("//input[@placeholder='Поиск шаблона по номеру, наименованию и специализации']")
                        .shouldBe(Condition.visible)
                        .isDisplayed());
    }
}