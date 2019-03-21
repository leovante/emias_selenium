package system.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "kla_Address", schema = "dbo", catalog = "test_mo_hlt_Taldom_CRB_20190129")
public class KlaAddressEntity {

    private int addressId;

    //    @OneToMany(mappedBy = "rfAddressRegId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OneToMany(fetch = FetchType.LAZY, /*mappedBy = "rfAddressRegId",*/ cascade = CascadeType.ALL)
    @JoinColumn(name = "AddressID")
    private Set<HltMkabEntity> hltMkabEntities = new LinkedHashSet<>();

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "Guid")
//    private Set<HltDispExamEntity> guids = new LinkedHashSet<>();

    private int xEdition;
    private byte xStatus;
    private String code;
    private String addressString;
    private String appartment;
    private String dopData;
    private int flags;

    @Id
    @Column(name = "AddressID", nullable = false)
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
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
    @Column(name = "CODE", nullable = false, length = 17)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "AddressString", nullable = false, length = 500)
    public String getAddressString() {
        return addressString;
    }

    public void setAddressString(String addressString) {
        this.addressString = addressString;
    }

    @Basic
    @Column(name = "Appartment", nullable = false, length = 50)
    public String getAppartment() {
        return appartment;
    }

    public void setAppartment(String appartment) {
        this.appartment = appartment;
    }

    @Basic
    @Column(name = "DopData", nullable = false, length = 500)
    public String getDopData() {
        return dopData;
    }

    public void setDopData(String dopData) {
        this.dopData = dopData;
    }

    @Basic
    @Column(name = "Flags", nullable = false)
    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KlaAddressEntity that = (KlaAddressEntity) o;
        return addressId == that.addressId &&
                xEdition == that.xEdition &&
                xStatus == that.xStatus &&
                flags == that.flags &&
                Objects.equals(code, that.code) &&
                Objects.equals(addressString, that.addressString) &&
                Objects.equals(appartment, that.appartment) &&
                Objects.equals(dopData, that.dopData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, xEdition, xStatus, code, addressString, appartment, dopData, flags);
    }
}