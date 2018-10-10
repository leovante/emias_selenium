package pages.calldoctor.profiles_interfaces;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@JsonTest
@ContextConfiguration(classes = Pacient.class)
public class Pacient extends AbstractTestNGSpringContextTests {

    @Autowired
    private JacksonTester<Pacient> json;

    @JsonFormat(pattern = "yyyy-MM-dd")// Formats output date when this DTO is passed through JSON
    @DateTimeFormat(pattern = "yyyy-MM-dd")// Allows dd/MM/yyyy date to be passed into GET request in JSON

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private int source;
    private int type;
    private int seriespol;
    private int numberpol;
    private int gender;
    private String name;
    private String address;
    private String address1;
    private String address2;
    private String address3;
    private String complaint;
    private String diagnosis;
    private String phone;
    private String birthdate_string;
    private Date birthdate = parseDate(birthdate_string);
    private String family;
    private String ot;
    private String number;//номер дома
    private String building;//корпус
    private String construction;//строение
    private String appartment;//квартира
    private String entrance;//подьезд
    private String floor;//этаж
    private String codedomophone;//домофон
    private String sourceName;//
    private String sourceCode;//
    private String JSON_TO_DESERIALIZE = "{\"address\" :  \"Московская обл.,Фрязино г.,Озерная ул.,10\"}";

    private java.util.Date parseDate(final String dateString) {
        try {
            if (dateString != null)
                return simpleDateFormat.parse(dateString);
        } catch (final ParseException e) {
            return new Date();
        }
        return null;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public String getSourceName() {
        return sourceName;
    }

    public int getGender() {
        return gender;
    }

    public String getNumber() {
        return number;
    }

    public String getEntrance() {
        return entrance;
    }

    public String getFloor() {
        return floor;
    }

    public String getCodedomophone() {
        return codedomophone;
    }

    public String getAppartment() {
        return appartment;
    }

    public String getConstruction() {
        return construction;
    }

    public String getBuilding() {
        return building;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getAddress3() {
        return address3;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public String getOt() {
        return ot;
    }

    public String getAddress() {
        return address;
    }

    public String getComplaint() {
        return complaint;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public int getType() {
        return type;
    }

    public String getPhone() {
        return phone;
    }

    public int getSource() {
        return source;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public int getSeriespol() {
        return seriespol;
    }

    public int getNumberpol() {
        return numberpol;
    }

    public String getBirthdate_string() {
        return String.valueOf(birthdate);
    }

    Pacient(){
//перегрузить пациента
    }

    public Pacient(String pacient) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + pacient + ".json");
//        Scanner sc = new Scanner(reader);
//        FileReader reader2 = new FileReader("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + pacient + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);
//        this.address = this.json.parseObject(JSON_TO_DESERIALIZE).getAddress();
//        this.address = this.json.parseObject(String.valueOf(reader2.read())).getAddress();

        DataInputStream reader3 = new DataInputStream(new FileInputStream("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + pacient + ".json"));
        String result = reader3.toString();


        Pacient pacient2 = new Pacient();
        this.json.write(pacient2);
        this.address = this.json.parseObject(result).getAddress();


        this.address1 = this.json.parseObject(String.valueOf(proData)).getAddress1();
        this.address2 = this.json.parseObject(String.valueOf(proData)).getAddress2();
        this.address3 = this.json.parseObject(String.valueOf(proData)).getAddress3();
        this.complaint = this.json.parseObject(String.valueOf(proData)).getComplaint();
        this.diagnosis = this.json.parseObject(String.valueOf(proData)).getDiagnosis();
        this.type = this.json.parseObject(String.valueOf(proData)).getType();
        this.phone = this.json.parseObject(String.valueOf(proData)).getPhone();
        this.source = this.json.parseObject(String.valueOf(proData)).getSource();
        this.birthdate = this.json.parseObject(String.valueOf(proData)).getBirthdate();
        this.birthdate_string = this.json.parseObject(String.valueOf(proData)).getBirthdate_string();
        this.seriespol = this.json.parseObject(String.valueOf(proData)).getSeriespol();
        this.numberpol = this.json.parseObject(String.valueOf(proData)).getNumberpol();
        this.gender = this.json.parseObject(String.valueOf(proData)).getGender();
        this.name = this.json.parseObject(String.valueOf(proData)).getName();
        this.family = this.json.parseObject(String.valueOf(proData)).getFamily();
        this.ot = this.json.parseObject(String.valueOf(proData)).getOt();
        this.number = this.json.parseObject(String.valueOf(proData)).getNumber();
        this.building = this.json.parseObject(String.valueOf(proData)).getBuilding();
        this.construction = this.json.parseObject(String.valueOf(proData)).getConstruction();
        this.appartment = this.json.parseObject(String.valueOf(proData)).getAppartment();
        this.entrance = this.json.parseObject(String.valueOf(proData)).getEntrance();
        this.floor = this.json.parseObject(String.valueOf(proData)).getFloor();
        this.codedomophone = this.json.parseObject(String.valueOf(proData)).getCodedomophone();
        this.sourceName = this.json.parseObject(String.valueOf(proData)).getSourceName();
        this.sourceCode = this.json.parseObject(String.valueOf(proData)).getSourceCode();
    }
}