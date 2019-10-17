package com.system.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "oms_ParamValue", schema = "dbo", catalog = "test_mo_hlt_Taldom_CRB_20190129")
public class OmsParamValue {
    private Timestamp date;
    private UUID docGuid;
    private Integer flags;
    private UUID guidParamValue;
    private Integer medUserId;
    private Integer paramValueId;
    private UUID patientGuid;
    private String value;
    private Integer xEdition;
    private Byte xStatus;
    private UUID documentGuid;
    private UUID documentMetaDataGuid;

    @Basic
    @Column(name = "Date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "DocGUID", nullable = false)
    public UUID getDocGuid() {
        return docGuid;
    }

    public void setDocGuid(UUID docGuid) {
        this.docGuid = docGuid;
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
    @Column(name = "GUIDParamValue", nullable = false)
    public UUID getGuidParamValue() {
        return guidParamValue;
    }

    public void setGuidParamValue(UUID guidParamValue) {
        this.guidParamValue = guidParamValue;
    }

    @Basic
    @Column(name = "MedUserID", nullable = false)
    public Integer getMedUserId() {
        return medUserId;
    }

    public void setMedUserId(Integer medUserId) {
        this.medUserId = medUserId;
    }

    @Id
    @Column(name = "ParamValueID", nullable = false)
    public Integer getParamValueId() {
        return paramValueId;
    }

    public void setParamValueId(Integer paramValueId) {
        this.paramValueId = paramValueId;
    }

    @Basic
    @Column(name = "PatientGUID", nullable = false)
    public UUID getPatientGuid() {
        return patientGuid;
    }

    public void setPatientGuid(UUID patientGuid) {
        this.patientGuid = patientGuid;
    }

    @Basic
    @Column(name = "Value", nullable = false, length = 2147483647)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
    @Column(name = "DocumentGUID", nullable = false)
    public UUID getDocumentGuid() {
        return documentGuid;
    }

    public void setDocumentGuid(UUID documentGuid) {
        this.documentGuid = documentGuid;
    }

    @Basic
    @Column(name = "DocumentMetaDataGuid", nullable = false)
    public UUID getDocumentMetaDataGuid() {
        return documentMetaDataGuid;
    }

    public void setDocumentMetaDataGuid(UUID documentMetaDataGuid) {
        this.documentMetaDataGuid = documentMetaDataGuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OmsParamValue that = (OmsParamValue) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(docGuid, that.docGuid) &&
                Objects.equals(flags, that.flags) &&
                Objects.equals(guidParamValue, that.guidParamValue) &&
                Objects.equals(medUserId, that.medUserId) &&
                Objects.equals(paramValueId, that.paramValueId) &&
                Objects.equals(patientGuid, that.patientGuid) &&
                Objects.equals(value, that.value) &&
                Objects.equals(xEdition, that.xEdition) &&
                Objects.equals(xStatus, that.xStatus) &&
                Objects.equals(documentGuid, that.documentGuid) &&
                Objects.equals(documentMetaDataGuid, that.documentMetaDataGuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, docGuid, flags, guidParamValue, medUserId, paramValueId, patientGuid, value, xEdition, xStatus, documentGuid, documentMetaDataGuid);
    }
}
