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

    @Autowired
    private JacksonTester<Pacient> json;

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

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }


    public Pacient(String name) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + name + ".json");
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEntrance() {
        return entrance;
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getCodedomophone() {
        return codedomophone;
    }

    public void setCodedomophone(String codedomophone) {
        this.codedomophone = codedomophone;
    }

    public String getAppartment() {
        return appartment;
    }

    public void setAppartment(String appartment) {
        this.appartment = appartment;
    }

    public String getConstruction() {
        return construction;
    }

    public void setConstruction(String construction) {
        this.construction = construction;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getOt() {
        return ot;
    }

    public void setOt(String ot) {
        this.ot = ot;
    }

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


    private java.util.Date parseDate(final String dateString) {
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

    public Date getBirthdate() {
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