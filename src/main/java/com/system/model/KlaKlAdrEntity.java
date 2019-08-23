package com.system.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "kla_KlAdr", schema = "dbo", catalog = "hlt_demonstration")
public class KlaKlAdrEntity {
    private int klAdrId;
    private int xEdition;
    private byte xStatus;
    private String name;
    private String socr;
    private String code;
    private String gninmb;
    private String uno;
    private String ocatd;
    private String status;
    private int flags;
    private String source;
    private int level;
    private String altCode;
    private String postIndex;

    @Id
    @Column(name = "KlAdrID", nullable = false)
    public int getKlAdrId() {
        return klAdrId;
    }

    public void setKlAdrId(int klAdrId) {
        this.klAdrId = klAdrId;
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
    @Column(name = "Name", nullable = false, length = 40)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "SOCR", nullable = false, length = 10)
    public String getSocr() {
        return socr;
    }

    public void setSocr(String socr) {
        this.socr = socr;
    }

    @Basic
    @Column(name = "CODE", nullable = false, length = 13)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "GNINMB", nullable = false, length = 4)
    public String getGninmb() {
        return gninmb;
    }

    public void setGninmb(String gninmb) {
        this.gninmb = gninmb;
    }

    @Basic
    @Column(name = "UNO", nullable = false, length = 4)
    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
        this.uno = uno;
    }

    @Basic
    @Column(name = "OCATD", nullable = false, length = 11)
    public String getOcatd() {
        return ocatd;
    }

    public void setOcatd(String ocatd) {
        this.ocatd = ocatd;
    }

    @Basic
    @Column(name = "STATUS", nullable = false, length = 1)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    @Column(name = "Source", nullable = false, length = 5)
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Basic
    @Column(name = "LEVEL", nullable = false)
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Basic
    @Column(name = "AltCode", nullable = false, length = 50)
    public String getAltCode() {
        return altCode;
    }

    public void setAltCode(String altCode) {
        this.altCode = altCode;
    }

    @Basic
    @Column(name = "PostIndex", nullable = false, length = 6)
    public String getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(String postIndex) {
        this.postIndex = postIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KlaKlAdrEntity that = (KlaKlAdrEntity) o;
        return klAdrId == that.klAdrId &&
                xEdition == that.xEdition &&
                xStatus == that.xStatus &&
                flags == that.flags &&
                level == that.level &&
                Objects.equals(name, that.name) &&
                Objects.equals(socr, that.socr) &&
                Objects.equals(code, that.code) &&
                Objects.equals(gninmb, that.gninmb) &&
                Objects.equals(uno, that.uno) &&
                Objects.equals(ocatd, that.ocatd) &&
                Objects.equals(status, that.status) &&
                Objects.equals(source, that.source) &&
                Objects.equals(altCode, that.altCode) &&
                Objects.equals(postIndex, that.postIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(klAdrId, xEdition, xStatus, name, socr, code, gninmb, uno, ocatd, status, flags, source, level, altCode, postIndex);
    }
}
