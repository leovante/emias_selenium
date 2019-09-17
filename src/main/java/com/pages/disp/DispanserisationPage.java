package com.pages.disp;

import com.pages.disp.ExampPage;
import com.pages.disp.JournalPage;
import com.pages.disp.KvotyPage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import static com.codeborne.selenide.Selenide.page;

@Component
public interface DispanserisationPage {

    default ExampPage exampPage() {
        return page(ExampPage.class);
    }

    default JournalPage journalPage() {
        return page(JournalPage.class);
    }

    default KvotyPage kvotyPage() {
        return page(KvotyPage.class);
    }
}
