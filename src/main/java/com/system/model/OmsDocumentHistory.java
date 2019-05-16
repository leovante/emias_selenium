package com.system.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "oms_DocumentHistory", schema = "dbo", catalog = "test_mo_hlt_Taldom_CRB_20190129")
public class OmsDocumentHistory {
    private Timestamp date;
    private UUID documentHistoryGuid;
    private int documentHistoryId;
    private String editor;
    private String newValue;
    private String oldValue;
    private UUID rfClientApplicationGuid;
    private UUID rfDocElemDefGuid;
    private UUID rfDocTypeDefGuid;
    private UUID rfDocumentGuid;
    private int xEdition;
    private byte xStatus;

    @Basic
    @Column(name = "Date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "DocumentHistoryGuid", nullable = false)
    public UUID getDocumentHistoryGuid() {
        return documentHistoryGuid;
    }

    public void setDocumentHistoryGuid(UUID documentHistoryGuid) {
        this.documentHistoryGuid = documentHistoryGuid;
    }

    @Id
    @GeneratedValue
    @Column(name = "DocumentHistoryID", nullable = false)
    public int getDocumentHistoryId() {
        return documentHistoryId;
    }

    public void setDocumentHistoryId(int documentHistoryId) {
        this.documentHistoryId = documentHistoryId;
    }

    @Basic
    @Column(name = "Editor", nullable = false, length = 50)
    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    @Basic
    @Column(name = "NewValue", nullable = false, length = 1000)
    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    @Basic
    @Column(name = "OldValue", nullable = false, length = 1000)
    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    @Basic
    @Column(name = "rf_ClientApplicationGuid", nullable = false)
    public UUID getRfClientApplicationGuid() {
        return rfClientApplicationGuid;
    }

    public void setRfClientApplicationGuid(UUID rfClientApplicationGuid) {
        this.rfClientApplicationGuid = rfClientApplicationGuid;
    }

    @Basic
    @Column(name = "rf_DocElemDefGuid", nullable = false)
    public UUID getRfDocElemDefGuid() {
        return rfDocElemDefGuid;
    }

    public void setRfDocElemDefGuid(UUID rfDocElemDefGuid) {
        this.rfDocElemDefGuid = rfDocElemDefGuid;
    }

    @Basic
    @Column(name = "rf_DocTypeDefGuid", nullable = false)
    public UUID getRfDocTypeDefGuid() {
        return rfDocTypeDefGuid;
    }

    public void setRfDocTypeDefGuid(UUID rfDocTypeDefGuid) {
        this.rfDocTypeDefGuid = rfDocTypeDefGuid;
    }

    @Basic
    @Column(name = "rf_DocumentGuid", nullable = false)
    public UUID getRfDocumentGuid() {
        return rfDocumentGuid;
    }

    public void setRfDocumentGuid(UUID rfDocumentGuid) {
        this.rfDocumentGuid = rfDocumentGuid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OmsDocumentHistory that = (OmsDocumentHistory) o;
        return documentHistoryId == that.documentHistoryId &&
                xEdition == that.xEdition &&
                xStatus == that.xStatus &&
                Objects.equals(date, that.date) &&
                Objects.equals(documentHistoryGuid, that.documentHistoryGuid) &&
                Objects.equals(editor, that.editor) &&
                Objects.equals(newValue, that.newValue) &&
                Objects.equals(oldValue, that.oldValue) &&
                Objects.equals(rfClientApplicationGuid, that.rfClientApplicationGuid) &&
                Objects.equals(rfDocElemDefGuid, that.rfDocElemDefGuid) &&
                Objects.equals(rfDocTypeDefGuid, that.rfDocTypeDefGuid) &&
                Objects.equals(rfDocumentGuid, that.rfDocumentGuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, documentHistoryGuid, documentHistoryId, editor, newValue, oldValue, rfClientApplicationGuid, rfDocElemDefGuid, rfDocTypeDefGuid, rfDocumentGuid, xEdition, xStatus);
    }
}
