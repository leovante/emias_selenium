package com.utils.api_model;

import com.config.ConfigFile;
import com.datas.calldoctor.Pacient;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class CallDoctorHttp {
    private Pacient pacientImpl;
    private ConfigFile configFile;
    HttpPost request;
    JSONObject jsonOb;

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
    }

    public HttpPost postRequestSMP() {
        this.request = new HttpPost(configFile.getRequestSmp());
        this.request.addHeader("content-type", "application/json");
        this.request.addHeader("Authorization", configFile.getAuthorization());
        this.request.addHeader("ClientApplication", configFile.getClientApplication());
        StringEntity params = new StringEntity(jsonOb.toString(), "UTF-8");
        this.request.setEntity(params);
        return request;
    }

    public HttpPost createPostRequestToken() throws IOException {
//        String token = new Tokenizer().getToken(pacient, clientApplication);
        this.request = new HttpPost(configFile.getRequestSmp());
        request.addHeader("Content-type", "application/json");
//        request.addHeader("Authorization", "Bearer " + token);
        request.addHeader("ClientApplication", configFile.getClientApplication());
        StringEntity params = new StringEntity(jsonOb.toString(), "UTF-8");
        request.setEntity(params);
        return request;
    }

    public HttpResponse execute() {
        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse httpResponse = null;
        try {
            if (pacientImpl.getSource() == 2) {//смп
                httpResponse = httpClient.execute(postRequestSMP());
            }
            if (pacientImpl.getSource() == 3) {//кц с авторизацией
                httpResponse = httpClient.execute(createPostRequestToken());
            }
            if (pacientImpl.getSource() != 2 && pacientImpl.getSource() != 3) {
                throw new NullPointerException("Нет такого источника");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return httpResponse;
    }
}