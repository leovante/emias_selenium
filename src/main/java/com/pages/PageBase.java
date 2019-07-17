package com.pages;

import com.dataGenerator.ModuleData;
import com.pages.calldoctor.pacients.Pacient;
import com.pages.disp.measureBlock.Examps;
import com.pages.disp.measureBlock.ExampsImpl;
import com.utils.CallDoctorCards;
import com.utils.override.Assistance;
import com.utils.override.AssistanceImpl;
import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class PageBase {
    public CallDoctorCards callDoctorCards;
    public WebDriver driver;
    public Assistance as = new AssistanceImpl();
    //    public final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
//    public org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LoggingLogback.class);
    public static Logger LOGGER = LoggerFactory.getLogger("myapp");
    public static int callNumber;
//    public static Map<String, Integer> cardMap = new HashMap();

    @Autowired
    public Examps examps = new ExampsImpl();

    public PageBase() {
        this.driver = getWebDriver();
    }

    public void isVisibleText(String text) {
        as.isVisibleText(text);
    }

    public void isNotVisibleText(String text) {
        as.isNotVisibleText(text);
    }

    public String parseTelephone(ModuleData mData) {
        String telephone = mData.getMkab().getContactMPhone();
        if (mData.getSource() == "СМП") {
            telephone = telephone.substring(0, 1) + "7 (" +
                    telephone.substring(1, 4) + ") " +
                    telephone.substring(4, 7) + "-" +
                    telephone.substring(7, 9) + "-" +
                    telephone.substring(9, telephone.length() - 1);
        }
        if (mData.getSource() == "СМП") {
            telephone = telephone.substring(0, 2) + " (" +
                    telephone.substring(2, 5) + ") " +
                    telephone.substring(5, 8) + "-" +
                    telephone.substring(8, 10) + "-" +
                    telephone.substring(10, telephone.length());
        }
        return telephone;
    }

    public String parseTelephone(Pacient pacientImpl) {
        String telephone = pacientImpl.getPhone();
        if (pacientImpl.getSource() == 4) {
            telephone = telephone.substring(0, 1) + "7 (" +
                    telephone.substring(1, 4) + ") " +
                    telephone.substring(4, 7) + "-" +
                    telephone.substring(7, 9) + "-" +
                    telephone.substring(9, telephone.length() - 1);
        }
        if (pacientImpl.getSource() != 4) {
            telephone = telephone.substring(0, 2) + " (" +
                    telephone.substring(2, 5) + ") " +
                    telephone.substring(5, 8) + "-" +
                    telephone.substring(8, 10) + "-" +
                    telephone.substring(10, telephone.length());
        }
        return telephone;
    }

    /*public String currentTime(String format) {
        String time;
        SimpleDateFormat simpleDateFormatEdit = new SimpleDateFormat(format);
        Date date = Calendar.getInstance().getTime();
        time = simpleDateFormatEdit.format(date);
        return time;
    }*/

    public ArrayList currentTimeList(String format) {
        ArrayList dateList = new ArrayList();
        SimpleDateFormat simpleDateFormatEdit = new SimpleDateFormat(format);
        //получаем время
        Date date = Calendar.getInstance().getTime();
        dateList.add(simpleDateFormatEdit.format(date));
        Date date1 = DateUtils.addMinutes(date, 1);
        dateList.add(simpleDateFormatEdit.format(date1));
        Date date2 = DateUtils.addMinutes(date, -1);
        dateList.add(simpleDateFormatEdit.format(date2));
        return dateList;
    }

//    public void cardNumberParser(String text) {
//        String strNew = text.replace("Карта вызова № ", "");
//        this.callNumber = Integer.valueOf(strNew);
//    }

    public Integer cardNumberParser(String text) {
        String strNew = text.replace("Карта вызова № ", "");
        return Integer.valueOf(strNew);
    }
}