/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bks.datenhaltung.bksdbmodel.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mhenk
 */
@Entity
@Table(name = "Konto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Konto.findAll", query = "SELECT k FROM Konto k"),
    @NamedQuery(name = "Konto.findByKtoid", query = "SELECT k FROM Konto k WHERE k.ktoid = :ktoid"),
    @NamedQuery(name = "Konto.findByArt", query = "SELECT k FROM Konto k WHERE k.art = :art"),
    @NamedQuery(name = "Konto.findByErstellungsdatum", query = "SELECT k FROM Konto k WHERE k.erstellungsdatum = :erstellungsdatum"),
    @NamedQuery(name = "Konto.findByKontostand", query = "SELECT k FROM Konto k WHERE k.kontostand = :kontostand"),
    @NamedQuery(name = "Konto.findByDispo", query = "SELECT k FROM Konto k WHERE k.dispo = :dispo"),
    @NamedQuery(name = "Konto.findByStatus", query = "SELECT k FROM Konto k WHERE k.status = :status")})
public class Konto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ktoid")
    private Integer ktoid;
    @Basic(optional = false)
    @Column(name = "art")
    private String art;
    @Basic(optional = false)
    @Column(name = "erstellungsdatum")
    @Temporal(TemporalType.DATE)
    private Date erstellungsdatum;
    @Basic(optional = false)
    @Column(name = "kontostand")
    private double kontostand;
    @Basic(optional = false)
    @Column(name = "dispo")
    private double dispo;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "kunde", referencedColumnName = "kid")
    @ManyToOne
    private Kunde kunde;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vonkonto")
    private List<Ueberweisung> ueberweisungList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zukonto")
    private List<Ueberweisung> ueberweisungList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "konto")
    private List<Zahlungsverkehr> zahlungsverkehrList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vonkonto")
    private List<UeberweisungsVorlage> ueberweisungsVorlageList;

    public Konto() {
    }

    public Konto(Integer ktoid) {
        this.ktoid = ktoid;
    }

    public Konto(Integer ktoid, String art, Date erstellungsdatum, double kontostand, double dispo, String status) {
        this.ktoid = ktoid;
        this.art = art;
        this.erstellungsdatum = erstellungsdatum;
        this.kontostand = kontostand;
        this.dispo = dispo;
        this.status = status;
    }

    public Integer getKtoid() {
        return ktoid;
    }

    public void setKtoid(Integer ktoid) {
        this.ktoid = ktoid;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public Date getErstellungsdatum() {
        return erstellungsdatum;
    }

    public void setErstellungsdatum(Date erstellungsdatum) {
        this.erstellungsdatum = erstellungsdatum;
    }

    public double getKontostand() {
        return kontostand;
    }

    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }

    public double getDispo() {
        return dispo;
    }

    public void setDispo(double dispo) {
        this.dispo = dispo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    @XmlTransient
    public List<Ueberweisung> getUeberweisungList() {
        return ueberweisungList;
    }

    public void setUeberweisungList(List<Ueberweisung> ueberweisungList) {
        this.ueberweisungList = ueberweisungList;
    }

    @XmlTransient
    public List<Ueberweisung> getUeberweisungList1() {
        return ueberweisungList1;
    }

    public void setUeberweisungList1(List<Ueberweisung> ueberweisungList1) {
        this.ueberweisungList1 = ueberweisungList1;
    }

    @XmlTransient
    public List<Zahlungsverkehr> getZahlungsverkehrList() {
        return zahlungsverkehrList;
    }

    public void setZahlungsverkehrList(List<Zahlungsverkehr> zahlungsverkehrList) {
        this.zahlungsverkehrList = zahlungsverkehrList;
    }

    @XmlTransient
    public List<UeberweisungsVorlage> getUeberweisungsVorlageList() {
        return ueberweisungsVorlageList;
    }

    public void setUeberweisungsVorlageList(List<UeberweisungsVorlage> ueberweisungsVorlageList) {
        this.ueberweisungsVorlageList = ueberweisungsVorlageList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ktoid != null ? ktoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Konto)) {
            return false;
        }
        Konto other = (Konto) object;
        if ((this.ktoid == null && other.ktoid != null) || (this.ktoid != null && !this.ktoid.equals(other.ktoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bks.datenhaltung.bksdbmodel.entities.Konto[ ktoid=" + ktoid + " ]";
    }
    
}
