package com.system.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "hlt_DoctorTimeTable", schema = "dbo", catalog = "hlt_demonstration")
public class HltDoctorTimeTableEntity {
    private int doctorTimeTableId;
    private int xEdition;
    private byte xStatus;
    private Date beginTime;
    private Date endTime;
    private Date date;
    private int rfLpuDoctorId;
    private int rfDocBusyType;
    private int flagAccess;
    private int flags;
    private String uguid;
    private int lastStubNum;
    private int planUe;
    private int rfDocPrvdid;
    private int rfHealingRoomId;
    private int ttSource;
    private int usedUe;
    private boolean isKatlVisit;

    @Id
    @Column(name = "DoctorTimeTableID", nullable = false)
    public int getDoctorTimeTableId() {
        return doctorTimeTableId;
    }

    public void setDoctorTimeTableId(int doctorTimeTableId) {
        this.doctorTimeTableId = doctorTimeTableId;
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

    @Temporal(TemporalType.DATE)
    @Column(name = "Begin_Time", nullable = false)
    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "End_Time", nullable = false)
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "Date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
    @Column(name = "rf_DocBusyType", nullable = false)
    public int getRfDocBusyType() {
        return rfDocBusyType;
    }

    public void setRfDocBusyType(int rfDocBusyType) {
        this.rfDocBusyType = rfDocBusyType;
    }

    @Basic
    @Column(name = "FlagAccess", nullable = false)
    public int getFlagAccess() {
        return flagAccess;
    }

    public void setFlagAccess(int flagAccess) {
        this.flagAccess = flagAccess;
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
    @GenericGenerator(name = "generator", strategy = "uuid2")
    @GeneratedValue(generator = "generator")
    @Column(name = "UGUID", nullable = false, columnDefinition = "uniqueidentifier")
    public String getUguid() {
        return uguid;
    }

    public void setUguid(String uguid) {
        this.uguid = uguid;
    }

    @Basic
    @Column(name = "LastStubNum", nullable = false)
    public int getLastStubNum() {
        return lastStubNum;
    }

    public void setLastStubNum(int lastStubNum) {
        this.lastStubNum = lastStubNum;
    }

    @Basic
    @Column(name = "PlanUE", nullable = false)
    public int getPlanUe() {
        return planUe;
    }

    public void setPlanUe(int planUe) {
        this.planUe = planUe;
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
    @Column(name = "rf_HealingRoomID", nullable = false)
    public int getRfHealingRoomId() {
        return rfHealingRoomId;
    }

    public void setRfHealingRoomId(int rfHealingRoomId) {
        this.rfHealingRoomId = rfHealingRoomId;
    }

    @Basic
    @Column(name = "TTSource", nullable = false)
    public int getTtSource() {
        return ttSource;
    }

    public void setTtSource(int ttSource) {
        this.ttSource = ttSource;
    }

    @Basic
    @Column(name = "UsedUE", nullable = false)
    public int getUsedUe() {
        return usedUe;
    }

    public void setUsedUe(int usedUe) {
        this.usedUe = usedUe;
    }

    @Basic
    @Column(name = "IsKatlVisit", nullable = false)
    public boolean isKatlVisit() {
        return isKatlVisit;
    }

    public void setKatlVisit(boolean katlVisit) {
        isKatlVisit = katlVisit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HltDoctorTimeTableEntity that = (HltDoctorTimeTableEntity) o;
        return doctorTimeTableId == that.doctorTimeTableId &&
                xEdition == that.xEdition &&
                xStatus == that.xStatus &&
                rfLpuDoctorId == that.rfLpuDoctorId &&
                rfDocBusyType == that.rfDocBusyType &&
                flagAccess == that.flagAccess &&
                flags == that.flags &&
                lastStubNum == that.lastStubNum &&
                planUe == that.planUe &&
                rfDocPrvdid == that.rfDocPrvdid &&
                rfHealingRoomId == that.rfHealingRoomId &&
                ttSource == that.ttSource &&
                usedUe == that.usedUe &&
                isKatlVisit == that.isKatlVisit &&
                Objects.equals(beginTime, that.beginTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(date, that.date) &&
                Objects.equals(uguid, that.uguid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorTimeTableId, xEdition, xStatus, beginTime, endTime, date, rfLpuDoctorId, rfDocBusyType, flagAccess, flags, uguid, lastStubNum, planUe, rfDocPrvdid, rfHealingRoomId, ttSource, usedUe, isKatlVisit);
    }
}
