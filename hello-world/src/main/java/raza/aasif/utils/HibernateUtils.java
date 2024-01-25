package raza.aasif.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {

	private static volatile SessionFactory sessionFactory = null;

	private HibernateUtils() {
		// Private constructor to prevent instantiation
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			synchronized (HibernateUtils.class) {
				if (sessionFactory == null) {
					try {
						sessionFactory = new MetadataSources(
								new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build())
								.getMetadataBuilder().build().getSessionFactoryBuilder().build();
					} catch (Exception e) {
						// Log the exception or handle it as needed
						e.printStackTrace();
						throw new RuntimeException("Error building SessionFactory: " + e.getMessage(), e);
					}
				}
			}
		}
		return sessionFactory;
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null && !sessionFactory.isClosed()) {
			sessionFactory.close();
		}
	}
}
