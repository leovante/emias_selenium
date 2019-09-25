package com.lib.disp;

import com.codeborne.selenide.SelenideElement;

public class RouteList {
    SelenideElement routeList;

    RouteList(SelenideElement se) {
        routeList = se;
    }

    public OpredelenieOtnositelnogoSSR opredelenieOtnositelnogoSSR(){
        SelenideElement opredelenieOtnositelnogoSSR = routeList.$x(".//*[contains(text(),'Определение относительного суммарного сердечно-сосудистого риска')]");
        return new OpredelenieOtnositelnogoSSR(opredelenieOtnositelnogoSSR);
    }
}