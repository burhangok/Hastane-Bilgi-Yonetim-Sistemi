/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author burhan
 */
@Entity
@Table(name = "DOKTORLAR", catalog = "", schema = "HR")
@NamedQueries({
    @NamedQuery(name = "Doktorlar_1.findAll", query = "SELECT d FROM Doktorlar_1 d"),
    @NamedQuery(name = "Doktorlar_1.findByDoktorId", query = "SELECT d FROM Doktorlar_1 d WHERE d.doktorId = :doktorId"),
    @NamedQuery(name = "Doktorlar_1.findByAdi", query = "SELECT d FROM Doktorlar_1 d WHERE d.adi = :adi"),
    @NamedQuery(name = "Doktorlar_1.findBySoyadi", query = "SELECT d FROM Doktorlar_1 d WHERE d.soyadi = :soyadi"),
    @NamedQuery(name = "Doktorlar_1.findByTcNo", query = "SELECT d FROM Doktorlar_1 d WHERE d.tcNo = :tcNo"),
    @NamedQuery(name = "Doktorlar_1.findByBransId", query = "SELECT d FROM Doktorlar_1 d WHERE d.bransId = :bransId"),
    @NamedQuery(name = "Doktorlar_1.findByTelefon", query = "SELECT d FROM Doktorlar_1 d WHERE d.telefon = :telefon"),
    @NamedQuery(name = "Doktorlar_1.findByMail", query = "SELECT d FROM Doktorlar_1 d WHERE d.mail = :mail"),
    @NamedQuery(name = "Doktorlar_1.findByKullaniciAdi", query = "SELECT d FROM Doktorlar_1 d WHERE d.kullaniciAdi = :kullaniciAdi"),
    @NamedQuery(name = "Doktorlar_1.findByKullaniciSifre", query = "SELECT d FROM Doktorlar_1 d WHERE d.kullaniciSifre = :kullaniciSifre"),
    @NamedQuery(name = "Doktorlar_1.findByPoliklinikId", query = "SELECT d FROM Doktorlar_1 d WHERE d.poliklinikId = :poliklinikId"),
    @NamedQuery(name = "Doktorlar_1.findByUnvan", query = "SELECT d FROM Doktorlar_1 d WHERE d.unvan = :unvan"),
    @NamedQuery(name = "Doktorlar_1.findByKayitTarihi", query = "SELECT d FROM Doktorlar_1 d WHERE d.kayitTarihi = :kayitTarihi")})
public class Doktorlar_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "DOKTOR_ID")
    private BigDecimal doktorId;
    @Column(name = "ADI")
    private String adi;
    @Column(name = "SOYADI")
    private String soyadi;
    @Column(name = "TC_NO")
    private BigInteger tcNo;
    @Column(name = "BRANS_ID")
    private BigInteger bransId;
    @Column(name = "TELEFON")
    private BigInteger telefon;
    @Column(name = "MAIL")
    private String mail;
    @Column(name = "KULLANICI_ADI")
    private String kullaniciAdi;
    @Column(name = "KULLANICI_SIFRE")
    private String kullaniciSifre;
    @Column(name = "POLIKLINIK_ID")
    private BigInteger poliklinikId;
    @Column(name = "UNVAN")
    private String unvan;
    @Column(name = "KAYIT_TARIHI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date kayitTarihi;

    public Doktorlar_1() {
    }

    public Doktorlar_1(BigDecimal doktorId) {
        this.doktorId = doktorId;
    }

    public BigDecimal getDoktorId() {
        return doktorId;
    }

    public void setDoktorId(BigDecimal doktorId) {
        BigDecimal oldDoktorId = this.doktorId;
        this.doktorId = doktorId;
        changeSupport.firePropertyChange("doktorId", oldDoktorId, doktorId);
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        String oldAdi = this.adi;
        this.adi = adi;
        changeSupport.firePropertyChange("adi", oldAdi, adi);
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        String oldSoyadi = this.soyadi;
        this.soyadi = soyadi;
        changeSupport.firePropertyChange("soyadi", oldSoyadi, soyadi);
    }

    public BigInteger getTcNo() {
        return tcNo;
    }

    public void setTcNo(BigInteger tcNo) {
        BigInteger oldTcNo = this.tcNo;
        this.tcNo = tcNo;
        changeSupport.firePropertyChange("tcNo", oldTcNo, tcNo);
    }

    public BigInteger getBransId() {
        return bransId;
    }

    public void setBransId(BigInteger bransId) {
        BigInteger oldBransId = this.bransId;
        this.bransId = bransId;
        changeSupport.firePropertyChange("bransId", oldBransId, bransId);
    }

    public BigInteger getTelefon() {
        return telefon;
    }

    public void setTelefon(BigInteger telefon) {
        BigInteger oldTelefon = this.telefon;
        this.telefon = telefon;
        changeSupport.firePropertyChange("telefon", oldTelefon, telefon);
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        String oldMail = this.mail;
        this.mail = mail;
        changeSupport.firePropertyChange("mail", oldMail, mail);
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        String oldKullaniciAdi = this.kullaniciAdi;
        this.kullaniciAdi = kullaniciAdi;
        changeSupport.firePropertyChange("kullaniciAdi", oldKullaniciAdi, kullaniciAdi);
    }

    public String getKullaniciSifre() {
        return kullaniciSifre;
    }

    public void setKullaniciSifre(String kullaniciSifre) {
        String oldKullaniciSifre = this.kullaniciSifre;
        this.kullaniciSifre = kullaniciSifre;
        changeSupport.firePropertyChange("kullaniciSifre", oldKullaniciSifre, kullaniciSifre);
    }

    public BigInteger getPoliklinikId() {
        return poliklinikId;
    }

    public void setPoliklinikId(BigInteger poliklinikId) {
        BigInteger oldPoliklinikId = this.poliklinikId;
        this.poliklinikId = poliklinikId;
        changeSupport.firePropertyChange("poliklinikId", oldPoliklinikId, poliklinikId);
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        String oldUnvan = this.unvan;
        this.unvan = unvan;
        changeSupport.firePropertyChange("unvan", oldUnvan, unvan);
    }

    public Date getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(Date kayitTarihi) {
        Date oldKayitTarihi = this.kayitTarihi;
        this.kayitTarihi = kayitTarihi;
        changeSupport.firePropertyChange("kayitTarihi", oldKayitTarihi, kayitTarihi);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doktorId != null ? doktorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doktorlar_1)) {
            return false;
        }
        Doktorlar_1 other = (Doktorlar_1) object;
        if ((this.doktorId == null && other.doktorId != null) || (this.doktorId != null && !this.doktorId.equals(other.doktorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistem.Doktorlar_1[ doktorId=" + doktorId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
