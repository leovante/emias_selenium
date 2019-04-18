package emias.disp.regress;

import emias.TestBase;
import org.testng.annotations.Test;
import utils.testngRetryCount.RetryCountIfFailed;

public class ValidationTest extends TestBase {

    @Test(groups = "disp", description = "значения в показателях")
    @RetryCountIfFailed(3)
    public void testFillExamp() throws InterruptedException {

    }
    // TODO: 3/22/2019 сделать тест валидации в показателях. Запрет пустых значений и пробелов
}