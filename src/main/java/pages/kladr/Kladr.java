package pages.kladr;

import org.json.JSONException;
import pages.sql.SQLDemonstration;
import utilities.Formalizer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Kladr {
    List addressStringList;
    String fullKLADRCodeAddress;

    public Kladr getAddressStringList() {
        int x = (int) (Math.random() * 1295);
        addressStringList = SQLDemonstration.getAddressString(x);
        return this;
    }

    public Kladr sendToFormalizerAndVerifyFullKLADRCodeAddress() throws IOException, JSONException {
        Iterator<String> iter = addressStringList.iterator();
        BufferedWriter writer = new BufferedWriter(new FileWriter("samplefile1.txt"));
        while (iter.hasNext()) {
            this.fullKLADRCodeAddress = new Formalizer(iter.next())
                    .sendToFormalizer()
                    .getEntity();
            if (fullKLADRCodeAddress != null) {
                writer.write(fullKLADRCodeAddress + " : " + iter.next());
                writer.newLine();
            }
        }
        writer.close();
        return this;
    }

    public void verifyFullKLADRCodeAddress() throws IOException {
        if (fullKLADRCodeAddress != null) {
            BufferedWriter writer = new BufferedWriter(new FileWriter("samplefile1.txt"));
            writer.write(addressStringList + " " + fullKLADRCodeAddress);
            writer.close();
        }
    }

    public Kladr verifyKladrCode() {
        String a = SQLDemonstration.verifyCodeAddress(fullKLADRCodeAddress);
        return this;
    }
}