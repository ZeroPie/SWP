package bks.datenhaltung.kontodaten.services;

import bks.datenhaltung.bksdbmodel.entities.Konto;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Barthy
 */
public interface ICRUDKonto {
    
    public void setEntityManager(EntityManager em);
    
    /**
     * Liefert das Konto mit der angegebenen Id.
     * 
     * @param ktoid ID des Kontos
     * @return das Konto
     */
    public Konto getKontoByID(int ktoid);
    
    /**
     * Liefert alle Konto des angegebenen Kunden.
     * 
     * @param kid Id des Kunden
     * @return Liste der Konten
     */
    public List<Konto> getKontoListeDesKunden(int kid);
    
    /**
     * Fügt ein neues Konto ein.
     * 
     * @param kto das zu hinzufügende Konto
     * @return true, falls ein Konto erstellt wurde (die Datenbank verändert wurde)
     */
    public boolean insertKonto(Konto kto);
    
    /**
     * Löscht das angegebene Konto
     * 
     * @param ktoid ID des zu löschenden Kontos
     * @return true, falls das Konto gelöscht wurde (die Datenbank verändert wurde)
     */
    public boolean deleteKonto(int ktoid);
    
    /**
     * Soll jederzeit möglich sein. Bei einer Einzahlung soll der text ebenfalls
     * in das Attribut erlaeuterung der Zahlungsverkehr-Einträge übernommen
     * werden. Nach dem erfolgreichen Einzahlen muss der Korrekte neue Status
     * des Kontos durch Aufruf der Methode kontoAktualisieren in IKontoService
     * gesetzt werden.
     * 
     * @param ktoid Id des Kontos
     * @param betrag Einzuzahlender Betrag
     * @param text Information zum Zahlungsverkehr
     * @return true, wenn das Konto bereits existiert und das Konto erfolgreich
     *         aktualisiert wurde
     */
    public boolean geldEinzahlen(int ktoid, double betrag, String text);
    
    /**
     * Erlaubt nur dann Abhebungen, wenn das Konto nicht gesperrt ist.
     * Ist ein Konto gesperrt, so liefert die geldAbheben-Methode die Rückgabe
     * false. Der Parameter text soll in das Attribut erlauterung der 
     * Zahlungsverkehr-Einträge übernommen werden. Nach dem erfolgreichen
     * Abheben muss der korrekte neue Status des Kontos durch Aufruf der Methode
     * kontoAktualisieren in IKontoService gesetzt werden.
     * 
     * @param ktoid ID des Kontos
     * @param betrag Abzuhebender Betrag
     * @param text Information zum Zahlungsverkehr
     * @return true, wenn das Konto nicht gesperrt ist und es erfolgreich
     *         aktualisiert wurde.
     */
    public boolean geldAbheben(int ktoid, double betrag, String text);
    
}
