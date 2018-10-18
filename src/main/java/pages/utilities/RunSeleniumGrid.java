package pages.utilities;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

public class RunSeleniumGrid {

    public static void run() throws Exception {
        Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"cd src/main/resources/selenium_grid && start run_grid.bat && exit\"");
        chekStatusGrid();
    }

    public static void stop() throws IOException {
        URL url = new URL("http://localhost:4444/lifecycle-manager?action=shutdown");
        url.openConnection().getInputStream();
        url = new URL("http://localhost:5558/extra/LifecycleServlet?action=shutdown");
        url.openConnection().getInputStream();
        System.out.println("Остановил хаб Selenium grid");
    }

    static void chekStatusGrid() throws Exception {
        String URL = "http://localhost:4444/grid/api/hub";
        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse httpResponse;
        HttpEntity entity;
        String responseString;
        JSONObject jsonOb;
        try {
            httpResponse = httpClient.execute(new HttpGet(URL));
            entity = httpResponse.getEntity();
            responseString = EntityUtils.toString(entity, "UTF-8");
            for (int i = 0; i < 20; i++) {
                int statCode = httpResponse.getStatusLine().getStatusCode();
                jsonOb = new JSONObject(responseString);
                String jsonObj = jsonOb.getString("success");
                if (!(statCode == 200) && !jsonObj.equals(true)) {
                    Thread.sleep(1000);
                } else {
                    break;
                }
                if (i == 19)
                    throw new Exception("Ошибка. Вышло время подключения к Selenium Grid!");
            }
        } catch (ClientProtocolException e) {

        } catch (IOException e) {

        }
        System.out.println("Selenium Grid Запущен!");
    }
}