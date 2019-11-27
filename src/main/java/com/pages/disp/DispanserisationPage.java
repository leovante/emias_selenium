package com.pages.disp;

import com.datas.disp.measure.MeasureEnum;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.page;

@Component
public interface DispanserisationPage {
    default Exams exampPage() {
        return new Exams();
    }
    default Exams exampPage(MeasureEnum measure) {
        return new Exams(measure);
    }

    default JournalPage journalPage() {
        return page(JournalPage.class);
    }

    default KvotyPage kvotyPage() {
        return page(KvotyPage.class);
    }
}
