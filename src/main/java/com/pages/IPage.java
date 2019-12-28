package com.pages;

import com.pages.callcenter.CallCenter;
import com.pages.calldoctor.Calldoctor;
import com.pages.disp.Disp;
import com.pages.kladr.Kladr;
import com.pages.medicalrecords.MedicalRecord;
import com.pages.mis.Mis;
import com.pages.portal.Portal;
import org.springframework.stereotype.Component;

public interface IPage extends Disp, Calldoctor, CallCenter, Kladr, Mis, MedicalRecord, Portal {}