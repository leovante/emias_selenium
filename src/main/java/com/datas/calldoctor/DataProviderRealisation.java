package com.datas.calldoctor;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Collectors;

import static com.google.gson.JsonParser.parseReader;

public class DataProviderRealisation {

    @DataProvider(name = "jsonDataProvider")
    public Iterator<Object[]> jsonDataProvider() throws IOException {
        Gson gson = new Gson();
        String path = "src/main/resources/calldoctor/pacients/trialJsonFile.json";
        FileReader fileReader = new FileReader(path);
        JsonElement jsonData = parseReader(fileReader);

        Type collectionType = new TypeToken<Collection<PacientImpl>>(){}.getType();
        Collection<PacientImpl> enums = gson.fromJson(jsonData, collectionType);

        return enums.stream().map((g)-> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
}
