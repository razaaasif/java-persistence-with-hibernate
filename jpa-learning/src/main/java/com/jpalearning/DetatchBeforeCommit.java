package com.jpalearning;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpalearning.entity.Message;

public class DetatchBeforeCommit {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myPU");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();

			Message message = entityManager.find(Message.class, 1L);
			message = entityManager.merge(message);//2
			entityManager.detach(message);//3
			entityManager.remove(message);//4
			message = entityManager.merge(message);//5
			System.out.println(entityManager.contains(message));//6
			entityTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
