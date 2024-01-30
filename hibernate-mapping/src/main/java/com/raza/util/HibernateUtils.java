package com.raza.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {

	private static final SessionFactory sessionFactory = null;

	private HibernateUtils() {
		// Private constructor to prevent instantiation
	}

	public static SessionFactory getSessionFactory() {
		try {

			StandardServiceRegistry registery = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
					.build();
			Metadata metadata = new MetadataSources(registery).getMetadataBuilder().build();
			return metadata.buildSessionFactory();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;

	}

	public static void closeSessionFactory() {
		if (sessionFactory != null && !sessionFactory.isClosed()) {
			sessionFactory.close();
		}
	}
}
