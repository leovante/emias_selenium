package com.datas.calldoctor;

import com.system.model.HltMkabEntity;
import com.system.service.HltMkabService;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class PacientDBImpl implements Pacient {
    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private int gender;
    private Timestamp birthdate;
    private String seriespol;
    private String numberpol;
    private String address;
    private String phone;
    private String name;
    private String family;
    private String ot;
    private int source = 2;
    private int type;
    private int callPersonType;
    private String complaint;
    private String diagnosis;
    private String entrance;//подьезд
    private String floor;//этаж
    private String number;//номер дома
    private String building;//корпус
    private String construction;//строение
    private String appartment;//квартира
    private String codedomophone;//домофон
    private String sourceName;
    private String sourceCode;
    private JSONObject kladraddress;
    private String addressStringMin;
    private HltMkabService mksb;

    public String getAddressStringMin() {
        return addressStringMin;
    }

    public Object getKladraddress() {
        return kladraddress;
    }

    public Date parseDate(String dateString) {
        try {
            return simpleDateFormat.parse(dateString);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAddress3adv() {
        return null;
    }

    @Override
    public String getAddress2adv() {
        return null;
    }

    @Override
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

    @Override
    public Timestamp getBirthdate() {
        return birthdate;
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

    @Override
    public String getAddress1() {
        return null;
    }

    @Override
    public String getAddress2() {
        return null;
    }

    @Override
    public String getAddress3() {
        return null;
    }

    @Override
    public int getCallPersonType() {
        return callPersonType;
    }

    public PacientDBImpl(HltMkabService hltMkabService) throws IOException, JSONException {
        this.mksb = hltMkabService;
        Optional<HltMkabEntity> mk = mksb.findRandom();
        mk.ifPresent(HltMkabEntity -> {
            this.seriespol = HltMkabEntity.getsPol();
            this.numberpol = HltMkabEntity.getnPol();
            this.gender = HltMkabEntity.getW();
            this.name = HltMkabEntity.getName();
            this.ot = HltMkabEntity.getOt();
            this.family = HltMkabEntity.getFamily();
            this.address = HltMkabEntity.getAdres();
            this.address = HltMkabEntity.getAdres();
            this.phone = HltMkabEntity.getPhoneHome();
            this.birthdate = HltMkabEntity.getDateBd();
        });
    }
}