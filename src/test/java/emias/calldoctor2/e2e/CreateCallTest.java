package emias.calldoctor2.e2e;

import dataGenerator.ModuleData;
import emias.TestBase;
import org.testng.annotations.Test;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;
import java.util.List;

import static dataGenerator.DataType.CalldoctorData;

public class CreateCallTest extends TestBase {


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
        page.loginPage().calldoctor();
        page.createCallPage(mData).createCall();
        page.fullCardPage(mData)
                .verifyNewCall()
                .closeCardBtn();
        page.dashboardPage(mData).verifyNewCallGroup();
    }
}