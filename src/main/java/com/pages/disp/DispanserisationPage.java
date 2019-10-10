package com.pages.disp;

import com.pages.disp.ExampPage;
import com.pages.disp.JournalPage;
import com.pages.disp.KvotyPage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.page;

@Component
public interface DispanserisationPage {

    default ExampPage exampPage(String text) {
        try {
            return new ExampPage(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    default ExampPage exampPage() {
        try {
            return new ExampPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    default JournalPage journalPage() {
        return page(JournalPage.class);
    }

    default KvotyPage kvotyPage() {
        return page(KvotyPage.class);
    }
}
