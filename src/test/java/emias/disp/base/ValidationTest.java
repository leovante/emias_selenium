package emias.disp.base;

import com.utils.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class ValidationTest extends TestBase {

    @Test(groups = "disp", description = "значения в показателях")
    @RetryCountIfFailed(2)
    public void testFillExamp() throws InterruptedException {

    }
    // TODO: 3/22/2019 сделать тест валидации в показателях. Запрет пустых значений и пробелов
}