package bks.datenhaltung.bksdbmodel.impl;

import bks.datenhaltung.bksdbmodel.services.EntityManagerSingleton;
import bks.datenhaltung.bksdbmodel.services.IDatabase;
import javax.persistence.EntityManager;

/**
 *
 * @author moetz
 */
public class IDatabaseImpl implements IDatabase {

	@Override
	public EntityManager getEntityManager() {
		return EntityManagerSingleton.getInstance().getEntityManager();
	}

	@Override
	public void useDevPU() {
		EntityManagerSingleton.getInstance().useDevPU();
	}

	@Override
	public void useProdPU() {
		EntityManagerSingleton.getInstance().useProdPU();
	}

	@Override
	public String getCurrentPU() {
		return EntityManagerSingleton.getInstance().getCurrentPU();
	}
}
