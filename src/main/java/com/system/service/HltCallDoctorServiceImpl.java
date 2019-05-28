package com.system.service;

import com.system.model.HltCallDoctorEntity;
import com.system.repositories.HltCallDoctorRepository;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HltCallDoctorServiceImpl {

    @Autowired
    private HltCallDoctorRepository hltCallDoctorRepository;

    @Autowired
    private CallDoctorCards callDoctorCards;

    public void cancelByNPol(String number) {
        List<HltCallDoctorEntity> calls = hltCallDoctorRepository.findAllByNumberPol(number);
        for (HltCallDoctorEntity call : calls) {
            call.setRfCallDoctorStatusId(4);
        }
    }

    @Step("отменяю созданный вызов")
    public void cancelByTestName(String testName) {
        HltCallDoctorEntity calls = hltCallDoctorRepository.findById(callDoctorCards.getCardMap(testName)).get();
        calls.setRfCallDoctorStatusId(4);
    }
}