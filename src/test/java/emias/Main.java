package emias;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add("src/test/resources/testngMIS.xml");
        suites.add("src/test/resources/testngCD.xml");
        suites.add("src/test/resources/testngTest.xml");
        testng.setTestSuites(suites);
        testng.run();
    }
}