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
@Table(name = "Manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manager.findAll", query = "SELECT m FROM Manager m"),
    @NamedQuery(name = "Manager.findByMid", query = "SELECT m FROM Manager m WHERE m.mid = :mid"),
    @NamedQuery(name = "Manager.findByTitel", query = "SELECT m FROM Manager m WHERE m.titel = :titel"),
    @NamedQuery(name = "Manager.findByName", query = "SELECT m FROM Manager m WHERE m.name = :name"),
    @NamedQuery(name = "Manager.findByVorname", query = "SELECT m FROM Manager m WHERE m.vorname = :vorname"),
    @NamedQuery(name = "Manager.findByGeschlecht", query = "SELECT m FROM Manager m WHERE m.geschlecht = :geschlecht"),
    @NamedQuery(name = "Manager.findByGeburtsdatum", query = "SELECT m FROM Manager m WHERE m.geburtsdatum = :geburtsdatum"),
    @NamedQuery(name = "Manager.findByAdresse", query = "SELECT m FROM Manager m WHERE m.adresse = :adresse"),
    @NamedQuery(name = "Manager.findByTelefon", query = "SELECT m FROM Manager m WHERE m.telefon = :telefon"),
    @NamedQuery(name = "Manager.findByAbteilung", query = "SELECT m FROM Manager m WHERE m.abteilung = :abteilung")})
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mid")
    private Integer mid;
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
    @OneToMany(mappedBy = "manager")
    private List<Antrag> antragList;

    public Manager() {
    }

    public Manager(Integer mid) {
        this.mid = mid;
    }

    public Manager(Integer mid, String titel, String name, String vorname, String geschlecht, Date geburtsdatum, String abteilung) {
        this.mid = mid;
        this.titel = titel;
        this.name = name;
        this.vorname = vorname;
        this.geschlecht = geschlecht;
        this.geburtsdatum = geburtsdatum;
        this.abteilung = abteilung;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
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
        hash += (mid != null ? mid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manager)) {
            return false;
        }
        Manager other = (Manager) object;
        if ((this.mid == null && other.mid != null) || (this.mid != null && !this.mid.equals(other.mid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bks.datenhaltung.bksdbmodel.entities.Manager[ mid=" + mid + " ]";
    }
    
}
