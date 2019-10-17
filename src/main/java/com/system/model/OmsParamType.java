package com.system.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "oms_ParamType", schema = "dbo", catalog = "test_mo_hlt_Taldom_CRB_20190129")
public class OmsParamType {
    private String code;
    private UUID guidParamType;
    private String name;
    private Integer paramTypeId;
    private Integer xEdition;
    private Byte xStatus;

    @Basic
    @Column(name = "Code", nullable = false, length = 100)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "GUIDParamType", nullable = false)
    public UUID getGuidParamType() {
        return guidParamType;
    }

    public void setGuidParamType(UUID guidParamType) {
        this.guidParamType = guidParamType;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "ParamTypeID", nullable = false)
    public Integer getParamTypeId() {
        return paramTypeId;
    }

    public void setParamTypeId(Integer paramTypeId) {
        this.paramTypeId = paramTypeId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OmsParamType that = (OmsParamType) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(guidParamType, that.guidParamType) &&
                Objects.equals(name, that.name) &&
                Objects.equals(paramTypeId, that.paramTypeId) &&
                Objects.equals(xEdition, that.xEdition) &&
                Objects.equals(xStatus, that.xStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, guidParamType, name, paramTypeId, xEdition, xStatus);
    }
}
