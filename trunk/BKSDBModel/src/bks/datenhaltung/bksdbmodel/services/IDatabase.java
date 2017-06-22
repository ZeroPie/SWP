package bks.datenhaltung.bksdbmodel.services;

import javax.persistence.EntityManager;

/**
 *
 * @author moetz
 */
public interface IDatabase {	
	public EntityManager getEntityManager();
	public void useDevPU();
	public void useProdPU();
	public String getCurrentPU();
}
