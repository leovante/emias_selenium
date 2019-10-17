package com.system.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "hlt_disp_ExamSM", schema = "dbo", catalog = "test_mo_hlt_Taldom_CRB_20190129")
public class HltDispExamSm {
    private Integer dispExamSmid;
    private Integer flags;
    private UUID guid;
    private UUID rfExamGuid;
    private UUID rfOmsServiceMedicalGuid;
    private Integer xEdition;
    private Byte xStatus;
    private Integer rfSmtapid;
    private Integer docTypeId;
    private Integer documentId;
    private Integer rfDispCardId;
    private Integer visitNum;

    @Id
    @Column(name = "disp_ExamSMID", nullable = false)
    public Integer getDispExamSmid() {
        return dispExamSmid;
    }

    public void setDispExamSmid(Integer dispExamSmid) {
        this.dispExamSmid = dispExamSmid;
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
    @Column(name = "rf_OmsServiceMedicalGuid", nullable = false)
    public UUID getRfOmsServiceMedicalGuid() {
        return rfOmsServiceMedicalGuid;
    }

    public void setRfOmsServiceMedicalGuid(UUID rfOmsServiceMedicalGuid) {
        this.rfOmsServiceMedicalGuid = rfOmsServiceMedicalGuid;
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
    @Column(name = "rf_SMTAPID", nullable = false)
    public Integer getRfSmtapid() {
        return rfSmtapid;
    }

    public void setRfSmtapid(Integer rfSmtapid) {
        this.rfSmtapid = rfSmtapid;
    }

    @Basic
    @Column(name = "DocTypeID", nullable = false)
    public Integer getDocTypeId() {
        return docTypeId;
    }

    public void setDocTypeId(Integer docTypeId) {
        this.docTypeId = docTypeId;
    }

    @Basic
    @Column(name = "DocumentID", nullable = false)
    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    @Basic
    @Column(name = "rf_disp_CardID", nullable = false)
    public Integer getRfDispCardId() {
        return rfDispCardId;
    }

    public void setRfDispCardId(Integer rfDispCardId) {
        this.rfDispCardId = rfDispCardId;
    }

    @Basic
    @Column(name = "VisitNum", nullable = false)
    public Integer getVisitNum() {
        return visitNum;
    }

    public void setVisitNum(Integer visitNum) {
        this.visitNum = visitNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HltDispExamSm that = (HltDispExamSm) o;
        return Objects.equals(dispExamSmid, that.dispExamSmid) &&
                Objects.equals(flags, that.flags) &&
                Objects.equals(guid, that.guid) &&
                Objects.equals(rfExamGuid, that.rfExamGuid) &&
                Objects.equals(rfOmsServiceMedicalGuid, that.rfOmsServiceMedicalGuid) &&
                Objects.equals(xEdition, that.xEdition) &&
                Objects.equals(xStatus, that.xStatus) &&
                Objects.equals(rfSmtapid, that.rfSmtapid) &&
                Objects.equals(docTypeId, that.docTypeId) &&
                Objects.equals(documentId, that.documentId) &&
                Objects.equals(rfDispCardId, that.rfDispCardId) &&
                Objects.equals(visitNum, that.visitNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dispExamSmid, flags, guid, rfExamGuid, rfOmsServiceMedicalGuid, xEdition, xStatus, rfSmtapid, docTypeId, documentId, rfDispCardId, visitNum);
    }
}
