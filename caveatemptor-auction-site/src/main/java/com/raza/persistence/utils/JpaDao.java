package com.raza.persistence.utils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JpaDao {
	private static EntityManager entityManager = Persistence.createEntityManagerFactory("casPU").createEntityManager();

	private JpaDao() {
	}

	public static EntityManager getEntityManager() {
		return entityManager;
	}

	public void begin() {
		getEntityManager().getTransaction().begin();
	}

	public void commit() {
		getEntityManager().getTransaction().commit();
	}

	public <T> T save(T obj) {
		entityManager.persist(obj);
		return obj;
	}

}
