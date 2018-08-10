package pages.utilities;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.InputStream;

public class Tokenizer {
    // TODO: 10.08.2018 нужно получить токен ответ через body а потом по нему создать вызов в ВД
    public Tokenizer() {
        HttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet request = new HttpGet("http://12.8.1.126:2224/api/v2/auth/a7f391d4-d5d8-44d5-a770-f7b527bb1233/token?Birthday=2018-01-01&s_pol=1111&n_pol=11111111");
            System.out.println(request);

            HttpResponse response = httpClient.execute(request);
            System.out.println(response);
            System.out.println(response.getStatusLine().getStatusCode());

            HttpEntity entity = response.getEntity();
            System.out.println(entity);

            if (response != null) {
                InputStream in = response.getEntity().getContent();
                System.out.println(in);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error, " + "Cannot Estabilish Connection");
        } finally {
//            driver.close();
        }
    }

    public static void main(String[] args) {
        new Tokenizer();
    }
}