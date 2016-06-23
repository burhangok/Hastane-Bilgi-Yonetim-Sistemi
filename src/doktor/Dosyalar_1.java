/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doktor;

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
@Table(name = "DOSYALAR", catalog = "", schema = "HR")
@NamedQueries({
    @NamedQuery(name = "Dosyalar_1.findAll", query = "SELECT d FROM Dosyalar_1 d"),
    @NamedQuery(name = "Dosyalar_1.findByDosyaId", query = "SELECT d FROM Dosyalar_1 d WHERE d.dosyaId = :dosyaId"),
    @NamedQuery(name = "Dosyalar_1.findByHastaId", query = "SELECT d FROM Dosyalar_1 d WHERE d.hastaId = :hastaId"),
    @NamedQuery(name = "Dosyalar_1.findByDoktorId", query = "SELECT d FROM Dosyalar_1 d WHERE d.doktorId = :doktorId"),
    @NamedQuery(name = "Dosyalar_1.findByRandevuId", query = "SELECT d FROM Dosyalar_1 d WHERE d.randevuId = :randevuId"),
    @NamedQuery(name = "Dosyalar_1.findByTeshis", query = "SELECT d FROM Dosyalar_1 d WHERE d.teshis = :teshis"),
    @NamedQuery(name = "Dosyalar_1.findByAciklama", query = "SELECT d FROM Dosyalar_1 d WHERE d.aciklama = :aciklama")})
public class Dosyalar_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "DOSYA_ID")
    private BigDecimal dosyaId;
    @Column(name = "HASTA_ID")
    private BigInteger hastaId;
    @Column(name = "DOKTOR_ID")
    private BigInteger doktorId;
    @Column(name = "RANDEVU_ID")
    private BigInteger randevuId;
    @Column(name = "TESHIS")
    private String teshis;
    @Column(name = "ACIKLAMA")
    private String aciklama;

    public Dosyalar_1() {
    }

    public Dosyalar_1(BigDecimal dosyaId) {
        this.dosyaId = dosyaId;
    }

    public BigDecimal getDosyaId() {
        return dosyaId;
    }

    public void setDosyaId(BigDecimal dosyaId) {
        BigDecimal oldDosyaId = this.dosyaId;
        this.dosyaId = dosyaId;
        changeSupport.firePropertyChange("dosyaId", oldDosyaId, dosyaId);
    }

    public BigInteger getHastaId() {
        return hastaId;
    }

    public void setHastaId(BigInteger hastaId) {
        BigInteger oldHastaId = this.hastaId;
        this.hastaId = hastaId;
        changeSupport.firePropertyChange("hastaId", oldHastaId, hastaId);
    }

    public BigInteger getDoktorId() {
        return doktorId;
    }

    public void setDoktorId(BigInteger doktorId) {
        BigInteger oldDoktorId = this.doktorId;
        this.doktorId = doktorId;
        changeSupport.firePropertyChange("doktorId", oldDoktorId, doktorId);
    }

    public BigInteger getRandevuId() {
        return randevuId;
    }

    public void setRandevuId(BigInteger randevuId) {
        BigInteger oldRandevuId = this.randevuId;
        this.randevuId = randevuId;
        changeSupport.firePropertyChange("randevuId", oldRandevuId, randevuId);
    }

    public String getTeshis() {
        return teshis;
    }

    public void setTeshis(String teshis) {
        String oldTeshis = this.teshis;
        this.teshis = teshis;
        changeSupport.firePropertyChange("teshis", oldTeshis, teshis);
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        String oldAciklama = this.aciklama;
        this.aciklama = aciklama;
        changeSupport.firePropertyChange("aciklama", oldAciklama, aciklama);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dosyaId != null ? dosyaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dosyalar_1)) {
            return false;
        }
        Dosyalar_1 other = (Dosyalar_1) object;
        if ((this.dosyaId == null && other.dosyaId != null) || (this.dosyaId != null && !this.dosyaId.equals(other.dosyaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "doktor.Dosyalar_1[ dosyaId=" + dosyaId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
