package dataGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.service.HltMkabService;

@Service
public class FactoryData implements UserData {

    @Autowired
    HltMkabService hltMkabService;

    @Override
    public ModuleData getData(DataType type) {
        try {
            if (type == DataType.CalldoctorData) {
                return new CalldoctorData(hltMkabService);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
}