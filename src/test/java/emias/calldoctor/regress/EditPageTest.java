package emias.calldoctor.regress;

import emias.AbstractTestGrid;

public class EditPageTest extends AbstractTestGrid {

//    @Test(groups = "CD", description = "проверка страницы редактирвоания карты вызова")
//    @Epic("Редактирование вызова")
//    @RetryCountIfFailed(2)
//    public void testVerifyEditPage() throws Exception {
//        Pacient pacient = new Pacient("Profile1");
//        enter.enterCalldoctorFromMis();
//        page.createCallPage(pacient)
//                .createCall()
//                .editCallBtn()
//                .verifyCallProfile1(pacient);
//    }
//
//    @Test(groups = "CD", description = "проверка страницы редактирвоания карты вызова. После сохранения в истории не должно появиться новых записей")
//    @Epic("Редактирование вызова")
//    @RetryCountIfFailed(2)
//    public void testVerifyEditPage_2() throws Exception {
//        Pacient pacient = new Pacient("Profile1");
//        enter.enterCalldoctorFromMis();
//        page.createCallPage(pacient)
//                .createCall()
//                .editCallBtn()
//                .saveBtn();
//        List<SelenideElement> se = $$(By.xpath("//div[@class='datatable-row-center datatable-row-group ng-star-inserted']"));
//        Assert.assertTrue(se.size() == 1, "Количество записей в истории больше одной!");
//    }
//
//    @Test(groups = "CD", description = "изменить карту вызова из регистратуры")
//    @Epic("Редактирование вызова")
//    @RetryCountIfFailed(2)
//    public void testEditCall() throws Exception {
//        Pacient pacient = new Pacient("Profile1");
//        Pacient pacient2 = new Pacient("Profile2");
//        enter.enterCalldoctorFromMis();
//        page.createCallPage(pacient)
//                .createCall()
//                .editCallBtn()
//                .setDeafult()
//                .editCallPage_Mkab(pacient2)
//                .saveBtn();
//        page.fullCardPage(testName())
//                .verifyNewCall(pacient2)
//                .closeCardBtn();
//        page.dashboardPage()
//                .clearAllFilters()
//                .verifyNewCallGroup(pacient2);
//    }
//
//    @Test(groups = "CD", description = "проверяю валидацию на наличие адреса после редактирвоания карты вызова")
//    @Epic("Редактирование вызова")
//    @Issue("EMIAS-956")
//    @RetryCountIfFailed(2)
//    public void testValidationAddressAfterSaveEditedCall() throws Exception {
//        Pacient pacient = new Pacient("Profile2");
//        Pacient pacient2 = new Pacient("Profile0_3");
//        enter.enterCalldoctorFromMis();
//        page.createCallPage(pacient).createCall_Mkab();
//        page.fullCardPage(testName()).editCallBtn();
//        page.createCallPage(pacient)
//                .setDeafult()
//                .editCallPage(pacient2)
//                .saveBtn();
//        $(By.xpath("//simple-snack-bar[contains(.,'Не указан адрес')]")).shouldBe(Condition.visible);
//    }
    // TODO: 1/21/2019 добавить тест, вводить новый адрес английскими буквами
}