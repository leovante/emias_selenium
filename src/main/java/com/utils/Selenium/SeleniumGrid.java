package com.utils.Selenium;

import com.pages.PageBase;
import org.json.JSONException;
import org.testng.SkipException;

import java.io.IOException;
import java.net.URL;

public class SeleniumGrid extends PageBase {
    static boolean status = false;
    static boolean grid = false;
    static boolean working = false;
    static int count = 10;
    static String command = "cmd /c start cmd.exe /K \"cd %userprofile%/Google Drive/chromedriver && start run_grid.bat && exit\"";

    private static void checkStatus() throws InterruptedException, IOException, JSONException {
        status = Status.checkRunningStatus();
        if (status)
            working = Status.checkWorkStatus();
    }

    public static void run(String gridRun) throws Exception {
        checkStatus();
        grid = Boolean.parseBoolean(gridRun);
        if (grid && !status) {
            Runtime.getRuntime().exec(command);
            for (int i = 0; i < count; i++) {
                checkStatus();
                if (status && working)
                    break;
                else {
                    if (count - 1 == i)
                        throw new SkipException("Грид не может запуститься");
                }
                Thread.sleep(1000);
            }
            LOGGER.info("Selenium Grid запущен!");
        } else {
            LOGGER.info("Selenium Grid не запускался!");
        }
    }

    public static void stop() throws IOException, JSONException, InterruptedException {
        checkStatus();
        if (grid) {
            URL urlHub = new URL("http://localhost:4444/lifecycle-manager?action=shutdown");
            urlHub.openConnection().getInputStream();
            URL urlNode = new URL("http://localhost:5558/extra/LifecycleServlet?action=shutdown");
            urlNode.openConnection().getInputStream();
            LOGGER.info("Остановил хаб Selenium grid");
        } else {
            LOGGER.info("Селениум грид работает, остановка невозможна!");
        }
        LOGGER.info("Тестирование закончено!");
    }

    // TODO: 11/2/2018 сделать параллельный запуск старой версии хрома
}