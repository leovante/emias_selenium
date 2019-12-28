package emias.medicalrecords;

import com.codeborne.selenide.Condition;
import com.commons.retryCountListner.RetryCountIfFailed;
import com.datas.Datas;
import com.testRunner.TestNGBase;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;

public class BasicFunction extends TestNGBase {
    @Test(groups = "MR", description = "Работоспособность кнопки отменить у старой медзаписи")
    @Epic("Базовая работа компонентов")
    @RetryCountIfFailed(2)
    public void cancelBtnOnOldMR() {
        Datas data = new Datas().setMedicalRecord("Осмотр гастроэнтеролога");
        IPage.misHome().mrFromTap();
        IPage.ehrMedrecords(data)
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