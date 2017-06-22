package bks.datenhaltung.kontodaten.services;
import java.util.List;
import javax.persistence.EntityManager;
import bks.datenhaltung.bksdbmodel.entities.Konto;

public interface ISonderKontoService {
    public void setEntityManager(EntityManager em);
    public Konto getKontoByID(int ktoid);
    public List<Konto> getUeberzogeneKontos();
    public boolean neuesDispoSetzen(int ktoid, double neuesDispo);
    public void kontoAktualisieren(int ktoid);
}
