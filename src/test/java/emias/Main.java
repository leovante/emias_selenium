package emias;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.collections.Lists;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ReportPortalTestNGListener listener = new ReportPortalTestNGListener();
        TestNG testNg = new TestNG();
        List<String> lSuites = Lists.newArrayList();
        Collections.addAll(lSuites, "test.xml");
        testNg.setTestSuites(lSuites);
        testNg.addListener((ITestNGListener) listener);
        testNg.run();
    }
}