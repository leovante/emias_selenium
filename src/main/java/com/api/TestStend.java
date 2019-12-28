package com.api;

import com.codeborne.selenide.Condition;
import com.settings.ConfigFile;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class TestStend {
//    private static Logger logger = LogManager.getLogger();
    private ConfigFile configFile;

    public TestStend() {
         configFile = new ConfigFile();
    }

    public Boolean call_doctor_ef_api() throws IOException {
        String pingCD = configFile.getUrlServices() + "/call/call_doctor_ef_api/ping";
//        HttpUriRequest request = new HttpGet(pingCD);
//        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        String result;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response;
        try {
            HttpGet httpGet = new HttpGet(pingCD);
//            httpGet.setHeader(forwardedForHeader);
            response = httpclient.execute(httpGet);
            try {
                result = EntityUtils.toString(response.getEntity());
//                if (logger.isDebugEnabled()) {
//                    logger.debug(result);
//                }
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
/*        try {
            httpResponse = HttpClientBuilder.create().build().execute(request);
        } catch (HttpHostConnectException e) {
            logger.error("Не удалось подключиться к " + request);
            e.printStackTrace();
        }*/
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
            return true;
        return false;
    }

    public Boolean kladrsave() throws IOException {
        HttpPost request = new HttpPost(configFile.getUrlServices() + "/api/kladrsave/find");
        String body = "{\"code\":\"5000002713600\",\"query\":\"заречная\"}";

        request.addHeader("Content-Type", "application/json");
        StringEntity stringEntity = new StringEntity(body, "UTF-8");
        request.setEntity(stringEntity);

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
            return true;
        return false;
    }

    public Boolean ehr_medrecords()  {
        open(configFile.getMrFromTap());
        if ($x("//*[contains(text(),'Медицинские записи')]")
                .shouldBe(Condition.visible)
                .is(Condition.visible))
            return true;
        return false;
    }

    public Boolean disp_journal()  {
        open(configFile.getDispJournal());
        if ($x("//*[contains(text(),'Журнал')]")
                .shouldBe(Condition.visible)
                .is(Condition.visible))
            return true;
        return false;
    }

    public Boolean disp_card()  {
        open(configFile.getDispCard());
        if ($x("//*[contains(text(),'Карта мероприятий')]")
                .shouldBe(Condition.visible)
                .is(Condition.visible))
            return true;
        return false;
    }

    public Boolean calldoctor()  {
        open(configFile.getCalldoctor());
        if ($x("//*[contains(.,'Добавить вызов')]")
                .shouldBe(Condition.visible)
                .is(Condition.visible))
            return true;
        return false;
    }

    public Boolean calldoctorVz()  {
        open(configFile.getCalldoctorVz());
        if ($x("//*[contains(.,'Взрослая поликлиника')]")
                .shouldBe(Condition.visible)
                .is(Condition.visible))
            return true;
        return false;
    }
}