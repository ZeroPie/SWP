package bks.datenhaltung.bksdbmodel.services;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author moetz
 */
public class EntityManagerSingleton {
	private static EntityManagerSingleton instance;
	private EntityManager emDev;
	private EntityManager emProd;
	private String pu = "BKSDBDEVPU";
	
	private EntityManagerSingleton() {
		emDev = Persistence.createEntityManagerFactory("BKSDBDEVPU").createEntityManager();
		emProd = Persistence.createEntityManagerFactory("BKSDBPRODPU").createEntityManager();
	}
	
	public static EntityManagerSingleton getInstance() {
		if (instance == null) {
			instance = new EntityManagerSingleton();
		}
		return instance;
	}
	
	public EntityManager getEntityManager() {
		if (pu.equals("BKSDBDEVPU")) {
			return emDev;
		}
		else if (pu.equals("BKSDBPRODPU")){
			return emProd;
		}
		else 
			return null;
	}
	
	public void useDevPU() {
		this.pu = "BKSDBDEVPU";
	}
		
	public void useProdPU() {
		this.pu = "BKSDBPRODPU";
	}
		
	public String getCurrentPU() {
		return pu;
	}
}
