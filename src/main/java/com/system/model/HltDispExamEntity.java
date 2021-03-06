package com.system.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

//<!--правка hibernate-->
//<!--правка hibernate-->
@Entity
@Table(name = "hlt_disp_Exam", schema = "dbo", catalog = "hlt_demonstration")
public class HltDispExamEntity {
    private Timestamp dateExam;
    private Timestamp dateOtkaz;
    private long dispExamId;
    private int dopPriznak;
    private int flags;
    private UUID guid;
    private boolean isDeviation;
    private boolean isOtkaz;
    private UUID rfCardGuid;
    private UUID rfDocPrvdGuid;
    private UUID rfDvtGuid;
    private UUID rfServiceGuid;
    private int xEdition;
    private byte xStatus;
    private boolean isSigned;
    private UUID rfServicePmGuid;
    private UUID rfTapGuid;


    @Basic
    @Column(name = "DateExam", nullable = false)
    public Timestamp getDateExam() {
        return dateExam;
    }

    public void setDateExam(Timestamp dateExam) {
        this.dateExam = dateExam;
    }

    @Basic
    @Column(name = "DateOtkaz", nullable = false)
    public Timestamp getDateOtkaz() {
        return dateOtkaz;
    }

    public void setDateOtkaz(Timestamp dateOtkaz) {
        this.dateOtkaz = dateOtkaz;
    }

    @Id
    @Column(name = "disp_ExamID", nullable = false)
    public long getDispExamId() {
        return dispExamId;
    }

    public void setDispExamId(long dispExamId) {
        this.dispExamId = dispExamId;
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
    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }

    @Basic
    @Column(name = "IsDeviation", nullable = false)
    public boolean isDeviation() {
        return isDeviation;
    }

    public void setDeviation(boolean deviation) {
        isDeviation = deviation;
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
    @Column(name = "rf_CardGuid", nullable = false)
    public UUID getRfCardGuid() {
        return rfCardGuid;
    }

    public void setRfCardGuid(UUID rfCardGuid) {
        this.rfCardGuid = rfCardGuid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Guid", nullable = false)
    private HltDispCardEntity hltDispCardEntity;

    @Basic
    @Column(name = "rf_DocPrvdGuid", nullable = false)
    public UUID getRfDocPrvdGuid() {
        return rfDocPrvdGuid;
    }

    public void setRfDocPrvdGuid(UUID rfDocPrvdGuid) {
        this.rfDocPrvdGuid = rfDocPrvdGuid;
    }

    @Basic
    @Column(name = "rf_DvtGuid", nullable = false)
    public UUID getRfDvtGuid() {
        return rfDvtGuid;
    }

    public void setRfDvtGuid(UUID rfDvtGuid) {
        this.rfDvtGuid = rfDvtGuid;
    }

    @Basic
    @Column(name = "rf_ServiceGuid", nullable = false)
    public UUID getRfServiceGuid() {
        return rfServiceGuid;
    }

    public void setRfServiceGuid(UUID rfServiceGuid) {
        this.rfServiceGuid = rfServiceGuid;
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
    @Column(name = "IsSigned", nullable = false)
    public boolean isSigned() {
        return isSigned;
    }

    public void setSigned(boolean signed) {
        isSigned = signed;
    }

    @Basic
    @Column(name = "rf_ServicePMGuid", nullable = false)
    public UUID getRfServicePmGuid() {
        return rfServicePmGuid;
    }

    public void setRfServicePmGuid(UUID rfServicePmGuid) {
        this.rfServicePmGuid = rfServicePmGuid;
    }

    @Basic
    @Column(name = "rf_TapGuid", nullable = false)
    public UUID getRfTapGuid() {
        return rfTapGuid;
    }

    public void setRfTapGuid(UUID rfTapGuid) {
        this.rfTapGuid = rfTapGuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HltDispExamEntity that = (HltDispExamEntity) o;
        return dispExamId == that.dispExamId &&
                dopPriznak == that.dopPriznak &&
                flags == that.flags &&
                isDeviation == that.isDeviation &&
                isOtkaz == that.isOtkaz &&
                xEdition == that.xEdition &&
                xStatus == that.xStatus &&
                isSigned == that.isSigned &&
                Objects.equals(dateExam, that.dateExam) &&
                Objects.equals(dateOtkaz, that.dateOtkaz) &&
                Objects.equals(guid, that.guid) &&
                Objects.equals(rfCardGuid, that.rfCardGuid) &&
                Objects.equals(rfDocPrvdGuid, that.rfDocPrvdGuid) &&
                Objects.equals(rfDvtGuid, that.rfDvtGuid) &&
                Objects.equals(rfServiceGuid, that.rfServiceGuid) &&
                Objects.equals(rfServicePmGuid, that.rfServicePmGuid) &&
                Objects.equals(rfTapGuid, that.rfTapGuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateExam, dateOtkaz, dispExamId, dopPriznak, flags, guid, isDeviation, isOtkaz, rfCardGuid, rfDocPrvdGuid, rfDvtGuid, rfServiceGuid, xEdition, xStatus, isSigned, rfServicePmGuid, rfTapGuid);
    }
}
