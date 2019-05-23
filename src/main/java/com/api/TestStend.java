package com.api;

import com.config.ConfigFile;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class TestStend {
    private ConfigFile configFile = new ConfigFile();

    public Boolean checkCreateCall() throws IOException {
        HttpUriRequest request = new HttpGet("http://192.168.7.24/test/api/kladrsave/find");
        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        // TODO: 5/23/2019 доделать
        return true;
    }

    public Boolean checkKladrFind() throws IOException {
        HttpPost request = new HttpPost(configFile.getUrlKladr() + "/api/kladrsave/find");
        String body = "{\"code\":\"5000002713600\",\"query\":\"заречная\"}";

        request.addHeader("Content-Type", "application/json");
        StringEntity stringEntity = new StringEntity(body, "UTF-8");
        request.setEntity(stringEntity);

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
            return true;
        return false;
    }
}