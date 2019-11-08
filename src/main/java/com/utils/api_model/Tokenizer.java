package com.utils.api_model;

import com.config.ConfigFile;
import com.datas.calldoctor.Pacient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pages.BasePage;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;
import org.testng.Assert;
import org.testng.SkipException;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tokenizer extends BasePage {
    private Pacient pacient;
    private ConfigFile config;

    public Tokenizer(Pacient pacientImpl) {
        this.config = new ConfigFile();
        this.pacient = pacientImpl;
    }

    public String getToken() {
        HttpGet request = new HttpGet(
                requestBuilder(config.getUrlApi(),
                        config.getLpuGuid(),
                        pacient.getBirthdate("yyyy-MM-dd"),
                        pacient.getSeriespol(),
                        pacient.getNumberpol()));
        Map<String, String> responseMap = requestRun(request);
        Map<String, String> proData = null;
        try {
            proData = new ObjectMapper().readValue(responseMap.get("body"), Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return proData.get("token");
    }

    private String requestBuilder(String urlApi, String lpuGuid, String birthdate, String seriespol, String numberpol) {
        String url = "http://";
        if (urlApi.equals("") ||
                lpuGuid.equals("") ||
                birthdate.equals("") ||
                seriespol.equals("") &&
                        numberpol.equals("")) {
            logger.error(
                    "urlApi is :" + urlApi +
                            "lpuGuid is: " + lpuGuid +
                            "birthdate is: " + birthdate +
                            "seriespol is: " + seriespol +
                            "numberpol is: " + numberpol);
            throw new SkipException("Error. Arguments not valid");
        } else {
            url += urlApi + "/auth/" + lpuGuid + "/token?Birthday=" + birthdate + "&n_pol=" + numberpol;
            if (!seriespol.equals(""))
                url += "&s_pol=" + seriespol;
        }
        return url;
    }

    private Map requestRun(HttpGet request)  {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse hr;
        Map<String, String> responseMap = new HashMap<String, String>();
        try {
            try {
                hr = httpClient.execute(request);
                ResponseHandler<String> handler = new BasicResponseHandler();
                String body = handler.handleResponse(hr);
                responseMap.put("body", body);
                try {
                    Scanner sc = new Scanner(hr.getEntity().getContent());
                    while (sc.hasNext()) {
                        logger.info(sc.nextLine());
                    }
                } finally {
                    hr.close();
                }
            } finally {
                httpClient.close();
            }
        }catch (IOException e){}
        return responseMap;
    }
}