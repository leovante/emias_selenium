package com.pages.mis;

import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.page;

@Component
public interface Mis {
    default HomeWebPage homePageMis() {
        return page(HomeWebPage.class);
    }

    default MisHomePage misHome() {
        return new MisHomePage();
    }

    default NapravlenieNaIssledovanie napravlenieNaIssledovanie() {
        return page(NapravlenieNaIssledovanie.class);
    }

    default VedenieRaspisaniyaWebPage manageShedule() {
        return page(VedenieRaspisaniyaWebPage.class);
    }

    default CreateMedicalCard medicalCard() {
        return page(CreateMedicalCard.class);
    }

    default RaspisaniePriemaWebPage raspisaniePriemaPage() {
        return page(RaspisaniePriemaWebPage.class);
    }

    default TransferRecords transferRecords() {
        return page(TransferRecords.class);
    }

    default DoctorMethods doctorMethods() {
        return page(DoctorMethods.class);
    }
}