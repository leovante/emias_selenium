package com.system.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "hlt_LPUDoctor", schema = "dbo", catalog = "test_mo_hlt_Taldom_CRB_20190129")
public class HltLpuDoctorEntity {
    private int lpuDoctorId;
    private int xEdition;
    private byte xStatus;
    private String pcod;
    private String otV;
    private String imV;
    private Timestamp dSer;
    private int rfPrvsid;
    private String famV;
    private int rfKvKatid;
    private String msgText;
    private int rfLpuid;
    private boolean isDoctor;
    private int rfHealingRoomId;
    private short inTime;
    private Timestamp dr;
    private boolean isSpecial;
    private int rfPrvdid;
    private UUID uguid;
    private String ss;
    private int rfDepartmentId;
    private Timestamp deSer;
    private String phone;

    @Id
    @Column(name = "LPUDoctorID", nullable = false)
    public int getLpuDoctorId() {
        return lpuDoctorId;
    }

    public void setLpuDoctorId(int lpuDoctorId) {
        this.lpuDoctorId = lpuDoctorId;
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
    @Column(name = "PCOD", nullable = false, length = 20)
    public String getPcod() {
        return pcod;
    }

    public void setPcod(String pcod) {
        this.pcod = pcod;
    }

    @Basic
    @Column(name = "OT_V", nullable = false, length = 20)
    public String getOtV() {
        return otV;
    }

    public void setOtV(String otV) {
        this.otV = otV;
    }

    @Basic
    @Column(name = "IM_V", nullable = false, length = 20)
    public String getImV() {
        return imV;
    }

    public void setImV(String imV) {
        this.imV = imV;
    }

    @Basic
    @Column(name = "D_SER", nullable = false)
    public Timestamp getdSer() {
        return dSer;
    }

    public void setdSer(Timestamp dSer) {
        this.dSer = dSer;
    }

    @Basic
    @Column(name = "rf_PRVSID", nullable = false)
    public int getRfPrvsid() {
        return rfPrvsid;
    }

    public void setRfPrvsid(int rfPrvsid) {
        this.rfPrvsid = rfPrvsid;
    }

    @Basic
    @Column(name = "FAM_V", nullable = false, length = 30)
    public String getFamV() {
        return famV;
    }

    public void setFamV(String famV) {
        this.famV = famV;
    }

    @Basic
    @Column(name = "rf_KV_KATID", nullable = false)
    public int getRfKvKatid() {
        return rfKvKatid;
    }

    public void setRfKvKatid(int rfKvKatid) {
        this.rfKvKatid = rfKvKatid;
    }

    @Basic
    @Column(name = "MSG_Text", nullable = false, length = 100)
    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
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
    @Column(name = "isDoctor", nullable = false)
    public boolean isDoctor() {
        return isDoctor;
    }

    public void setDoctor(boolean doctor) {
        isDoctor = doctor;
    }

    @Basic
    @Column(name = "rf_HealingRoomID", nullable = false)
    public int getRfHealingRoomId() {
        return rfHealingRoomId;
    }

    public void setRfHealingRoomId(int rfHealingRoomId) {
        this.rfHealingRoomId = rfHealingRoomId;
    }

    @Basic
    @Column(name = "inTime", nullable = false)
    public short getInTime() {
        return inTime;
    }

    public void setInTime(short inTime) {
        this.inTime = inTime;
    }

    @Basic
    @Column(name = "DR", nullable = false)
    public Timestamp getDr() {
        return dr;
    }

    public void setDr(Timestamp dr) {
        this.dr = dr;
    }

    @Basic
    @Column(name = "IsSpecial", nullable = false)
    public boolean isSpecial() {
        return isSpecial;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }

    @Basic
    @Column(name = "rf_PRVDID", nullable = false)
    public int getRfPrvdid() {
        return rfPrvdid;
    }

    public void setRfPrvdid(int rfPrvdid) {
        this.rfPrvdid = rfPrvdid;
    }

    @Basic
    @Column(name = "UGUID", nullable = false)
    public UUID getUguid() {
        return uguid;
    }

    public void setUguid(UUID uguid) {
        this.uguid = uguid;
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
    @Column(name = "rf_DepartmentID", nullable = false)
    public int getRfDepartmentId() {
        return rfDepartmentId;
    }

    public void setRfDepartmentId(int rfDepartmentId) {
        this.rfDepartmentId = rfDepartmentId;
    }

    @Basic
    @Column(name = "DE_SER", nullable = false)
    public Timestamp getDeSer() {
        return deSer;
    }

    public void setDeSer(Timestamp deSer) {
        this.deSer = deSer;
    }

    @Basic
    @Column(name = "Phone", nullable = false, length = 25)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HltLpuDoctorEntity that = (HltLpuDoctorEntity) o;
        return lpuDoctorId == that.lpuDoctorId &&
                xEdition == that.xEdition &&
                xStatus == that.xStatus &&
                rfPrvsid == that.rfPrvsid &&
                rfKvKatid == that.rfKvKatid &&
                rfLpuid == that.rfLpuid &&
                isDoctor == that.isDoctor &&
                rfHealingRoomId == that.rfHealingRoomId &&
                inTime == that.inTime &&
                isSpecial == that.isSpecial &&
                rfPrvdid == that.rfPrvdid &&
                rfDepartmentId == that.rfDepartmentId &&
                Objects.equals(pcod, that.pcod) &&
                Objects.equals(otV, that.otV) &&
                Objects.equals(imV, that.imV) &&
                Objects.equals(dSer, that.dSer) &&
                Objects.equals(famV, that.famV) &&
                Objects.equals(msgText, that.msgText) &&
                Objects.equals(dr, that.dr) &&
                Objects.equals(uguid, that.uguid) &&
                Objects.equals(ss, that.ss) &&
                Objects.equals(deSer, that.deSer) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lpuDoctorId, xEdition, xStatus, pcod, otV, imV, dSer, rfPrvsid, famV, rfKvKatid, msgText, rfLpuid, isDoctor, rfHealingRoomId, inTime, dr, isSpecial, rfPrvdid, uguid, ss, rfDepartmentId, deSer, phone);
    }
}
