package emias.disp.base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.commons.retryCountListner.RetryCountIfFailed;
import com.system.service.HltDispExamServiceImpl;
import emias.TestDispBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.datas.disp.measure.MeasureEnum.issledovanie_kala;

public class RouteListTest extends TestDispBase {
    @Autowired
    public HltDispExamServiceImpl hltDispExamService;

    @Ignore
    @Test(groups = "disp", description = "проверка что терапевт в конце МЛ после отмены мероприятия", enabled = false)
//сейчас даже если терапевт не последний, тап и заключение отображается как надо
    @RetryCountIfFailed(2)
    public void cancelTerapevt() {
        page.misHome().loginMis();
        page.homePageMis().raspisaniPriemaBtn();
        page.raspisaniePriemaPage()
                .createDispMl("Темников", "18.07.1995")
                .generateML()
                .disableIPK()
                .validateTerapevtLast();
    }

    @Test(groups = "disp", description = "проверка пустых значений в показателях")
    @RetryCountIfFailed(2)
    public void empyFieldParams() {
        page.misHome().dispCard();
        page.exampPage().validateFieldParamIsEmpy();
    }

    @Test(groups = "disp", description = "показатели не должны сохраняться с пробелом")
    @RetryCountIfFailed(2)
    public void spaceValidationFieldParams() {
        page.misHome().dispCard();
        page.exampPage().validateFieldParamWithSpace();
    }

    @Test(groups = "disp", description = "показатели не должны сохраняться с дефолтным пустым полем")
    @RetryCountIfFailed(2)
    public void defaultValidationFieldParams() {
        page.misHome().dispCard();
        page.exampPage().validateClearParam();
    }

    @Test(groups = "disp", description = "пустое мероприятие не должно промаркироваться, даже если его не раскрыли", enabled = false)
    @RetryCountIfFailed(2)
    public void validateParamNotOpen() {
        page.misHome().dispCard();
        page.exampPage()
                .switchAllServicesTap()
                .validateParamNotOpen();
    }
    // TODO: 7/2/2019 пока не работает
    // TODO: 14-Feb-19 сделать тест добавление мероприятия на истекшее время. Бекетова 63 года

    @Test(groups = "disp", description = "отображение кнопки просмотреть у мероприятия без маркировок. И подписание")
    @RetryCountIfFailed(2)
    public void validateKallMeasure() {
        long a = page.misHome().getDispCardNumber();
        hltDispExamService.resetCardExams(a);
        page.misHome().dispCard42();
        page.exampPage()
                .switchAllServicesTap();
        page.exampPage(issledovanie_kala)
                .expandExam()
                .expandService()
                .signService()
                .validateServiceIsSign();
    }
    // TODO: 5/14/2019 сделать проверку задизеблинной кнопки подписать и сохранить у мероприятия при входе через чужую ячейку расписания
    // TODO: 5/14/2019 сделать проверку отсутствующего тапа в заключении терапевта у врача без должности врач

    @Test(groups = "disp", description = "абсолютный ССР не должен отображаться в заключении >= 42 года, относительный должен")
    @RetryCountIfFailed(2)
    public void viewSSRinZakluchenieOlder42() {
        //мкаб генератор сорок два, карта диспы
        open("http://192.168.7.24/test/disp;doctorId=2129;doctorGuid=3e043c9f-57ea-4b3b-8aae-77df8162da41;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=59DSztWZ6MCU1G22cnS6v9yeAtzMutiJZYG7Qn6zHQr%2Fgw31hMKnM8R3hkxPsfw%2BZmyk2%2B34uo%2BAdTYs8s3Acj1hrjOYurSha2PBINnI%2FouBZCKEQHJqlJVEE8Laz4YgnBh%2B4gkr4eZ70vehJoFFcB9YC8P3z9%2BA2ADq6c3DkLpPEkpWTuvU0QDkKXJUU1AqBQgIzxL3vvt27bc64w%2F2H4ZF0yl8UTs%2FfkNsMM9GIz4cXrf06b%2B1RB9tBDPeMmOGKduxiKrm2TRrJ0WY%2FaVJki9YopM%2FrQFcChp5%2FroimLfsZ7mQMyAJDY599rw5epD6ewIOLQ%3D%3D/card/2168?ticket=59DSztWZ6MCU1G22cnS6v9yeAtzMutiJZYG7Qn6zHQr%2Fgw31hMKnM8R3hkxPsfw%2BZmyk2%2B34uo%2BAdTYs8s3Acj1hrjOYurSha2PBINnI%2FouBZCKEQHJqlJVEE8Laz4YgnBh%2B4gkr4eZ70vehJoFFcB9YC8P3z9%2BA2ADq6c3DkLpPEkpWTuvU0QDkKXJUU1AqBQgIzxL3vvt27bc64w%2F2H4ZF0yl8UTs%2FfkNsMM9GIz4cXrf06b%2B1RB9tBDPeMmOGKduxiKrm2TRrJ0WY%2FaVJki9YopM%2FrQFcChp5%2FroimLfsZ7mQMyAJDY599rw5epD6ewIOLQ%3D%3D&mkabId=0&dvtId=1473473&DocPrvdId=2129&MisUrl=http:%2F%2F192.168.7.54%2Ftest&ReturnUrl=http:%2F%2F192.168.7.54%2Ftest%2FEngine%2FRenderView%3Furl%3D~%252FViews%252FShared%252FMkab%252FLazyViewMkab.cshtml%26_%3D1563174387203");
        SelenideElement se1 = $x("//*[contains(.,'Относительный суммарный сердечно-сосудистый риск по шкале SCORE')]");
        Assert.assertFalse(se1.is(Condition.visible), "относительный ССР отображается");

        SelenideElement se2 = $x("//*[contains(.,'Абсолютный суммарный сердечно-сосудистый риск по шкале SCORE')]");
        Assert.assertTrue(se2.is(Condition.visible), "абсолютный ССР не отображается");
    }

