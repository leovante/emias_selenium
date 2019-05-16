package com.system.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "hlt_MKAB", schema = "dbo", catalog = "test_mo_hlt_Taldom_CRB_20190129")
public class HltMkabEntity {
    private int mkabid;
    private int xEdition;
    private byte xStatus;
    private String family;
    private String name;
    private String ot;
    private String ss;
    private String dType;
    private String num;
    private int w;
    private Timestamp dateBd;
    private String adres;
    private int rfInvid;
    private int rfSmoid;
    private String phoneWork;
    private String phoneHome;
    private String work;
    private String profession;
    private String post;
    private boolean dependent;
    private int rfLpuid;
    private boolean kindCod;
    private boolean rh;
    private String codPerson;
    private String militaryCod;
    private int rfUchastokId;
    private int rfCitizenId;
    private int rfTypedocid;
    private String sPol;
    private String nPol;
    private String uguid;
    private int rfOtherSmoid;
    private String sDoc;
    private String nDoc;
    private boolean isWorker;
    private int rfMkabLocationId;
    private int rfSpecEventCertId;
    private String adresFact;
    private Timestamp datePolBegin;
    private Timestamp datePolEnd;
    private int rfEnterpriseId;
    private int blackLabel;
    private int rfOkatoid;
    private int flags;
    private int isClosed;
    private int rfReasonCloseMkabid;
    private Timestamp dateClose;
    private int rfKlPrivilegeCategoryId;
    private int rfOmsOkvedid;
    private int rfKlSocStatusId;
    private int rfKlSexId;
    private int rfKlHealthGroupId;
    private int rfAddressLiveId;
    private int rfAddressRegId;

//    @ManyToOne
//    @JoinColumn(name = "AddressID", nullable = false)
//    private KlaAddressEntity klaAddressEntity;

//    @Basic
//    @Column(name = "rf_AddressRegID", nullable = false)
//    public int getRfAddressRegId() {
//        return rfAddressRegId;
//    }
//
//    public void setRfAddressRegId(int rfAddressRegId) {
//        this.rfAddressRegId = rfAddressRegId;
//    }

    private boolean confirmAgree;
    private Timestamp confirmDate;
    private String confirmUserFio;
    private boolean contactConfirm;
    private String contactEmail;
    private String contactMPhone;
    private String createUserName;
    private String editUserName;
    private String hash0;
    private String hash1;
    private String hash2;
    private String hash3;
    private String hash4;
    private boolean isEncrypted;
    private int mainContact;
    private int messageFlag;
    private int rfConfirmUserId;
    private int rfCreateUserId;
    private int rfEditUserId;
    private int rfKlTipOmsid;
    private String ridn;
    private String mkabInfo;
    private String birthplace;
    private String mainMkabGuid;
    private Timestamp dateDoc;
    private Timestamp dateMkab;
    private boolean isLsHome;
    private String docIssuedBy;
    private int rfKlEducationTypeId;
    private int rfKlMaterialStatusId;
    private String blackLabelComment;
    private boolean isAuto;
    private boolean isExistIpra;
    private int rfOksmid;
    private Timestamp identificationDate;
    private int rfIdentificationStatusId;

    @Id
    @Column(name = "MKABID", nullable = false)
    public int getMkabid() {
        return mkabid;
    }

