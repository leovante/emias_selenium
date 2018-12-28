package pages.kladr;

import org.json.JSONException;
import pages.sql.SQLDemonstration;
import utilities.Formalizer;

import java.io.IOException;

public class Kladr {
    String AddressString;
    String codeKladrStreet;

    public Kladr getAddressString() {
        int x = (int) (Math.random() * 35868);
        AddressString = SQLDemonstration.getAddressString(x);
        return this;
    }

    public Kladr sendToFormalizer() throws IOException, JSONException {
        this.codeKladrStreet = new Formalizer(AddressString)
                .sendToFormalizer()
                .getEntity();
        return this;
    }

    public Kladr verifyKladrCode() {
        SQLDemonstration.verifyCodeAddress(codeKladrStreet);
        return this;
    }
}