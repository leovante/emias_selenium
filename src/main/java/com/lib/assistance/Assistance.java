package com.lib.assistance;

import com.datas.ModuleData;
import com.datas.calldoctor.Pacient;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public interface Assistance {

    long getDateDiff(Date date1, Date date2, TimeUnit timeUnit);

    void isVisibleText(String text);

    void isNotVisibleText(String text);

    void isContains(String text);

    String parseTelephone(ModuleData mData);

    String parseTelephone(Pacient pacientImpl);

    ArrayList currentTimeList(String format);

    Integer cardNumberParser(String text);

    int years(Pacient pacient);
}
