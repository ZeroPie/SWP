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
@Table(name = "Admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a"),
    @NamedQuery(name = "Admin.findByAid", query = "SELECT a FROM Admin a WHERE a.aid = :aid"),
    @NamedQuery(name = "Admin.findByTitel", query = "SELECT a FROM Admin a WHERE a.titel = :titel"),
    @NamedQuery(name = "Admin.findByName", query = "SELECT a FROM Admin a WHERE a.name = :name"),
    @NamedQuery(name = "Admin.findByVorname", query = "SELECT a FROM Admin a WHERE a.vorname = :vorname"),
    @NamedQuery(name = "Admin.findByGeschlecht", query = "SELECT a FROM Admin a WHERE a.geschlecht = :geschlecht"),
    @NamedQuery(name = "Admin.findByGeburtsdatum", query = "SELECT a FROM Admin a WHERE a.geburtsdatum = :geburtsdatum"),
    @NamedQuery(name = "Admin.findByAdresse", query = "SELECT a FROM Admin a WHERE a.adresse = :adresse"),
    @NamedQuery(name = "Admin.findByTelefon", query = "SELECT a FROM Admin a WHERE a.telefon = :telefon"),
    @NamedQuery(name = "Admin.findByAbteilung", query = "SELECT a FROM Admin a WHERE a.abteilung = :abteilung")})
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aid")
    private Integer aid;
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
    @OneToMany(mappedBy = "admin")
    private List<Antrag> antragList;

    public Admin() {
    }

    public Admin(Integer aid) {
        this.aid = aid;
    }

    public Admin(Integer aid, String titel, String name, String vorname, String geschlecht, Date geburtsdatum, String abteilung) {
        this.aid = aid;
        this.titel = titel;
        this.name = name;
        this.vorname = vorname;
        this.geschlecht = geschlecht;
        this.geburtsdatum = geburtsdatum;
        this.abteilung = abteilung;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
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
        hash += (aid != null ? aid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.aid == null && other.aid != null) || (this.aid != null && !this.aid.equals(other.aid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bks.datenhaltung.bksdbmodel.entities.Admin[ aid=" + aid + " ]";
    }
    
}
