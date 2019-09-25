package com.lib.disp;

import com.codeborne.selenide.SelenideElement;

public class OpredelenieOtnositelnogoSSR {
    SelenideElement opredelenieOtnositelnogoSSR;
    Parameters parameters;

    OpredelenieOtnositelnogoSSR(SelenideElement opredelenieOtnositelnogoSSR) {
        this.opredelenieOtnositelnogoSSR = opredelenieOtnositelnogoSSR;
        this.parameters = new ParametersImpl();
    }

    public void click() {
        opredelenieOtnositelnogoSSR.$x("../.").hover();
        opredelenieOtnositelnogoSSR.click();
    }

    public String getValue() {
        return parameters.returnValueField(opredelenieOtnositelnogoSSR.$x("../../../.")).getValue();
    }
}