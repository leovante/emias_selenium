package com.pages;

import com.pages.callcenter.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import static com.codeborne.selenide.Selenide.page;

@Component
public interface CallCenterPage {
    default RecordDoctorBasePage recordDoctorPage() {
        return page(RecordDoctorBasePage.class);
    }

    default FindPatientBasePage findPatientPage() {
        return page(FindPatientBasePage.class);
    }

    default WaitingListBasePage waitingListPage() {
        return page(WaitingListBasePage.class);
    }

    default CallDoctorBasePage callDoctorPage() {
        return page(CallDoctorBasePage.class);
    }

    default DirectionsBasePage directionsPage() {
        return page(DirectionsBasePage.class);
    }
}
