package com.system.service;

import com.system.model.HltCallDoctorEntity;
import com.system.repositories.HltCallDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HltCallDoctorServiceImpl {

    @Autowired
    private HltCallDoctorRepository hltCallDoctorRepository;

    public void cancelByNPol(String number) {
        List<HltCallDoctorEntity> calls = hltCallDoctorRepository.findAllByNumberPol(number);
        for (HltCallDoctorEntity call : calls) {
            call.setRfCallDoctorStatusId(3);
        }
    }
}
