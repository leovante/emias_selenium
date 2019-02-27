package system.service;

import system.dao.HltDispExamDao;
import system.model.HltDispExamEntity;

import java.util.List;

public class HltDispExamService {
    //<!--правка hibernate-->
    private HltDispExamDao hltDispExam = new HltDispExamDao();

    public HltDispExamService() {
    }

//    public HltDispExamEntity findExam(int id) {
//        return hltDispExam.findById(id);
//    }
//
//    public void saveExam(HltDispExamEntity hltDispExamEntity) {
//        hltDispExam.save(hltDispExamEntity);
//    }
//
//    public void deleteExam(HltDispExamEntity hltDispExamEntity) {
//        hltDispExam.delete(hltDispExamEntity);
//    }
//
//    public void updateExam(HltDispExamEntity hltDispExamEntity) {
//        hltDispExam.update(hltDispExamEntity);
//    }

    public List<HltDispExamEntity> findAllExam() {
        return hltDispExam.findAll();
    }
}