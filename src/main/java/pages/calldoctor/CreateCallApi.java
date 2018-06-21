package pages.calldoctor;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class CreateCallApi extends BasePage {

    public CreateCallApi(WebDriver driver) {
        super(driver);
    }

    public void createCallProfile3() {

        HttpClient httpClient = HttpClients.createDefault();

        try {
            HttpPost request = new HttpPost("http://12.8.1.126:2224/api/v2/smp/calldoctor/a7f391d4-d5d8-44d5-a770-f7b527bb1233");
            request.addHeader("content-type", "application/json");
            request.addHeader("Authorization", "fb6e439f-c34f-4ee0-b2ba-38c1be5116a3");
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            // handle response here...
        } catch (Exception ex) {
            // handle exception here
        } finally {
//            httpClient.getConnectionManager().shutdown();
        }
    }
}