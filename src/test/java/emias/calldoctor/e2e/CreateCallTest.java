package emias.calldoctor.e2e;

import com.system.model.HltMkabEntity;
import com.system.service.HltMkabServiceImpl;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.Optional;

public class CreateCallTest extends TestBase {

    @Autowired
    private HltMkabServiceImpl hltMkabService;

    @Test(groups = "e2e", description = "пытаюсь взять модель с двумя таблицами")
    @RetryCountIfFailed(2)
    public void testHiber() {
        Optional<HltMkabEntity> en = hltMkabService.findById(2467544);
        System.out.println(en);
    }
}