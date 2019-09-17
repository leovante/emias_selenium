package com.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.pages.BasePage.logger2;

public class ConfigFile {
    private String url;
    private String urlServices;
    private String codeLpu;
    private String login;
    private String password;
    private String adminLogin;
    private String adminPassword;
    private String useUrl;
    private String headless;
    private String dispJournal;
    private String dispCard;
    private String calldoctor;
    private String calldoctorVz;
    private String clientApplication;
    private String authorization;
    private String requestSmp;

    private String mr_tap;

    public ConfigFile() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);

            url = property.getProperty("st.mis.url");
            urlServices = property.getProperty("st.mis.urlServices");
            login = property.getProperty("st.mis.doctorLogin");
            password = property.getProperty("st.mis.doctorLoginPass");
            adminLogin = property.getProperty("st.mis.adminLogin");
            adminPassword = property.getProperty("st.mis.adminLoginPass");
            password = property.getProperty("st.mis.doctorLoginPass");
            useUrl = property.getProperty("st.mis.useUrl");
            headless = property.getProperty("st.mis.headless");
            dispJournal = property.getProperty("st.mis.url.dispJournal");
            dispCard = property.getProperty("st.mis.url.dispCard");
            calldoctor = property.getProperty("st.mis.url.calldoctor");
            calldoctorVz = property.getProperty("st.mis.url.calldoctorVz");
            clientApplication = property.getProperty("st.api.clientApplication");
            authorization = property.getProperty("st.api.authorization");
            requestSmp = property.getProperty("st.api.requestSmp");
            codeLpu = property.getProperty("st.mis.codeLpu");
            mr_tap = property.getProperty("st.mis.url.MRTAP");
        } catch (IOException e) {
            logger2.error("ОШИБКА: Файл свойств отсуствует!");
        }
    }

    public String getMr_tap() {
        return mr_tap;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlServices() {
        return urlServices;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getAdminLogin() {
        return adminLogin;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public String getUseUrl() {
        return useUrl;
    }

    public Boolean getHeadless() {
        return Boolean.valueOf(headless);
    }

    public String getDispJournal() {
        return dispJournal;
    }

    public String getDispCard() {
        return dispCard;
    }

    public String getCalldoctor() {
        return calldoctor;
    }

    public String getCalldoctorVz() {
        return calldoctorVz;
    }

    public String getClientApplication() {
        return clientApplication;
    }

    public String getAuthorization() {
        return authorization;
    }

    public String getRequestSmp() {
        return requestSmp;
    }

    public String getCodeLpu() {
        return codeLpu;
    }
}

