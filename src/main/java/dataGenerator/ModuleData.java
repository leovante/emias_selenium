package dataGenerator;


import system.model.HltMkabEntity;

public interface ModuleData {

    ModuleData findByModel();

    CalldoctorData setDopData(String source, String complaint, String adress);

    HltMkabEntity getMkab();
}
