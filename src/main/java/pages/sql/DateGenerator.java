package pages.sql;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateGenerator {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    int rf_DocBusyType = 15;
    int FlagAccess = 15;
    int MINUTE_IN_CELL = 15;
    int CELL_COUNT = 31;
    int DAY_COUNT = 3;
    int rf_LPUDoctorID;
    int rf_DocPRVDID;
    String sqlRequest;
    Calendar cell;
    List<String> cellList;

    public DateGenerator() {
        cell = Calendar.getInstance();
        cellList = new ArrayList<String>();
    }

    public String dispDoctorShedule(int rf_LPUDoctorID, int rf_DocPRVDID) throws ParseException {
        this.rf_LPUDoctorID = rf_LPUDoctorID;
        this.rf_DocPRVDID = rf_DocPRVDID;
        cellsInDay();
        return sqlRequest;
    }

    void cellsInDay() throws ParseException {
        for (int i = 0; i < DAY_COUNT; i++) {
            if (cellList.size() > 0) {
                cell.setTime(parserDate(cellList.get(cellList.size() - 1)));
                cell.add(Calendar.HOUR, DAY_COUNT * 24);
                cellList.add(formaterZero(cell));
            }
            for (int n = 0; n < CELL_COUNT - 1; n++) {
                cell.setTime(parserDate(cellList.get(cellList.size() - 1)));
                cell.add(Calendar.MINUTE, MINUTE_IN_CELL);
                cellList.add(formater(cell));
            }
        }
    }

    String formater(Calendar date) {
        return dateFormat.format(date.getTime());
    }

    Date parserDate(String date) throws ParseException {
        return dateFormat.parse(date);
    }

    String formaterZero(Calendar date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateF = dateFormat.format(date.getTime()) + " 07:00:00.000";
        return dateF;
    }

    void pattern() {
        String insert = "insert into hlt_DoctorTimeTable (Begin_Time, End_Time, Date, rf_LPUDoctorID, rf_DocBusyType, FlagAccess, rf_DocPRVDID) ";
        String value1 = "values ";
        String value2 = "('2018-10-19 20:00:00.000', '2018-10-19 20:15:00.000', '2018-10-19 00:00:00.000', '" + rf_LPUDoctorID + "', '" + rf_DocBusyType + "', '" + FlagAccess + "', '" + rf_DocPRVDID + "') ";
    }
}
