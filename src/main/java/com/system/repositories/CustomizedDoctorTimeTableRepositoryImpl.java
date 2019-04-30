package com.system.repositories;

import com.system.model.HltDoctorTimeTableEntity;

import java.util.List;

public interface CustomizedDoctorTimeTableRepositoryImpl<T> {

    List<HltDoctorTimeTableEntity> deleteShedule(int LPUDoctorID, int DocPRVDID);

}
