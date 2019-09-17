package com.pages;

import com.pages.callcenter.CallCenterPage;
import com.pages.calldoctor.CalldoctorPage;
import com.pages.disp.DispanserisationPage;
import com.pages.kladr.KladrPage;
import com.pages.medicalrecords.MedicalRecordPage;
import com.pages.mis.MisPage;
import com.pages.portal.PortalPage;
import org.springframework.stereotype.Component;

@Component
public interface Page extends DispanserisationPage, CalldoctorPage, CallCenterPage, KladrPage, MisPage, MedicalRecordPage, PortalPage {

}
