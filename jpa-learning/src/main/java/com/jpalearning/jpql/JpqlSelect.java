package com.jpalearning.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jpalearning.entity.Guide;

public class JpqlSelect {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();

			Query query2 = entityManager.createQuery("select guide from Guide as guide ");
			List<Guide> guidesName = query2.getResultList();
			System.out.println(guidesName);
			System.out.println(guidesName.get(0).getStudents());
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
