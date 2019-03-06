package dataGenerator;

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
