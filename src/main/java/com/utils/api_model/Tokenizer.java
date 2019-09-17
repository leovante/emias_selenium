package com.utils.api_model;

import com.config.ConfigFile;
import com.datas.calldoctor.PacientImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pages.BasePage;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;

import java.io.IOException;
import java.util.Map;

public class Tokenizer extends BasePage {
    ConfigFile configFile;
    public static String token;
    HttpResponse response;

    public Tokenizer() throws IOException {
        configFile = new ConfigFile();
    }

    public String getToken(PacientImpl pacientImpl, String ClientApplication) throws IOException {
        String bd = pacientImpl.getBirthdate("yyyy-MM-dd");
        String spol = pacientImpl.getSeriespol();
        String npol = pacientImpl.getNumberpol();
        HttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet request = new HttpGet("http://rpgu.emias.mosreg.ru/api/v2/auth/a7f391d4-d5d8-44d5-a770-f7b527bb1233/token?Birthday=" + bd + "&s_pol=" + spol + "&n_pol=" + npol);
            request.addHeader("ClientApplication", ClientApplication);

            ResponseHandler<String> handler = new BasicResponseHandler();
            String jString = httpClient.execute(request, handler);

            this.response = httpClient.execute(request);
            Assert.assertEquals(response.getStatusLine().getStatusCode(), 200, "Не удаётся получить токен для создания вызова!");

            Map<String, String> proData = new ObjectMapper().readValue(jString, Map.class);
            token = proData.get("token");
        } catch (Exception ex) {
            ex.printStackTrace();
            logger2.info("Ответ:\n" + response.getEntity().getContent());
            logger2.info("Ошибка. Не удается подключиться!");
        }
        return token;
    }
}