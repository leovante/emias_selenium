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
    int CELL_COUNT = 10;
    int DAY_COUNT = 3;
    int rf_LPUDoctorID;
    int rf_DocPRVDID;
    String sqlRequest;
    Calendar date;
    //    List<String> cellList;
    Cell cell = null;
    List<Cell> cellList = new ArrayList<>();

    public DateGenerator() {
        date = Calendar.getInstance();
//        cellList = new ArrayList<String>();
    }

    public String dispDoctorShedule(int rf_LPUDoctorID, int rf_DocPRVDID) throws ParseException {
        this.rf_LPUDoctorID = rf_LPUDoctorID;
        this.rf_DocPRVDID = rf_DocPRVDID;
        cellsInDay();
        return sqlRequest;
    }

    void cellsInDay() throws ParseException {
        for (int i = 0; i < DAY_COUNT; i++) {
            if (!cellList.isEmpty()) {
                cell = new Cell();
                cell = cellList.get(cellList.size() - 1);

                date.setTime(parserDate(cell.getEnd_date()));
                date.add(Calendar.HOUR, 24);

                cell.setStart_date(formaterZero(date));
                date.add(Calendar.MINUTE, MINUTE_IN_CELL);
                cell.setEnd_date(formater(date));
                cellList.add(cell);
//                date.setTime(parserDate(cellList.get(cellList.size() - 1)));
//                date.add(Calendar.HOUR,  24);
//                cellList.add(formaterZero(date));
            } else {                //добавляю первую ячейку
                cell = new Cell();
                cell.setStart_date(formaterZero(date));
                date.setTime(parserDate(cell.getStart_date()));
                date.add(Calendar.MINUTE, MINUTE_IN_CELL);
                cell.setEnd_date(formater(date));
                cellList.add(cell);
            }
            for (int n = 0; n < CELL_COUNT; n++) {
                cell = new Cell();
                cell = cellList.get(cellList.size() - 1);

                date.setTime(parserDate(cell.getEnd_date()));
                date.add(Calendar.MINUTE, MINUTE_IN_CELL);

                cell.setStart_date(cell.getEnd_date());
                cell.setEnd_date(formater(date));
                cellList.add(cell);
            }

//                if (cellList.size() == 0) {
//                    cellList.add(formaterZero(date));
//                    date.setTime(parserDate(cellList.get(0)));
//                    date.add(Calendar.MINUTE, MINUTE_IN_CELL);
//                    cellList.add(formater(date));
//                } else {
//                date.setTime(parserDate(cellList.get(cellList.size() - 1)));
//                date.add(Calendar.MINUTE, MINUTE_IN_CELL);
//                cellList.add(formater(date));
//                date.add(Calendar.MINUTE, MINUTE_IN_CELL * 2);
//                cellList.add(formater(date));
//                }
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

    class Cell {
        String start_date;
        String end_date;

        public Cell() {
        }

        public String getStart_date() {
            return start_date;
        }

        public void setStart_date(String start_date) {
            this.start_date = start_date;
        }

        public String getEnd_date() {
            return end_date;
        }

        public void setEnd_date(String end_date) {
            this.end_date = end_date;
        }
    }
}
