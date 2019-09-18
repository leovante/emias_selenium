package com.system.service;

import com.system.model.HltCallDoctorEntity;
import com.system.repositories.HltCallDoctorRepository;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@Service
public class HltCallDoctorServiceImpl {

    @Autowired
    private HltCallDoctorRepository hltCallDoctorRepository;

    @Transactional
    @Step("cancel call by pol number")
    public void cancelByNPol(String number) {
        List<HltCallDoctorEntity> calls = hltCallDoctorRepository.findAllByNumberPol(number);
        for (HltCallDoctorEntity call : calls) {
            call.setRfCallDoctorStatusId(4);
        }
    }

    @Transactional
    @Step("cancel call by card ID")
    public void cancelById(int id) {
        HltCallDoctorEntity calls = hltCallDoctorRepository.findById(id).get();
        calls.setRfCallDoctorStatusId(4);
    }

    @Transactional
    @Step("cancel call by card ID")
    public void cancelNotClosedCards() {
        Stream<HltCallDoctorEntity> calls = hltCallDoctorRepository.findAllNotClosed();
        calls.forEach(call -> {
            call.setRfCallDoctorStatusId(4);
            call.setCauseCancel("Canceled before autotests framework run. By DTemnikov");
        });
    }
}