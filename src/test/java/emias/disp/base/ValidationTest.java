package emias.disp.base;

import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import org.testng.annotations.Test;

public class ValidationTest extends TestBase {

    @Test(groups = "disp", description = "значения в показателях")
    @RetryCountIfFailed(3)
    public void testFillExamp() throws InterruptedException {

    }
    // TODO: 3/22/2019 сделать тест валидации в показателях. Запрет пустых значений и пробелов
}