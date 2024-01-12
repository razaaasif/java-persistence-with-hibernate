package raza.aasif.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		if (null == sessionFactory) {
			sessionFactory = new MetadataSources(
					new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml")
					.build()
					)
					.buildMetadata()
					.buildSessionFactory();

		}
		return sessionFactory;
	}

}
