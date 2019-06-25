package com.system.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "oms_PRVS", schema = "dbo", catalog = "test_mo_hlt_Taldom_CRB_20190129")
public class OmsPrvs {
    private int xEdition;
    private byte xStatus;
    private String cPrvs;
    private String prvsName;
    private String msgText;
    private int prvsid;
    private int iPrvs;
    private Timestamp dateBeg;
    private Timestamp dateEnd;

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
    @Column(name = "C_PRVS", nullable = false, length = 100)
    public String getcPrvs() {
        return cPrvs;
    }

    public void setcPrvs(String cPrvs) {
        this.cPrvs = cPrvs;
    }

    @Basic
    @Column(name = "PRVS_NAME", nullable = false, length = 100)
    public String getPrvsName() {
        return prvsName;
    }

    public void setPrvsName(String prvsName) {
        this.prvsName = prvsName;
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
    @Column(name = "PRVSID", nullable = false)
    public int getPrvsid() {
        return prvsid;
    }

    public void setPrvsid(int prvsid) {
        this.prvsid = prvsid;
    }

    @Basic
    @Column(name = "I_PRVS", nullable = false)
    public int getiPrvs() {
        return iPrvs;
    }

    public void setiPrvs(int iPrvs) {
        this.iPrvs = iPrvs;
    }

    @Basic
    @Column(name = "Date_Beg", nullable = false)
    public Timestamp getDateBeg() {
        return dateBeg;
    }

    public void setDateBeg(Timestamp dateBeg) {
        this.dateBeg = dateBeg;
    }

    @Basic
    @Column(name = "Date_End", nullable = false)
    public Timestamp getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Timestamp dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OmsPrvs omsPrvs = (OmsPrvs) o;
        return xEdition == omsPrvs.xEdition &&
                xStatus == omsPrvs.xStatus &&
                prvsid == omsPrvs.prvsid &&
                iPrvs == omsPrvs.iPrvs &&
                Objects.equals(cPrvs, omsPrvs.cPrvs) &&
                Objects.equals(prvsName, omsPrvs.prvsName) &&
                Objects.equals(msgText, omsPrvs.msgText) &&
                Objects.equals(dateBeg, omsPrvs.dateBeg) &&
                Objects.equals(dateEnd, omsPrvs.dateEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xEdition, xStatus, cPrvs, prvsName, msgText, prvsid, iPrvs, dateBeg, dateEnd);
    }
}
