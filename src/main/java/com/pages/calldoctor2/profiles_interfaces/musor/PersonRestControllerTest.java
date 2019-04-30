package com.pages.calldoctor2.profiles_interfaces.musor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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