    public void setMkabid(int mkabid) {
        this.mkabid = mkabid;
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
    public byte getxStatus() {
        return xStatus;
    }

    public void setxStatus(byte xStatus) {
        this.xStatus = xStatus;
    }

    @Basic
    @Column(name = "FAMILY", nullable = false, length = 40)
    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 40)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "OT", nullable = false, length = 40)
    public String getOt() {
        return ot;
    }

    public void setOt(String ot) {
        this.ot = ot;
    }

    @Basic
    @Column(name = "SS", nullable = false, length = 14)
    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    @Basic
    @Column(name = "D_TYPE", nullable = false, length = 3)
    public String getdType() {
        return dType;
    }

    public void setdType(String dType) {
        this.dType = dType;
    }

    @Basic
    @Column(name = "NUM", nullable = false, length = 40)
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Basic
    @Column(name = "W", nullable = false)
    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    @Basic
    @Column(name = "DATE_BD", nullable = false)
    public Timestamp getDateBd() {
        return dateBd;
    }

    public void setDateBd(Timestamp dateBd) {
        this.dateBd = dateBd;
    }

    @Basic
    @Column(name = "ADRES", nullable = false, length = 200)
    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Basic
    @Column(name = "rf_INVID", nullable = false)
    public int getRfInvid() {
        return rfInvid;
    }

    public void setRfInvid(int rfInvid) {
        this.rfInvid = rfInvid;
    }

    @Basic
    @Column(name = "rf_SMOID", nullable = false)
    public int getRfSmoid() {
        return rfSmoid;
    }

    public void setRfSmoid(int rfSmoid) {
        this.rfSmoid = rfSmoid;
    }

    @Basic
    @Column(name = "PhoneWork", nullable = false, length = 20)
    public String getPhoneWork() {
        return phoneWork;
    }

    public void setPhoneWork(String phoneWork) {
        this.phoneWork = phoneWork;
    }

    @Basic
    @Column(name = "PhoneHome", nullable = false, length = 20)
    public String getPhoneHome() {
        return phoneHome;
    }

    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }

    @Basic
    @Column(name = "Work", nullable = false, length = 200)
    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Basic
    @Column(name = "Profession", nullable = false, length = 50)
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Basic
    @Column(name = "Post", nullable = false, length = 50)
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Basic
    @Column(name = "Dependent", nullable = false)
    public boolean isDependent() {
        return dependent;
    }

    public void setDependent(boolean dependent) {
        this.dependent = dependent;
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
    @Column(name = "KindCod", nullable = false)
    public boolean isKindCod() {
        return kindCod;
    }

    public void setKindCod(boolean kindCod) {
        this.kindCod = kindCod;
    }

    @Basic
    @Column(name = "RH", nullable = false)
    public boolean isRh() {
        return rh;
    }

    public void setRh(boolean rh) {
        this.rh = rh;
    }

    @Basic
    @Column(name = "COD_Person", nullable = false, length = 20)
    public String getCodPerson() {
        return codPerson;
    }

    public void setCodPerson(String codPerson) {
        this.codPerson = codPerson;
    }

    @Basic
    @Column(name = "MilitaryCOD", nullable = false, length = 3)
    public String getMilitaryCod() {
        return militaryCod;
    }

    public void setMilitaryCod(String militaryCod) {
        this.militaryCod = militaryCod;
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
    @Column(name = "rf_CitizenID", nullable = false)
    public int getRfCitizenId() {
        return rfCitizenId;
    }

    public void setRfCitizenId(int rfCitizenId) {
        this.rfCitizenId = rfCitizenId;
    }

    @Basic
    @Column(name = "rf_TYPEDOCID", nullable = false)
    public int getRfTypedocid() {
        return rfTypedocid;
    }

    public void setRfTypedocid(int rfTypedocid) {
        this.rfTypedocid = rfTypedocid;
    }

    @Basic
    @Column(name = "S_POL", nullable = false, length = 50)
    public String getsPol() {
        return sPol;
    }

    public void setsPol(String sPol) {
        this.sPol = sPol;
    }

    @Basic
    @Column(name = "N_POL", nullable = false, length = 50)
    public String getnPol() {
        return nPol;
    }

    public void setnPol(String nPol) {
        this.nPol = nPol;
    }

    @Basic
    @Column(name = "UGUID", nullable = false)
    public String getUguid() {
        return uguid;
    }

    public void setUguid(String uguid) {
        this.uguid = uguid;
    }

    @Basic
    @Column(name = "rf_OtherSMOID", nullable = false)
    public int getRfOtherSmoid() {
        return rfOtherSmoid;
    }

    public void setRfOtherSmoid(int rfOtherSmoid) {
        this.rfOtherSmoid = rfOtherSmoid;
    }

    @Basic
    @Column(name = "S_DOC", nullable = false, length = 10)
    public String getsDoc() {
        return sDoc;
    }

    public void setsDoc(String sDoc) {
        this.sDoc = sDoc;
    }

    @Basic
    @Column(name = "N_DOC", nullable = false, length = 15)
    public String getnDoc() {
        return nDoc;
    }

    public void setnDoc(String nDoc) {
        this.nDoc = nDoc;
    }

    @Basic
    @Column(name = "IsWorker", nullable = false)
    public boolean isWorker() {
        return isWorker;
    }

    public void setWorker(boolean worker) {
        isWorker = worker;
    }

    @Basic
    @Column(name = "rf_MKABLocationID", nullable = false)
    public int getRfMkabLocationId() {
        return rfMkabLocationId;
    }

    public void setRfMkabLocationId(int rfMkabLocationId) {
        this.rfMkabLocationId = rfMkabLocationId;
    }

    @Basic
    @Column(name = "rf_SpecEventCertID", nullable = false)
    public int getRfSpecEventCertId() {
        return rfSpecEventCertId;
    }

    public void setRfSpecEventCertId(int rfSpecEventCertId) {
        this.rfSpecEventCertId = rfSpecEventCertId;
    }

    @Basic
    @Column(name = "AdresFact", nullable = false, length = 200)
    public String getAdresFact() {
        return adresFact;
    }

    public void setAdresFact(String adresFact) {
        this.adresFact = adresFact;
    }

    @Basic
    @Column(name = "DatePolBegin", nullable = false)
    public Timestamp getDatePolBegin() {
        return datePolBegin;
    }

    public void setDatePolBegin(Timestamp datePolBegin) {
        this.datePolBegin = datePolBegin;
    }

    @Basic
    @Column(name = "DatePolEnd", nullable = false)
    public Timestamp getDatePolEnd() {
        return datePolEnd;
    }

    public void setDatePolEnd(Timestamp datePolEnd) {
        this.datePolEnd = datePolEnd;
    }

    @Basic
    @Column(name = "rf_EnterpriseID", nullable = false)
    public int getRfEnterpriseId() {
        return rfEnterpriseId;
    }

    public void setRfEnterpriseId(int rfEnterpriseId) {
        this.rfEnterpriseId = rfEnterpriseId;
    }

    @Basic
    @Column(name = "BlackLabel", nullable = false)
    public int getBlackLabel() {
        return blackLabel;
    }

    public void setBlackLabel(int blackLabel) {
        this.blackLabel = blackLabel;
    }

    @Basic
    @Column(name = "rf_OKATOID", nullable = false)
    public int getRfOkatoid() {
        return rfOkatoid;
    }

    public void setRfOkatoid(int rfOkatoid) {
        this.rfOkatoid = rfOkatoid;
    }

    @Basic
    @Column(name = "FLAGS", nullable = false)
    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    @Basic
    @Column(name = "isClosed", nullable = false)
    public int getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(int isClosed) {
        this.isClosed = isClosed;
    }

    @Basic
    @Column(name = "rf_ReasonCloseMKABID", nullable = false)
    public int getRfReasonCloseMkabid() {
        return rfReasonCloseMkabid;
    }

    public void setRfReasonCloseMkabid(int rfReasonCloseMkabid) {
        this.rfReasonCloseMkabid = rfReasonCloseMkabid;
    }

    @Basic
    @Column(name = "DateClose", nullable = false)
    public Timestamp getDateClose() {
        return dateClose;
    }

    public void setDateClose(Timestamp dateClose) {
        this.dateClose = dateClose;
    }

    @Basic
    @Column(name = "rf_kl_PrivilegeCategoryID", nullable = false)
    public int getRfKlPrivilegeCategoryId() {
        return rfKlPrivilegeCategoryId;
    }

    public void setRfKlPrivilegeCategoryId(int rfKlPrivilegeCategoryId) {
        this.rfKlPrivilegeCategoryId = rfKlPrivilegeCategoryId;
    }

    @Basic
    @Column(name = "rf_omsOKVEDID", nullable = false)
    public int getRfOmsOkvedid() {
        return rfOmsOkvedid;
    }

    public void setRfOmsOkvedid(int rfOmsOkvedid) {
        this.rfOmsOkvedid = rfOmsOkvedid;
    }

    @Basic
    @Column(name = "rf_kl_SocStatusID", nullable = false)
    public int getRfKlSocStatusId() {
        return rfKlSocStatusId;
    }

    public void setRfKlSocStatusId(int rfKlSocStatusId) {
        this.rfKlSocStatusId = rfKlSocStatusId;
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
    @Column(name = "rf_kl_HealthGroupID", nullable = false)
    public int getRfKlHealthGroupId() {
        return rfKlHealthGroupId;
    }

    public void setRfKlHealthGroupId(int rfKlHealthGroupId) {
        this.rfKlHealthGroupId = rfKlHealthGroupId;
    }

    @Basic
    @Column(name = "rf_AddressLiveID", nullable = false)
    public int getRfAddressLiveId() {
        return rfAddressLiveId;
    }

    public void setRfAddressLiveId(int rfAddressLiveId) {
        this.rfAddressLiveId = rfAddressLiveId;
    }


    @Basic
    @Column(name = "ConfirmAgree", nullable = false)
    public boolean isConfirmAgree() {
        return confirmAgree;
    }

    public void setConfirmAgree(boolean confirmAgree) {
        this.confirmAgree = confirmAgree;
    }

    @Basic
    @Column(name = "ConfirmDate", nullable = false)
    public Timestamp getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Timestamp confirmDate) {
        this.confirmDate = confirmDate;
    }

    @Basic
    @Column(name = "ConfirmUserFIO", nullable = false, length = 50)
    public String getConfirmUserFio() {
        return confirmUserFio;
    }

    public void setConfirmUserFio(String confirmUserFio) {
        this.confirmUserFio = confirmUserFio;
    }

    @Basic
    @Column(name = "contactConfirm", nullable = false)
    public boolean isContactConfirm() {
        return contactConfirm;
    }

    public void setContactConfirm(boolean contactConfirm) {
        this.contactConfirm = contactConfirm;
    }

    @Basic
    @Column(name = "contactEmail", nullable = false, length = 100)
    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @Basic
    @Column(name = "contactMPhone", nullable = false, length = 25)
    public String getContactMPhone() {
        return contactMPhone;
    }

    public void setContactMPhone(String contactMPhone) {
        this.contactMPhone = contactMPhone;
    }

    @Basic
    @Column(name = "CreateUserName", nullable = false, length = 255)
    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    @Basic
    @Column(name = "EditUserName", nullable = false, length = 255)
    public String getEditUserName() {
        return editUserName;
    }

    public void setEditUserName(String editUserName) {
        this.editUserName = editUserName;
    }

    @Basic
    @Column(name = "Hash0", nullable = false, length = 65)
    public String getHash0() {
        return hash0;
    }

    public void setHash0(String hash0) {
        this.hash0 = hash0;
    }

    @Basic
    @Column(name = "Hash1", nullable = false, length = 65)
    public String getHash1() {
        return hash1;
    }

    public void setHash1(String hash1) {
        this.hash1 = hash1;
    }

    @Basic
    @Column(name = "Hash2", nullable = false, length = 65)
    public String getHash2() {
        return hash2;
    }

    public void setHash2(String hash2) {
        this.hash2 = hash2;
    }

    @Basic
    @Column(name = "Hash3", nullable = false, length = 65)
    public String getHash3() {
        return hash3;
    }

    public void setHash3(String hash3) {
        this.hash3 = hash3;
    }

    @Basic
    @Column(name = "Hash4", nullable = false, length = 65)
    public String getHash4() {
        return hash4;
    }

    public void setHash4(String hash4) {
        this.hash4 = hash4;
    }

    @Basic
    @Column(name = "isEncrypted", nullable = false)
    public boolean isEncrypted() {
        return isEncrypted;
    }

    public void setEncrypted(boolean encrypted) {
        isEncrypted = encrypted;
    }

    @Basic
    @Column(name = "mainContact", nullable = false)
    public int getMainContact() {
        return mainContact;
    }

    public void setMainContact(int mainContact) {
        this.mainContact = mainContact;
    }

    @Basic
    @Column(name = "MessageFLAG", nullable = false)
    public int getMessageFlag() {
        return messageFlag;
    }

    public void setMessageFlag(int messageFlag) {
        this.messageFlag = messageFlag;
    }

    @Basic
    @Column(name = "rf_ConfirmUserID", nullable = false)
    public int getRfConfirmUserId() {
        return rfConfirmUserId;
    }

    public void setRfConfirmUserId(int rfConfirmUserId) {
        this.rfConfirmUserId = rfConfirmUserId;
    }

    @Basic
    @Column(name = "rf_CreateUserID", nullable = false)
    public int getRfCreateUserId() {
        return rfCreateUserId;
    }

    public void setRfCreateUserId(int rfCreateUserId) {
        this.rfCreateUserId = rfCreateUserId;
    }

    @Basic
    @Column(name = "rf_EditUserID", nullable = false)
    public int getRfEditUserId() {
        return rfEditUserId;
    }

    public void setRfEditUserId(int rfEditUserId) {
        this.rfEditUserId = rfEditUserId;
    }

    @Basic
    @Column(name = "rf_kl_TipOMSID", nullable = false)
    public int getRfKlTipOmsid() {
        return rfKlTipOmsid;
    }

    public void setRfKlTipOmsid(int rfKlTipOmsid) {
        this.rfKlTipOmsid = rfKlTipOmsid;
    }

    @Basic
    @Column(name = "RIDN", nullable = false, length = 10)
    public String getRidn() {
        return ridn;
    }

    public void setRidn(String ridn) {
        this.ridn = ridn;
    }

    @Basic
    @Column(name = "MKABInfo", nullable = false)
    public String getMkabInfo() {
        return mkabInfo;
    }

    public void setMkabInfo(String mkabInfo) {
        this.mkabInfo = mkabInfo;
    }

    @Basic
    @Column(name = "Birthplace", nullable = false, length = 200)
    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    @Basic
    @Column(name = "MainMKABGuid", nullable = false)
    public String getMainMkabGuid() {
        return mainMkabGuid;
    }

    public void setMainMkabGuid(String mainMkabGuid) {
        this.mainMkabGuid = mainMkabGuid;
    }

    @Basic
    @Column(name = "DateDoc", nullable = false)
    public Timestamp getDateDoc() {
        return dateDoc;
    }

    public void setDateDoc(Timestamp dateDoc) {
        this.dateDoc = dateDoc;
    }

    @Basic
    @Column(name = "DateMKAB", nullable = false)
    public Timestamp getDateMkab() {
        return dateMkab;
    }

    public void setDateMkab(Timestamp dateMkab) {
        this.dateMkab = dateMkab;
    }

    @Basic
    @Column(name = "isLSHome", nullable = false)
    public boolean isLsHome() {
        return isLsHome;
    }

    public void setLsHome(boolean lsHome) {
        isLsHome = lsHome;
    }

    @Basic
    @Column(name = "DocIssuedBy", nullable = false, length = 255)
    public String getDocIssuedBy() {
        return docIssuedBy;
    }

    public void setDocIssuedBy(String docIssuedBy) {
        this.docIssuedBy = docIssuedBy;
    }

    @Basic
    @Column(name = "rf_kl_EducationTypeID", nullable = false)
    public int getRfKlEducationTypeId() {
        return rfKlEducationTypeId;
    }

    public void setRfKlEducationTypeId(int rfKlEducationTypeId) {
        this.rfKlEducationTypeId = rfKlEducationTypeId;
    }

    @Basic
    @Column(name = "rf_kl_MaterialStatusID", nullable = false)
    public int getRfKlMaterialStatusId() {
        return rfKlMaterialStatusId;
    }

    public void setRfKlMaterialStatusId(int rfKlMaterialStatusId) {
        this.rfKlMaterialStatusId = rfKlMaterialStatusId;
    }

    @Basic
    @Column(name = "BlackLabelComment", nullable = false, length = 255)
    public String getBlackLabelComment() {
        return blackLabelComment;
    }

    public void setBlackLabelComment(String blackLabelComment) {
        this.blackLabelComment = blackLabelComment;
    }

    @Basic
    @Column(name = "isAuto", nullable = false)
    public boolean isAuto() {
        return isAuto;
    }

    public void setAuto(boolean auto) {
        isAuto = auto;
    }

    @Basic
    @Column(name = "isExistIPRA", nullable = false)
    public boolean isExistIpra() {
        return isExistIpra;
    }

    public void setExistIpra(boolean existIpra) {
        isExistIpra = existIpra;
    }

    @Basic
    @Column(name = "rf_OKSMID", nullable = false)
    public int getRfOksmid() {
        return rfOksmid;
    }

    public void setRfOksmid(int rfOksmid) {
        this.rfOksmid = rfOksmid;
    }

    @Basic
    @Column(name = "IdentificationDate", nullable = false)
    public Timestamp getIdentificationDate() {
        return identificationDate;
    }

    public void setIdentificationDate(Timestamp identificationDate) {
        this.identificationDate = identificationDate;
    }

    @Basic
    @Column(name = "rf_IdentificationStatusID", nullable = false)
    public int getRfIdentificationStatusId() {
        return rfIdentificationStatusId;
    }

    public void setRfIdentificationStatusId(int rfIdentificationStatusId) {
        this.rfIdentificationStatusId = rfIdentificationStatusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HltMkabEntity that = (HltMkabEntity) o;
        return mkabid == that.mkabid &&
                xEdition == that.xEdition &&
                xStatus == that.xStatus &&
                w == that.w &&
                rfInvid == that.rfInvid &&
                rfSmoid == that.rfSmoid &&
                dependent == that.dependent &&
                rfLpuid == that.rfLpuid &&
                kindCod == that.kindCod &&
                rh == that.rh &&
                rfUchastokId == that.rfUchastokId &&
                rfCitizenId == that.rfCitizenId &&
                rfTypedocid == that.rfTypedocid &&
                rfOtherSmoid == that.rfOtherSmoid &&
                isWorker == that.isWorker &&
                rfMkabLocationId == that.rfMkabLocationId &&
                rfSpecEventCertId == that.rfSpecEventCertId &&
                rfEnterpriseId == that.rfEnterpriseId &&
                blackLabel == that.blackLabel &&
                rfOkatoid == that.rfOkatoid &&
                flags == that.flags &&
                isClosed == that.isClosed &&
                rfReasonCloseMkabid == that.rfReasonCloseMkabid &&
                rfKlPrivilegeCategoryId == that.rfKlPrivilegeCategoryId &&
                rfOmsOkvedid == that.rfOmsOkvedid &&
                rfKlSocStatusId == that.rfKlSocStatusId &&
                rfKlSexId == that.rfKlSexId &&
                rfKlHealthGroupId == that.rfKlHealthGroupId &&
                rfAddressLiveId == that.rfAddressLiveId &&
                rfAddressRegId == that.rfAddressRegId &&
                confirmAgree == that.confirmAgree &&
                contactConfirm == that.contactConfirm &&
                isEncrypted == that.isEncrypted &&
                mainContact == that.mainContact &&
                messageFlag == that.messageFlag &&
                rfConfirmUserId == that.rfConfirmUserId &&
                rfCreateUserId == that.rfCreateUserId &&
                rfEditUserId == that.rfEditUserId &&
                rfKlTipOmsid == that.rfKlTipOmsid &&
                isLsHome == that.isLsHome &&
                rfKlEducationTypeId == that.rfKlEducationTypeId &&
                rfKlMaterialStatusId == that.rfKlMaterialStatusId &&
                isAuto == that.isAuto &&
                isExistIpra == that.isExistIpra &&
                rfOksmid == that.rfOksmid &&
                rfIdentificationStatusId == that.rfIdentificationStatusId &&
                Objects.equals(family, that.family) &&
                Objects.equals(name, that.name) &&
                Objects.equals(ot, that.ot) &&
                Objects.equals(ss, that.ss) &&
                Objects.equals(dType, that.dType) &&
                Objects.equals(num, that.num) &&
                Objects.equals(dateBd, that.dateBd) &&
                Objects.equals(adres, that.adres) &&
                Objects.equals(phoneWork, that.phoneWork) &&
                Objects.equals(phoneHome, that.phoneHome) &&
                Objects.equals(work, that.work) &&
                Objects.equals(profession, that.profession) &&
                Objects.equals(post, that.post) &&
                Objects.equals(codPerson, that.codPerson) &&
                Objects.equals(militaryCod, that.militaryCod) &&
                Objects.equals(sPol, that.sPol) &&
                Objects.equals(nPol, that.nPol) &&
                Objects.equals(uguid, that.uguid) &&
                Objects.equals(sDoc, that.sDoc) &&
                Objects.equals(nDoc, that.nDoc) &&
                Objects.equals(adresFact, that.adresFact) &&
                Objects.equals(datePolBegin, that.datePolBegin) &&
                Objects.equals(datePolEnd, that.datePolEnd) &&
                Objects.equals(dateClose, that.dateClose) &&
                Objects.equals(confirmDate, that.confirmDate) &&
                Objects.equals(confirmUserFio, that.confirmUserFio) &&
                Objects.equals(contactEmail, that.contactEmail) &&
                Objects.equals(contactMPhone, that.contactMPhone) &&
                Objects.equals(createUserName, that.createUserName) &&
                Objects.equals(editUserName, that.editUserName) &&
                Objects.equals(hash0, that.hash0) &&
                Objects.equals(hash1, that.hash1) &&
                Objects.equals(hash2, that.hash2) &&
                Objects.equals(hash3, that.hash3) &&
                Objects.equals(hash4, that.hash4) &&
                Objects.equals(ridn, that.ridn) &&
                Objects.equals(mkabInfo, that.mkabInfo) &&
                Objects.equals(birthplace, that.birthplace) &&
                Objects.equals(mainMkabGuid, that.mainMkabGuid) &&
                Objects.equals(dateDoc, that.dateDoc) &&
                Objects.equals(dateMkab, that.dateMkab) &&
                Objects.equals(docIssuedBy, that.docIssuedBy) &&
                Objects.equals(blackLabelComment, that.blackLabelComment) &&
                Objects.equals(identificationDate, that.identificationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mkabid, xEdition, xStatus, family, name, ot, ss, dType, num, w, dateBd, adres, rfInvid, rfSmoid, phoneWork, phoneHome, work, profession, post, dependent, rfLpuid, kindCod, rh, codPerson, militaryCod, rfUchastokId, rfCitizenId, rfTypedocid, sPol, nPol, uguid, rfOtherSmoid, sDoc, nDoc, isWorker, rfMkabLocationId, rfSpecEventCertId, adresFact, datePolBegin, datePolEnd, rfEnterpriseId, blackLabel, rfOkatoid, flags, isClosed, rfReasonCloseMkabid, dateClose, rfKlPrivilegeCategoryId, rfOmsOkvedid, rfKlSocStatusId, rfKlSexId, rfKlHealthGroupId, rfAddressLiveId, rfAddressRegId, confirmAgree, confirmDate, confirmUserFio, contactConfirm, contactEmail, contactMPhone, createUserName, editUserName, hash0, hash1, hash2, hash3, hash4, isEncrypted, mainContact, messageFlag, rfConfirmUserId, rfCreateUserId, rfEditUserId, rfKlTipOmsid, ridn, mkabInfo, birthplace, mainMkabGuid, dateDoc, dateMkab, isLsHome, docIssuedBy, rfKlEducationTypeId, rfKlMaterialStatusId, blackLabelComment, isAuto, isExistIpra, rfOksmid, identificationDate, rfIdentificationStatusId);
    }

    private KlaAddressEntity rf_AddressRegID;

    @ManyToOne
    @JoinColumn(name = "rf_AddressRegID", referencedColumnName = "addressId", nullable = false)
    public KlaAddressEntity getRf_AddressRegID() {
        return rf_AddressRegID;
    }

    public void setRf_AddressRegID(KlaAddressEntity rf_AddressRegID) {
        this.rf_AddressRegID = rf_AddressRegID;
    }
}