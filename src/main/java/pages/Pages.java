package pages;

import pages.calldoctor.CreateCallPage;
import pages.calldoctor.FullCardPage;

import static com.codeborne.selenide.Selenide.page;

public class Pages extends AbstractPage {

    public Pages() {
    }


    public CreateCallPage createCallPage() {
        return page(CreateCallPage.class);
    }

    public FullCardPage fullCardPage() {
        return page(FullCardPage.class);
    }
}