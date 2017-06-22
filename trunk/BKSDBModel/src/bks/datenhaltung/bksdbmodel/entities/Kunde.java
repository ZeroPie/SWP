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
@Table(name = "Kunde")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kunde.findAll", query = "SELECT k FROM Kunde k"),
    @NamedQuery(name = "Kunde.findByKid", query = "SELECT k FROM Kunde k WHERE k.kid = :kid"),
    @NamedQuery(name = "Kunde.findByTitel", query = "SELECT k FROM Kunde k WHERE k.titel = :titel"),
    @NamedQuery(name = "Kunde.findByName", query = "SELECT k FROM Kunde k WHERE k.name = :name"),
    @NamedQuery(name = "Kunde.findByVorname", query = "SELECT k FROM Kunde k WHERE k.vorname = :vorname"),
    @NamedQuery(name = "Kunde.findByGeburtsdatum", query = "SELECT k FROM Kunde k WHERE k.geburtsdatum = :geburtsdatum"),
    @NamedQuery(name = "Kunde.findByAdresse", query = "SELECT k FROM Kunde k WHERE k.adresse = :adresse"),
    @NamedQuery(name = "Kunde.findByTelefon", query = "SELECT k FROM Kunde k WHERE k.telefon = :telefon"),
    @NamedQuery(name = "Kunde.findByGeschlecht", query = "SELECT k FROM Kunde k WHERE k.geschlecht = :geschlecht"),
    @NamedQuery(name = "Kunde.findByNationalitaet", query = "SELECT k FROM Kunde k WHERE k.nationalitaet = :nationalitaet"),
    @NamedQuery(name = "Kunde.findByFamilientstand", query = "SELECT k FROM Kunde k WHERE k.familientstand = :familientstand")})
public class Kunde implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kid")
    private Integer kid;
    @Basic(optional = false)
    @Column(name = "titel")
    private String titel;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "vorname")
    private String vorname;
    @Basic(optional = false)
    @Column(name = "geburtsdatum")
    @Temporal(TemporalType.DATE)
    private Date geburtsdatum;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "telefon")
    private String telefon;
    @Basic(optional = false)
    @Column(name = "geschlecht")
    private String geschlecht;
    @Column(name = "nationalitaet")
    private String nationalitaet;
    @Basic(optional = false)
    @Column(name = "familientstand")
    private String familientstand;
    @OneToMany(mappedBy = "kunde")
    private List<Konto> kontoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kunde")
    private List<Ueberweisung> ueberweisungList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kunde")
    private List<UeberweisungsVorlage> ueberweisungsVorlageList;

    public Kunde() {
    }

    public Kunde(Integer kid) {
        this.kid = kid;
    }

    public Kunde(Integer kid, String titel, String name, String vorname, Date geburtsdatum, String geschlecht, String familientstand) {
        this.kid = kid;
        this.titel = titel;
        this.name = name;
        this.vorname = vorname;
        this.geburtsdatum = geburtsdatum;
        this.geschlecht = geschlecht;
        this.familientstand = familientstand;
    }

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(Date geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public String getNationalitaet() {
        return nationalitaet;
    }

    public void setNationalitaet(String nationalitaet) {
        this.nationalitaet = nationalitaet;
    }

    public String getFamilientstand() {
        return familientstand;
    }

    public void setFamilientstand(String familientstand) {
        this.familientstand = familientstand;
    }

    @XmlTransient
    public List<Konto> getKontoList() {
        return kontoList;
    }

    public void setKontoList(List<Konto> kontoList) {
        this.kontoList = kontoList;
    }

    @XmlTransient
    public List<Ueberweisung> getUeberweisungList() {
        return ueberweisungList;
    }

    public void setUeberweisungList(List<Ueberweisung> ueberweisungList) {
        this.ueberweisungList = ueberweisungList;
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
        hash += (kid != null ? kid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kunde)) {
            return false;
        }
        Kunde other = (Kunde) object;
        if ((this.kid == null && other.kid != null) || (this.kid != null && !this.kid.equals(other.kid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bks.datenhaltung.bksdbmodel.entities.Kunde[ kid=" + kid + " ]";
    }
    
}
