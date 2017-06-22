package bks.fachlogik.kundesteuerung.services;

import bks.datenhaltung.bksdbmodel.entities.Ueberweisung;
import bks.fachlogik.kundesteuerung.grenz.UeberweisungGrenz;
import java.util.List;

/**
 *
 * @author Barthy
 */
public interface IUeberweisungSteuerung {
    
    public List<UeberweisungGrenz> getStornierbareUeberweisungen();
    
    public boolean ueberweisungErfassen(UeberweisungGrenz uberweisungGrenz);
    
    public boolean ueberweisungStornieren(int ubid);

        
}
