package com.datas.disp.measure;

public class IndividualnoeProfKonsultirovanie implements Measure  {
    private String measuerName = "Исследование кала на скрытую кровь иммунохимическим методом (допускается проведение бензидиновой или гваяковой пробы)";
    private String serviceName = "Индивидуальное профилактическое консультирование";

    public String getExamName() {
        return measuerName;
    }

    public String getServiceName() {
        return serviceName;
    }
}
