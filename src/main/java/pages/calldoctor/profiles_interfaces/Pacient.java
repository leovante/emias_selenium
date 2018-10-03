package pages.calldoctor.profiles_interfaces;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Map;

public class Pacient {
    String address;
    String complaint;
    String diagnosis;
    int type;
    String phone;
    int source;
    Date birthdate;
    int seriespol;
    int numberpol;

    public Pacient(String profile) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        this.proData = new ObjectMapper().readValue(reader, Map.class);
    }


}