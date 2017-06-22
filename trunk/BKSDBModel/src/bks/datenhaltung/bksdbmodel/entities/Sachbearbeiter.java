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
@Table(name = "Sachbearbeiter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sachbearbeiter.findAll", query = "SELECT s FROM Sachbearbeiter s"),
    @NamedQuery(name = "Sachbearbeiter.findBySid", query = "SELECT s FROM Sachbearbeiter s WHERE s.sid = :sid"),
    @NamedQuery(name = "Sachbearbeiter.findByTitel", query = "SELECT s FROM Sachbearbeiter s WHERE s.titel = :titel"),
    @NamedQuery(name = "Sachbearbeiter.findByName", query = "SELECT s FROM Sachbearbeiter s WHERE s.name = :name"),
    @NamedQuery(name = "Sachbearbeiter.findByVorname", query = "SELECT s FROM Sachbearbeiter s WHERE s.vorname = :vorname"),
    @NamedQuery(name = "Sachbearbeiter.findByGeschlecht", query = "SELECT s FROM Sachbearbeiter s WHERE s.geschlecht = :geschlecht"),
    @NamedQuery(name = "Sachbearbeiter.findByGeburtsdatum", query = "SELECT s FROM Sachbearbeiter s WHERE s.geburtsdatum = :geburtsdatum"),
    @NamedQuery(name = "Sachbearbeiter.findByAdresse", query = "SELECT s FROM Sachbearbeiter s WHERE s.adresse = :adresse"),
    @NamedQuery(name = "Sachbearbeiter.findByTelefon", query = "SELECT s FROM Sachbearbeiter s WHERE s.telefon = :telefon"),
    @NamedQuery(name = "Sachbearbeiter.findByAbteilung", query = "SELECT s FROM Sachbearbeiter s WHERE s.abteilung = :abteilung")})
public class Sachbearbeiter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sid")
    private Integer sid;
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
    @Column(name = "geschlecht")
    private String geschlecht;
    @Basic(optional = false)
    @Column(name = "geburtsdatum")
    @Temporal(TemporalType.DATE)
    private Date geburtsdatum;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "telefon")
    private String telefon;
    @Basic(optional = false)
    @Column(name = "abteilung")
    private String abteilung;
    @OneToMany(mappedBy = "sachbearbeiter")
    private List<Antrag> antragList;

    public Sachbearbeiter() {
    }

    public Sachbearbeiter(Integer sid) {
        this.sid = sid;
    }

    public Sachbearbeiter(Integer sid, String titel, String name, String vorname, String geschlecht, Date geburtsdatum, String abteilung) {
        this.sid = sid;
        this.titel = titel;
        this.name = name;
        this.vorname = vorname;
        this.geschlecht = geschlecht;
        this.geburtsdatum = geburtsdatum;
        this.abteilung = abteilung;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
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

    public String getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(String abteilung) {
        this.abteilung = abteilung;
    }

    @XmlTransient
    public List<Antrag> getAntragList() {
        return antragList;
    }

    public void setAntragList(List<Antrag> antragList) {
        this.antragList = antragList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sid != null ? sid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sachbearbeiter)) {
            return false;
        }
        Sachbearbeiter other = (Sachbearbeiter) object;
        if ((this.sid == null && other.sid != null) || (this.sid != null && !this.sid.equals(other.sid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bks.datenhaltung.bksdbmodel.entities.Sachbearbeiter[ sid=" + sid + " ]";
    }
    
}
