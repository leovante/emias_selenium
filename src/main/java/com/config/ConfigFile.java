package com.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.pages.WebPage.logger;

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
    private String dispCard42;
    private String calldoctor;
    private String calldoctorVz;
    private String calldoctorUdinaVz;
    private String clientApplication;
    private String authorization;
    private String requestSmp;
    private String requestSmpAuth;
    private String token;
    private String urlApi;
    private String lpuGuid;
    private String mr_tap;
    private String mr_mkab;
    private boolean cleanBeforeTest;


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
            dispCard42 = property.getProperty("st.mis.url.dispCard42");
            calldoctor = property.getProperty("st.mis.url.calldoctor");
            calldoctorVz = property.getProperty("st.mis.url.calldoctorVz");
            calldoctorUdinaVz = property.getProperty("st.mis.url.calldoctorUdina");
            clientApplication = property.getProperty("st.api.clientApplication");
            authorization = property.getProperty("st.api.authorization");
            requestSmp = property.getProperty("st.api.requestSmp");
            requestSmpAuth = property.getProperty("st.api.requestSmpAuth");
            token = property.getProperty("st.api.token");
            codeLpu = property.getProperty("st.mis.codeLpu");
            mr_tap = property.getProperty("st.mis.url.MRTAP");
            mr_mkab = property.getProperty("st.mis.url.MRMKAB");
            urlApi = property.getProperty("st.api.urlApi");
            lpuGuid = property.getProperty("st.api.lpuGuid");
            cleanBeforeTest = Boolean.parseBoolean(property.getProperty("st.test.cleanBeforeTest"));
        } catch (IOException e) {
            logger.error("ОШИБКА: Файл свойств отсуствует!");
        }
    }

    public String getMrFromTap() {
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

    public String getDispCard42() {
        return dispCard42;
    }

    public String getCalldoctor() {
        return calldoctor;
    }

    public String getCalldoctorVz() {
        return calldoctorVz;
    }

    public String getCalldoctorUdinaVz() {
        return calldoctorUdinaVz;
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

    public String getRequestSmpAuth() {
        return requestSmpAuth;
    }

    public String getToken() {
        return token;
    }

    public String getCodeLpu() {
        return codeLpu;
    }

    public String getUrlApi() {
        return urlApi;
    }

    public String getLpuGuid() {
        return lpuGuid;
    }

    public String getMr_mkab() {
        return mr_mkab;
    }

    public boolean isCleanBeforeTest() {
        return cleanBeforeTest;
    }
}

