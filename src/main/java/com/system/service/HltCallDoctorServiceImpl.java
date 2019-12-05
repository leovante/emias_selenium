package com.system.service;

import com.system.model.HltCallDoctorEntity;
import com.system.repositories.HltCallDoctorRepository;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service("HltCallDoctorServiceImpl")
public class HltCallDoctorServiceImpl {
    public static Logger logger = LogManager.getLogger();

    @Autowired
    private HltCallDoctorRepository hltCallDoctorRepository;

    @Step("cancel call by pol number")
    @Transactional
    public void cancelByNPol(String number) {
        try {
            List<HltCallDoctorEntity> calls = hltCallDoctorRepository.findAllByNumberPolAndRfCallDoctorStatusId(number);
            calls.forEach(call -> {
                call.setRfCallDoctorStatusId(4);
                hltCallDoctorRepository.save(call);
            });
        } catch (NullPointerException e) {
            logger.error("Error of close card by pol number. Number pol is: " + number);
            e.printStackTrace();
        }
    }

    @Step("cancel call by card ID")
    @Transactional
    public void cancelById(int id) {
        try {
            HltCallDoctorEntity call = hltCallDoctorRepository.findById(id).get();
            call.setRfCallDoctorStatusId(4);
            hltCallDoctorRepository.save(call);
        } catch (NullPointerException e) {
            logger.error("Error of close card by pol number. Number pol is: " + id);
            e.printStackTrace();
        }
    }
}