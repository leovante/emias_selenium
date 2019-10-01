package com.system.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "hlt_disp_ServiceDocPrvd", schema = "dbo", catalog = "test_mo_hlt_Taldom_CRB_20190129")
public class HltDispServiceDocPrvd {
    private int dispServiceDocPrvdId;
    private int flags;
    private UUID guid;
    private UUID rfDocPrvdGuid;
    private UUID rfServiceGuid;
    private int xEdition;
    private byte xStatus;

    @Id
    @GeneratedValue
    @Column(name = "disp_ServiceDocPrvdID", nullable = false)
    public int getDispServiceDocPrvdId() {
        return dispServiceDocPrvdId;
    }

    public void setDispServiceDocPrvdId(int dispServiceDocPrvdId) {
        this.dispServiceDocPrvdId = dispServiceDocPrvdId;
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
    @Column(name = "rf_DocPrvdGuid", nullable = false)
    public UUID getRfDocPrvdGuid() {
        return rfDocPrvdGuid;
    }

    public void setRfDocPrvdGuid(UUID rfDocPrvdGuid) {
        this.rfDocPrvdGuid = rfDocPrvdGuid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HltDispServiceDocPrvd that = (HltDispServiceDocPrvd) o;
        return dispServiceDocPrvdId == that.dispServiceDocPrvdId &&
                flags == that.flags &&
                xEdition == that.xEdition &&
                xStatus == that.xStatus &&
                Objects.equals(guid, that.guid) &&
                Objects.equals(rfDocPrvdGuid, that.rfDocPrvdGuid) &&
                Objects.equals(rfServiceGuid, that.rfServiceGuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dispServiceDocPrvdId, flags, guid, rfDocPrvdGuid, rfServiceGuid, xEdition, xStatus);
    }
}
