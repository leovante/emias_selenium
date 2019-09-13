package com.pages;

import org.springframework.stereotype.Component;

@Component
public interface Page extends DispanserisationPage, CalldoctorPage, CallCenterPage, KladrPage, MisPage, MedicalRecordPage, PortalPage {

}
