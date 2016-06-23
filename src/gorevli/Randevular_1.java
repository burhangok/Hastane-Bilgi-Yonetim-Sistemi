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
@Table(name = "RANDEVULAR", catalog = "", schema = "HR")
@NamedQueries({
    @NamedQuery(name = "Randevular_1.findAll", query = "SELECT r FROM Randevular_1 r"),
    @NamedQuery(name = "Randevular_1.findByRandevuId", query = "SELECT r FROM Randevular_1 r WHERE r.randevuId = :randevuId"),
    @NamedQuery(name = "Randevular_1.findByHastaId", query = "SELECT r FROM Randevular_1 r WHERE r.hastaId = :hastaId"),
    @NamedQuery(name = "Randevular_1.findByDoktorId", query = "SELECT r FROM Randevular_1 r WHERE r.doktorId = :doktorId"),
    @NamedQuery(name = "Randevular_1.findByPoliklinikId", query = "SELECT r FROM Randevular_1 r WHERE r.poliklinikId = :poliklinikId"),
    @NamedQuery(name = "Randevular_1.findByGun", query = "SELECT r FROM Randevular_1 r WHERE r.gun = :gun"),
    @NamedQuery(name = "Randevular_1.findBySaat", query = "SELECT r FROM Randevular_1 r WHERE r.saat = :saat")})
public class Randevular_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "RANDEVU_ID")
    private BigDecimal randevuId;
    @Column(name = "HASTA_ID")
    private BigInteger hastaId;
    @Column(name = "DOKTOR_ID")
    private BigInteger doktorId;
    @Column(name = "POLIKLINIK_ID")
    private BigInteger poliklinikId;
    @Column(name = "GUN")
    private BigInteger gun;
    @Column(name = "SAAT")
    private String saat;

    public Randevular_1() {
    }

    public Randevular_1(BigDecimal randevuId) {
        this.randevuId = randevuId;
    }

    public BigDecimal getRandevuId() {
        return randevuId;
    }

    public void setRandevuId(BigDecimal randevuId) {
        BigDecimal oldRandevuId = this.randevuId;
        this.randevuId = randevuId;
        changeSupport.firePropertyChange("randevuId", oldRandevuId, randevuId);
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

    public BigInteger getPoliklinikId() {
        return poliklinikId;
    }

    public void setPoliklinikId(BigInteger poliklinikId) {
        BigInteger oldPoliklinikId = this.poliklinikId;
        this.poliklinikId = poliklinikId;
        changeSupport.firePropertyChange("poliklinikId", oldPoliklinikId, poliklinikId);
    }

    public BigInteger getGun() {
        return gun;
    }

    public void setGun(BigInteger gun) {
        BigInteger oldGun = this.gun;
        this.gun = gun;
        changeSupport.firePropertyChange("gun", oldGun, gun);
    }

    public String getSaat() {
        return saat;
    }

    public void setSaat(String saat) {
        String oldSaat = this.saat;
        this.saat = saat;
        changeSupport.firePropertyChange("saat", oldSaat, saat);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (randevuId != null ? randevuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Randevular_1)) {
            return false;
        }
        Randevular_1 other = (Randevular_1) object;
        if ((this.randevuId == null && other.randevuId != null) || (this.randevuId != null && !this.randevuId.equals(other.randevuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gorevli.Randevular_1[ randevuId=" + randevuId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
