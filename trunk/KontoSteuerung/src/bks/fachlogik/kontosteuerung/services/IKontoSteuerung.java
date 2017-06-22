package bks.fachlogik.kontosteuerung.services;

import bks.fachlogik.kontosteuerung.grenz.UeberweisungGrenz;
import java.util.List;


public interface IKontoSteuerung {
    
    public boolean ueberweisungAusfuehren(int zuUeberweisen);
    public List<UeberweisungGrenz> getLoeschbareUeberweisungen();
    public boolean ueberweisungenLoeschen(List<UeberweisungGrenz> uList);
    public List<UeberweisungGrenz> getWartendeUeberweisungenByKid(int kid);
    public List<UeberweisungGrenz> getWartendeUeberweisungenByKtoid(int ktoid);
}
