package com.pages.mis;

import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.page;

@Component
public interface MisPage {

    default HomeBasePage homePageMis() {
        return page(HomeBasePage.class);
    }

    default MisHomePage misHome() {
        return new MisHomePage();
    }

    default NapravlenieNaIssledovanie napravlenieNaIssledovanie() {
        return page(NapravlenieNaIssledovanie.class);
    }

    default VedenieRaspisaniyaBasePage manageShedule() {
        return page(VedenieRaspisaniyaBasePage.class);
    }

    default CreateMedicalCard medicalCard() {
        return page(CreateMedicalCard.class);
    }

    default RaspisaniePriemaBasePage raspisaniePriemaPage() {
        return page(RaspisaniePriemaBasePage.class);
    }

    default TransferRecords transferRecords() {
        return page(TransferRecords.class);
    }

    default DoctorMethods doctorMethods() {
        return page(DoctorMethods.class);
    }
}
