package dataGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import system.model.HltMkabEntity;
import system.service.HltMkabService;

public class CalldoctorData implements ModuleData {
    HltMkabEntity mkab;
    String source;
    String complaint;
    String adress;

    @Autowired
    private HltMkabService hltMkabService;

    @Override
    public CalldoctorData findByModel() {
        mkab = hltMkabService.findByModel();
        return this;
    }

    public CalldoctorData() {
        mkab = hltMkabService.findByModel();
    }

    @Override
    public CalldoctorData setDopData(String source, String complaint, String adress) {
        this.source = source;
        this.complaint = complaint;
        this.adress = adress;
        return this;
    }

    public String getSource() {
        return source;
    }

    public String getComplaint() {
        return complaint;
    }

    @Override
    public HltMkabEntity getMkab() {
        return mkab;
    }
    //тут дополнительно к мкаб будут проставляться
    //тип вызова, по апи или нет
    //источник вызова
    //дополнительные параметры для адреса (корпус, строение)
    //жалоба
}
