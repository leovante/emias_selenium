package com.dataGenerator;


import com.system.model.HltMkabEntity;

public interface ModuleData {

    ModuleData findByModel();

    ModuleData modelWithKladr();

//    CalldoctorData setDopData(Boolean mkabStat, Boolean api, String source, String complaint, String dopAdress);

    String getSource();

    String getComplaint();

    HltMkabEntity getMkab();

    Boolean getApiStat();

    Boolean getMkabStat();

    String getSMPPhone();

    String getPd();

    String getDfon();

    String getEntrance();
}
