package com.pages.disp;

import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.page;

@Component
public interface DispanserisationPage {
    default Exams exampPage() {
        return new Exams();
    }

//    default Exams exampPage() {
//        return new Exams();
//    }

    default JournalPage journalPage() {
        return page(JournalPage.class);
    }

    default KvotyPage kvotyPage() {
        return page(KvotyPage.class);
    }
}
