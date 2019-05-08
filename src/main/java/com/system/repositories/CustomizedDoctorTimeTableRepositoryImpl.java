package com.system.repositories;

import com.system.model.HltDoctorTimeTableEntity;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

public interface CustomizedDoctorTimeTableRepositoryImpl<T> {

    List<HltDoctorTimeTableEntity> deleteShedule(int LPUDoctorID, int DocPRVDID);

    List<HltDoctorTimeTableEntity> selectShedule(int LPUDoctorID, int DocPRVDID);

    void createShedule(int LPUDoctorID, int DocPRVDID) throws FileNotFoundException, ParseException;
}
