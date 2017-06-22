package bks.datenhaltung.sachbearbeiterdaten.services;

import java.util.List;
import bks.datenhaltung.bksdbmodel.entities.*;
import javax.persistence.EntityManager;


public interface IUeberweisungsVorlage {
    
    public void setEntityManager(EntityManager em);
    
    public UeberweisungsVorlage getUeberweisungsVorlageByID(int uvid);
    
    public List<UeberweisungsVorlage> getUeberweisungsVorlagenDesKunden(int kid);
    
    public List<UeberweisungsVorlage> getUeberweisungsVorlagenDesKontos(int ktoid);
    
    public boolean insertUeberweisungsVorlage(UeberweisungsVorlage uv);
    
    public boolean deleteUeberweisungsVorlage(int uvid);
    
    public boolean editUeberweisungsVorlage(UeberweisungsVorlage uv);
    
    public List<Ueberweisung> getUeberweisungenZuKonto(int ktoid);
    
    public List<Ueberweisung> getUeberweisungenVonKonto(int ktoid);
    
    public List<Ueberweisung> getLoeschbareUeberweisungen();
    
    public boolean loescheUeberweisung(int ubid);
    
}