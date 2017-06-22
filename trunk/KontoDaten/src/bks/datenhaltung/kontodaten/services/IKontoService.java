package bks.datenhaltung.kontodaten.services;

import bks.datenhaltung.bksdbmodel.entities.Konto;
import bks.datenhaltung.bksdbmodel.entities.Ueberweisung;
import bks.datenhaltung.bksdbmodel.entities.Zahlungsverkehr;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Date;



/**
 *
 * @author Alexander
 */
public interface IKontoService {
    
public void setEntityManager(EntityManager em);
public boolean ueberweisungErfassen(Ueberweisung u);
public List<Ueberweisung> getStornierbareUeberweisungen(int kid);
public List<Ueberweisung> getLoeschbareUeberweisungen();
public boolean ueberweisungLoeschen(int ubid);
public boolean ueberweisungStornieren(int ubid);
public void kontoAktualisieren(int ktoid);
public boolean ueberweisungAusfuehren(int ubid);
public boolean kontoFreischalten(int ktoid);

public List<Konto>      getKontoListe(int kid);
public Konto            getKontoByID(int ktoid);
public List<Konto>      getNichtFreigeschalteteKonten();
public List<Zahlungsverkehr> getKontoauszug(int ktoid,Date von, Date bis);
public List<Zahlungsverkehr> getKontoauszugDrucken(int ktoid);
    
    
}
