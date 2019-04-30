package com.system.service;

import com.system.dao.ExamDao;
import com.system.model.HltDispExamEntity;

import java.util.List;
import java.util.Optional;

public class ExamService {
    //<!--правка hibernate-->
    private ExamDao examDao = new ExamDao();

    public ExamService() {
    }

    public Optional<HltDispExamEntity> findExam(int id) {
        return examDao.findById(Long.valueOf(id));
    }

//    public void saveExam(HltDispExamEntity hltDispExamEntity) {
//        examDao.save(hltDispExamEntity);
//    }
//
//    public void deleteExam(HltDispExamEntity hltDispExamEntity) {
//        examDao.delete(hltDispExamEntity);
//    }
//
//    public void updateExam(HltDispExamEntity hltDispExamEntity) {
//        examDao.update(hltDispExamEntity);
//    }

    public List<HltDispExamEntity> findAllExam() {
        return examDao.findAll();
    }
}


