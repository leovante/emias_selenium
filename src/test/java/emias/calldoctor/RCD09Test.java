package emias.calldoctor;

import emias.AbstractTest;
import pages.calldoctor.profiles_interfaces.Profile;

public class RCD09Test extends AbstractTest implements Profile {
//    String nameGen;
//
//    @BeforeMethod(groups = {"CD", "test"})
//    public void beforeMethod() {
//        StringGenerator nameGen = new StringGenerator();
//        String name = String.valueOf(nameGen.generator());
//        this.nameGen = name;
//    }
//
//    @AfterMethod(groups = {"CD", "test"})
//    public void afterMethod(ITestResult result) {
//        //SQLDemonstration.finalizePacientName(nameGen);
////        if (!result.isSuccess()) {
////            try {
////                WebDriver returned = new Augmenter().augment(driver);
////                if (returned != null) {
////                    File f = ((TakesScreenshot) returned).getScreenshotAs(OutputType.FILE);
////                    try {
////                        FileUtils.copyFile(f, new File("D:\\Test_results\\" + result.getName() + " " + /*getFileName()*/ ".jpg"));
////                    } catch (IOException e) {
////                        e.printStackTrace();
////                    }
////                }
////            } catch (ScreenshotException se) {
////                se.printStackTrace();
////            }
////        }
//    }
//
//    @Test(groups = "test", description = "фильтр поиск по ФИО")
//    @Issue("EMIAS-90")
//    @RetryCountIfFailed(2)
//    public void testFilterFIO() throws InterruptedException {
//        //driver.get(curUrlCalldoctor);
//
//        page.createCallPage().createCallProfile1(nameGen);
//        page.fullCardPage().closeCardBtn();
//
//        page.dashboardPage().searchFilterFio(nameGen)
//                .verifyNewCallProgressFrame(nameGen, adressPro1_3, telephonePro1);
//    }
//
////    @Listeners({CustomTestListener.class}) //https://automated-testing.info/t/pomogite-podklyuchit-allure-k-proektu-java-testng-maven/7122/15
//    @Attachment(value = "Console error", type = "text/plain")
//    @Test(groups = "test", description = "фильтр поиск по врачу")
//    @Issue("EMIAS-90")
//    @RetryCountIfFailed(0)
//    public void testFilterDoctor() throws InterruptedException {
//        //driver.get(curUrlCalldoctor);
//
//        page.createCallPage().createCallProfile1(nameGen);
//
//        page.fullCardPage().appoindDoctorBtn();
//        page.setDoctorPage().appendDoctor(doctorFamPro1);
//        page.fullCardPage().closeCardBtn();
//
//        page.dashboardPage()
//                .searchFilterDoctor(doctorFamPro1)
//                .verifyActiveDocGroup(doctorFamPro1, nameGen, adressPro1_2, telephonePro1);
//    }
//
//    @Test(groups = "test", description = "фильтр поиск по виду вызова")
//    @Issue("EMIAS-90")
//    @RetryCountIfFailed(2)
//    public void testTypeCall() throws InterruptedException {
//        page.createCallPage().createCallProfile3(nameGen);
//        //driver.get(curUrlCalldoctor);
//
//        page.dashboardPage().openNewCallProgressFrame(nameGen);
//        page.fullCardPage()
//                .verifyCallProfile3(nameGen)
//                .closeCardBtn();
//
//        page.dashboardPage()
//                .searchFilterFio(nameGen)
//                .searchFilterTypeCallNeotlozhniy()
//                .verifyNewCallProgressFrame(nameGen, adressPro3, telephonePro1);
//    }
}