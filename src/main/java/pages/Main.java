package pages;

import org.openqa.grid.internal.utils.configuration.GridHubConfiguration;
import org.openqa.grid.web.Hub;

public class Main {
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        GridHubConfiguration configHub = new GridHubConfiguration();
        configHub.host = "localhost";
        configHub.port = 8060;

        //GridNodeConfiguration configNode = new GridNodeConfiguration();
        //configNode.host = configHub.host;
        //configNode.port = 5300;

        Hub hub = new Hub(configHub);
        //configNode.getHubHost();
        hub.start();
        //System.out.println(configNode.getRemoteHost());
        //hub.stop();



//        TestListenerAdapter tla = new TestListenerAdapter();
//        TestNG testng = new TestNG();
//        List<String> suites = Lists.newArrayList();
//        suites.add("src/test/resources/testngMIS.xml");
//        suites.add("src/test/resources/testngCD.xml");
//        suites.add("src/test/resources/testngTest.xml");
//        testng.setTestSuites(suites);
//        testng.run();
    }
}