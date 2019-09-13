package com.pages;

import com.pages.callcenter.*;
import com.pages.kladr.Kladr;
import org.springframework.stereotype.Repository;

import static com.codeborne.selenide.Selenide.page;

@Repository
public interface KladrPage {
    default Kladr kladr() {
        return page(Kladr.class);
    }
}
