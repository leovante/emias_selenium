package com.pages.kladr;

import com.commons.Formalizer;
import com.commons.sql.DBScripts;
import org.json.JSONException;
import org.testng.Assert;

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
        addressStringList = DBScripts.getAddressStringHiber();
        return this;
    }

    //отправляю формализатору стринги и получаю ответ в виде кода адреса
    public Kladr sendToFormalizerAndVerifyFullKLADRCodeAddress() {
        try {
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
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void verifyFullKLADRCodeAddress() {
        try {
            if (fullKLADRCodeAddress != null) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("samplefile1.txt"));
                writer.write(addressStringList + " " + fullKLADRCodeAddress);

                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean verifyKladrCode() {
        if (DBScripts.verifyKladrCodeHiber(fullKLADRCodeAddress)) {
            return true;
        }
        return false;
    }

    public void badAddressCanBeEmpty() {
        Assert.assertTrue(badAddress == null, "Аларма! Формализатор выдает заблокированные адреса!");
    }
}