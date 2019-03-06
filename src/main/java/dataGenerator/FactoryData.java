package dataGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FactoryData implements UserData {

    @Autowired
    CalldoctorData calldoctorData;

    @Override
    public ModuleData getData(DataType type) {
        try {
            if (type == DataType.CalldoctorData) {
                return calldoctorData;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
}
