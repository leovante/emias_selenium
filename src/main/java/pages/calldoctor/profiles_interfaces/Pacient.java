package pages.calldoctor.profiles_interfaces;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Pacient extends AbstractTestNGSpringContextTests {
    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private int source;
    private int type;
    private int gender;
    private long numberpol;
    private String birthdate_string;
    private Date birthdate;
    private String seriespol;
    private String address;
    private String address1;
    private String address2;
    private String address3;
    private String complaint;
    private String diagnosis;
    private String phone;
    private String name;
    private String family;
    private String ot;
    private String entrance;//подьезд
    private String floor;//этаж
    private String number;//номер дома
    private String building;//корпус
    private String construction;//строение
    private String appartment;//квартира
    private String codedomophone;//домофон
    private String sourceName;//
    private String sourceCode;//

    private Date parseDate(String dateString) {
        try {
            return simpleDateFormat.parse(dateString);
        } catch (final ParseException e) {
            return new Date();
        }
    }

    public int getSource() {
        return source;
    }

    public int getType() {
        return type;
    }

    public String getEntrance() {
        return entrance;
    }

    public String getFloor() {
        return floor;
    }

    public int getGender() {
        return gender;
    }

    public Date getBirthdate() {
        return birthdate = parseDate(birthdate_string);
    }

    public String getBirthdate(String format) {
        SimpleDateFormat simpleDateFormatEdit = new SimpleDateFormat(format);
        return simpleDateFormatEdit.format(birthdate);
    }

    public String getSeriespol() {
        return seriespol;
    }

    public long getNumberpol() {
        return numberpol;
    }

    public String getAddress() {
        return address;
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

    public String getComplaint() {
        return complaint;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getPhone() {
        return phone;
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

    public String getNumber() {
        return number;
    }

    public String getBuilding() {
        return building;
    }

    public String getConstruction() {
        return construction;
    }

    public String getAppartment() {
        return appartment;
    }

    public String getCodedomophone() {
        return codedomophone;
    }

    public String getSourceName() {
        return sourceName;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public Pacient(String pacient) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + pacient + ".json");
        HashMap<String, Object> proData = new ObjectMapper().readValue(reader, HashMap.class);
        if (proData.get("source") != null && proData.get("source") != "")
            this.source = Integer.valueOf((String) proData.get("source"));

        if (proData.get("type") != null && proData.get("type") != "")
            this.type = Integer.valueOf((String) proData.get("type"));

        if (proData.get("seriespol") != null && proData.get("seriespol") != "")
            this.seriespol = (String) proData.get("seriespol");

        if (proData.get("numberpol") != null && proData.get("numberpol") != "")
            this.numberpol = Long.valueOf((String) proData.get("numberpol"));

        if (proData.get("gender") != null && proData.get("gender") != "")
            this.gender = Integer.valueOf((String) proData.get("gender"));

        if (proData.get("name") != null && proData.get("name") != "")
            this.name = (String) proData.get("name");

        if (proData.get("address") != null && proData.get("address") != "")
            this.address = (String) proData.get("address");

        if (proData.get("address1") != null && proData.get("address1") != "")
            this.address1 = (String) proData.get("address1");

        if (proData.get("address2") != null && proData.get("address2") != "")
            this.address2 = (String) proData.get("address2");

        if (proData.get("address3") != null && proData.get("address3") != "")
            this.address3 = (String) proData.get("address3");

        if (proData.get("complaint") != null && proData.get("complaint") != "")
            this.complaint = (String) proData.get("complaint");

        if (proData.get("diagnosis") != null && proData.get("diagnosis") != "")
            this.diagnosis = (String) proData.get("diagnosis");

        if (proData.get("phone") != null && proData.get("phone") != "")
            this.phone = (String) proData.get("phone");

        if (proData.get("birthdate") != null && proData.get("birthdate") != "")
            this.birthdate_string = (String) proData.get("birthdate");

        if (proData.get("family") != null && proData.get("family") != "")
            this.family = (String) proData.get("family");

        if (proData.get("ot") != null && proData.get("ot") != "")
            this.ot = (String) proData.get("ot");

        if (proData.get("number") != null && proData.get("number") != "")
            this.number = (String) proData.get("number");

        if (proData.get("building") != null && proData.get("building") != "")
            this.building = (String) proData.get("building");

        if (proData.get("construction") != null && proData.get("construction") != "")
            this.construction = (String) proData.get("construction");

        if (proData.get("appartment") != null && proData.get("appartment") != "")
            this.appartment = (String) proData.get("appartment");

        if (proData.get("entrance") != null && proData.get("entrance") != "")
            this.entrance = (String) proData.get("entrance");

        if (proData.get("floor") != null && proData.get("floor") != "")
            this.floor = (String) proData.get("floor");

        if (proData.get("codedomophone") != null && proData.get("codedomophone") != "")
            this.codedomophone = (String) proData.get("codedomophone");

        if (proData.get("sourceName") != null && proData.get("sourceName") != "")
            this.sourceName = (String) proData.get("sourceName");

        if (proData.get("sourceCode") != null && proData.get("sourceCode") != "")
            this.sourceCode = (String) proData.get("sourceCode");

        if (birthdate_string != null && birthdate_string != "")
            this.birthdate = parseDate(birthdate_string);
        System.out.println();
    }
}