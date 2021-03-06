package com.system.service;

import com.system.model.HltDoctorTimeTableEntity;
import com.system.repositories.HltDoctorTimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

@Service
public class HltDoctorTimeTableService {

    @Autowired
    HltDoctorTimeTableRepository hltDoctorTimeTableRepository;

    @Transactional
    public List<HltDoctorTimeTableEntity> deleteShedule(int LPUDoctorID, int DocPRVDID) {
        return hltDoctorTimeTableRepository.deleteShedule(LPUDoctorID, DocPRVDID);
    }

    @Transactional
    public void createShedule(int LPUDoctorID, int DocPRVDID) throws FileNotFoundException, ParseException {
        hltDoctorTimeTableRepository.createShedule(LPUDoctorID, DocPRVDID);
    }
}