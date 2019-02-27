package emias.calldoctor.e2e;

import emias.AbstractTestGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import system.model.HltMkabEntity;
import system.service.HltMkabService;
import utilities.testngRetryCount.RetryCountIfFailed;

public class CreateCallTest extends AbstractTestGrid {

    @Autowired
    private HltMkabService hltMkabService;

    @Test(groups = "e2e", description = "")
    @RetryCountIfFailed(2)
    public void testCallRegistrMkab() {
        HltMkabEntity hltMkabEntity = hltMkabService.findById(2662108);
        System.out.println(hltMkabEntity.getFamily());
    }
}