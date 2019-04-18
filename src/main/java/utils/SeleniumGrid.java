package utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import pages.AbstractPage;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

public class SeleniumGrid extends AbstractPage {
    public static void run(String gridIsRun) throws Exception {
        if (gridIsRun != null && !statusGrid.checkStatusBeforeRunning()) {
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"cd src/main/resources/selenium_grid && start run_grid.bat && exit\"");
            statusGrid.checkRunningIsSuccesfull();
            LOGGER.info("Selenium Grid запущен!");
        } else {
            LOGGER.info("Selenium Grid не запущен!");
        }
    }

    public static void stop(String gridIsRun) throws IOException, JSONException, InterruptedException {
        if (gridIsRun != null && statusGrid.checkIsNotWorkStatus()) {
            URL urlHub = new URL("http://localhost:4444/lifecycle-manager?action=shutdown");
            urlHub.openConnection().getInputStream();
            URL urlNode = new URL("http://localhost:5558/extra/LifecycleServlet?action=shutdown");
            urlNode.openConnection().getInputStream();
            LOGGER.info("Остановил хаб Selenium grid");
        } else {
            LOGGER.info("Селениум грид работает, остановка невозможна!");
        }
    }

    /**
     * новый класс проверки статуса селениума
     */
    static class statusGrid {
        static String URL = "http://localhost:4444/grid/api/hub";
        static HttpClient httpClient = HttpClients.createDefault();
        static HttpResponse httpResponse;
        static HttpEntity entity;
        static String responseString;
        final static int SEC_COUNT = 5;

        static void checkRunningIsSuccesfull() throws JSONException, InterruptedException, IOException {
            if (!chekResponseStatusAndStatusField()) {
                LOGGER.info("Не удалось запустить Selenium Grid, выход с кодом 1");

            }
        }

        /*при запуске проекта первое обращение на адрес селениума, проверка что он запущен*/
        static boolean checkStatusBeforeRunning() throws JSONException, InterruptedException, IOException {
            LOGGER.info("Проверка запущен ли селениум");
            if (responseIsSuccess()) {
                LOGGER.info("Проверка показала что селениум уже запущен!");
                return true;
            }
            LOGGER.info("Проверка показала что селениум не запущен...");
            return false;
        }


        static boolean checkIsNotWorkStatus() throws InterruptedException, JSONException {
            for (int i = 1; i <= SEC_COUNT; i++) {
                int free = Integer.parseInt(new JSONObject(responseString).getJSONObject("slotCounts").getString("free"));
                int total = Integer.parseInt(new JSONObject(responseString).getJSONObject("slotCounts").getString("total"));
                if (free == total)
                    return true;
                Thread.sleep(1000);
            }
            return false;
        }

        /*проверка что ответ 200*/
        static boolean chekResponseStatusAndStatusField() throws InterruptedException, JSONException {
            boolean a = false;
            for (int i = 0; i < SEC_COUNT; i++) {
                if (responseIsSuccess()) {
                    return true;
                }
                Thread.sleep(1000);
            }
            LOGGER.info(String.valueOf(a));
            return false;
        }
        /*

         */
        /*проверка что селениум запущен*//*

        static boolean chekStatusField() throws JSONException, InterruptedException {
            for (int i = 0; i < SEC_COUNT; i++) {
                if (new JSONObject(responseString).getString("success").equals(true))
                    return true;
                Thread.sleep(1000);
            }
            return false;
        }
*/

        static boolean responseIsSuccess() throws JSONException {
            try {
                httpResponse = httpClient.execute(new HttpGet(URL));
                entity = httpResponse.getEntity();
                responseString = EntityUtils.toString(entity, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                LOGGER.info("Не могу подключиться. Код ошибки - 1!");
            } catch (ClientProtocolException e) {
                LOGGER.info("Не могу подключиться. Код ошибки - 2!");
            } catch (IOException e) {
                LOGGER.info("Не могу подключиться. Код ошибки - 3!");
            }
            if (httpResponse != null &&
                    httpResponse.getStatusLine().getStatusCode() == 200 &&
                    new JSONObject(responseString).getString("success").equals("true"))
                return true;
            return false;
        }
    }
    // TODO: 11/2/2018 сделать параллельный запуск старой версии хрома
}