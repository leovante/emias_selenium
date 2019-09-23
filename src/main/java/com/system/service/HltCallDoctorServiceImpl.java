package com.system.service;

import com.system.model.HltCallDoctorEntity;
import com.system.repositories.HltCallDoctorRepository;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class HltCallDoctorServiceImpl {
    public static Logger logger = LogManager.getLogger();

    @Autowired
    private HltCallDoctorRepository hltCallDoctorRepository;

    @Transactional
    @Step("cancel call by pol number")
    public void cancelByNPol(String number) {
        try {
            Optional<HltCallDoctorEntity> calls = hltCallDoctorRepository
                    .findAllByNumberPolAndRfCallDoctorStatusId(number);
//            calls.forEach(call -> {
//                call.setRfCallDoctorStatusId(4);
//            });

            calls.ifPresent(call -> {
                call.setRfCallDoctorStatusId(4);
            });
        } catch (NullPointerException e) {
            logger.error("Error of close card by pol number. Number pol is: " + number);
            e.printStackTrace();
        }
    }

    @Transactional
    @Step("cancel call by card ID")
    public void cancelById(int id) {
        try {
            HltCallDoctorEntity calls = hltCallDoctorRepository.findById(id).get();
            calls.setRfCallDoctorStatusId(4);
        } catch (NullPointerException e) {
            logger.error("Error of close card by pol number. Number pol is: " + id);
            e.printStackTrace();
        }
    }

//    @Transactional
    @Step("cancel call by card ID")
    public void cancelNotClosedCards() {
        try{
        Stream<HltCallDoctorEntity> calls = hltCallDoctorRepository.findAllNotClosed();
        calls.forEach(call -> {
            call.setRfCallDoctorStatusId(4);
            call.setCauseCancel("Canceled before autotests framework run. By DTemnikov");
        });
        }catch (NullPointerException e){
            logger.error("Error of close cards");
            e.printStackTrace();
        }
    }
}