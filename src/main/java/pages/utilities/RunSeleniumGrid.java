package pages.utilities;

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
import java.net.URL;

public class RunSeleniumGrid {
    public static void run() throws Exception {
        Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"cd src/main/resources/selenium_grid && start run_grid.bat && exit\"");
        statusGrid.chekStatus();
        System.out.println("Selenium Grid Запущен!");
    }

    public static void stop() throws IOException {
        URL url = new URL("http://localhost:4444/lifecycle-manager?action=shutdown");
        url.openConnection().getInputStream();
        url = new URL("http://localhost:5558/extra/LifecycleServlet?action=shutdown");
        url.openConnection().getInputStream();
        System.out.println("Остановил хаб Selenium grid");
    }

    static class statusGrid {
        static String URL = "http://localhost:4444/grid/api/hub";
        static HttpClient httpClient = HttpClients.createDefault();
        static HttpResponse httpResponse;
        static HttpEntity entity;
        static String responseString;
        static String jsonOb;
        static int SEC_COUNT = 10;
        static int statCode;//200 is true

        static void chekStatus() throws JSONException, InterruptedException, IOException {
            if (!chekResponseStatus() && !chekStatusField())
                throw new RuntimeException("Ошибка. Вышло время подключения к Selenium Grid!");
        }

        static void getResponse(String URL) throws IOException {
            try {
                httpResponse = httpClient.execute(new HttpGet(URL));
                entity = httpResponse.getEntity();
                responseString = EntityUtils.toString(entity, "UTF-8");
            } catch (ClientProtocolException e) {
                System.out.println("Не могу подключиться!");
            }
        }

        static boolean chekResponseStatus() throws InterruptedException, IOException {
            int SEC_CURRENT = 1; // default=1 max=20
            while (SEC_CURRENT <= SEC_COUNT) {
                getResponse(URL);
                statCode = httpResponse.getStatusLine().getStatusCode();
                if (statCode == 200)
                    return true;
                Thread.sleep(1000);
                SEC_CURRENT++;
            }
            return false;
        }

        static boolean chekStatusField() throws JSONException, InterruptedException {
            int SEC_CURRENT = 1; // default=1 max=20
            while (SEC_CURRENT <= SEC_COUNT) {
                jsonOb = new JSONObject(responseString).getString("success");
                if (jsonOb.equals(true))
                    return true;
                Thread.sleep(1000);
                SEC_CURRENT++;
            }
            return false;
        }
    }
}