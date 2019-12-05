package com.pages.medicalrecords;

import com.datas.Datas;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.page;

@Component
public interface MedicalRecordPage {
    default EhrMedRecords ehrMedrecords(Datas d) {
        return new EhrMedRecords(d);
    }

    default Ehr_medicalrecordsMkab ehr_medicalrecordsMKAB(Datas d) {
        return new Ehr_medicalrecordsMkab(d);
    }
}
