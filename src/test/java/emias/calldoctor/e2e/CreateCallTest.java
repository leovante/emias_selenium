package emias.calldoctor.e2e;

import dataGenerator.FactoryData;
import dataGenerator.ModuleData;
import emias.AbstractTestGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import system.service.HltMkabService;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import static dataGenerator.DataType.CalldoctorData;

public class CreateCallTest extends AbstractTestGrid {

    @Autowired
    private HltMkabService hltMkabService;

    @Autowired
    private FactoryData factoryData;

    @Test(groups = "e2e", description = "")
    @RetryCountIfFailed(2)
    public void testCallRegistrMkab() {
        List l = hltMkabService.findByIdList(2662108);
        System.out.println("Ответик" + l);
    }

    @Test(groups = "e2e", description = "")
    @RetryCountIfFailed(2)
    public void testCallRegistrWithGenerator() throws InterruptedException, ParseException, IOException {
        ModuleData mData = factoryData
                .getData(CalldoctorData)
                .findByModel()
                .setDopData("СМП", "жалоба", "адрес");

        enter.enterCalldoctorFromMis();
        page.createCallPage(mData).createCall();
        page.fullCardPage(mData)
                .verifyNewCall()
                .closeCardBtn();
        page.dashboardPage(mData).verifyNewCallGroup();
    }
}