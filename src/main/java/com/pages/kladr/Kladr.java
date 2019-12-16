package com.pages.kladr;

import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.page;

@Component
public interface Kladr {
    default KladrImpl kladr() {
        return page(KladrImpl.class);
    }
}
