package com.datas.disp.measure;

public class IssledovanieKala implements Measure {
    private String examName = "Исследование кала на скрытую кровь иммунохимическим методом (допускается проведение бензидиновой или гваяковой пробы)";
    private String serviceName = "Анализ кала на скрытую кровь";

    @Override
    public String getExamName() {
        return examName;
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }
}