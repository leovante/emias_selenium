package com.utils.api_model;

import com.config.ConfigFile;
import com.datas.calldoctor.Pacient;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.SkipException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CallDoctorHttp {
    private static Logger logger = LogManager.getLogger();
    private Pacient pacientImpl;
    private ConfigFile configFile;
    private HttpPost request;
    private JSONObject jsonOb;

    // TODO: 9/24/2019 навести порядок
    public CallDoctorHttp(Pacient pacientImpl) throws JSONException {
        this.pacientImpl = pacientImpl;
        this.jsonOb = new JSONObject();
        this.configFile = new ConfigFile();
        if (pacientImpl.getName() != null && pacientImpl.getName() != "")
            jsonOb.put("name", pacientImpl.getName());
        if (pacientImpl.getFamily() != null && pacientImpl.getFamily() != "")
            jsonOb.put("family", pacientImpl.getFamily());
        if (pacientImpl.getOt() != null && pacientImpl.getOt() != "")
            jsonOb.put("ot", pacientImpl.getOt());
        if (pacientImpl.getBirthdate() != null && pacientImpl.getBirthdate("yyyy-MM-dd") != "")
            jsonOb.put("birthdate", pacientImpl.getBirthdate("yyyy-MM-dd"));
        if (pacientImpl.getSeriespol() != null && pacientImpl.getSeriespol() != "")
            jsonOb.put("seriespol", pacientImpl.getSeriespol());
        if (pacientImpl.getNumberpol() != null && pacientImpl.getNumberpol() != "")
            jsonOb.put("numberpol", pacientImpl.getNumberpol());
        if (pacientImpl.getGender() != 0)
            jsonOb.put("gender", pacientImpl.getGender());
        if (pacientImpl.getAddress() != null && pacientImpl.getAddress() != "")
            jsonOb.put("address", pacientImpl.getAddress());
        if (pacientImpl.getComplaint() != null && pacientImpl.getComplaint() != "")
            jsonOb.put("complaint", pacientImpl.getComplaint());
        if (pacientImpl.getDiagnosis() != null && pacientImpl.getDiagnosis() != "")
            jsonOb.put("diagnosis", pacientImpl.getDiagnosis());
        if (pacientImpl.getType() != 0)
            jsonOb.put("type", pacientImpl.getType());
        if (pacientImpl.getCodedomophone() != null && pacientImpl.getCodedomophone() != "")
            jsonOb.put("codedomophone", pacientImpl.getCodedomophone());
        if (pacientImpl.getPhone() != null && pacientImpl.getPhone() != "")
            jsonOb.put("phone", pacientImpl.getPhone());
        if (pacientImpl.getSource() != 0)
            jsonOb.put("source", pacientImpl.getSource());
        if (pacientImpl.getSourceName() != null && pacientImpl.getSourceName() != "")
            jsonOb.put("sourceName", pacientImpl.getSourceName());
        if (pacientImpl.getSourceCode() != null && pacientImpl.getSourceCode() != "")
            jsonOb.put("sourceCode", pacientImpl.getSourceCode());
        if (pacientImpl.getEntrance() != null && pacientImpl.getEntrance() != "")
            jsonOb.put("entrance", pacientImpl.getEntrance());
        if (pacientImpl.getEntrance() != null && pacientImpl.getEntrance() != "")
            jsonOb.put("floor", pacientImpl.getFloor());
        if (pacientImpl.getKladraddress() != null && pacientImpl.getKladraddress() != "")
            jsonOb.put("kladraddress", pacientImpl.getKladraddress());
        if (pacientImpl.getCallPersonType() != 0)
            jsonOb.put("callPersonType", pacientImpl.getCallPersonType());
    }

    private HttpPost requestSmp() {
        this.request = new HttpPost(configFile.getRequestSmp());
        this.request.addHeader("content-type", "application/json");
        this.request.addHeader("Authorization", configFile.getAuthorization());
        this.request.addHeader("ClientApplication", configFile.getClientApplication());
        StringEntity params = new StringEntity(jsonOb.toString(), "UTF-8");
        this.request.setEntity(params);
        return request;
    }

    private HttpPost requestToken() {
        this.request = new HttpPost(configFile.getRequestSmp());
        request.addHeader("Content-type", "application/json");
        request.addHeader("ClientApplication", configFile.getClientApplication());
        StringEntity params = new StringEntity(jsonOb.toString(), "UTF-8");
        request.setEntity(params);
        return request;
    }

    private HttpPost requestTokenAuth() throws IOException {
        String token = new Tokenizer(pacientImpl).getToken();
        this.request = new HttpPost(configFile.getRequestSmpAuth());
        request.addHeader("Content-type", "application/json");
        request.addHeader("Authorization", "Bearer " + token);
        StringEntity params = new StringEntity(jsonOb.toString(), "UTF-8");
        request.setEntity(params);
        return request;
    }

    public void execute() {
        HttpResponse httpResponse = null;
        try {
            if (pacientImpl.getSource() == 2) {//смп
                httpResponse = executeRetry(requestSmp());
            }
            if (pacientImpl.getSource() == 3) {//кц с авторизацией
                httpResponse = executeRetry(requestToken());
            }
            if (pacientImpl.getSource() != 2 && pacientImpl.getSource() != 3) {
                logger.error("Can't create request with source " + pacientImpl.getSource());
                throw new SkipException("Error. Can't create request");
            }
        } catch (Exception e) {
            logger.error("Error of execute request " + httpResponse);
            e.printStackTrace();
        }
    }

    public void executeAuth() throws IOException, InterruptedException {
        executeRetry(requestTokenAuth());
    }

    private HttpResponse executeRetry(HttpPost request) throws IOException, InterruptedException {
        HttpResponse httpResponse = null;
        for (int i = 0; i < 5; i++) {
            httpResponse = executeAndGetResponce(request);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                logger.info("Request is success");
                return httpResponse;
            }
            Thread.sleep(1000);
        }
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            throw new SkipException("Call don't create");
        }
        return httpResponse;
    }

    private HttpResponse executeAndGetResponce(HttpPost request) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse hr;
        try {
            logger.info("Execute request");
            hr = httpClient.execute(request);
            try {
                logger.info("Request status line is : " + hr.getStatusLine());
                logger.info("Request body is: \n" + hr);
                Scanner sc = new Scanner(hr.getEntity().getContent());
                while (sc.hasNext()) {
                    logger.info("Entity.Content: " + sc.nextLine());
                }
            } finally {
                hr.close();
            }
        } finally {
            httpClient.close();
        }
        return hr;
    }
}