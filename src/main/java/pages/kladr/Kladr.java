package pages.kladr;

import org.json.JSONException;
import org.testng.Assert;
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
    List<String> badAddress;

    //получаю стринги адресов
    public Kladr getAddressStringList() {
        int x = (int) (Math.random() * 1295);
//        addressStringList = SQLDemonstration.getAddressString(x);
        addressStringList = SQLDemonstration.getAddressStringHiber(x);
        return this;
    }

    //отправляю формализатору стринги и получаю ответ в виде кода адреса
    public Kladr sendToFormalizerAndVerifyFullKLADRCodeAddress() throws IOException, JSONException {
        Iterator<String> iter = addressStringList.iterator();
        BufferedWriter writer = new BufferedWriter(new FileWriter("samplefile1.txt"));
        while (iter.hasNext()) {
            this.fullKLADRCodeAddress = new Formalizer(iter.next())
                    .sendToFormalizer()
                    .getEntity();
            if (fullKLADRCodeAddress != null) {
                if (verifyKladrCode()) {
                    badAddress.add(fullKLADRCodeAddress);
                    writer.write(fullKLADRCodeAddress + " : " + iter.next());
                    writer.newLine();
                }
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

    public boolean verifyKladrCode() {
        if (SQLDemonstration.verifyKladrCodeHiber(fullKLADRCodeAddress)) {
            return true;
        }
        return false;
    }

    public void badAddressCanBeEmpty() {
        Assert.assertTrue(badAddress.size() == 0, "Аларма! Формализатор выдает заблокированные адреса!");
    }
}