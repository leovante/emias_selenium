package pages.calldoctor.doctors_interfaces;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;

public class Doctor extends AbstractTestNGSpringContextTests {

    @Autowired
    private JacksonTester<Doctor> json;

    private static String name;
    private static String family;
    private static String ot;
    private static String department;//этаж
    private static String uchastocs;//домофон

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Doctor.name = name;
    }

    public static String getFamily() {
        return family;
    }

    public static void setFamily(String family) {
        Doctor.family = family;
    }

    public static String getOt() {
        return ot;
    }

    public static void setOt(String ot) {
        Doctor.ot = ot;
    }

    public static String getDepartment() {
        return department;
    }

    public static void setDepartment(String department) {
        Doctor.department = department;
    }

    public static String getUchastocs() {
        return uchastocs;
    }

    public static void setUchastocs(String uchastocs) {
        Doctor.uchastocs = uchastocs;
    }

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Doctor(String name) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + name + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);
        this.name = this.json.parseObject(String.valueOf(proData)).getName();
        this.family = this.json.parseObject(String.valueOf(proData)).getFamily();
        this.ot = this.json.parseObject(String.valueOf(proData)).getOt();
        this.department = this.json.parseObject(String.valueOf(proData)).getDepartment();
        this.uchastocs = this.json.parseObject(String.valueOf(proData)).getUchastocs();
    }
}