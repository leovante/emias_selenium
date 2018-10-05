package pages.calldoctor.profiles_interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest
//@RunWith(SpringRunner.class)
public class PersonRestControllerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private PersonRestController controller;

    @Test
    public void controllerInitializedCorrectly() {
        assertThat(controller).isNotNull();
    }


}