    @Test(groups = "disp", description = "абсолютный ССР не должен отображаться у диспы <= 42 года, относительный должен")
    @RetryCountIfFailed(2)
    public void viewSSRinZakluchenieLater42() {
        //мкаб темникова, карта диспы
        open("http://192.168.7.24/test/disp;doctorId=2129;doctorGuid=3e043c9f-57ea-4b3b-8aae-77df8162da41;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=VaeTxsHl8q10jh46nOZRYSKD0gFb0%2fFKZih9VDMWg6tT3YbP9vC6YAk8yAgGnlDBHeIpodcn%2bvjTaIv3C6%2bON8C4jiVW49mB9jrnQ4jhw1eoiUN1%2bQplqRUqXgPRj3vrC209knCJFwrmoExAY6j4l4FaTa2zJZqXEMvY0XuyJPui%2bVmwNsvFEt51W5B49xHBJijSwTC7DP0uGWx5v%2bdQ2v0xdouCuY2O%2bQ21T7wbDGAHyHUp4NiIpP7qtqAambu0%2bpSdycEW0AcUyw%2bsf%2bAFfGjbGz%2bgrYPgOqnG1IrMqXc7nf68YNT5kDT9uaD7j%2fpEfbf%2bLg%3d%3d/card/2165?ticket=VaeTxsHl8q10jh46nOZRYSKD0gFb0%2fFKZih9VDMWg6tT3YbP9vC6YAk8yAgGnlDBHeIpodcn%2bvjTaIv3C6%2bON8C4jiVW49mB9jrnQ4jhw1eoiUN1%2bQplqRUqXgPRj3vrC209knCJFwrmoExAY6j4l4FaTa2zJZqXEMvY0XuyJPui%2bVmwNsvFEt51W5B49xHBJijSwTC7DP0uGWx5v%2bdQ2v0xdouCuY2O%2bQ21T7wbDGAHyHUp4NiIpP7qtqAambu0%2bpSdycEW0AcUyw%2bsf%2bAFfGjbGz%2bgrYPgOqnG1IrMqXc7nf68YNT5kDT9uaD7j%2fpEfbf%2bLg%3d%3d&mkabId=0&dvtId=1473458&DocPrvdId=2129&MisUrl=http%3a%2f%2f192.168.7.54%2ftest&ReturnUrl=http%3a%2f%2f192.168.7.54%2ftest%2fSchedule");
        SelenideElement se1 = $x("//*[contains(.,'Относительный суммарный сердечно-сосудистый риск по шкале SCORE')]");
        Assert.assertTrue(se1.is(Condition.visible), "относительный ССР отображается");

        SelenideElement se2 = $x("//*[contains(.,'Абсолютный суммарный сердечно-сосудистый риск по шкале SCORE')]");
        Assert.assertFalse(se2.is(Condition.visible), "абсолютный ССР не отображается");
    }
    // TODO: 7/15/2019 добавить тест. проставить отказ мероприятию с медзаписю например ИПК и сохранить карту. Потом перезагрузиться и попытаться раскрыть медзапись. Сейчас не раскрывается
}