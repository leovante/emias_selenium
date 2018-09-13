package pages;

import pages.calldoctor.CreateCallPage;
import pages.calldoctor.FullCardPage;

public class Pages extends AbstractPage {

    public Pages() {
    }


    public CreateCallPage createCallPage() {
        CreateCallPage createCallPage = new CreateCallPage();
        return createCallPage;
    }

    public FullCardPage fullCardPage() {
        FullCardPage fullCardPage = new FullCardPage();
        return fullCardPage;
    }
}