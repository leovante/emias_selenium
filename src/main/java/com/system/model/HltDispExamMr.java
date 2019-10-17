package com.system.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "hlt_disp_ExamMR", schema = "dbo", catalog = "test_mo_hlt_Taldom_CRB_20190129")
public class HltDispExamMr {
    private Integer dispExamMrid;
    private Integer flags;
    private UUID guid;
    private UUID rfExamGuid;
    private UUID rfMedRecordGuid;
    private Integer xEdition;
    private Byte xStatus;
    private UUID ehrMedRecordGuid;

    @Id
    @Column(name = "disp_ExamMRID", nullable = false)
    public Integer getDispExamMrid() {
        return dispExamMrid;
    }

    public void setDispExamMrid(Integer dispExamMrid) {
        this.dispExamMrid = dispExamMrid;
    }

    @Basic
    @Column(name = "Flags", nullable = false)
    public Integer getFlags() {
        return flags;
    }

    public void setFlags(Integer flags) {
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
    @Column(name = "rf_ExamGuid", nullable = false)
    public UUID getRfExamGuid() {
        return rfExamGuid;
    }

    public void setRfExamGuid(UUID rfExamGuid) {
        this.rfExamGuid = rfExamGuid;
    }

    @Basic
    @Column(name = "rf_MedRecordGuid", nullable = false)
    public UUID getRfMedRecordGuid() {
        return rfMedRecordGuid;
    }

    public void setRfMedRecordGuid(UUID rfMedRecordGuid) {
        this.rfMedRecordGuid = rfMedRecordGuid;
    }

    @Basic
    @Column(name = "x_Edition", nullable = false)
    public Integer getxEdition() {
        return xEdition;
    }

    public void setxEdition(Integer xEdition) {
        this.xEdition = xEdition;
    }

    @Basic
    @Column(name = "x_Status", nullable = false)
    public Byte getxStatus() {
        return xStatus;
    }

    public void setxStatus(Byte xStatus) {
        this.xStatus = xStatus;
    }

    @Basic
    @Column(name = "EhrMedRecordGuid", nullable = false)
    public UUID getEhrMedRecordGuid() {
        return ehrMedRecordGuid;
    }

    public void setEhrMedRecordGuid(UUID ehrMedRecordGuid) {
        this.ehrMedRecordGuid = ehrMedRecordGuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HltDispExamMr that = (HltDispExamMr) o;
        return Objects.equals(dispExamMrid, that.dispExamMrid) &&
                Objects.equals(flags, that.flags) &&
                Objects.equals(guid, that.guid) &&
                Objects.equals(rfExamGuid, that.rfExamGuid) &&
                Objects.equals(rfMedRecordGuid, that.rfMedRecordGuid) &&
                Objects.equals(xEdition, that.xEdition) &&
                Objects.equals(xStatus, that.xStatus) &&
                Objects.equals(ehrMedRecordGuid, that.ehrMedRecordGuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dispExamMrid, flags, guid, rfExamGuid, rfMedRecordGuid, xEdition, xStatus, ehrMedRecordGuid);
    }
}
