package pages.utilities;

import java.io.IOException;

public class RunSeleniumGrid {

    public static void run() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"cd src/main/resources && start run_grid.bat && exit\"");
        Thread.sleep(5000);
        System.out.println("Запустил Selenium grid");
    }

    public static void stop() throws IOException, InterruptedException {
        // TODO: 9/19/2018 ноду не останавливает. Нужно доделать
//        Runtime.getRuntime().exec("curl http://localhost:4444/lifecycle-manager?action=shutdown");
        Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"cd src/main/resources && start kill_grid.bat && exit\"");
        Thread.sleep(5000);
        System.out.println("Остановил хаб Selenium grid");
    }
}