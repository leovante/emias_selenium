package pages.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClients;

import java.util.Map;

public class Tokenizer {
    public static String token;

    public Tokenizer() {
    }

    public String getToken() {
        HttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet request = new HttpGet("http://12.8.1.126:2224/api/v2/auth/a7f391d4-d5d8-44d5-a770-f7b527bb1233/token?Birthday=2018-01-01&s_pol=1111&n_pol=11111111");
//            System.out.println(request);

            ResponseHandler<String> handler = new BasicResponseHandler();
            String jString = httpClient.execute(request, handler);
//            System.out.println(jString);

            HttpResponse response = httpClient.execute(request);
            String body2 = handler.handleResponse(response);
//            System.out.println(body2);

            Map<String, String> proData = new ObjectMapper().readValue(jString, Map.class);
            token = proData.get("token");
            System.out.println("Получен токен: " + token);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error, " + "Cannot Estabilish Connection");
        }
        return token;
    }
}