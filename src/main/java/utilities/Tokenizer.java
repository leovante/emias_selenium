package utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import pages.calldoctor.profiles_interfaces.Pacient;

import java.io.IOException;
import java.util.Map;

public class Tokenizer {
    public static String token;
    HttpResponse response;

    public Tokenizer() {
    }

    public String getToken(Pacient pacient, String ClientApplication) throws IOException {
        String bd = pacient.getBirthdate("yyyy-MM-dd");
        String spol = pacient.getSeriespol();
        String npol = pacient.getNumberpol();
        HttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet request = new HttpGet("http://rpgu.emias.mosreg.ru/api/v2/auth/a7f391d4-d5d8-44d5-a770-f7b527bb1233/token?Birthday=" + bd + "&s_pol=" + spol + "&n_pol=" + npol);
            request.addHeader("ClientApplication", ClientApplication);

            ResponseHandler<String> handler = new BasicResponseHandler();
            String jString = httpClient.execute(request, handler);

            this.response = httpClient.execute(request);
            Assert.assertEquals(response.getStatusLine().getStatusCode(), 200, "Не удаётся получить токен для создания вызова!");

            Map<String, String> proData = new ObjectMapper().readValue(jString, Map.class);
            token = proData.get("token");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Ответ:\n" + response.getEntity().getContent());
            System.out.println("Ошибка. Не удается подключиться!");
        }
        return token;
    }
}