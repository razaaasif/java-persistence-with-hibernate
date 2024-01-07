package raza.aasif.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
	private static EntityManager entityManager = null;

	public JpaUtils() {
		// Auto-generated constructor stub
	}

	public static EntityManager getEntityManager() {
		if (entityManager == null || !entityManager.isOpen()) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloWorldPU");
			entityManager = emf.createEntityManager();
		}
		return entityManager;
	}

	public static void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	public static void commitTransaction() {
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
