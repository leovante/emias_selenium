package emias.calldoctor;

import emias.AbstractTest;

public class RCD09Test extends AbstractTest {
    String nameGen;


//    @Test(groups = "CD", description = "фильтр поиск по ФИО")
//    @Issue("EMIAS-90")
////    @RetryCountIfFailed(2)
//    public void testFilterFIO() throws InterruptedException, IOException {
//        open(curUrlCalldoctor);
//        page.createCallPage().createNewCall("Profile1", nameGen, "n");
//        page.fullCardPage().closeCardBtn();
//        page.dashboardPage()
//                .searchFilterFio(nameGen)
//                .verifyNewCallGroup("Profile1", nameGen);
//    }
//
//    //    @Listeners({CustomTestListener.class}) //https://automated-testing.info/t/pomogite-podklyuchit-allure-k-proektu-java-testng-maven/7122/15
//    @Attachment(value = "Console error", type = "text/plain")
//    @Test(groups = "CD", description = "фильтр поиск по врачу")
//    @Issue("EMIAS-90")
////    @RetryCountIfFailed(0)
//    public void testFilterDoctor() throws InterruptedException, IOException {
//        open(curUrlCalldoctor);
//        page.createCallPage().createNewCall("Profile1", nameGen, "n");
//        page.fullCardPage().chooseDoctorBtn();
//        page.setDoctorPage().chooseDoctor("Profile1");
//        page.fullCardPage().closeCardBtn();
//        page.dashboardPage()
//                .clearFilterDepart()
//                .searchFilterDoctor("Profile1")
//                .verifyActiveDocGroup(nameGen, "Profile1");
//    }
//
//    @Test(groups = "CD", description = "фильтр поиск по виду вызова")
//    @Issue("EMIAS-90")
////    @RetryCountIfFailed(2)
//    public void testTypeCall() throws InterruptedException, IOException {
//        page.createCallPage().createCallProfile3(nameGen);
//        open(curUrlCalldoctor);
//        page.dashboardPage().openNewCallProgressFrame("Profile3");
//        page.fullCardPage().closeCardBtn();
//        page.dashboardPage()
//                .searchFilterFio(nameGen)
//                .searchFilterTypeCallNeotlozhniy()
//                .verifyNewCallGroup("Profile3", nameGen);
//    }
//
//    @Test(groups = "CD", description = "проверка кнопки выход")
//    @Issue("EMIAS-90")
////    @RetryCountIfFailed(2)
//    public void testExitToMis() {
//        open(curUrlCalldoctor);
//        page.dashboardPage().exitToMis();
//        assertTrue($(By.xpath("//span[contains(text(),'Расписание приёма')]")).isDisplayed());
//    }

    // TODO: 13.08.2018 сделать тест отображение вызовов в различных подразделениях и группах
}