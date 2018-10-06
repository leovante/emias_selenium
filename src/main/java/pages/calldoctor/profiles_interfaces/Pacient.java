package pages.calldoctor.profiles_interfaces;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Pacient extends AbstractTestNGSpringContextTests {
    private static String address;
    private static String address1;
    private static String address2;
    private static String address3;
    private static String complaint;
    private static String diagnosis;
    private static int type;
    private static String phone;
    private static int source;
    private static String birthdate_string;
    private static Date birthdate = parseDate(birthdate_string);
    private static int seriespol;
    private static int numberpol;
    private static String name;
    private static String family;
    private static String ot;

    public static String getBuilding() {
        return building;
    }

    public static void setBuilding(String building) {
        Pacient.building = building;
    }

    private static String building;

    public static String getAddress1() {
        return address1;
    }

    public static void setAddress1(String address1) {
        Pacient.address1 = address1;
    }

    public static String getAddress2() {
        return address2;
    }

    public static void setAddress2(String address2) {
        Pacient.address2 = address2;
    }

    public static String getAddress3() {
        return address3;
    }

    public static void setAddress3(String address3) {
        Pacient.address3 = address3;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Pacient.name = name;
    }

    public static String getFamily() {
        return family;
    }

    public static void setFamily(String family) {
        Pacient.family = family;
    }

    public static String getOt() {
        return ot;
    }

    public static void setOt(String ot) {
        Pacient.ot = ot;
    }

    @Autowired
    private JacksonTester<Pacient> json;

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Pacient(String profile) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);
        this.address = this.json.parseObject(String.valueOf(proData)).getAddress();
        this.complaint = this.json.parseObject(String.valueOf(proData)).getComplaint();
        this.diagnosis = this.json.parseObject(String.valueOf(proData)).getDiagnosis();
        this.type = this.json.parseObject(String.valueOf(proData)).getType();
        this.phone = this.json.parseObject(String.valueOf(proData)).getPhone();
        this.source = this.json.parseObject(String.valueOf(proData)).getSource();
        this.birthdate = this.json.parseObject(String.valueOf(proData)).getBirthdate();
        this.seriespol = this.json.parseObject(String.valueOf(proData)).getSeriespol();
        this.numberpol = this.json.parseObject(String.valueOf(proData)).getNumberpol();
    }

    private static java.util.Date parseDate(final String dateString) {
        try {
            return simpleDateFormat.parse(dateString);
        } catch (final ParseException e) {
            return new Date();
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public java.util.Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getSeriespol() {
        return seriespol;
    }

    public void setSeriespol(int seriespol) {
        this.seriespol = seriespol;
    }

    public int getNumberpol() {
        return numberpol;
    }

    public void setNumberpol(int numberpol) {
        this.numberpol = numberpol;
    }
}