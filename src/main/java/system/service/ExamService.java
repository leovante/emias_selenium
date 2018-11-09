package system.service;

import pages.sql.HltDispExamEntity;
import system.dao.ExamDao;

import java.util.List;

public class ExamService {

    private ExamDao examDao = new ExamDao();

    public ExamService() {
    }

    public HltDispExamEntity findExam(int id) {
        return examDao.findById(id);
    }

    public void saveExam(HltDispExamEntity hltDispExamEntity) {
        examDao.save(hltDispExamEntity);
    }

    public void deleteExam(HltDispExamEntity hltDispExamEntity) {
        examDao.delete(hltDispExamEntity);
    }


    public void updateExam(HltDispExamEntity hltDispExamEntity) {
        examDao.update(hltDispExamEntity);
    }

    public List<HltDispExamEntity> findAllExam() {
        return examDao.findAll();
    }
}


