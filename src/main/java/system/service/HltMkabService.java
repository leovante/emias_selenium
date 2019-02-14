package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.dao.HltMkabDao;

import java.util.List;

@Service
public class HltMkabService {
    @Autowired
    private HltMkabDao hltMkabDao;

    public List getAllMkab() {
        return hltMkabDao.findAll();
    }

}
