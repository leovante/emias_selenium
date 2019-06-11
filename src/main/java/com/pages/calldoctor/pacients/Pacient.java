package com.pages.calldoctor.pacients;

import java.util.Date;

public interface Pacient {
    String getAddressStringMin();

    Object getKladraddress();

    Date parseDate(String dateString);

    String getAddress3adv();

    String getAddress2adv();

    int getSource();

    int getType();

    String getEntrance();

    String getFloor();

    int getGender();

    Date getBirthdate();

    String getBirthdate(String format);

    String getSeriespol();

    String getNumberpol();

    String getAddress();

    String getComplaint();

    String getDiagnosis();

    String getPhone();

    String getName();

    String getFamily();

    String getOt();

    String getNumber();

    String getBuilding();

    String getConstruction();

    String getAppartment();

    String getCodedomophone();

    String getSourceName();

    String getSourceCode();

    String getAddress1();

    String getAddress2();

    String getAddress3();
}
