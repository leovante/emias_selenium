package com.utils.assistance;

import com.datas.ModuleData;
import com.datas.calldoctor.Pacient;

import java.util.ArrayList;

public interface Assistance {

    void isVisibleText(String text);

    void isNotVisibleText(String text);

    void isContains(String text);

    String parseTelephone(ModuleData mData);

    String parseTelephone(Pacient pacientImpl);

    ArrayList currentTimeList(String format);

    Integer cardNumberParser(String text);
}
