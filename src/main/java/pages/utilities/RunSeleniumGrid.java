package pages.utilities;

import java.io.IOException;

public class RunSeleniumGrid {

    public static void run() throws IOException {
//        Runtime.
//                getRuntime().
//                exec("src/main/resources/run_grid.bat");

        ProcessBuilder pb = new ProcessBuilder();
        pb.command("java ", "-jar ", "src/main/resources/selenium-server-standalone-3.14.0.jar ", "-role hub", "-hubConfig src/main/resources/hubconfig.json");
//        pb.command("java", "-jar", "src/main/resources/selenium-server-standalone-3.14.0.jar", "-role node", "-nodeConfig nodeconfig.json");
        Process p = pb.start();

        System.out.println("Запустил Selenium Grid");
    }
}