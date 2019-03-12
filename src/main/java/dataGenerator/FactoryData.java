package dataGenerator;

import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

@Service
@ContextConfiguration(locations = {"classpath:beans.xml"})
public class FactoryData implements UserData {

    @Override
    public ModuleData getData(DataType type) {
        try {
            if (type == DataType.CalldoctorData) {
                return new CalldoctorData();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
}