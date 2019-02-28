package emias.calldoctor.e2e;

import emias.AbstractTestGrid;
import io.qameta.allure.Epic;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import pages.calldoctor.profiles_interfaces.Pacient;
import system.service.HltMkabService;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.util.List;

public class CreateCallTest extends AbstractTestGrid {

    @Autowired
    private HltMkabService hltMkabService;

    @Test(groups = "e2e", description = "")
    @RetryCountIfFailed(2)
    public void testCallRegistrMkab() {
        List l = hltMkabService.findByIdList(2662108);
        System.out.println("Ответик" + l);
    }

    @Test(groups = "CD", description = "вызов с иточником Регистратура без МКАБ")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallRegistrWithGenerator() throws Exception {


        Pacient pacient = new Pacient("Profile1");
        enter.enterCalldoctorFromMis();
        page.createCallPage(pacient).createCall();
        page.fullCardPage(testName())
                .verifyNewCall(pacient)
                .closeCardBtn();
        page.dashboardPage().verifyNewCallGroup(pacient);
    }
}