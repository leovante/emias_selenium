package pages.calldoctor.profiles_interfaces;

import org.codehaus.plexus.util.IOUtil;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pacient extends AbstractTestNGSpringContextTests {
    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private int source;
    private int type;
    private int gender;
    private String numberpol;
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
    private String sourceName;
    private String sourceCode;
    private Object kladraddress;


    public Object getKladraddress() {
        return kladraddress;
    }

    private Date parseDate(String dateString) {
        try {
            return simpleDateFormat.parse(dateString);
        } catch (Exception e) {
            return null;
        }
    }

    public int getSource() {
        return source;
    }

    public int getType() {
        return type;
    }

    public String getEntrance() {
        if (entrance != null)
            return entrance;
        return "";
    }

    public String getFloor() {
        if (floor != null)
            return floor;
        return "";
    }

    public int getGender() {
        return gender;
    }

    public Date getBirthdate() {
        return birthdate = parseDate(birthdate_string);
    }

    public String getBirthdate(String format) {
        SimpleDateFormat simpleDateFormatEdit = new SimpleDateFormat(format);
        String date1;
        if (birthdate != null) {
            date1 = simpleDateFormatEdit.format(birthdate);
        } else {
            date1 = null;
        }
        return date1;
    }

    public String getSeriespol() {
        if (seriespol != null)
            return seriespol;
        return "";
    }

    public String getNumberpol() {
        if (numberpol != null)
            return numberpol;
        return "";
    }

    public String getAddress() {
        if (address != null)
            return address;
        return "";
    }

    public String getAddress1() {
        if (address1 != null)
            return address1;
        return "";
    }

    public String getAddress2() {
        if (address2 != null)
            return address2;
        return "";
    }

    public String getAddress3() {
        if (address3 != null)
            return address3;
        return "";
    }

    public String getComplaint() {
        if (complaint != null)
            return complaint;
        return "";
    }

    public String getDiagnosis() {
        if (diagnosis != null)
            return diagnosis;
        return "";
    }

    public String getPhone() {
        if (phone != null)
            return phone;
        return "";
    }

    public String getName() {
        if (name != null)
            return name;
        return "";
    }

    public String getFamily() {
        if (family != null)
            return family;
        return "";
    }

    public String getOt() {
        if (ot != null)
            return ot;
        return "";
    }

    public String getNumber() {
        if (number != null)
            return number;
        return "";
    }

    public String getBuilding() {
        if (building != null)
            return building;
        return "";
    }

    public String getConstruction() {
        if (construction != null)
            return construction;
        return "";
    }

    public String getAppartment() {
        if (appartment != null)
            return appartment;
        return "";
    }

    public String getCodedomophone() {
        if (codedomophone != null)
            return codedomophone;
        return "";
    }

    public String getSourceName() {
        if (sourceName != null)
            return sourceName;
        return "";
    }

    public String getSourceCode() {
        if (sourceCode != null)
            return sourceCode;
        return "";
    }

    public Pacient(String pacient) throws IOException, JSONException {
        JSONObject jsonOb;
        String path = "src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + pacient + ".json";
        File reader2 = new File(path);
        if (reader2.exists()) {
            InputStream is = new FileInputStream(path);
            String jsonTxt = IOUtil.toString(is, "UTF-8");
            jsonOb = new JSONObject(jsonTxt);
        } else {
            throw new JSONException("Ошибка! Не найден файл пациента.");
        }

        if (jsonOb.has("source") && !jsonOb.get("source").equals(""))
            this.source = jsonOb.getInt("source");

        if (jsonOb.has("type") && !jsonOb.get("type").equals(""))
            this.type = jsonOb.getInt("type");

        if (jsonOb.has("seriespol") && !jsonOb.get("seriespol").equals(""))
            this.seriespol = jsonOb.getString("seriespol");

        if (jsonOb.has("numberpol") && !jsonOb.get("numberpol").equals(""))
            this.numberpol = jsonOb.getString("numberpol");

        if (jsonOb.has("gender") && !jsonOb.get("gender").equals(""))
            this.gender = jsonOb.getInt("gender");

        if (jsonOb.has("name") && !jsonOb.get("name").equals(""))
            this.name = jsonOb.getString("name");

        if (jsonOb.has("address") && !jsonOb.get("address").equals(""))
            this.address = jsonOb.getString("address");

        if (jsonOb.has("address1") && !jsonOb.get("address1").equals(""))
            this.address1 = jsonOb.getString("address1");

        if (jsonOb.has("address2") && !jsonOb.get("address2").equals(""))
            this.address2 = jsonOb.getString("address2");

        if (jsonOb.has("address3") && !jsonOb.get("address3").equals(""))
            this.address3 = jsonOb.getString("address3");

        if (jsonOb.has("complaint") && !jsonOb.get("complaint").equals(""))
            this.complaint = jsonOb.getString("complaint");

        if (jsonOb.has("diagnosis") && !jsonOb.get("diagnosis").equals(""))
            this.diagnosis = jsonOb.getString("diagnosis");

        if (jsonOb.has("phone") && !jsonOb.get("phone").equals(""))
            this.phone = jsonOb.getString("phone");

        if (jsonOb.has("birthdate") && !jsonOb.get("birthdate").equals(""))
            this.birthdate_string = jsonOb.getString("birthdate");

        if (jsonOb.has("family") && !jsonOb.get("family").equals(""))
            this.family = jsonOb.getString("family");

        if (jsonOb.has("ot") && !jsonOb.get("ot").equals(""))
            this.ot = jsonOb.getString("ot");

        if (jsonOb.has("number") && !jsonOb.get("number").equals(""))
            this.number = jsonOb.getString("number");

        if (jsonOb.has("building") && !jsonOb.get("building").equals(""))
            this.building = jsonOb.getString("building");

        if (jsonOb.has("construction") && !jsonOb.get("construction").equals(""))
            this.construction = jsonOb.getString("construction");

        if (jsonOb.has("appartment") && !jsonOb.get("appartment").equals(""))
            this.appartment = jsonOb.getString("appartment");

        if (jsonOb.has("entrance") && !jsonOb.get("entrance").equals(""))
            this.entrance = jsonOb.getString("entrance");

        if (jsonOb.has("floor") && !jsonOb.get("floor").equals(""))
            this.floor = jsonOb.getString("floor");

        if (jsonOb.has("codedomophone") && !jsonOb.get("codedomophone").equals(""))
            this.codedomophone = jsonOb.getString("codedomophone");

        if (jsonOb.has("sourceName") && !jsonOb.get("sourceName").equals(""))
            this.sourceName = jsonOb.getString("sourceName");

        if (jsonOb.has("sourceCode") && !jsonOb.get("sourceCode").equals(""))
            this.sourceCode = jsonOb.getString("sourceCode");

        if (birthdate_string != null && birthdate_string != "")
            this.birthdate = parseDate(birthdate_string);

        if (jsonOb.has("kladraddress") && !jsonOb.get("kladraddress").equals(""))
            this.kladraddress = jsonOb.getJSONObject("kladraddress");
    }
}