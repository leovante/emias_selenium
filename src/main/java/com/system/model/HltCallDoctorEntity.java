package com.system.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

//<!--правка hibernate-->
//<!--правка hibernate-->
@Entity
@Table(name = "hlt_CallDoctor", schema = "dbo", catalog = "test_mo_hlt_Taldom_CRB_20190129")
public class HltCallDoctorEntity {
    private int callDoctorId;
    private int xEdition;
    private int xStatus;
    private int rfLpuDoctorId;
    private int rfMkabid;
    private String address;
    private String complaint;
    private Date dateCall;
    private int rfCallDoctorStatusId;
    private boolean isFinalize;
    private Date dateFinalize;
    private int rfTapid;
    private String codeDomophon;
    private String phone;
    private int rfFinalizeLpuDoctorId;
    private String description;
    private int entrance;
    private int floor;
    private int rfAddressId;
    private int rfDocPrvdid;
    private int rfFinalizeDocPrvdid;
    private Date dateVisit;
    private int flags;
    private String guid;
    private int rfLpuid;
    private int sourceDvt;
    private Date birthDate;
    private String family;
    private String name;
    private String numberPol;
    private String ot;
    private int rfKlSexId;
    private String seriesPol;
    private int rfMkbid;
    private Date dateStatus;
    private String causeCancel;
    private String sourceSmp;
    private String callFamily;
    private String callName;
    private String callPatronymic;
    private int rfCallPersonTypeId;
    private int age;
    private int ageTitle;
    private Date dateActive;
    private Date dateResolved;
    private boolean isChild;
    private boolean isNotification;
    private int rfUchastokId;
    private int rfKlAgeGroupId;

    @Id
    @GeneratedValue
    @Column(name = "CallDoctorID", nullable = false)
    public int getCallDoctorId() {
        return callDoctorId;
    }

    public void setCallDoctorId(int callDoctorId) {
        this.callDoctorId = callDoctorId;
    }

    @Basic
    @Column(name = "x_Edition", nullable = false)
    public int getxEdition() {
        return xEdition;
    }

    public void setxEdition(int xEdition) {
        this.xEdition = xEdition;
    }

    @Basic
    @Column(name = "x_Status", nullable = false)
    public int getxStatus() {
        return xStatus;
    }

    public void setxStatus(int xStatus) {
        this.xStatus = xStatus;
    }

    @Basic
    @Column(name = "rf_LPUDoctorID", nullable = false)
    public int getRfLpuDoctorId() {
        return rfLpuDoctorId;
    }

    public void setRfLpuDoctorId(int rfLpuDoctorId) {
        this.rfLpuDoctorId = rfLpuDoctorId;
    }

    @Basic
    @Column(name = "rf_MKABID", nullable = false)
    public int getRfMkabid() {
        return rfMkabid;
    }

    public void setRfMkabid(int rfMkabid) {
        this.rfMkabid = rfMkabid;
    }

