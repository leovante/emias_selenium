package com.lib.assistance;

import com.codeborne.selenide.Condition;
import com.datas.ModuleData;
import com.datas.calldoctor.Pacient;
import io.qameta.allure.Step;
import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$x;

public class AssistanceImpl implements Assistance {

    @Override
    public void isVisibleText(String text) {
        $x("//*[contains(.,'" + text + "')]").shouldBe(Condition.visible);
    }

    @Override
    public void isNotVisibleText(String text) {
        $x("//*[contains(.,'" + text + "')]").shouldNotBe(Condition.visible);
    }

    @Override
    public void isContains(String text) {
    }
    @Override
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
    @Override
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
    @Override
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
    @Override
    public Integer cardNumberParser(String text) {
        String strNew = text.replace("Карта вызова № ", "");
        return Integer.valueOf(strNew);
    }

    @Override
    public long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    @Override
    public int years(Pacient pacient) {
        Date newData = new Date();
        Date bd = pacient.getBirthdate();
        int years = (int) getDateDiff(bd, newData, TimeUnit.DAYS) / 365;
        return years;
    }
}
