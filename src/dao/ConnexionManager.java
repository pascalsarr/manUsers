package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnexionManager {
	private static final String			PU_NAME	= "man_users_pu";
	private static EntityManagerFactory	factory	= null;

	private ConnexionManager()
	{
	}

	public static EntityManager getEntityManager() throws DaoException
	{
		if (factory == null)
		{
			factory = Persistence.createEntityManagerFactory(PU_NAME);
		}

		return factory.createEntityManager();
	}
}
