package utils.api_model;

import dataGenerator.ModuleData;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONException;
import org.json.JSONObject;
import pages.calldoctor.pacients.Pacient;
import utils.Config;

import java.io.IOException;

public class CallDoctorHttp {
    private ModuleData mData;
    private Pacient pacient;
    private Config config;
    HttpPost request;
    JSONObject jsonOb;

    public CallDoctorHttp(Pacient pacient) throws JSONException {
        this.pacient = pacient;
        this.jsonOb = new JSONObject();
        this.config = new Config();
        if (pacient.getName() != null && pacient.getName() != "")
            jsonOb.put("name", pacient.getName());
        if (pacient.getFamily() != null && pacient.getFamily() != "")
            jsonOb.put("family", pacient.getFamily());
        if (pacient.getOt() != null && pacient.getOt() != "")
            jsonOb.put("ot", pacient.getOt());
        if (pacient.getBirthdate() != null && pacient.getBirthdate("yyyy-MM-dd") != "")
            jsonOb.put("birthdate", pacient.getBirthdate("yyyy-MM-dd"));
        if (pacient.getSeriespol() != null && pacient.getSeriespol() != "")
            jsonOb.put("seriespol", pacient.getSeriespol());
        if (pacient.getNumberpol() != null && pacient.getNumberpol() != "")
            jsonOb.put("numberpol", pacient.getNumberpol());
        if (pacient.getGender() != 0)
            jsonOb.put("gender", pacient.getGender());
        if (pacient.getAddress() != null && pacient.getAddress() != "")
            jsonOb.put("address", pacient.getAddress());
        if (pacient.getComplaint() != null && pacient.getComplaint() != "")
            jsonOb.put("complaint", pacient.getComplaint());
        if (pacient.getDiagnosis() != null && pacient.getDiagnosis() != "")
            jsonOb.put("diagnosis", pacient.getDiagnosis());
        if (pacient.getType() != 0)
            jsonOb.put("type", pacient.getType());
        if (pacient.getCodedomophone() != null && pacient.getCodedomophone() != "")
            jsonOb.put("codedomophone", pacient.getCodedomophone());
        if (pacient.getPhone() != null && pacient.getPhone() != "")
            jsonOb.put("phone", pacient.getPhone());
        if (pacient.getSource() != 0)
            jsonOb.put("source", pacient.getSource());
        if (pacient.getSourceName() != null && pacient.getSourceName() != "")
            jsonOb.put("sourceName", pacient.getSourceName());
        if (pacient.getSourceCode() != null && pacient.getSourceCode() != "")
            jsonOb.put("sourceCode", pacient.getSourceCode());
        if (pacient.getEntrance() != null && pacient.getEntrance() != "")
            jsonOb.put("entrance", pacient.getEntrance());
        if (pacient.getEntrance() != null && pacient.getEntrance() != "")
            jsonOb.put("floor", pacient.getFloor());
        if (pacient.getKladraddress() != null && pacient.getKladraddress() != "")
            jsonOb.put("kladraddress", pacient.getKladraddress());
    }

    public CallDoctorHttp(ModuleData mData) throws JSONException {
        this.pacient = pacient;
        this.jsonOb = new JSONObject();
        if (pacient.getName() != null && pacient.getName() != "")
            jsonOb.put("name", pacient.getName());
        if (pacient.getFamily() != null && pacient.getFamily() != "")
            jsonOb.put("family", pacient.getFamily());
        if (pacient.getOt() != null && pacient.getOt() != "")
            jsonOb.put("ot", pacient.getOt());
        if (pacient.getBirthdate() != null && pacient.getBirthdate("yyyy-MM-dd") != "")
            jsonOb.put("birthdate", pacient.getBirthdate("yyyy-MM-dd"));
        if (pacient.getSeriespol() != null && pacient.getSeriespol() != "")
            jsonOb.put("seriespol", pacient.getSeriespol());
        if (pacient.getNumberpol() != null && pacient.getNumberpol() != "")
            jsonOb.put("numberpol", pacient.getNumberpol());
        if (pacient.getGender() != 0)
            jsonOb.put("gender", pacient.getGender());
        if (pacient.getAddress() != null && pacient.getAddress() != "")
            jsonOb.put("address", pacient.getAddress());
        if (pacient.getComplaint() != null && pacient.getComplaint() != "")
            jsonOb.put("complaint", pacient.getComplaint());
        if (pacient.getDiagnosis() != null && pacient.getDiagnosis() != "")
            jsonOb.put("diagnosis", pacient.getDiagnosis());
        if (pacient.getType() != 0)
            jsonOb.put("type", pacient.getType());
        if (pacient.getCodedomophone() != null && pacient.getCodedomophone() != "")
            jsonOb.put("codedomophone", pacient.getCodedomophone());
        if (pacient.getPhone() != null && pacient.getPhone() != "")
            jsonOb.put("phone", pacient.getPhone());
        if (pacient.getSource() != 0)
            jsonOb.put("source", pacient.getSource());
        if (pacient.getSourceName() != null && pacient.getSourceName() != "")
            jsonOb.put("sourceName", pacient.getSourceName());
        if (pacient.getSourceCode() != null && pacient.getSourceCode() != "")
            jsonOb.put("sourceCode", pacient.getSourceCode());
        if (pacient.getEntrance() != null && pacient.getEntrance() != "")
            jsonOb.put("entrance", pacient.getEntrance());
        if (pacient.getEntrance() != null && pacient.getEntrance() != "")
            jsonOb.put("floor", pacient.getFloor());
        if (pacient.getKladraddress() != null && pacient.getKladraddress() != "")
            jsonOb.put("kladraddress", pacient.getKladraddress());
    }

    public HttpPost createPostRequest() {
        this.request = new HttpPost(config.getRequestSmp());
        this.request.addHeader("content-type", "application/json");
        this.request.addHeader("Authorization", config.getAuthorization());
        this.request.addHeader("ClientApplication", config.getClientApplication());
        StringEntity params = new StringEntity(jsonOb.toString(), "UTF-8");
        this.request.setEntity(params);
        return request;
    }

    public HttpPost createPostRequestToken() throws IOException {
//        String token = new Tokenizer().getToken(pacient, clientApplication);
        this.request = new HttpPost(config.getRequestSmp());
        request.addHeader("Content-type", "application/json");
//        request.addHeader("Authorization", "Bearer " + token);
        request.addHeader("ClientApplication", config.getClientApplication());
        StringEntity params = new StringEntity(jsonOb.toString(), "UTF-8");
        request.setEntity(params);
        return request;
    }

    public HttpResponse execute() {
        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse httpResponse = null;
        try {
            if (pacient.getSource() == 2) {//смп
                httpResponse = httpClient.execute(createPostRequest());
            }
            if (pacient.getSource() == 3) {//кц авторизацией
                httpResponse = httpClient.execute(createPostRequestToken());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return httpResponse;
    }
}
