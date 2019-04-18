package emias.calldoctor2.e2e;

import dataGenerator.ModuleData;
import emias.TestBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import system.model.HltMkabEntity;
import system.service.HltMkabService;
import utils.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;

import static dataGenerator.DataType.CalldoctorData;

public class CreateCallTest extends TestBase {

//    @Autowired
//    private HltMkabService2 hltMkabService2;

    @Autowired
    private HltMkabService hltMkabService;

    @Test(groups = "e2e", description = "пытаюсь взять модель с двумя таблицами")
    @RetryCountIfFailed(2)
    public void testHiber() {
        HltMkabEntity var = hltMkabService.findById(2467544);
        System.out.println(var);
    }

    @Test(groups = "e2e", description = "первый тест с генератором тестовых данных")
    @RetryCountIfFailed(2)
    public void testCallRegistrWithGenerator() throws InterruptedException, IOException {
        ModuleData mData = factoryData
                .getData(CalldoctorData)
                .findByModel()
                .setDopData(false, false, "СМП", "", "");
        page.loginPage().calldoctor();
        page.createCallPage(mData).createCall();
        page.fullCardPage(mData)
                .verifyNewCall()
                .closeCardBtn();
        page.dashboardPage(mData).verifyNewCallGroup();
    }
}