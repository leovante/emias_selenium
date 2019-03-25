package emias.disp.regress;

import emias.AbstractTestGrid;
import org.testng.annotations.Test;
import utilities.testngRetryCount.RetryCountIfFailed;

public class ValidationTest extends AbstractTestGrid {

    @Test(groups = "disp", description = "значения в показателях")
    @RetryCountIfFailed(3)
    public void testFillExamp() throws InterruptedException {

    }
    // TODO: 3/22/2019 сделать тест валидации в показателях. Запрет пустых значений и пробелов
}