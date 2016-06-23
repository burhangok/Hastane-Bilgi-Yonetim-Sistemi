/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gorevli;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author burhan
 */
@Entity
@Table(name = "HASTALAR", catalog = "", schema = "HR")
@NamedQueries({
    @NamedQuery(name = "Hastalar.findAll", query = "SELECT h FROM Hastalar h"),
    @NamedQuery(name = "Hastalar.findByHastaId", query = "SELECT h FROM Hastalar h WHERE h.hastaId = :hastaId"),
    @NamedQuery(name = "Hastalar.findByAdi", query = "SELECT h FROM Hastalar h WHERE h.adi = :adi"),
    @NamedQuery(name = "Hastalar.findBySoyadi", query = "SELECT h FROM Hastalar h WHERE h.soyadi = :soyadi"),
    @NamedQuery(name = "Hastalar.findByTcNo", query = "SELECT h FROM Hastalar h WHERE h.tcNo = :tcNo"),
    @NamedQuery(name = "Hastalar.findByUcret", query = "SELECT h FROM Hastalar h WHERE h.ucret = :ucret"),
    @NamedQuery(name = "Hastalar.findByAdres", query = "SELECT h FROM Hastalar h WHERE h.adres = :adres"),
    @NamedQuery(name = "Hastalar.findByTelefon", query = "SELECT h FROM Hastalar h WHERE h.telefon = :telefon"),
    @NamedQuery(name = "Hastalar.findByDosyaId", query = "SELECT h FROM Hastalar h WHERE h.dosyaId = :dosyaId")})
public class Hastalar implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "HASTA_ID")
    private BigDecimal hastaId;
    @Column(name = "ADI")
    private String adi;
    @Column(name = "SOYADI")
    private String soyadi;
    @Column(name = "TC_NO")
    private BigInteger tcNo;
    @Column(name = "UCRET")
    private BigInteger ucret;
    @Column(name = "ADRES")
    private String adres;
    @Column(name = "TELEFON")
    private BigInteger telefon;
    @Column(name = "DOSYA_ID")
    private BigInteger dosyaId;

    public Hastalar() {
    }

    public Hastalar(BigDecimal hastaId) {
        this.hastaId = hastaId;
    }

    public BigDecimal getHastaId() {
        return hastaId;
    }

    public void setHastaId(BigDecimal hastaId) {
        BigDecimal oldHastaId = this.hastaId;
        this.hastaId = hastaId;
        changeSupport.firePropertyChange("hastaId", oldHastaId, hastaId);
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

    public BigInteger getUcret() {
        return ucret;
    }

    public void setUcret(BigInteger ucret) {
        BigInteger oldUcret = this.ucret;
        this.ucret = ucret;
        changeSupport.firePropertyChange("ucret", oldUcret, ucret);
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        String oldAdres = this.adres;
        this.adres = adres;
        changeSupport.firePropertyChange("adres", oldAdres, adres);
    }

    public BigInteger getTelefon() {
        return telefon;
    }

    public void setTelefon(BigInteger telefon) {
        BigInteger oldTelefon = this.telefon;
        this.telefon = telefon;
        changeSupport.firePropertyChange("telefon", oldTelefon, telefon);
    }

    public BigInteger getDosyaId() {
        return dosyaId;
    }

    public void setDosyaId(BigInteger dosyaId) {
        BigInteger oldDosyaId = this.dosyaId;
        this.dosyaId = dosyaId;
        changeSupport.firePropertyChange("dosyaId", oldDosyaId, dosyaId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hastaId != null ? hastaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hastalar)) {
            return false;
        }
        Hastalar other = (Hastalar) object;
        if ((this.hastaId == null && other.hastaId != null) || (this.hastaId != null && !this.hastaId.equals(other.hastaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gorevli.Hastalar[ hastaId=" + hastaId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
