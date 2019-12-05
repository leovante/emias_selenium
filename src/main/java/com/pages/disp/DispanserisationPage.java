package com.pages.disp;

import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.page;

@Component
public interface DispanserisationPage {
    default ExampPage exampPage(String text) {
        return new ExampPage(text);
    }

    default ExampPage exampPage() {
        return new ExampPage();
    }

    default JournalPage journalPage() {
        return page(JournalPage.class);
    }

    default KvotyPage kvotyPage() {
        return page(KvotyPage.class);
    }
}
