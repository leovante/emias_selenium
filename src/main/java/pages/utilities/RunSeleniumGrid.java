package pages.utilities;

import java.io.IOException;
import java.net.URL;

public class RunSeleniumGrid {

    public static void run() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"cd C:/selenium_grid && start run_grid.bat && exit\"");
        Thread.sleep(5000);
        System.out.println("Запустил Selenium grid");
    }

    public static void stop() throws IOException  {
        URL url = new URL("http://localhost:4444/lifecycle-manager?action=shutdown");
        url.openConnection().getInputStream();
        url = new URL("http://localhost:5558/extra/LifecycleServlet?action=shutdown");
        url.openConnection().getInputStream();
        System.out.println("Остановил хаб Selenium grid");
    }
}