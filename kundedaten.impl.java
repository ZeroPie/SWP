package bks.datenhaltung.kundedaten.services;

import javax.persistence.EntityManager;
import bks.datenhaltung.bksdbmodel.entities.Kunde;

import java.util.List;

/**
 *
 * @author Alejandro P.
 */
public interface ICRUDKunde {
    /**
     * @author Alejandro P.
     * @param em EntityManager
     */
    public void        setEntityManager(EntityManager em);
    public Kunde       getKundeByID(int kid);
    public List<Kunde> getKundenListe();
    public boolean     insertKunde(Kunde kunde);
    public boolean     editKunde(Kunde kunde);
    public boolean     deleteKunde(int kid);

}
