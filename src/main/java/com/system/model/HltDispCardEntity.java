package com.system.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "hlt_disp_Card", schema = "dbo", catalog = "test_mo_hlt_Taldom_CRB_20190129")
public class HltDispCardEntity {
    private Timestamp dateAccept;
    private Timestamp dateClose;
    private Timestamp dateOpen;
    private int dispCardId;
    private int dopPriznak;
    private int flags;
    private String guid;
    private boolean isClosed;
    private boolean isOtkaz;
    private String number;
    private String rfDispTypeGuid;
    private String rfMainCardGuid;
    private String rfMkabGuid;
    private int xEdition;
    private byte xStatus;
    private String rfPatientModelGuid;
    private String rfLpuGuid;
    private Timestamp dateStatus;
    private boolean isPay;
    private String uin;
    private String uinState;
    private int rfDocPrvdid;

    @Basic
    @Column(name = "DateAccept", nullable = false)
    public Timestamp getDateAccept() {
        return dateAccept;
    }

    public void setDateAccept(Timestamp dateAccept) {
        this.dateAccept = dateAccept;
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
    @Column(name = "DateOpen", nullable = false)
    public Timestamp getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(Timestamp dateOpen) {
        this.dateOpen = dateOpen;
    }

    @Id
    @Column(name = "disp_CardID", nullable = false)
    public int getDispCardId() {
        return dispCardId;
    }

    public void setDispCardId(int dispCardId) {
        this.dispCardId = dispCardId;
    }

    @Basic
    @Column(name = "DopPriznak", nullable = false)
    public int getDopPriznak() {
        return dopPriznak;
    }

    public void setDopPriznak(int dopPriznak) {
        this.dopPriznak = dopPriznak;
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
    @Column(name = "Guid", nullable = false)
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "Guid")
    private Set<HltDispExamEntity> guids = new LinkedHashSet<>();


    @Basic
    @Column(name = "IsClosed", nullable = false)
    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    @Basic
    @Column(name = "IsOtkaz", nullable = false)
    public boolean isOtkaz() {
        return isOtkaz;
    }

    public void setOtkaz(boolean otkaz) {
        isOtkaz = otkaz;
    }

    @Basic
    @Column(name = "Number", nullable = false, length = 100)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "rf_DispTypeGuid", nullable = false)
    public String getRfDispTypeGuid() {
        return rfDispTypeGuid;
    }

    public void setRfDispTypeGuid(String rfDispTypeGuid) {
        this.rfDispTypeGuid = rfDispTypeGuid;
    }

    @Basic
    @Column(name = "rf_MainCardGuid", nullable = false)
    public String getRfMainCardGuid() {
        return rfMainCardGuid;
    }

    public void setRfMainCardGuid(String rfMainCardGuid) {
        this.rfMainCardGuid = rfMainCardGuid;
    }

    @Basic
    @Column(name = "rf_MkabGuid", nullable = false)
    public String getRfMkabGuid() {
        return rfMkabGuid;
    }

    public void setRfMkabGuid(String rfMkabGuid) {
        this.rfMkabGuid = rfMkabGuid;
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
    @Column(name = "rf_PatientModelGuid", nullable = false)
    public String getRfPatientModelGuid() {
        return rfPatientModelGuid;
    }

    public void setRfPatientModelGuid(String rfPatientModelGuid) {
        this.rfPatientModelGuid = rfPatientModelGuid;
    }

    @Basic
    @Column(name = "rf_LpuGuid", nullable = false)
    public String getRfLpuGuid() {
        return rfLpuGuid;
    }

    public void setRfLpuGuid(String rfLpuGuid) {
        this.rfLpuGuid = rfLpuGuid;
    }

    @Basic
    @Column(name = "DateStatus", nullable = false)
    public Timestamp getDateStatus() {
        return dateStatus;
    }

    public void setDateStatus(Timestamp dateStatus) {
        this.dateStatus = dateStatus;
    }

    @Basic
    @Column(name = "IsPay", nullable = false)
    public boolean isPay() {
        return isPay;
    }

    public void setPay(boolean pay) {
        isPay = pay;
    }

    @Basic
    @Column(name = "Uin", nullable = false, length = 150)
    public String getUin() {
        return uin;
    }

    public void setUin(String uin) {
        this.uin = uin;
    }

    @Basic
    @Column(name = "UinState", nullable = false, length = 150)
    public String getUinState() {
        return uinState;
    }

    public void setUinState(String uinState) {
        this.uinState = uinState;
    }

    @Basic
    @Column(name = "rf_DocPRVDID", nullable = false)
    public int getRfDocPrvdid() {
        return rfDocPrvdid;
    }

    public void setRfDocPrvdid(int rfDocPrvdid) {
        this.rfDocPrvdid = rfDocPrvdid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HltDispCardEntity that = (HltDispCardEntity) o;
        return dispCardId == that.dispCardId &&
                dopPriznak == that.dopPriznak &&
                flags == that.flags &&
                isClosed == that.isClosed &&
                isOtkaz == that.isOtkaz &&
                xEdition == that.xEdition &&
                xStatus == that.xStatus &&
                isPay == that.isPay &&
                rfDocPrvdid == that.rfDocPrvdid &&
                Objects.equals(dateAccept, that.dateAccept) &&
                Objects.equals(dateClose, that.dateClose) &&
                Objects.equals(dateOpen, that.dateOpen) &&
                Objects.equals(guid, that.guid) &&
                Objects.equals(number, that.number) &&
                Objects.equals(rfDispTypeGuid, that.rfDispTypeGuid) &&
                Objects.equals(rfMainCardGuid, that.rfMainCardGuid) &&
                Objects.equals(rfMkabGuid, that.rfMkabGuid) &&
                Objects.equals(rfPatientModelGuid, that.rfPatientModelGuid) &&
                Objects.equals(rfLpuGuid, that.rfLpuGuid) &&
                Objects.equals(dateStatus, that.dateStatus) &&
                Objects.equals(uin, that.uin) &&
                Objects.equals(uinState, that.uinState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateAccept, dateClose, dateOpen, dispCardId, dopPriznak, flags, guid, isClosed, isOtkaz, number, rfDispTypeGuid, rfMainCardGuid, rfMkabGuid, xEdition, xStatus, rfPatientModelGuid, rfLpuGuid, dateStatus, isPay, uin, uinState, rfDocPrvdid);
    }
}
