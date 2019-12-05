package com.commons.Selenium;

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

import static com.codeborne.selenide.Selenide.sleep;
import static com.pages.WebPage.logger;

public class Status {
    static String URL = "http://localhost:4444/grid/api/hub";
    static HttpClient httpClient = HttpClients.createDefault();
    static HttpResponse httpResponse;
    static HttpEntity entity;
    static String responseString;
    final static int SEC_COUNT = 10;

    /*при запуске проекта первое обращение на адрес селениума, проверка что он запущен*/
    static boolean checkRunningStatus()   {
        logger.info("Проверка запущен ли селениум");
        if (response()) {
            logger.info("Проверка показала что селениум уже запущен!");
            return true;
        }
        logger.info("Проверка показала что селениум не запущен...");
        return false;
    }

    static boolean checkWorkStatus()  {
        for (int i = 1; i <= SEC_COUNT; i++) {
            int free = 0;
            int total = 0;
            try {
                free = Integer.parseInt(new JSONObject(responseString).getJSONObject("slotCounts").getString("free"));
                total = Integer.parseInt(new JSONObject(responseString).getJSONObject("slotCounts").getString("total"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (free == total)
                return true;
            sleep(1000);
        }
        return false;
    }

    static boolean response()   {
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
        try {
            if (httpResponse != null
                    && httpResponse.getStatusLine().getStatusCode() == 200
                    && new JSONObject(responseString).getString("success").equals("true"))
                return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }
}