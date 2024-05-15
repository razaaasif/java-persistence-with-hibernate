package com.jpalearning;

import com.jpalearning.entity.Guide;
import com.jpalearning.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			
			entityTransaction.begin();
			Student st1 = new Student("24-01" , "Aamir");
			Student st2 = new Student("24-02" , "Aasif");
			Student st3 = new Student("24-03" , "Kashif");
			
			
			Guide guide1 = new Guide("Guide1" , "g-01" , 10000);
			Guide guide2 = new Guide("Guide2" , "g-02" , 20000);
			
			st1.setGuide(guide1);
			st2.setGuide(guide1);
			st3.setGuide(guide2);
			entityManager.persist(st1);
			entityManager.persist(st2);
			entityManager.persist(st3);
			entityTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}

}
