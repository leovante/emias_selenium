package system.service;

import system.dao.HltDispExam;
import system.model.HltDispExamEntity;

import java.util.List;

public class HltDispExamService {

    private HltDispExam hltDispExam = new HltDispExam();

    public HltDispExamService() {
    }

    public HltDispExamEntity findExam(int id) {
        return hltDispExam.findById(id);
    }

    public void saveExam(HltDispExamEntity hltDispExamEntity) {
        hltDispExam.save(hltDispExamEntity);
    }

    public void deleteExam(HltDispExamEntity hltDispExamEntity) {
        hltDispExam.delete(hltDispExamEntity);
    }

    public void updateExam(HltDispExamEntity hltDispExamEntity) {
        hltDispExam.update(hltDispExamEntity);
    }

    public List<HltDispExamEntity> findAllExam() {
        return hltDispExam.findAll();
    }
}