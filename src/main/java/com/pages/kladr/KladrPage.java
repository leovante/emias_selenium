package com.pages.kladr;

import com.pages.callcenter.*;
import com.pages.kladr.Kladr;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import static com.codeborne.selenide.Selenide.page;

@Component
public interface KladrPage {
    default Kladr kladr() {
        return page(Kladr.class);
    }
}
