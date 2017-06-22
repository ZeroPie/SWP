package bks.fachlogik.kundesteuerung.services;

import bks.fachlogik.kundesteuerung.grenz.KundeGrenz;

public interface IKundeSteuerung {
    
    public KundeGrenz getKundenProfil();
    public boolean kundenProfilBearbeiten(KundeGrenz kunde);
    
}
