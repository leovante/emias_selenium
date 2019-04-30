package com.utils.sql;

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
    int CELL_COUNT = 62;
    int DAY_COUNT = 4;
    int rf_LPUDoctorID;
    int rf_DocPRVDID;
    String firstCellTime = "07:00:00.000";
    String sqlRequest;
    Calendar date;
    Cell cell;
    List<Cell> cellList = new ArrayList<>();

    public DateGenerator() {
        date = Calendar.getInstance();
    }

    public String doctorShedule_Disp(int rf_LPUDoctorID, int rf_DocPRVDID) throws ParseException {
        this.rf_LPUDoctorID = rf_LPUDoctorID;
        this.rf_DocPRVDID = rf_DocPRVDID;
        cellsGenerator();
        patternSql();
        return sqlRequest;
    }

    public String doctorShedule_CD(int rf_LPUDoctorID, int rf_DocPRVDID) throws ParseException {
        this.rf_DocBusyType = 17;
        this.rf_LPUDoctorID = rf_LPUDoctorID;
        this.rf_DocPRVDID = rf_DocPRVDID;
        cellsGenerator();
        patternSql();
        return sqlRequest;
    }

    void cellsGenerator() throws ParseException {
        for (int i = 0; i < DAY_COUNT; i++) {
            if (!cellList.isEmpty()) {
                cell = new Cell();
                date.setTime(parserDate(cellList.get(cellList.size() - 1).getEnd_date()));
                date.add(Calendar.HOUR, 24);

                cell.setStart_date(formaterFirstDate(date));
                date.setTime(parserDate(cell.getStart_date()));
                date.add(Calendar.MINUTE, MINUTE_IN_CELL);

                cell.setEnd_date(formater(date));
                cellList.add(cell);
            } else {//добавляю первую ячейку в список со стёртыми значениями часа, минут и секунд
                cell = new Cell();
                cell.setStart_date(formaterFirstDate(date));
                date.setTime(parserDate(cell.getStart_date()));
                date.add(Calendar.MINUTE, MINUTE_IN_CELL);
                cell.setEnd_date(formater(date));
                cellList.add(cell);
            }
            for (int n = 0; n < CELL_COUNT; n++) {
                cell = new Cell();
                date.setTime(parserDate(cellList.get(cellList.size() - 1).getEnd_date()));
                date.add(Calendar.MINUTE, MINUTE_IN_CELL);
                cell.setStart_date(cellList.get(cellList.size() - 1).getEnd_date());
                cell.setEnd_date(formater(date));
                cellList.add(cell);
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
        String dateF = dateFormat.format(date.getTime()) + " 00:00:00.000";
        return dateF;
    }

    String formaterFirstDate(Calendar date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateF = dateFormat.format(date.getTime()) + " " + firstCellTime;
        return dateF;
    }

    void patternSql() throws ParseException {
        String header = "insert into hlt_DoctorTimeTable (Begin_Time, End_Time, Date, rf_LPUDoctorID, rf_DocBusyType, FlagAccess, rf_DocPRVDID) values";
        String value = patternSqlValue();
        this.sqlRequest = header + value;
    }

    String patternSqlValue() throws ParseException {
        String value = "";
        for (Cell cellCur : cellList) {

            date.setTime(parserDate(cellCur.getStart_date()));
            String body = " ('" + cellCur.getStart_date() + "', '" + cellCur.getEnd_date() + "', '" + formaterZero(date) + "', '" + rf_LPUDoctorID + "', '" + rf_DocBusyType + "', '" + FlagAccess + "', '" + rf_DocPRVDID + "')";
            value = value + body + ",";
        }
        StringBuilder builder = new StringBuilder(value);
        builder.deleteCharAt(value.length() - 1);
        return builder.toString();
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

    // TODO: 15-Feb-19 переписать в соответствии с http://dev-blogs.com/simple-spring-database/
}
