package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private String url;
    private String login;
    private String password;
    private String useUrl;
    private String headless;
    private String dispJournal;
    private String dispCard;
    private String calldoctor;

    public Config() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);

            url = property.getProperty("st.mis.url");
            login = property.getProperty("st.mis.doctorLogin");
            password = property.getProperty("st.mis.doctorLoginPass");
            useUrl = property.getProperty("st.mis.useUrl");
            headless = property.getProperty("st.mis.headless");
            dispJournal = property.getProperty("st.mis.url.dispJournal");
            dispCard = property.getProperty("st.mis.url.dispCard");
            calldoctor = property.getProperty("st.mis.url.calldoctor");

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }

    public String getUrl() {
        return url;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
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
}
