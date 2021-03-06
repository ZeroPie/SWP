package bks.fachlogik.kundesteuerung.services;

import bks.fachlogik.kundesteuerung.grenz.UeberweisungsvorlageGrenz;
import java.util.List;

public interface IUeberweisungVorlageSteuerung {
    
    public List<UeberweisungsvorlageGrenz>  getUeberweisungvorlagenList();
    public boolean                          ueberweisungsvorlageAnlegen(UeberweisungsvorlageGrenz uvg);
    public boolean                          ueberweisungsvorlageBearbeiten(UeberweisungsvorlageGrenz uvg);
    public boolean                          ueberweisungsvorlageLoeschen(int uvid);
    
}