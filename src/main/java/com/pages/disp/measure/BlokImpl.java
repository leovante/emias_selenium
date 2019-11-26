package com.pages.disp.measure;

import com.datas.disp.measure.Measure;
import com.datas.disp.measure.MeasureEnum;

public interface BlokImpl {
    Measure examFactory(MeasureEnum measure);
    void expand(MeasureEnum measure);
}
