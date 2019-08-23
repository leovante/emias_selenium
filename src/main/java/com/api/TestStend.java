package com.api;

import com.codeborne.selenide.Condition;
import com.config.ConfigFile;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class TestStend {
    private ConfigFile configFile = new ConfigFile();

    public Boolean call_doctor_ef_api() throws IOException {
        HttpUriRequest request = new HttpGet(configFile.getUrlServices() + "/call/call_doctor_ef_api/ping");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
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

    public Boolean ehr_medrecords() throws IOException {
        open(configFile.getMr_tap());
        if ($x("//*[contains(text(),'Медицинские записи')]")
                .shouldBe(Condition.visible)
                .is(Condition.visible))
            return true;
        return false;
    }

    public Boolean disp_journal() throws IOException {
        open(configFile.getDispJournal());
        if ($x("//*[contains(text(),'Журнал')]")
                .shouldBe(Condition.visible)
                .is(Condition.visible))
            return true;
        return false;
    }

    public Boolean disp_card() throws IOException {
        open(configFile.getDispCard());
        if ($x("//*[contains(text(),'Карта мероприятий')]")
                .shouldBe(Condition.visible)
                .is(Condition.visible))
            return true;
        return false;
    }

    public Boolean calldoctor() throws IOException {
        open(configFile.getCalldoctor());
        if ($x("//*[contains(.,'Добавить вызов')]")
                .shouldBe(Condition.visible)
                .is(Condition.visible))
            return true;
        return false;
    }

    public Boolean calldoctorVz() throws IOException {
        open(configFile.getCalldoctorVz());
        if ($x("//*[contains(.,'Взрослая поликлиника')]")
                .shouldBe(Condition.visible)
                .is(Condition.visible))
            return true;
        return false;
    }
}