package com.pages.callcenter;

import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.page;

@Component
public interface CallCenter {
    default RecordDoctorWebPage recordDoctorPage() {
        return page(RecordDoctorWebPage.class);
    }

    default FindPatientWebPage findPatientPage() {
        return page(FindPatientWebPage.class);
    }

    default WaitingListWebPage waitingListPage() {
        return page(WaitingListWebPage.class);
    }

    default CallDoctorWebPage callDoctorPage() {
        return page(CallDoctorWebPage.class);
    }

    default DirectionsWebPage directionsPage() {
        return page(DirectionsWebPage.class);
    }
}
