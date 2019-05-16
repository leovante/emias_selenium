package com.dataGenerator;

import com.system.service.HltMkabServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactoryData implements UserData {

    @Autowired
    HltMkabServiceImpl hltMkabService;

//    @Override
//    public ModuleData getData(DataType type) {
//        try {
//            if (type == DataType.CalldoctorData) {
//                return new CalldoctorData(hltMkabService);
//            }
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}