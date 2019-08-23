package com.utils.api_model;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;
import com.pages.calldoctor.profiles_interfaces.Pacient;

import java.io.IOException;

//<!--правка hibernate-->
public class CallDoctorEntity {
    private Pacient pacient;
    HttpPost request;
    JSONObject jsonOb;
    String clientApplication = "CB174067-702F-42D0-B0EB-1D84A514515D";
    String authorization = "fb6e439f-c34f-4ee0-b2ba-38c1be5116a3";
    String requestSmp = "http://rpgu.emias.mosreg.ru/api/v2/smp/calldoctor/a7f391d4-d5d8-44d5-a770-f7b527bb1233";

    public CallDoctorEntity(Pacient pacient) throws JSONException {
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

    public HttpPost createRequest() {
        this.request = new HttpPost(requestSmp);
        request.addHeader("content-type", "application/json");
        request.addHeader("Authorization", authorization);
        request.addHeader("ClientApplication", clientApplication);
        StringEntity params = new StringEntity(jsonOb.toString(), "UTF-8");
        request.setEntity(params);
        return request;
    }

    public HttpPost createRequestToken() throws IOException {
        String token = new Tokenizer().getToken(pacient, clientApplication);
        this.request = new HttpPost(requestSmp);
        request.addHeader("Content-type", "application/json");
        request.addHeader("Authorization", "Bearer " + token);
        request.addHeader("ClientApplication", clientApplication);
        StringEntity params = new StringEntity(jsonOb.toString(), "UTF-8");
        request.setEntity(params);
        return request;
    }
}
