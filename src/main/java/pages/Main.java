package pages;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        TestListenerAdapter tla = new TestListenerAdapter();
//        TestNG testng = new TestNG();
//        List<String> suites = Lists.newArrayList();
//        suites.add("src/test/resources/testngMIS.xml");
//        suites.add("src/test/resources/testngCD.xml");
//        suites.add("src/test/resources/testngTest.xml");
//        testng.setTestSuites(suites);
//        testng.run();

        int[] arr1 = Arrays.asList(args[0].split(",")).stream().mapToInt(Integer::parseInt).toArray();

    }
}