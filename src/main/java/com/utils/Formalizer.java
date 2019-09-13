package com.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static com.pages.BasePage.LOGGER;

public class Formalizer {
    HttpResponse httpResponse;
    HttpGet httpget;
    String requestSmp = "http://service.emias.mosreg.ru/test/callhome/api/parseaddress/parse?address=";
    String responseString;
    HttpEntity entity;

    public Formalizer(String addressString) throws UnsupportedEncodingException {
        this.requestSmp = requestSmp + URLEncoder.encode(addressString, "UTF-8");
    }

    public Formalizer sendToFormalizer() {
        HttpClient httpClient = HttpClients.createDefault();
        try {
            httpResponse = httpClient.execute(createRequest());
            entity = httpResponse.getEntity();
            responseString = EntityUtils.toString(entity, "UTF-8");
            statusBodyResponce(httpResponse);
            LOGGER.info("энтити: " + String.valueOf(entity));
        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.info("Error, " + "Cannot Estabilish Connection");
        }
        return this;
    }

    public HttpGet createRequest() {
        httpget = new HttpGet(requestSmp);
        httpget.addHeader("content-type", "application/json");
        httpget.addHeader("connection", "keep-alive");
        return httpget;
    }

    protected void statusBodyResponce(HttpResponse resp) throws IOException {
        if (resp.getStatusLine().getStatusCode() != 200) {
            LOGGER.info("Ошибка! Ответ сервера:\n" + EntityUtils.toString(resp.getEntity(), "UTF-8"));
        }
    }

    public String getEntity() throws IOException, JSONException {
        String text = null;
        JSONObject responseText = new JSONObject(responseString)
                .getJSONObject("SOAP-ENV:Envelope")
                .getJSONObject("SOAP-ENV:Body")
                .getJSONObject("NS1:workPocketAdrResponse")
                .getJSONObject("NS2:TPacketAdr")
                .getJSONObject("fullKLADRCodeAddress");
        if (responseText.has("#text")) {
            LOGGER.info("#text: " + responseText.getString("#text"));
            return responseText.getString("#text");
        }
        return text;
    }
}