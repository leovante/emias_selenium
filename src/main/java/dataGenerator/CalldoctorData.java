package dataGenerator;

import org.springframework.stereotype.Service;
import system.model.HltMkabEntity;
import system.service.HltMkabService;

@Service
public class CalldoctorData implements ModuleData {
    HltMkabEntity hltMkabEntity;
    HltMkabService hltMkabService;
    Boolean api;
    Boolean mkabStat;
    String source;
    String complaint = "тестовая жалоба";
    String adress;
    String smpPhone = "+79511582711";
    String pd = "132";
    String dfon = "135";
    String entrance = "172";

    public CalldoctorData(HltMkabService hltMkabService) {
        this.hltMkabService = hltMkabService;
    }

    @Override
    public CalldoctorData findByModel() {
        hltMkabEntity = hltMkabService.findByModel();
        return this;
    }

    @Override
    public ModuleData modelWithKladr() {
//        hltMkabEntity = hltMkabService.modelWithKladr();
        return this;
    }

    @Override
    public CalldoctorData setDopData(Boolean mkabStat, Boolean api, String source, String complaint, String dopAdress) {
        this.mkabStat = mkabStat;
        this.api = api;
        this.source = source;
        this.complaint = complaint;
        this.adress = dopAdress;
        return this;
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public String getComplaint() {
        return complaint;
    }

    @Override
    public HltMkabEntity getMkab() {
        return hltMkabEntity;
    }

    @Override
    public Boolean getApiStat() {
        return api;
    }

    @Override
    public Boolean getMkabStat() {
        return mkabStat;
    }

    @Override
    public String getSMPPhone() {
        return smpPhone;
    }

    @Override
    public String getPd() {
        return pd;
    }

    @Override
    public String getDfon() {
        return dfon;
    }

    @Override
    public String getEntrance() {
        return entrance;
    }
}