package com.system.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "oms_PRVD", schema = "dbo", catalog = "test_mo_hlt_Taldom_CRB_20190129")
public class OmsPrvd {
    private int xEdition;
    private byte xStatus;
    private String name;
    private String cPrvd;
    private String msgText;
    private int prvdid;
    private Timestamp dateB;
    private Timestamp dateE;

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
    @Column(name = "NAME", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "C_PRVD", nullable = false, length = 50)
    public String getcPrvd() {
        return cPrvd;
    }

    public void setcPrvd(String cPrvd) {
        this.cPrvd = cPrvd;
    }

    @Basic
    @Column(name = "MSG_TEXT", nullable = false, length = 100)
    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    @Id
    @Column(name = "PRVDID", nullable = false)
    public int getPrvdid() {
        return prvdid;
    }

    public void setPrvdid(int prvdid) {
        this.prvdid = prvdid;
    }

    @Basic
    @Column(name = "Date_B", nullable = false)
    public Timestamp getDateB() {
        return dateB;
    }

    public void setDateB(Timestamp dateB) {
        this.dateB = dateB;
    }

    @Basic
    @Column(name = "Date_E", nullable = false)
    public Timestamp getDateE() {
        return dateE;
    }

    public void setDateE(Timestamp dateE) {
        this.dateE = dateE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OmsPrvd omsPrvd = (OmsPrvd) o;
        return xEdition == omsPrvd.xEdition &&
                xStatus == omsPrvd.xStatus &&
                prvdid == omsPrvd.prvdid &&
                Objects.equals(name, omsPrvd.name) &&
                Objects.equals(cPrvd, omsPrvd.cPrvd) &&
                Objects.equals(msgText, omsPrvd.msgText) &&
                Objects.equals(dateB, omsPrvd.dateB) &&
                Objects.equals(dateE, omsPrvd.dateE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xEdition, xStatus, name, cPrvd, msgText, prvdid, dateB, dateE);
    }
}
