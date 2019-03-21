package emias.calldoctor.e2e;

import dataGenerator.FactoryData;
import dataGenerator.ModuleData;
import emias.AbstractTestGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import system.service.HltMkabService;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;
import java.util.List;

import static dataGenerator.DataType.CalldoctorData;

public class CreateCallTest extends AbstractTestGrid {

    @Autowired
    private FactoryData factoryData;

    @Autowired
    private HltMkabService hltMkabService;

    @Test(groups = "e2e", description = "пытаюсь взять модель с двумя таблицами")
    @RetryCountIfFailed(2)
    public void testHiber() {
        List a = hltMkabService.modelWithKladr();
        System.out.println(a);
    }

    @Test(groups = "e2e", description = "первый тест с генератором тестовых данных")
    @RetryCountIfFailed(2)
    public void testCallRegistrWithGenerator() throws InterruptedException, IOException {
        ModuleData mData = factoryData
                .getData(CalldoctorData)
                .findByModel()
                .setDopData(false, false, "СМП", "", "");
        enter.enterCalldoctorFromMis();
        page.createCallPage(mData).createCall();
        page.fullCardPage(mData)
                .verifyNewCall()
                .closeCardBtn();
        page.dashboardPage(mData).verifyNewCallGroup();
    }
}