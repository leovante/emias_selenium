package com.pages.medicalrecords;

import com.datas.Datas;
import com.pages.disp.ExampPage;
import com.pages.disp.JournalPage;
import com.pages.disp.KvotyPage;
import com.pages.medicalrecords.Ehr_medicalrecords;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import static com.codeborne.selenide.Selenide.page;

@Component
public interface MedicalRecordPage {
    default Ehr_medicalrecords ehrMedicalrecords(Datas d) {
        return new Ehr_medicalrecords(d);
    }

    default Ehr_medicalrecordsMkab ehr_medicalrecordsMKAB(Datas d) {
        return new Ehr_medicalrecordsMkab(d);
    }
}
