package emias.calldoctor.e2e;

import emias.AbstractTestGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import system.model.HltMkabEntity;
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

    @Test(groups = "e2e", description = "")
    @RetryCountIfFailed(2)
    public void testCallRegistrWithGenerator() throws Exception {
        HltMkabEntity mkab = hltMkabService.findByModel();
//        Pacient pacient = new Pacient("Profile1");
//        Caller caller = new CallerFromApi(mkab);
        //сделать фабрику на тип вызова
        //в ручную или по апи
        //если в ручную, то от смп или от регистратуры
        //если по апи, то методом с авторизацией или без


        enter.enterCalldoctorFromMis();
        page.createCallPage(mkab).createCall();
        page.fullCardPage(testName())
                .verifyNewCall(mkab)
                .closeCardBtn();
        page.dashboardPage().verifyNewCallGroup(mkab);
    }
}