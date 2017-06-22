package bks.fachlogik.kundesteuerung.impl;

import bks.datenhaltung.bksdbmodel.entities.Kunde;
import bks.fachlogik.componentcontroller.services.CompType;
import bks.fachlogik.componentcontroller.services.IActivateComponent;
import bks.datenhaltung.bksdbmodel.impl.IDatabaseImpl;
import bks.datenhaltung.bksdbmodel.services.IDatabase;
import bks.datenhaltung.kundedaten.services.ICRUDKunde;
import bks.datenhaltung.kundedaten.impl.ICRUDKundeImpl;
import bks.fachlogik.kundesteuerung.grenz.KundeGrenz;
import javax.persistence.EntityManager;

/**
 * Implementiert die Methoden getComponentType, activateComponent,
 * deactivateComponent und isActivated des Interfaces IActivateComponent.
 * Zusätzlich wird die statische Methode getUser( ): KundeGrenz bereitgestellt.
 *
 * @author Alexander
 */
public class IActivateComponentImpl implements IActivateComponent {

    private static boolean status = false;
    private static int userid;

    public IActivateComponentImpl() {
    }

    /**
     * Liefert den CompType der Komponente
     *
     * @return liefert CompType Kunde wenn Komponente activated sonst null
     */
    @Override
    public CompType getComponentType() {

        if (status) {
            return CompType.KUNDE;
        } else {
            return null;
        }
    }

    /**
     * Aktiviert die Komponente und setzt bei Erfolg den Status der Komponente
     * auf aktiviert.
     *
     * @param userid kid des Kunden
     * @return true wenn Komponente aktiviert werden konnte (Wechsel von
     * deaktiviert zu aktiviert) sonst false.
     */
    @Override
    public boolean activateComponent(int userid) {
        if (status == false) { //Wenn Komponente nicht aktiv ist
            IDatabase db = new IDatabaseImpl();
            EntityManager em = db.getEntityManager(); //EntityManager holen
            ICRUDKunde icrudKunde = new ICRUDKundeImpl();
            icrudKunde.setEntityManager(em);
            
            if (icrudKunde.getKundeByID(userid) != null) {
                status = true;
                IActivateComponentImpl.userid=userid;
                return true;
            } else {        //Wenn der Kunde nicht existiert
                return false; //Komponente konnte nicht aktiviert werden
            }
        }
        return false;
    }

    /**
     * Deaktiviert die Komponente und setzt den Status der Komponente bei Erfolg
     * auf deaktiviert.
     *
     * @return Liefert true wenn die Komponente deaktiviert werden konnte.
     * (wechsel von aktiviert zu deaktiviert) sonst false.
     */
    @Override
    public boolean deactivateComponent() {
        if (status == true) {
            status = false;
            return true;
        } else {
            status = false;
            return false;
        }
    }

    /**
     * Liefert den aktuellen Status der Komponente zurück
     *
     * @return true wenn Komponente aktiv sonst false
     */
    @Override
    public boolean isActivated() {
        return status;
    }
    /**
     * Liefert den aktuell angemeldeten Kunden als KundeGrenz zurück oder null
     * wenn Komponente inaktiv ist.
     *
     * @author Alexander
     * @return KundeGrenz wenn Komponente aktiv, sonst null
     */
    public static KundeGrenz getUser() {
        if (!status) {
            return null;
        }
        IDatabase db = new IDatabaseImpl();
        EntityManager em = db.getEntityManager(); //EntityManager holen
        ICRUDKunde icrudKunde = new ICRUDKundeImpl();
        icrudKunde.setEntityManager(em);
        Kunde kunde = icrudKunde.getKundeByID(userid);
        KundeGrenz kundeGrenz = new KundeGrenz();
        kundeGrenz.setName(kunde.getName());
        kundeGrenz.setAdresse(kunde.getAdresse());
        kundeGrenz.setGeburtsdatum(kunde.getGeburtsdatum());
        kundeGrenz.setGeschlecht(kunde.getGeschlecht());
        kundeGrenz.setTelefon(kunde.getTelefon());
        kundeGrenz.setTitel(kunde.getTitel());
        kundeGrenz.setKid(kunde.getKid());
        kundeGrenz.setFamilienstand(kunde.getFamilientstand());
        kundeGrenz.setNationalitaet(kunde.getNationalitaet());
        kundeGrenz.setVorname(kunde.getVorname());
                
        return kundeGrenz;
    }
}
