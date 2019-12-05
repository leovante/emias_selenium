package com.system.service;

import com.system.model.HltDispServiceDocPrvd;
import com.system.repositories.HltDispServiceDocPrvdRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class HltDispServiceDocPrvdServiceImpl {
    public static Logger logger = LogManager.getLogger();

    @Autowired
    private HltDispServiceDocPrvdRepository hltDispServiceDocPrvdRepository;

    @Transactional()
    public void deleteAllDocPrvd() {
        hltDispServiceDocPrvdRepository.deleteAll();
    }

    @Transactional()
    public void addDocPrvd() {
        List<HltDispServiceDocPrvd> sdpList = new ArrayList<HltDispServiceDocPrvd>();
        // TODO: 9/26/2019 сделать проверку что такая запись уже существует, тогда не добавлять из списка

//        for (HltDispServiceDocPrvd sdp : sdpList) {
//            sdp.set
//        }

//        try {
//            Stream<HltCallDoctorEntity> calls = hltCallDoctorRepository.findAllNotClosed();
//            calls.forEach(call -> {
//                call.setRfCallDoctorStatusId(4);
//                call.setCauseCancel("Canceled before autotests framework run. By DTemnikov");
//            });
//        } catch (NullPointerException e) {
//            logger.error("Error of close cards");
//            e.printStackTrace();
//        }
    }
}