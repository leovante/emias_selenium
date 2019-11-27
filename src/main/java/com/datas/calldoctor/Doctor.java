package com.datas.calldoctor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Doctor extends AbstractTestNGSpringContextTests {
    private String name;
    private String family;
    private String ot;
    private String department;//этаж
    private String uchastocs;//домофон
    private String specialization;//специализация врача
    private String cabinet;

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

    public String getDepartment() {
        if (department != null)
            return department;
        return "";
    }

    public String getUchastocs() {
        if (uchastocs != null)
            return uchastocs;
        return "";
    }

    public String getSpecialization() {
        if (specialization != null)
            return specialization;
        return "";
    }

    public String getCabinet() {
        if (cabinet != null)
            return cabinet;
        return "";
    }

    public Doctor(String name)   {
        File reader = new File("src\\main\\resources\\calldoctorAdminTemnikov\\doctors\\" + name + ".json");
        HashMap<String, Object> proData = null;
        try {
            proData = new ObjectMapper().readValue(reader, HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (proData.get("name") != null && proData.get("name") != "")
            this.name = (String) proData.get("name");
        if (proData.get("family") != null && proData.get("family") != "")
            this.family = (String) proData.get("family");
        if (proData.get("ot") != null && proData.get("ot") != "")
            this.ot = (String) proData.get("ot");
        if (proData.get("department") != null && proData.get("department") != "")
            this.department = (String) proData.get("department");
        if (proData.get("uchastocs") != null && proData.get("uchastocs") != "")
            this.uchastocs = (String) proData.get("uchastocs");
        if (proData.get("specialization") != null && proData.get("specialization") != "")
            this.specialization = (String) proData.get("specialization");
        if (proData.get("cabinet") != null && proData.get("cabinet") != "")
            this.cabinet = (String) proData.get("cabinet");
    }
}