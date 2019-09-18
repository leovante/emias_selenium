package com.utils.Selenium;

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

import static com.pages.BasePage.logger;

public class Status {
    static String URL = "http://localhost:4444/grid/api/hub";
    static HttpClient httpClient = HttpClients.createDefault();
    static HttpResponse httpResponse;
    static HttpEntity entity;
    static String responseString;
    final static int SEC_COUNT = 10;

    /*при запуске проекта первое обращение на адрес селениума, проверка что он запущен*/
    static boolean checkRunningStatus() throws JSONException, InterruptedException, IOException {
        logger.info("Проверка запущен ли селениум");
        if (response()) {
            logger.info("Проверка показала что селениум уже запущен!");
            return true;
        }
        logger.info("Проверка показала что селениум не запущен...");
        return false;
    }

    static boolean checkWorkStatus() throws InterruptedException, JSONException {
        for (int i = 1; i <= SEC_COUNT; i++) {
            int free = Integer.parseInt(new JSONObject(responseString).getJSONObject("slotCounts").getString("free"));
            int total = Integer.parseInt(new JSONObject(responseString).getJSONObject("slotCounts").getString("total"));
            if (free == total)
                return true;
            Thread.sleep(1000);
        }
        return false;
    }

    static boolean response() throws JSONException {
        try {
            httpResponse = httpClient.execute(new HttpGet(URL));
            entity = httpResponse.getEntity();
            responseString = EntityUtils.toString(entity, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.info("Не могу подключиться. Код ошибки - 1!");
        } catch (ClientProtocolException e) {
            logger.info("Не могу подключиться. Код ошибки - 2!");
        } catch (IOException e) {
            logger.info("Не могу подключиться. Код ошибки - 3!");
        }
        if (httpResponse != null
                && httpResponse.getStatusLine().getStatusCode() == 200
                && new JSONObject(responseString).getString("success").equals("true"))
            return true;
        return false;
    }
}