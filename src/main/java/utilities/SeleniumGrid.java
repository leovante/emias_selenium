package utilities;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

public class SeleniumGrid {
    public static void run(String gridIsRun) throws Exception {
        if (gridIsRun != null && !statusGrid.checkStatus()) {
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"cd src/main/resources/selenium_grid && start run_grid.bat && exit\"");
            statusGrid.chekStatus();
            System.out.println("Selenium Grid запущен!");
        } else {
            System.out.println("Selenium Grid не запущен!");
        }
    }

    public static void stop(String gridIsRun) throws IOException {
        if (gridIsRun != null) {
            URL urlHub = new URL("http://localhost:4444/lifecycle-manager?action=shutdown");
            urlHub.openConnection().getInputStream();
            URL urlNode = new URL("http://localhost:5558/extra/LifecycleServlet?action=shutdown");
            urlNode.openConnection().getInputStream();
            System.out.println("Остановил хаб Selenium grid");
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
        final static int SEC_COUNT = 10;

        static void chekStatus() throws JSONException, InterruptedException, IOException {
            if (!chekResponseStatus() && !chekStatusField()) {
                System.out.println("Не удалось запустить Selenium Grid, выход с кодом 1");
                System.exit(1);
            }
        }

        /*при запуске проекта первое обращение на адрес селениума, проверка что он запущен*/
        static boolean checkStatus() throws JSONException, InterruptedException, IOException {
            System.out.println("Проверка запущен ли селениум");
            if (chekResponseStatus() && chekStatusField()) {
                System.out.println("Селениум уже запущен!");
                return true;
            }
            System.out.println("Селениум не запущен...");
            return false;
        }

        /*проверка что ответ 200*/
        static boolean chekResponseStatus() throws InterruptedException, IOException {
            for (int i = 0; i < SEC_COUNT; i++) {
                getResponse(URL);
                if (httpResponse != null && httpResponse.getStatusLine().getStatusCode() == 200)
                    return true;
                Thread.sleep(1000);
            }
            return false;
        }

        /*проверка что селениум запущен*/
        static boolean chekStatusField() throws JSONException, InterruptedException {
            for (int i = 0; i < SEC_COUNT; i++) {
                if (new JSONObject(responseString).getString("success").equals(true))
                    return true;
                Thread.sleep(1000);
            }
            return false;
        }

        static void getResponse(String URL) {
            try {
                httpResponse = httpClient.execute(new HttpGet(URL));
                entity = httpResponse.getEntity();
                responseString = EntityUtils.toString(entity, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                System.out.println("Не могу подключиться. Код ошибки - 1!");
            } catch (ClientProtocolException e) {
                System.out.println("Не могу подключиться. Код ошибки - 2!");
            } catch (IOException e) {
                System.out.println("Не могу подключиться. Код ошибки - 3!");
            }
        }
    }
    // TODO: 11/2/2018 сделать параллельный запуск старой версии хрома
}