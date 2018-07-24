package emias.calldoctor;

import emias.AbstractTest;

public class RCD02Test extends AbstractTest {
    String nameGen;


//    @BeforeMethod(groups = {"CD", "test"})
//    public void beforeMethod() {
//        StringGenerator nameGen = new StringGenerator();
//        String name = String.valueOf(nameGen.generator());
//        this.nameGen = name;
//    }
//
//    @AfterMethod(groups = {"CD", "test"})
//    public void afterMethod() {
//        //SQLDemonstration.finalizePacientName(nameGen);
//    }
//
//    @Test(groups = "CD", description = "изменить карту вызова из регистратуры")
//    @Issue("EMIAS-90")
//    @RetryCountIfFailed(2)
//    public void testEditProfile1() throws Exception {
//        //driver.get(curUrlCalldoctor);
//        page.createCallPage().createCallProfile1(nameGen);
//        page.createCallPage()
//                .editCallBtn()
//                .verifyCallProfile1(nameGen)
//                .editCallProfile5(nameGen);
//        page.fullCardPage()
//                .verifyCallProfile5(nameGen)
//                .closeCardBtn();
//        page.dashboardPage()
//                .searchFilterFio(nameGen)
//                .verifyNewCallProgressFrame(nameGen, adressPro5_2, telephonePro5);
//    }
}