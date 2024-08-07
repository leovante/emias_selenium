package com.utils.Selenium;

import com.pages.BasePage;
import org.json.JSONException;
import org.testng.SkipException;

import java.io.IOException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.sleep;

public class SeleniumGrid extends BasePage {
    static boolean status = false;
    static boolean grid = false;
    static boolean working = false;
    static int count = 10;
    static String command = "cmd /c start cmd.exe /K \"cd C:/chromedriver && start run_grid.bat && exit\"";

    public SeleniumGrid() throws IOException {
    }

    private static void checkStatus() {
        status = Status.checkRunningStatus();
        if (status)
            working = Status.checkWorkStatus();
    }

    public static void run(String gridRun)   {
        checkStatus();
        grid = Boolean.parseBoolean(gridRun);
        if (grid && !status) {
            try {
                Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < count; i++) {
                checkStatus();
                if (status && working)
                    break;
                else {
                    if (count - 1 == i)
                        throw new SkipException("Грид не может запуститься");
                }
                sleep(1000);
            }
            logger.info("Selenium Grid запущен!");
        } else {
            logger.info("Selenium Grid не запускался!");
        }
    }

    public static void stop() throws IOException, JSONException, InterruptedException {
        checkStatus();
        if (grid) {
            URL urlHub = new URL("http://localhost:4444/lifecycle-manager?action=shutdown");
            urlHub.openConnection().getInputStream();
            URL urlNode = new URL("http://localhost:5558/extra/LifecycleServlet?action=shutdown");
            urlNode.openConnection().getInputStream();
            logger.info("Остановил хаб Selenium grid");
        } else {
            logger.info("Селениум грид работает, остановка невозможна!");
        }
        logger.info("Тестирование закончено!");
    }
}