    @Basic
    @Column(name = "Address", nullable = false, length = 200)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "Complaint", nullable = false, length = 500)
    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    //NOTE THIS!
    @Temporal(TemporalType.DATE)
    @Column(name = "DateCall", nullable = false)
    public Date getDateCall() {
        return dateCall;
    }

    public void setDateCall(Date dateCall) {
        this.dateCall = dateCall;
    }

    @Basic
    @Column(name = "rf_CallDoctorStatusID", nullable = false)
    public int getRfCallDoctorStatusId() {
        return rfCallDoctorStatusId;
    }

    public void setRfCallDoctorStatusId(int rfCallDoctorStatusId) {
        this.rfCallDoctorStatusId = rfCallDoctorStatusId;
    }

    @Basic
    @Column(name = "isFinalize", nullable = false)
    public boolean isFinalize() {
        return isFinalize;
    }

    public void setFinalize(boolean finalize) {
        isFinalize = finalize;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "DateFinalize", nullable = false)
    public Date getDateFinalize() {
        return dateFinalize;
    }

    public void setDateFinalize(Date dateFinalize) {
        this.dateFinalize = dateFinalize;
    }

    @Basic
    @Column(name = "rf_TAPID", nullable = false)
    public int getRfTapid() {
        return rfTapid;
    }

    public void setRfTapid(int rfTapid) {
        this.rfTapid = rfTapid;
    }

    @Basic
    @Column(name = "CodeDomophon", nullable = false, length = 20)
    public String getCodeDomophon() {
        return codeDomophon;
    }

    public void setCodeDomophon(String codeDomophon) {
        this.codeDomophon = codeDomophon;
    }

    @Basic
    @Column(name = "Phone", nullable = false, length = 25)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "Rf_FinalizeLPUDoctorID", nullable = false)
    public int getRfFinalizeLpuDoctorId() {
        return rfFinalizeLpuDoctorId;
    }

    public void setRfFinalizeLpuDoctorId(int rfFinalizeLpuDoctorId) {
        this.rfFinalizeLpuDoctorId = rfFinalizeLpuDoctorId;
    }

    @Basic
    @Column(name = "Description", nullable = false, length = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Entrance", nullable = false)
    public int getEntrance() {
        return entrance;
    }

    public void setEntrance(int entrance) {
        this.entrance = entrance;
    }

    @Basic
    @Column(name = "Floor", nullable = false)
    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Basic
    @Column(name = "rf_AddressID", nullable = false)
    public int getRfAddressId() {
        return rfAddressId;
    }

    public void setRfAddressId(int rfAddressId) {
        this.rfAddressId = rfAddressId;
    }

    @Basic
    @Column(name = "rf_DocPRVDID", nullable = false)
    public int getRfDocPrvdid() {
        return rfDocPrvdid;
    }

    public void setRfDocPrvdid(int rfDocPrvdid) {
        this.rfDocPrvdid = rfDocPrvdid;
    }

    @Basic
    @Column(name = "rf_FinalizeDocPRVDID", nullable = false)
    public int getRfFinalizeDocPrvdid() {
        return rfFinalizeDocPrvdid;
    }

    public void setRfFinalizeDocPrvdid(int rfFinalizeDocPrvdid) {
        this.rfFinalizeDocPrvdid = rfFinalizeDocPrvdid;
    }

    //NOTE THIS!
    @Temporal(TemporalType.DATE)
    @Column(name = "DateVisit", nullable = false)
    public Date getDateVisit() {
        return dateVisit;
    }

    public void setDateVisit(Date dateVisit) {
        this.dateVisit = dateVisit;
    }

    @Basic
    @Column(name = "Flags", nullable = false)
    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    @Basic
    @Column(name = "GUID", nullable = false)
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Basic
    @Column(name = "rf_LPUID", nullable = false)
    public int getRfLpuid() {
        return rfLpuid;
    }

    public void setRfLpuid(int rfLpuid) {
        this.rfLpuid = rfLpuid;
    }

    @Basic
    @Column(name = "SourceDvt", nullable = false)
    public int getSourceDvt() {
        return sourceDvt;
    }

    public void setSourceDvt(int sourceDvt) {
        this.sourceDvt = sourceDvt;
    }

    //NOTE THIS!
    @Temporal(TemporalType.DATE)
    @Column(name = "BirthDate", nullable = false)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "Family", nullable = false, length = 40)
    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 40)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "NumberPol", nullable = false, length = 50)
    public String getNumberPol() {
        return numberPol;
    }

    public void setNumberPol(String numberPol) {
        this.numberPol = numberPol;
    }

    @Basic
    @Column(name = "Ot", nullable = false, length = 40)
    public String getOt() {
        return ot;
    }

    public void setOt(String ot) {
        this.ot = ot;
    }

    @Basic
    @Column(name = "rf_kl_SexID", nullable = false)
    public int getRfKlSexId() {
        return rfKlSexId;
    }

    public void setRfKlSexId(int rfKlSexId) {
        this.rfKlSexId = rfKlSexId;
    }

    @Basic
    @Column(name = "SeriesPol", nullable = false, length = 50)
    public String getSeriesPol() {
        return seriesPol;
    }

    public void setSeriesPol(String seriesPol) {
        this.seriesPol = seriesPol;
    }

    @Basic
    @Column(name = "rf_MKBID", nullable = false)
    public int getRfMkbid() {
        return rfMkbid;
    }

    public void setRfMkbid(int rfMkbid) {
        this.rfMkbid = rfMkbid;
    }

    //NOTE THIS!
    @Temporal(TemporalType.DATE)
    @Column(name = "DateStatus", nullable = false)
    public Date getDateStatus() {
        return dateStatus;
    }

    public void setDateStatus(Date dateStatus) {
        this.dateStatus = dateStatus;
    }

    @Basic
    @Column(name = "CauseCancel", nullable = false, length = 2147483647)
    public String getCauseCancel() {
        return causeCancel;
    }

    public void setCauseCancel(String causeCancel) {
        this.causeCancel = causeCancel;
    }

    @Basic
    @Column(name = "SourceSmp", nullable = false, length = 2147483647)
    public String getSourceSmp() {
        return sourceSmp;
    }

    public void setSourceSmp(String sourceSmp) {
        this.sourceSmp = sourceSmp;
    }

    @Basic
    @Column(name = "Call_Family", nullable = false, length = 40)
    public String getCallFamily() {
        return callFamily;
    }

    public void setCallFamily(String callFamily) {
        this.callFamily = callFamily;
    }

    @Basic
    @Column(name = "Call_Name", nullable = false, length = 40)
    public String getCallName() {
        return callName;
    }

    public void setCallName(String callName) {
        this.callName = callName;
    }

    @Basic
    @Column(name = "Call_Patronymic", nullable = false, length = 40)
    public String getCallPatronymic() {
        return callPatronymic;
    }

    public void setCallPatronymic(String callPatronymic) {
        this.callPatronymic = callPatronymic;
    }

    @Basic
    @Column(name = "rf_CallPersonTypeID", nullable = false)
    public int getRfCallPersonTypeId() {
        return rfCallPersonTypeId;
    }

    public void setRfCallPersonTypeId(int rfCallPersonTypeId) {
        this.rfCallPersonTypeId = rfCallPersonTypeId;
    }

    @Basic
    @Column(name = "Age", nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Basic
    @Column(name = "AgeTitle", nullable = false)
    public int getAgeTitle() {
        return ageTitle;
    }

    public void setAgeTitle(int ageTitle) {
        this.ageTitle = ageTitle;
    }

    //NOTE THIS!
    @Temporal(TemporalType.DATE)
    @Column(name = "DateActive", nullable = false)
    public Date getDateActive() {
        return dateActive;
    }

    public void setDateActive(Date dateActive) {
        this.dateActive = dateActive;
    }

    //NOTE THIS!
    @Temporal(TemporalType.DATE)
    @Column(name = "DateResolved", nullable = false)
    public Date getDateResolved() {
        return dateResolved;
    }

    public void setDateResolved(Date dateResolved) {
        this.dateResolved = dateResolved;
    }

    @Basic
    @Column(name = "isChild", nullable = false)
    public boolean isChild() {
        return isChild;
    }

    public void setChild(boolean child) {
        isChild = child;
    }

    @Basic
    @Column(name = "IsNotification", nullable = false)
    public boolean isNotification() {
        return isNotification;
    }

    public void setNotification(boolean notification) {
        isNotification = notification;
    }

    @Basic
    @Column(name = "rf_UchastokID", nullable = false)
    public int getRfUchastokId() {
        return rfUchastokId;
    }

    public void setRfUchastokId(int rfUchastokId) {
        this.rfUchastokId = rfUchastokId;
    }

    @Basic
    @Column(name = "rf_kl_AgeGroupID", nullable = false)
    public int getRfKlAgeGroupId() {
        return rfKlAgeGroupId;
    }

    public void setRfKlAgeGroupId(int rfKlAgeGroupId) {
        this.rfKlAgeGroupId = rfKlAgeGroupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HltCallDoctorEntity that = (HltCallDoctorEntity) o;
        return callDoctorId == that.callDoctorId &&
                xEdition == that.xEdition &&
                xStatus == that.xStatus &&
                rfLpuDoctorId == that.rfLpuDoctorId &&
                rfMkabid == that.rfMkabid &&
                rfCallDoctorStatusId == that.rfCallDoctorStatusId &&
                isFinalize == that.isFinalize &&
                rfTapid == that.rfTapid &&
                rfFinalizeLpuDoctorId == that.rfFinalizeLpuDoctorId &&
                entrance == that.entrance &&
                floor == that.floor &&
                rfAddressId == that.rfAddressId &&
                rfDocPrvdid == that.rfDocPrvdid &&
                rfFinalizeDocPrvdid == that.rfFinalizeDocPrvdid &&
                flags == that.flags &&
                rfLpuid == that.rfLpuid &&
                sourceDvt == that.sourceDvt &&
                rfKlSexId == that.rfKlSexId &&
                rfMkbid == that.rfMkbid &&
                rfCallPersonTypeId == that.rfCallPersonTypeId &&
                age == that.age &&
                ageTitle == that.ageTitle &&
                isChild == that.isChild &&
                isNotification == that.isNotification &&
                rfUchastokId == that.rfUchastokId &&
                rfKlAgeGroupId == that.rfKlAgeGroupId &&
                Objects.equals(address, that.address) &&
                Objects.equals(complaint, that.complaint) &&
                Objects.equals(dateCall, that.dateCall) &&
                Objects.equals(dateFinalize, that.dateFinalize) &&
                Objects.equals(codeDomophon, that.codeDomophon) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(description, that.description) &&
                Objects.equals(dateVisit, that.dateVisit) &&
                Objects.equals(guid, that.guid) &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(family, that.family) &&
                Objects.equals(name, that.name) &&
                Objects.equals(numberPol, that.numberPol) &&
                Objects.equals(ot, that.ot) &&
                Objects.equals(seriesPol, that.seriesPol) &&
                Objects.equals(dateStatus, that.dateStatus) &&
                Objects.equals(causeCancel, that.causeCancel) &&
                Objects.equals(sourceSmp, that.sourceSmp) &&
                Objects.equals(callFamily, that.callFamily) &&
                Objects.equals(callName, that.callName) &&
                Objects.equals(callPatronymic, that.callPatronymic) &&
                Objects.equals(dateActive, that.dateActive) &&
                Objects.equals(dateResolved, that.dateResolved);
    }

    @Override
    public int hashCode() {
        return Objects.hash(callDoctorId, xEdition, xStatus, rfLpuDoctorId, rfMkabid, address, complaint, dateCall, rfCallDoctorStatusId, isFinalize, dateFinalize, rfTapid, codeDomophon, phone, rfFinalizeLpuDoctorId, description, entrance, floor, rfAddressId, rfDocPrvdid, rfFinalizeDocPrvdid, dateVisit, flags, guid, rfLpuid, sourceDvt, birthDate, family, name, numberPol, ot, rfKlSexId, seriesPol, rfMkbid, dateStatus, causeCancel, sourceSmp, callFamily, callName, callPatronymic, rfCallPersonTypeId, age, ageTitle, dateActive, dateResolved, isChild, isNotification, rfUchastokId, rfKlAgeGroupId);
    }
}