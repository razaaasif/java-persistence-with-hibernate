package com.jpalearning.jpql;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.jpalearning.entity.Guide;

public class JpqlSelect {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			namedQueryByXml(entityManager);
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void namedQueryByXml(EntityManager entityManager) {
		Guide g = entityManager.createNamedQuery("findByGuide", Guide.class).setParameter("name", "Guide1")
				.getSingleResult();
		System.out.println(g);
	}

	private static void namedQuery(EntityManager entityManager) {
		TypedQuery<Guide> query = entityManager.createNamedQuery("Guide.findAll", Guide.class);
		query.getResultStream().forEach(System.out::println);

	}

	private static void nativeQuery(EntityManager entityManager) {
		Query query = entityManager.createNativeQuery("SELECT COUNT(*) FROM guide");
		BigInteger count = (BigInteger) query.getSingleResult();
		System.out.println("Count of records in Guide table: " + count);

	}

	@SuppressWarnings("unchecked")
	private static void likeQueury(EntityManager entityManager) {
		Query query2 = entityManager.createQuery("select guide from Guide guide where guide.name like '%2'",
				Guide.class);
		query2.getResultList().forEach(System.out::println);
		;

	}
}
